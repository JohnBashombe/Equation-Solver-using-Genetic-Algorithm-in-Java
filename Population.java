package EquationSolver;

import java.util.ArrayList;

public class Population {

	float mutationRate = (float) 0.01;
	int totalPopulation = 200;

	DNA[] population;

	int variable = 4;

	boolean find = true;

	ArrayList<DNA> matingPool = new ArrayList<>();

	int generation = 1;

	public Population() {

		initialFunction();

	}

	void initialFunction() {

		population = new DNA[totalPopulation];

		for (int i = 0; i < population.length; i++) {

			population[i] = new DNA(variable);

		}

	}

	void draw() {

		int total = 0;

		while (find) {

			
			// This calculate the fitness of each chromosome
			for (int i = 0; i < population.length; i++) {
				population[i].calculateFitness();
			}

			// This covert the fitness in between 0 and 1
			
			for (int i = 0; i < population.length; i++) {
				population[i].fitness = 1 / 1 + population[i].fitness;
				
				if (population[i].fitness == 1) {

					System.out.println("The answer is : " + population[i].getItem());
					System.out.println("Find After  :  " + generation + "   Generations.");
					System.out.println();
					find = false;
					return;
				}
			}
			
			for (int i = 0; i < population.length; i++) {
				total += population[i].fitness;
			}

			for (int i = 0; i < population.length; i++) {
				population[i].fitness = population[i].fitness / total;
			}

			callArray();
			operation();
			//print();
			generation++;

		}

	}

	void callArray() {

		matingPool.clear();

		for (int i = 0; i < population.length; i++) {

			int times = (int) (Math.ceil(population[i].fitness * 100));

			for (int j = 0; j < times; j++) {

				matingPool.add(population[i]);

			}

		}

	}

	void operation() {

		for (int i = 0; i < population.length; i++) {

			int pick1 = (int) (Math.random() * matingPool.size());
			int pick2 = (int) (Math.random() * matingPool.size());

			DNA partnerA = matingPool.get(pick1);
			DNA partnerB = matingPool.get(pick2);

			DNA child = partnerA.crossover(partnerB);

			child.mutation(mutationRate);

			population[i] = child;

		}

	}

	void print() {

		System.out.println("Generation : " + generation);

	}

}
