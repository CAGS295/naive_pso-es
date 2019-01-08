package com.cags.EC;


import java.util.Random;

/**
 * velocity update function for the swarm.
 * xk = current position of particle k
 *vk = current velocity of particle k
 *pk = best position found by particle k
 *Q(x) = quality of position x
 *g = index of best position found so far
 *phi_1, phi_2 = random variables uniformly distributed over
[0, 2]
w = inertia < 1
 */

public class VelocityFunction  {	
	
	private double w=1,phi_k, phi_g;
	private int length=0;
	
	public VelocityFunction(double w,double phi_k,double phi_g) {
		setW(w);
		setPhi_k(phi_k);
		setPhi_g(phi_g);		
	}

	public int length() throws IllegalArgumentException {
		if(this.length<0) throw new IllegalArgumentException("negative length not allowed");
		return length;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) throws IllegalArgumentException{
		if(w<=0 ) throw new IllegalArgumentException("w must be  greater than 0.");
		this.w = w;
	}

	public double getPhi_k() {
		return phi_k;
	}

	public void setPhi_k(double phi_k) throws IllegalArgumentException{
		if(phi_k > 2 || phi_k < 0) throw new IllegalArgumentException("phi_k must be between range [0,2].");
		this.phi_k = phi_k;
	}

	public double getPhi_g() {
		return phi_g;
	}

	public void setPhi_g(double phi_g) throws IllegalArgumentException{
		if(phi_g > 2 || phi_g < 0) throw new IllegalArgumentException("phi_g must be between range [0,2].");
		this.phi_g = phi_g;
	}

	/**
	 * function that updates velocity for a single dimension at a time.
	 * @param vel velocity to be updated
	 * @param x    current position of x dimension.
	 * @param k		position of best local for x dimension.
	 * @param g    position of best global for x dimension.
	 * @return	returns the new velocity v' as adouble.  
	 */
	
	public double f(double vel, double x , double k ,double g ) {
		
		Random r = new Random();		
		double velocity = this.w*vel + this.phi_k * r.nextDouble() *  (k - x)  + this.phi_g * r.nextDouble() * ( g - k );			
		return velocity;
	}

}
