package gc.genetic;

import java.util.BitSet;

public class Chromosome {
	BitSet chromosome;
	float fitness = -999;
	float x;

	@SuppressWarnings("unused")
	private Chromosome() {
	}

	public Chromosome(int num_genes) {
		chromosome = new BitSet(num_genes);
	}

	public boolean getBit(int index) {
		return chromosome.get(index);
	}

	public String toString() {
		return "[Chromosome: fitness: " + fitness + ", bit set: " + chromosome + "]";
	}

	public void setBit(int index, boolean value) {
		chromosome.set(index, value);
	}

	public float getFitness() {
		return fitness;
	}

	public void setFitness(float value) {
		fitness = value;
	}

	public boolean equals(Chromosome c) {
		return chromosome.equals(c.chromosome);
	}

	public BitSet getChromosome() {
		return chromosome;
	}

	public void setChromosome(BitSet chromosome) {
		this.chromosome = chromosome;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

}
