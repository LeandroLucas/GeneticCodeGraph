package gc;

import java.util.ArrayList;

import gc.data.Data;
import gc.genetic.Chromosome;
import gc.genetic.MyGenetic;
import gc.view.Window;

/**
 * Genetic Algorithm Java classes
 *
 * <p/>
 * Copyright 1996-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */

public class Main {

	static MyGenetic genetic_experiment;
	public static double interval = 1;

	static public void main(String args[]) throws InterruptedException {
		Window window = new Window();

		// we will use chromosomes with 10 1 bit genes per
		// chromosomes, and a population of 12 chromosomes:
		genetic_experiment = new MyGenetic(10, 20, 0.85f, 0.3f);
		int geneIndex = 0; // debug only
		for (Chromosome ll : genetic_experiment.getChromosomes()) {
			System.out.println(ll.getChromosome() + " : " + genetic_experiment.geneToFloat(geneIndex++));
		}
		int NUM_CYCLES = 10000;
		for (int i = 0; i <= NUM_CYCLES; i++) {
			int generation = i;
			genetic_experiment.evolve();
			// if ((i%100)==0) {
			if (generation > 0)
				Thread.sleep((long) interval * 1000);
			// System.out.println("Generation " + i);
			genetic_experiment.calcFitness(); // suggested by Rick Hall
			genetic_experiment.sort(); // suggested by Rick Hall
			// genetic_experiment.print();
			genetic_experiment.setXPosInChromosomes();
			Data data = new Data(generation, genetic_experiment.getFitnessAverage());
			ArrayList<Chromosome> cms = new ArrayList<Chromosome>();
			cms.addAll(genetic_experiment.getChromosomes());
			data.setChromosomes(cms);
			window.updateGraph(data);
			// }
		}
	}
}
