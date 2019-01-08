package com.cags.EC.PSO;
import java.security.InvalidParameterException;

import com.cags.EC.*;
/**
 * Factory of Double particles  using the randomize() method implemented in DoubleArrayPhenotype. Sets the Particle's best local at its current position. Fitness defaults to 0.0.
 */
public class DoubleParticleFactory extends ParticleFactory<Double> {
	

	private int nComponents;
	private double minValue, maxValue;
	
	public DoubleParticleFactory(int nComponents, double min, double max) {		
		this.setnComponents(nComponents);
		this.minValue    = min;
		this.maxValue    = max;
	}		
	/**
	 * Creates a new Particle with a random position within bounds set by the phenotype. Fitness defaults to 0.0.
	 */
	@Override
	public Particle<Double> create() {
		
		Phenotype<Double>   phenotype  = new DoubleArrayPhenotype(this.nComponents, this.minValue, this.maxValue);
		phenotype.randomize();	
		Particle<Double> nparticle = new DoubleParticle(phenotype);		
		nparticle.bestlocal = nparticle.clone();
		return nparticle;
	}
	public void setnComponents(int nComponents) throws InvalidParameterException{
		if(nComponents<1) throw new InvalidParameterException("nComponents must be greater than 0");
		this.nComponents = nComponents;
	}
	
	
}
