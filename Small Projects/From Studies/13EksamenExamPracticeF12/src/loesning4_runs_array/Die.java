package loesning4_runs_array;

import java.util.Random;

public class Die {
	private Random generator;
	private int max;

	public Die(int max) {
		if (max > 1) {
			this.max = max;
			this.generator = new Random();
		}
		else{
			System.out.println("Fejl ved oprettelse af Die. Der skal være mindst 2 sider på terningen.");
		}
	}

	public int throwDie() {
		return generator.nextInt(max) + 1;
	}

}
