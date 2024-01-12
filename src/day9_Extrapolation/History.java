package day9_Extrapolation;

import java.util.LinkedList;

public class History {

	LinkedList<Integer> firstSequence;
	
	LinkedList<LinkedList<Integer>> listSequences;
	
	public History(LinkedList<Integer> firstSequence) {
		this.firstSequence = firstSequence;
		
		this.listSequences = new LinkedList<LinkedList<Integer>>();
		this.listSequences.add(firstSequence);
	}
	
	public int extrapolateNextValue() {		
		
		findDifferencesUntilAllZeros();
		
		//Extrapoler
		//TODO
		//Ajouter le 0 à la dernière ligne
		this.listSequences.getLast().add(0);
		
		//Pour chaque ligne remontée, on additionne l'élément de gauche et l'élément du bas (= dernier élément de la ligne suivante)
		int newValue;
		for(int indexLine = this.listSequences.size() - 2; indexLine >= 0; indexLine--) {
			newValue = this.listSequences.get(indexLine).getLast() + this.listSequences.get(indexLine + 1).getLast();
			this.listSequences.get(indexLine).add(newValue);
		}
		
		return this.listSequences.getFirst().getLast();
	}
	
	public int extrapolatePreviousValue() {		
		
		findDifferencesUntilAllZeros();
		
		//Extrapoler
		//TODO
		//Ajouter le 0 à la dernière ligne
		this.listSequences.getLast().add(0);
		
		//Pour calculer la valeur de la ligne précédente, il faut se baser sur le calcul des différences
		//ex : l1 = A 2 ... 	l2 = 0		donc 2-A=0 <=> A = -1 x (0 - 2)		soit 2-A=0 <=> B-A=C	<=> A = -1 x (C-B)
		//A : newValue		B = first L1	C = first L2
		
		//Pour chaque ligne remontée, on additionne l'élément de gauche et l'élément du bas (= dernier élément de la ligne suivante)
		int newValue;
		for(int indexLine = this.listSequences.size() - 2; indexLine >= 0; indexLine--) {
			newValue = -1 * (this.listSequences.get(indexLine + 1).getFirst() - this.listSequences.get(indexLine).getFirst());
			
			this.listSequences.get(indexLine).addFirst(newValue);
		}
		
		return this.listSequences.getFirst().getFirst();
	}
	
	private void findDifferencesUntilAllZeros() {
		//Générer les séquences jusqu'à atteindre l'état 0
		boolean isAllZero = false;
		
		while(!isAllZero) {
			this.listSequences.add(this.generateNextSequenceBySubstract(this.listSequences.getLast()));
			
			isAllZero = this.isSequenceAllZero(this.listSequences.getLast());
		}
	}
	
	private LinkedList<Integer> generateNextSequenceBySubstract(LinkedList<Integer> previousSequence) {
		LinkedList<Integer> nextSequence = new LinkedList<Integer>();
		
		for(int indexValue = 1; indexValue < previousSequence.size(); indexValue++) {
			nextSequence.add(previousSequence.get(indexValue) - previousSequence.get(indexValue - 1));
		}
		
		return nextSequence;
	}
	
	private boolean isSequenceAllZero(LinkedList<Integer> sequence) {
		boolean isAllZero = true;
		
		for(Integer value : sequence) {
			if(value != 0) {
				isAllZero = false;
				break;
			}
		}
		
		return isAllZero;
	}
}
