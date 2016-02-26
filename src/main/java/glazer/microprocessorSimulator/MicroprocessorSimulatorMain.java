package glazer.microprocessorSimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MicroprocessorSimulatorMain {
	public static void main(String[] args) {
		String inputCode = null;
		char[] instructionSet;
		String output;
		Processor simulate = new Processor();
		try {

			// BufferedReader inputFile = new BufferedReader(new FileReader(
			// "mach.in"));
			BufferedReader inputFile = new BufferedReader(new InputStreamReader(System.in));
			while ((inputCode = inputFile.readLine()) != null) {
				instructionSet = inputCode.toCharArray();
				instructionSet = simulate.execute(instructionSet);
				output = String.valueOf(instructionSet);
				System.out.print(output + "\n");
			}
			inputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
