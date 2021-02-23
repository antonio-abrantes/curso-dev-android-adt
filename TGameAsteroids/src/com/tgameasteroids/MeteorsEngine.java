package com.tgameasteroids;

import java.util.Random;

import org.cocos2d.layers.CCLayer;

public class MeteorsEngine extends CCLayer {

	private MeteorsEngineDelegate delegate;

	public MeteorsEngine() {
		this.schedule("meteorsEngine", 1.0f / 10f);
	}

	public void meteorsEngine(float dt) {
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			if (new Random().nextInt(25) == 0) {
				this.getDelegate().createMeteor(new Meteor(Assets.METEOR));
			}
		}
	}


	public void setDelegate(MeteorsEngineDelegate delegate) {
		this.delegate = delegate;
	}

	public MeteorsEngineDelegate getDelegate() {
		return delegate;
	}

}
