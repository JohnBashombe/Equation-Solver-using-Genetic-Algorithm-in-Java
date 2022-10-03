package EquationSolver;

import java.util.Random;

public class DNA {

	Random random;

	float fitness;

	int[] genes;

	int total;

	public DNA(int num) {

		random = new Random();

		genes = new int[num];

		for (int i = 0; i < genes.length; i++) {

			genes[i] = random.nextInt(31);

		}

	}

	String getItem() {

		String answer = "";

		for (int i = 0; i < genes.length; i++) {
			answer += genes[i] + " ";
		}

		return new String(answer);

	}

	void calculateFitness() {

		fitness = Math.abs((genes[0]) + (2 * genes[1]) + (3 * genes[2]) + (4 * genes[3]) - (30));

	}

	DNA crossover(DNA partner) {

		DNA child = new DNA(genes.length);

		int midpoint = (int) (Math.random() * genes.length);

		for (int i = 0; i < genes.length; i++) {
			if (i < midpoint) {
				child.genes[i] = genes[i];
			} else {
				child.genes[i] = partner.genes[i];
			}
		}

		return child;

	}

	void mutation(float mutationRate) {

		double degree = random.nextDouble();

		for (int i = 0; i < genes.length; i++) {

			if (degree < mutationRate) {

				genes[i] = random.nextInt(31);

			}
		}

	}

}
