package gc.genetic;

/**
 * 
 * @author <a href="mailto:leandro.lucas_@hotmail.com">Leandro Lucas Santos</a>
 */
public class MyGenetic extends Genetic {
	public MyGenetic(int num_genes_per_chromosome, int num_chromosomes, float crossover_fraction, float mutation_fraction) {
		super(num_genes_per_chromosome, num_chromosomes, crossover_fraction, mutation_fraction);
	}

	private float fitness(float x) { //cos(x+2) * cos(0.1 * x)
		return (float) (Math.cos(x + 2) * Math.cos(0.1f * x));
//		return (float)(Math.sin(x) * Math.sin(0.4f * x) * Math.sin(3.0f * x));
	}

	public float geneToFloat(int chromosomeIndex) {
		int base = 1;
		float x = 0;
		for (int j = 0; j < numGenesPerChromosome; j++) {
			if (getGene(chromosomeIndex, j)) {
				x += base;
			}
			base *= 2;
		}
		x /= 102.4f;
		return x;
	}

	public void calcFitness() {
		for (int i = 0; i < numChromosomes; i++) {
			float x = geneToFloat(i);
			getChromosomes().get(i).setFitness(fitness(x));
		}
	}

	public void setXPosInChromosomes() {
		for (int i = 0; i < numChromosomes; i++) {
			float x = geneToFloat(i);
			getChromosomes().get(i).setX(x);
		}
	}

	public void print() {
		float sum = 0.0f;
		for (int i = 0; i < numChromosomes; i++) {
			float x = geneToFloat(i);
			sum += getChromosomes().get(i).getFitness();
			System.out.print("Fitness for chromosome ");
			System.out.print(i);
			System.out.print(" is ");
			System.out.println(getChromosomes().get(i).getFitness() + ", occurs at x=" + x);
		}
		sum /= (float) numChromosomes;
		System.out.println(
				"Average fitness=" + sum + " and best fitness for this generation:" + getChromosomes().get(0).getFitness());

	}

	public float getFitnessAverage() {
		float sum = 0.0f;
		for (int i = 0; i < numChromosomes; i++) {
			geneToFloat(i);
			sum += getChromosomes().get(i).getFitness();
		}
		return (sum / (float) numChromosomes);
	}

}
