package microprocessorSimulation;

public class MicroprocessorSimulation {
	private int a;
	private int b;
	private int index;
	private char[] instructionSet;
	String hex;
	String forA;
	String forB;
	int num;

	public MicroprocessorSimulation() {
	}

	public char[] execute(char[] instructionSet) {
		index = 0;
		b = 0;
		a = 0;
		this.instructionSet = instructionSet;
		char value;
		while (index < instructionSet.length) {
			value = instructionSet[index];
			numWords(value);
		}
		return instructionSet;
	}

	public void numWords(char code) {

		switch (code) {
		case '0':
			hex = findArgument();
			num = convertToInteger(hex);
			a = findValue(num);
			incrementIndex(3);
			break;
		case '1':
			hex = findArgument();
			num = convertToInteger(hex);
			instructionSet[num] = convertToHex(a).charAt(0);
			incrementIndex(3);
			break;
		case '2':
			int swap;
			swap = a;
			a = b;
			b = swap;
			incrementIndex(1);
			break;
		case '3':
			num = a + b;
			hex = convertToHex(num);
			if (hex.length() == 2) {
				a = convertToInteger(hex.charAt(1) + "");
				b = convertToInteger(hex.charAt(0) + "");
			} else {
				a = convertToInteger(hex);
				b = 0;
			}
			incrementIndex(1);
			break;

		case '4':
			a++;
			if (a == 16) {
				a = 0;
			}
			incrementIndex(1);
			break;
		case '5':
			a--;
			if (a == -1) {
				a = 15;
			}
			incrementIndex(1);
			break;
		case '6':
			// If accumulator A is zero, the next command to be executed is at
			// the location specified by
			// the argument. If A is not zero, the argument is ignored and
			// nothing happens.
			if (a == 0) {
				hex = findArgument();
				index = convertToInteger(hex);
			} else {
				incrementIndex(3);
			}
			break;
		case '7':
			hex = findArgument();
			index = convertToInteger(hex);
			break;
		case '8':
			index = 256;
		}

	}

	private void incrementIndex(int increment) {
		index += increment;
	}

	private int findValue(int num) {
		// TODO Auto-generated method stub
		return convertToInteger(instructionSet[num] + "");
	}

	public String convertToHex(int code) {
		return Integer.toString(code, 16).toUpperCase();
	}

	public int convertToInteger(String hex) {
		return Integer.parseInt(hex, 16);
	}

	public String findArgument() {
		return instructionSet[index + 1] + "" + instructionSet[index + 2];
	}
}
