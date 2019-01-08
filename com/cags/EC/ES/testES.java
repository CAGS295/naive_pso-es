package com.cags.EC.ES;

import com.cags.EC.DoubleMutation;
import com.cags.EC.Evolutionary_Computation;
import com.cags.EC.ObjectiveFunction;
import com.cags.EC.PSO.TestFunctions;


public class testES {

	public static void main(String[] args) {
		Double_1_1_ES ES = new Double_1_1_ES(500, 1000,Evolutionary_Computation.goal.MAXIMIZE);
		ObjectiveFunction<Double>  function = TestFunctions.getInstance();
		ES.setObjectiveFunction(function);
		ES.setIndividualFactory(	new DoubleIndividualFactory(function.length() , -2 , 2	)	);
		ES.setMutator(new DoubleMutation(100, .1, Evolutionary_Computation.goal.MAXIMIZE));
		ES.run();
		System.out.println(ES.getBest());
	}
}
