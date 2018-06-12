package gc.data;

import java.util.List;

import gc.genetic.Chromosome;

public class Data {

	private int generation;
	private float fitnessAverage;
	private List<Chromosome> chromosomes;

	public Data(int generation, float average) {
		this.generation = generation;
		this.fitnessAverage = average;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public float getFitnessAverage() {
		return fitnessAverage;
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public void setFitnessAverage(float fitnessAverage) {
		this.fitnessAverage = fitnessAverage;
	}

}
