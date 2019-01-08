package com.cags.EC.ES;

import com.cags.EC.Individual;

public abstract class IndividualFactory<P> {

	public abstract Individual<P> create();

}
