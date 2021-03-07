package loesning4_runs_array;

import java.util.Arrays;

public class DieAnalyser {
	
	private int max;
	private int[] intArray;

	public DieAnalyser(int max, int length) {
		intArray = new int[length];
		this.max = max;
	}

	public void fillArray() {
		Die die = new Die(max);
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = die.throwDie();
		}
		System.out.println(Arrays.toString(intArray));
	}

	public String toString() {
		boolean inRun = false;
		String r = "[";
		/* look for runs of numbers */
		for (int i = 0; i < intArray.length; i++) {
			if (inRun) {
				if (intArray[i] != intArray[i - 1]) {
					r = r + ")";
					inRun = false;
				}
			}
			if (i > 0)
				r = r + ", ";
			if (!inRun) {
				if (i < intArray.length - 1 && intArray[i] == intArray[i + 1]) {
					r = r + "(";
					inRun = true;
				}
			}
			r = r +  intArray[i];
		}

		/* check for possible final run */
		if (inRun){
			r = r + ")";
		}
		return r + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Opg b
		DieAnalyser ria = new DieAnalyser(4, 10);
		ria.fillArray();
		
		// Opg c
		System.out.println(ria);
	}

}
