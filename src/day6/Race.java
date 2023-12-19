package day6;

public class Race {

	/**
	 * Limite de temps de la course
	 */
	private long time;
	
	/**
	 * Distance minimale pour gagner
	 */
	private long distance;
	
	public Race(long time, long distance) {
		this.time = time;
		this.distance = distance;
	}
	
	public long getTime() {
		return time;
	}

	public long getDistance() {
		return distance;
	}


	public int nbWaysToWin() {
		int nbWaysToWin = 0;
		
		//Parcourir chaque possibilité de temps
		//<= car on a la possiblité de 0 secondes d'appui et la possibilité de que appui et 0 secondes de courses
		//Ces deux cas auront en résultat 0, mais peuvent être pris en compte
		long timeOnMove;
		long distanceMoved;
		
		System.out.println(this.toString());
		
		//Résultats selon le temps en hold : [false, vitesse trop faible][ok][false, temps en hold trop important]
		//Optimisation pour ne pas lire les cas lorsqu'on atteint la 3e intervalle
		boolean isLimitOvercome = false;
		
		//Temps passé à appuyer = vitesse générée (1:1)
		for(long speed = 0; speed <= this.time; speed++) {
			timeOnMove = this.time - speed;
			
			distanceMoved = timeOnMove * speed;

			if(distanceMoved > distance) {
				if(!isLimitOvercome)
					isLimitOvercome = true;
				nbWaysToWin++;
			} else {
				if(isLimitOvercome)
					break;
			}
		}
		
		System.out.println(this.toString() + " - nbWaysToWin = " + nbWaysToWin);
		
		return nbWaysToWin;
	}

	@Override
	public String toString() {
		return "Course : time = " + this.time + " - distance = " + this.distance;
	}
}
