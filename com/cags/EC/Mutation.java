package com.cags.EC;


public abstract class Mutation<P> {
	
	int noffspring=0;
	P sd;		
	
/**
 * mutates an individual and sets a better fitted offspring.
 * @param noffspring number of offsprings 
 * @param sd deviation to mutate the parent
 */
	public Mutation(int noffspring,P sd) {
		this.setNoffspring(noffspring);
		this.setSd(sd);
		
	}


	public int getNoffspring() {
		return noffspring;
	}


	public void setNoffspring(int noffspring) {
		if(noffspring < 1) throw new IllegalArgumentException("Individual must have at least one offspring");
		this.noffspring = noffspring;
	}


	public P getSd() {
		return sd;
	}

	public void setSd(P sd) {
		this.sd = sd;
	}
	
	public abstract int mutate(Individual<P> individuo, ObjectiveFunction<P> of );


	
}
