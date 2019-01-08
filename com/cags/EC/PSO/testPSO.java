package com.cags.EC.PSO;
import com.cags.EC.*;

public class testPSO {

	public static void main(String[] args) {
		DoublePSO PSO1 = new DoublePSO(PSO.goal.MINIMIZE,10000, 1000);
		ObjectiveFunction<Double>  function = TestFunctions.getInstance();
		PSO1.setObjectiveFunction(function);
		PSO1.setIndividualFactory(	new DoubleParticleFactory(function.length() , -10 , 10	)	);
		PSO1.setVelocityFunction(new VelocityFunction( 1 , .2 , .2) );
		PSO1.run();
	}
}
