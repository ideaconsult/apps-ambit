package net.idea.examples.ml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.lib.ConnectedComponents;
import org.apache.spark.mllib.clustering.StreamingKMeans;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix;
import org.apache.spark.mllib.linalg.distributed.MatrixEntry;
import org.apache.spark.mllib.linalg.distributed.RowMatrix;
import org.apache.spark.storage.StorageLevel;

import scala.reflect.ClassTag;

public class ClusteringApp implements Serializable  {

	public void run(String inputPath, String outputPath, final int dim)
			throws Exception {

		SparkConf conf = new SparkConf().setAppName(
				StreamingKMeans.class.getName()).setMaster("local[*]");
		SparkContext ctx = SparkContext.getOrCreate(conf);
		JavaSparkContext jsc = JavaSparkContext.fromSparkContext(ctx);
		try {
			// rows - fp, columns : cmps
			JavaRDD<Vector> data = jsc.textFile(inputPath).map(
					new Function<String, Vector>() {
					
						/**
						 * 
						 */
						private static final long serialVersionUID = 8780511981313089234L;

						public Vector call(String line) throws Exception {
							String[] tokens = line.split("\t");

							List<scala.Tuple2<Integer, Double>> items = new ArrayList<scala.Tuple2<Integer, Double>>();
							for (int i = 1; i < tokens.length; i++) {
								int id = Integer.parseInt(tokens[i]);
								items.add(new scala.Tuple2<Integer, Double>(id,
										1.0));
							}

							return Vectors.sparse(dim, items);
						}
					});
			RowMatrix rows = new RowMatrix(data.rdd());
			CoordinateMatrix simmatrix = rows.columnSimilarities(0.75);

			JavaRDD<Edge<Double>> similarities = simmatrix.entries()
					.toJavaRDD().map(new Function<MatrixEntry, Edge<Double>>() {
						public Edge<Double> call(MatrixEntry entry) {
							return new Edge<Double>(entry.i(), entry.j(), entry
									.value());
						}
					}).cache();
			ClassTag<String> vd = scala.reflect.ClassTag$.MODULE$
					.apply(String.class);
			ClassTag<Double> ed = scala.reflect.ClassTag$.MODULE$
					.apply(Double.class);
			Graph<String, Double> graph = Graph.fromEdges(similarities.rdd(),
					"node", StorageLevel.MEMORY_ONLY(),
					StorageLevel.MEMORY_ONLY(), vd, ed);
			Graph<Object, Double> cc = ConnectedComponents.run(graph, vd, ed);

			String path = String.format("%s/cc/%s", outputPath,
					UUID.randomUUID());

			cc.vertices().saveAsTextFile(path);
		} finally {
			jsc.close();
		}
	}

	public static void main(String args[]) {
		/*
		 * args[0] input args[1] output args[2] number of columns
		 */

		if (args.length < 3)
			return;

		ClusteringApp app = new ClusteringApp();
		try {
			app.run(args[0], args[1], Integer.parseInt(args[2]));
		} catch (Exception x) {
			x.printStackTrace();
		}
		/*
		 * 
		 * Options options = new Options();
		 * 
		 * Option input = OptionBuilder.hasArg().withLongOpt("input")
		 * .withArgName("file").withDescription("Input SDF file") .create("i");
		 * 
		 * Option output = OptionBuilder.hasArg().withLongOpt("output")
		 * .withArgName("file").withDescription("Output file").create("o");
		 * CommandLineParser parser = new PosixParser(); try { CommandLine line
		 * = parser.parse(options, args, false); input = getInput(line); output
		 * = getOutput(line); } catch (Exception x) {
		 */
	}

}
