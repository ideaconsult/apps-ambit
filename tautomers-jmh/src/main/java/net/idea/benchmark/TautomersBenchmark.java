/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.idea.benchmark;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.MDLReader;
import org.openscience.cdk.silent.AtomContainer;

import ambit2.tautomers.TautomerManager;

import com.google.common.base.Verify;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(1)
public class TautomersBenchmark {

	@State(Scope.Benchmark)
	public static class TautomerManagerFactory {
		TautomerManager instance;

		@Setup(Level.Trial)
		public void initialize() {
			instance = new TautomerManager();
		}

		@TearDown(Level.Trial)
		public void shutdown() {

		}
	}

	@State(Scope.Benchmark)
	public static class Molecule {
		IAtomContainer instance = null;

		@Setup(Level.Trial)
		public void initialize() {
			MDLReader reader = null;
			try {
				IAtomContainer mol = null;
				InputStream in = getClass().getClassLoader()
						.getResourceAsStream(
								"net/idea/benchmark/CHEMBL2373570.sdf");
				Verify.verifyNotNull(in);
				reader = new MDLReader(in);
				mol = reader.read(new AtomContainer());
				instance = mol;
				Verify.verifyNotNull(instance);
				Verify.verify(instance.getAtomCount() == 581);
			} catch (CDKException x) {
				x.printStackTrace();

			} finally {
				try {
					if (reader != null)
						reader.close();
				} catch (Exception x) {
				}
			}

		}
	}

	@Benchmark
	public List<IAtomContainer> generateTautomers(
			TautomerManagerFactory tautomerManager, Molecule molecule)

	throws Exception {
		tautomerManager.instance.setStructure(molecule.instance);
		List<IAtomContainer> res = tautomerManager.instance
				.generateTautomersIncrementaly();

		return res;
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(".*" + TautomersBenchmark.class.getSimpleName() + ".*")
				.warmupIterations(5).measurementIterations(5).forks(1).build();

		new Runner(opt).run();
	}
}
