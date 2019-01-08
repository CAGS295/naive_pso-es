package com.cags.EC;


import java.util.Random;

public class DoubleMutation extends Mutation<Double> {
	Evolutionary_Computation.goal goal;

	public DoubleMutation(int noffspring, double sd, Evolutionary_Computation.goal g) {
		super(noffspring, sd);
		this.goal=g;
	}

	public int mutate(Individual<Double> duddlet, ObjectiveFunction<Double> OF) {
		int doesmutate = 0;
		Random r = new Random();
		int j=0;
		while(j++<this.noffspring) {
			Individual<Double> offspring = new DoubleIndividual(duddlet.phenotype.clone());
			for(int i = 0 ; i < duddlet.getPhenotype().size() ; i++) {
				offspring.getPhenotype().set( i, duddlet.getPhenotype().get(i)  +  sd * r.nextGaussian() ) ;			
			}
			offspring.setFitness(OF.f(offspring.getPhenotype()));
			if(goal == Evolutionary_Computation.goal.MAXIMIZE && offspring.getFitness() > duddlet.getFitness()) {
				 duddlet=offspring;//intentar con clone si falla
				 doesmutate = 1;
			}
			if(goal == Evolutionary_Computation.goal.MINIMIZE && offspring.getFitness() < duddlet.getFitness()) {
				 duddlet=offspring;//intentar con clone si falla
				 doesmutate = 1;
			}			
		}		
		
		return doesmutate;	
	}
}
