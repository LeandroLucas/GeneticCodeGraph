package gc.genetic;

import java.util.Comparator;

public class ChromosomeComparator implements Comparator<Chromosome> {
	public int compare(Chromosome o1, Chromosome o2) {
		return (int) (1000 * (o2.getFitness() - o1.getFitness()));
	}
}
