package com.tgameasteroids;

import java.util.Random;

import org.cocos2d.layers.CCLayer;

public class EnergysEngine extends CCLayer {

	private EnergysEngineDelegate delegate;

	public EnergysEngine() {
		this.schedule("energysEngine", 1.0f / 10f);
	}

	public void energysEngine(float dt) {

		if (new Random().nextInt(150) == 0) {
			this.getDelegate().createEnergy(new Energy(Assets.ENERGY));
		}
	}

	public void setDelegate(EnergysEngineDelegate delegate) {
		this.delegate = delegate;
	}

	public EnergysEngineDelegate getDelegate() {
		return delegate;
	}
}
