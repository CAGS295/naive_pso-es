package com.cags.EC.PSO;
import java.util.ArrayList;
import java.util.List;
import com.cags.EC.*;

/**
 * Double implementation of class Particle. * 
 */
public class DoubleParticle extends Particle<Double> {	
	/**
	 * @param dblPhenotype a Double implementation of a phenotype.
	 */
	

	public DoubleParticle(Phenotype<Double> dblPhenotype) {
		super(dblPhenotype);
	}
	
	/**
	 * Uses StringBuilder() to build a string representation of the particle's phenotype and its fitness;
	 */
	public String toString() {
		

		StringBuilder sb = new StringBuilder();		
		sb.append('<');
		for(int v = 0; v < phenotype.length(); v ++) {
			sb.append(String.format(" %.8f", phenotype.getValue(v)));
			if(v < phenotype.length() - 1) sb.append(", ");
		}
		sb.append(String.format(">; Fitness:  %.6f \n", super.fitness));
		return sb.toString();
	}

	/**
	 * Clone method for a Double Particle.
	 */
	@Override
	public Particle<Double> clone() {
		
		Particle<Double> clone = new DoubleParticle(super.phenotype.clone()); 
		clone.setFitness(this.fitness);
		clone.bestlocal = this.bestlocal;
		return clone;
	}
	
	/**
	 * Outputs the Particle's phenotype as a Double List . 
	 */
	public List<Double> getPhenotype() {		
		return this.phenotype.asList();
	}


	@Override
	/**
	 * set the velocity of the Particle as a List containing the velocities for each dimension.  
	 */
	public void setVelocity(List<Double> velocity) {		
		super.velocity = velocity;	
	}

	/**
	 * get the velocity of the Particle as a List containing the velocities for each dimension.  
	 */
	
	@Override
	public List<Double> getVelocity() {		
		return super.velocity;
	}
	
	/**
	 * Primes a List<Double> of velocities for the phenotype at 0.0s.
	 */ 
	public void startVelocity() {		
		int length = phenotype.asList().size();
		List<Double> newVelocity= new ArrayList<Double>(length);
		for(int i=0 ; i< length ; i++) newVelocity.add(0.0);
		super.velocity=newVelocity;
	}	
}
