package net.idea.example.ambit.tautomers;

import java.net.URL;

import org.junit.Test;

public class TautomersTest {

	@Test
	public void test() throws Exception {
		MainApp app = new MainApp();
		URL url = TautomersTest.class.getClassLoader().getResource("net/idea/example/ambit/tautomers/inchi.txt");
		
		org.junit.Assert.assertNotNull(url.getFile());
		String[] args = new String[] {
				"-"+MainApp._option.file.getShortName(),url.getFile(),
				"-"+MainApp._option.output.getShortName(),url.getFile().replace(".txt", "_result.sdf")};
		for (String arg:args) System.out.println(arg);
		app.run(args);
	}
}
