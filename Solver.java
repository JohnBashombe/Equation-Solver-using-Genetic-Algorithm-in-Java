package EquationSolver;

public class Solver {

	static int iteration = 100;
	static Population population;

	public Solver() {
		population = new Population();
	}

	public static void main(String[] args) {

		System.out.println("The Equation is : A + 2B + 3C + 4D = 30");
		System.out.println();

		for (int i = 0; i < iteration; i++) {

			Solver solver = new Solver();
			population.draw();
		}

		System.out.println();
		System.out.println("Solutions Generated : " + iteration);
		System.out.println("Population : " + population.totalPopulation);
		System.out.println("Mutation Rate : " + population.mutationRate);
	}

}
