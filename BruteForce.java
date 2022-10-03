package EquationSolver;

public class BruteForce {

	int limit = 30;

	int result;

	int countSolution;
	int iteration;

	void tryEverything() {

		for (int a = 0; a < limit; a++) {

			for (int b = 0; b < limit; b++) {

				for (int c = 0; c < limit; c++) {

					for (int d = 0; d < limit; d++) {

						result = a + 2 * b + 3 * c + 4 * d;

						iteration++;

						if (result == 30) {
							countSolution++;
							System.out.println("A is " + a + ", B is " + b + ", C is " + c + " and D is " + d);
							System.out.println();
						}

					}

				}
			}

		}

		System.out.println();
		System.out.println(countSolution + " Solutions Found Using Brute Force Search.");
		System.out.println();
		System.out.println(iteration + " Iterations have been made during this Brute Force Searching.");

	}

	public static void main(String[] args) {

		BruteForce bruteForce = new BruteForce();
		bruteForce.tryEverything();

	}

}
