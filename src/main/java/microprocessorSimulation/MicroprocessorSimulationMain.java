package microprocessorSimulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MicroprocessorSimulationMain {
	public static void main(String[] args) {
		String inputCode = null;
		char[] instructionSet;
		String output;
		MicroprocessorSimulation simulate = new MicroprocessorSimulation();
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader(
					"mach.in"));
			while ((inputCode = inputFile.readLine()) != null) {
				instructionSet = inputCode.toCharArray();
				instructionSet = simulate.execute(instructionSet);
				output=String.valueOf(instructionSet);
				System.out.print(output+"\n");
			}
			inputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, File not found");
			System.exit(1);
			e.printStackTrace();
		}

	}
}
