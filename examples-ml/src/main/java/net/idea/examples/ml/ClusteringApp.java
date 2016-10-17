package net.idea.examples.ml;

import java.io.Serializable;
import java.util.UUID;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.lib.ConnectedComponents;
import org.apache.spark.storage.StorageLevel;

import scala.reflect.ClassTag;

public class ClusteringApp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2806036525498486697L;

	public static void main(String args[]) {
		if (args.length < 2) {
			System.out.println("ClusteringApp inputfile outputfile [threshold]\nInputfile is a similarity matrix as generated from ambitcli -a simmatrix");
			return;
		}
		double threshold = 0.95;
		try {
			threshold = Double.parseDouble(args[2]);
		} catch (Exception x) {
			threshold = 0.95;
		}

		ClusteringApp app = new ClusteringApp();
		try {
			app.run(args[0], args[1], threshold);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void run(String inputPath, String outputPath, double threshold) throws Exception {
		// String dir = "file:///" + dir_;
		// System.getProperty("java.io.tmpdir")
		long now = System.currentTimeMillis();

		SparkConf conf = new SparkConf().setAppName(ConnectedComponents.class.getName()).setMaster("local[*]");
		SparkContext ctx = SparkContext.getOrCreate(conf);
		JavaSparkContext jsc = JavaSparkContext.fromSparkContext(ctx);

		JavaRDD<Edge<Double>> data = getMatrixAsRDD(jsc, inputPath, threshold);

		ClassTag<String> vd = scala.reflect.ClassTag$.MODULE$.apply(String.class);
		ClassTag<Double> ed = scala.reflect.ClassTag$.MODULE$.apply(Double.class);
		Graph<String, Double> graph = Graph.fromEdges(data.rdd(), "node", StorageLevel.MEMORY_ONLY(),
				StorageLevel.MEMORY_ONLY(), vd, ed);
		Graph<Object, Double> cc = ConnectedComponents.run(graph, vd, ed);

		UUID uuid = UUID.randomUUID();
		String path = String.format("file:///%s/results%s/%s-%s.triplets", outputPath, threshold, uuid, threshold);
		cc.triplets().saveAsTextFile(path);
		path = String.format("file:///%s/results%s/%s-%s.vertices", outputPath, threshold, uuid, threshold);
		cc.vertices().saveAsTextFile(path);

		jsc.close();
		System.out.println(System.currentTimeMillis() - now);
	}

	protected JavaRDD<Edge<Double>> getMatrixAsRDD(JavaSparkContext jsc, String inputhpath, final double threshold) {
		JavaRDD<Edge<Double>> data = jsc.textFile(inputhpath).filter(new Function<String, Boolean>() {
			@Override
			public Boolean call(String line) throws Exception {
				String[] tokens = line.split("\t");
				Double attr = Double.parseDouble(tokens[2]);
				return attr >= threshold;
			}
		}).map(new Function<String, Edge<Double>>() {
			@Override
			public Edge<Double> call(String line) throws Exception {
				String[] tokens = line.split("\t");
				Double attr = Double.parseDouble(tokens[2]);
				long srcId = Long.parseLong(tokens[0]);
				long dstId = Long.parseLong(tokens[1]);
				Edge<Double> edge = new Edge<Double>(srcId, dstId, attr);
				return edge;
			}
		});
		return data;
	}
}
