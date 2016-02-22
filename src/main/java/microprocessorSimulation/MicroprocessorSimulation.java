package microprocessorSimulation;

public class MicroprocessorSimulation {
	private int a;
	private int b;
	private int y;
	private char[] instructionSet;

	public MicroprocessorSimulation() {

	}

//	 private char[] getResult() {
//	 // TODO Auto-generated method stub
//	 char[] hi = new char[3];
//	 // hi[0]='f';
//	 // hi[1]= 'm';
//	 // hi[2]='o';
//	 return hi;
//	 }

	public char[] execute(char[] instructionSet) {
		y = 0;
		this.instructionSet = instructionSet;
		char index;
		while (y < instructionSet.length) {
			index = instructionSet[y];
			//System.out.println(instructionSet[y]+"Hi");
			
			numWords(index);
		}
		return instructionSet;
	}

	public void numWords(char code) {
		String hex;
		String forA;
		String forB;
		int num;
		switch (code) {
		case '0':
			hex = instructionSet[y + 1] + "" + instructionSet[y + 2];
			num = Integer.parseInt(hex, 16);
			forA = instructionSet[num]+"";
			a=Integer.parseInt(forA, 16);
			y += 3;
			break;
		case '1':
			hex = instructionSet[y + 1] + "" + instructionSet[y + 2];
			num = Integer.parseInt(hex, 16);
			hex = Integer.toString(a, 16).toUpperCase();
			instructionSet[num] = hex.charAt(0);
			y += 3;
			break;
		case '2':
			int swap;
			swap = a;
			a = b;
			b = swap;
			y += 1;
			break;
		case '3':

			int sum = a + b;

			hex = Integer.toString(sum, 16).toUpperCase();
			
			forB = hex.charAt(0)+"";
			b=Integer.parseInt(forB, 16);
			if (hex.length() == 2) {
				forA=hex.charAt(1)+"";
				a=Integer.parseInt(forA, 16);
			} //else {
				//b = 0;
			//}
			y += 1;
			break;
		case '4':
			a++;
			y += 1;
			break;
		case '5':
			a--;
			if (a == -1) {
				a = 15;
			}
			y += 1;
			break;
		case '6':
			// If accumulator A is zero, the next command to be executed is at
			// the location specified by
			// the argument. If A is not zero, the argument is ignored and
			// nothing happens.
			if (a == 0) {
				y = Integer.parseInt(instructionSet[y + 1] + ""
						+ instructionSet[y + 2], 16);
			}
			y += 3;
			break;
		case '7':
			hex = instructionSet[y + 1] + "" + instructionSet[y + 2];
			num = Integer.parseInt(hex, 16);
			y = num;
			break;
		case '8':
			y = 256;
		}

	}
}
