package glazer.microprocessorSimulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Compiler {
	private StringBuilder machineCode;

	public Compiler(String fileName) throws IOException {
		machineCode = new StringBuilder();
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		String inputCode;
		while ((inputCode = input.readLine()) != null) {
			translate(inputCode);
		}
		input.close();
	}

	private void translate(String inputCode) {
		String[] tokens = inputCode.split(" ");
		// TODO Auto-generated method stub
		switch (tokens[0]) {
		case "LD":
			this.machineCode.append("0");
			this.machineCode.append(convertToHex(tokens[1]));
			break;
		case "ST":
			this.machineCode.append("1");
			this.machineCode.append(convertToHex(tokens[1]));
			break;
		case "SWP":
			this.machineCode.append("2");
			break;
		case "ADD":
			this.machineCode.append("3");
			break;
		case "INC":
			this.machineCode.append("4");
			break;
		case "DEC":
			this.machineCode.append("5");
			break;
		case "BZ":
			this.machineCode.append("6");
			this.machineCode.append(convertToHex(tokens[1]));
			break;
		case "BR":
			this.machineCode.append("7");
			this.machineCode.append(convertToHex(tokens[1]));
			break;
		case "STP":
			this.machineCode.append("8");
			break;
		case "DATA":
			this.machineCode.append(tokens[1]);
			break;
		}
	}

	public String convertToHex(String code) {
		int decimal = Integer.parseInt(code);
		String hex = Integer.toString(decimal, 16).toUpperCase();
		if (hex.length() == 1) {
			return "0" + hex;
		}
		return hex;
	}

	private String getMachineCode() {
		// TODO Auto-generated method stub
		return machineCode.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "./assemblyLanguage.txt";
		Compiler compiler;
		try {
			compiler = new Compiler(fileName);
			System.out.println(compiler.getMachineCode());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
