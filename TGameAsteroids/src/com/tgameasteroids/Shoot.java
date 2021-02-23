package com.tgameasteroids;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCScaleBy;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import static com.tgameasteroids.DeviceSettings.*;

public class Shoot extends CCSprite {
	private ShootEngineDelegate delegate;
	float positionX, positionY;

	public Shoot(float positionX, float positionY) {
		super(Assets.SHOOT);
		this.positionX = positionX;
		this.positionY = positionY;
		setPosition(this.positionX, this.positionY);
		this.schedule("update");
	}

	public void update(float dt) {
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			positionY += 2;
			this.setPosition(screenResolution(CGPoint.ccp(positionX, positionY)));
		}
	}

	public void setDelegate(ShootEngineDelegate delegate) {
		this.delegate = delegate;
	}

	public void start() {
		System.out.println("Tiro funcionando");
		SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), R.raw.disparo);
	}

	public void explode() {

		this.delegate.removeShoot(this);

		this.unschedule("update");

		float dt = 0.2f;
		CCScaleBy a1 = CCScaleBy.action(dt, 2f);
		CCFadeOut a2 = CCFadeOut.action(dt);
		CCSpawn s1 = CCSpawn.actions(a1, a2);

		CCCallFunc c1 = CCCallFunc.action(this, "removeMe");

		this.runAction(CCSequence.actions(s1, c1));
	}

	public void removeMe() {
		this.removeFromParentAndCleanup(true);
	}
}
