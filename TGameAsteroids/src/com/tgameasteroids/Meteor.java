package com.tgameasteroids;

import static com.tgameasteroids.DeviceSettings.*;

import java.util.Random;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCScaleBy;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;

public class Meteor extends CCSprite {
	private float x, y;
	private MeteorsEngineDelegate delegate;

	public Meteor(String image) {
		super(image);
		x = new Random().nextInt(Math.round(screenWidth()));
		y = screenHeight();
	}

	public void start() {
		this.schedule("update");
	}

	public void update(float dt) {
		// pause
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			y -= 1;
			this.setPosition(screenResolution(CGPoint.ccp(x, y)));
		}
	}

	public void setDelegate(MeteorsEngineDelegate delegate) {
		this.delegate = delegate;
	}

	//Funcao para removar o componente
	public void shooted() {
		SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), R.raw.explosao);
		this.delegate.removeMeteor(this);
		this.unschedule("update");
		float dt = 0.2f;
		CCScaleBy a1 = CCScaleBy.action(dt, 0.5f);
		CCFadeOut a2 = CCFadeOut.action(dt);
		CCSpawn s1 = CCSpawn.actions(a1, a2);
		CCCallFunc c1 = CCCallFunc.action(this, "removeMe");
		this.runAction(CCSequence.actions(s1, c1));
	}

	public void removeMe() {
		this.removeFromParentAndCleanup(true);
	}
}
