package com.cags.EC;

import java.util.List;

/**
 * Encloses the phenotype of an Individual T	
 */

public abstract class Phenotype<T> {	
	/**
	 * 
	  * @param index dimension (variable) index in the phenotype List
	 * @param value	value to be set at index.
	 */
	
	public abstract void setValue(int index, T value);
	public abstract T getValue(int index);
	public abstract int  length();
	public abstract T getMinValue();
	public abstract T getMaxValue();
	public abstract List<T> asList();
	public abstract Phenotype<T> clone();
	public abstract void randomize();

}
