package com.cags.EC.PSO;
import com.cags.EC.*;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

import java.util.List;

/**
 * encloses functions to test the PSO implementations. Must manually adjust the parameters on usage.
 */

public class TestFunctions implements ObjectiveFunction<Double> {	

	private static TestFunctions instance = null;
	
	private TestFunctions() {
		
	}
	
	@Override
	public int length() {
		return 3;  //mover
	}

	@Override
	public double f(List<Double> args) {
		double x1 = args.get(0);
		double x2 = args.get(1);
		double x3 = args.get(2);
//		return 20 + (x1 * x1) + (x2 * x2) - 10 * (cos(2 * PI * x1) + cos(2 * PI * x2)); //Rastrigin MIN
		return -x1*x1-x2*x2 -x3*x3;	// MAX <0,0,0>
//		return (1.5 - x1  +x1*x2)*(1.5 - x1  +x1*x2) + (2.25 - x1 + x1*x2*x2)*(2.25 - x1 + x1*x2*x2) + (2.625 - x1 + x1*x2*x2*x2)*(2.625 - x1 + x1*x2*x2*x2);		//Beale		MIN <3,.5>
//		return 100*(x2 - x1*x1)*(x2 - x1*x1) + (x1-1)*(x1-1);				//rosenbrock MIN <0,0>
//		return x1*x1; // <0,0>
	}
	
	public static TestFunctions getInstance() {
		if(instance == null) instance = new TestFunctions();
		return instance;
	}

}
