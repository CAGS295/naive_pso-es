package com.cags.EC.PSO;
import com.cags.EC.*;

import java.util.List;

/**
 * An extensión of Individual<P> that encloses a particle instance of the prior best position and a List<P> of velocities for each dimension (variable). 
 */
public abstract class Particle<P> extends Individual<P> {
	protected Particle<P> bestlocal;
	protected List<Double> velocity;
	
	public Particle(Phenotype<P> phenotype) {
		super(phenotype);
		startVelocity();		
	}
	
	public abstract void setVelocity(List<P> velocity);
	public abstract List<Double> getVelocity();	
	public abstract void startVelocity();
	public abstract Particle<P> clone();
	
}
