package com.cags.EC;

import java.util.List;

/**
 * Interface for the objective function to be optimized.
 */
public interface ObjectiveFunction<P> {
	int length();
	double f(List<P> args);
	
}
