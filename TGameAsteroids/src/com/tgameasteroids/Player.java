package com.tgameasteroids;

import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCScaleBy;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;

import static com.tgameasteroids.DeviceSettings.*;

public class Player extends CCSprite implements AccelerometerDelegate {

	float positionX = screenWidth() / 2;
	float positionY = (screenHeight() / 2) - screenHeight() / 4;
	private ShootEngineDelegate delegate;

	private float currentAccelX;
	private float currentAccelY;
	private Accelerometer accelerometer;

	private int ammunition = 5;
	
	public void setAmmunition(int ammunition) {
		this.ammunition += ammunition;
	}
	
	public int getAmmunition() {
		return ammunition;
	}

	public Player() {
		super(Assets.ANIMA1);

		CCAnimation animation = CCAnimation.animation("abc", 1f);
		for (int i = 1; i <= 200; i++) {
			animation.addFrame(Assets.ANIMA1);
			animation.addFrame(Assets.ANIMA2);
		}
		CCAnimate action = CCAnimate.action(120, animation, true);

		this.runAction(action);

		setPosition(positionX, positionY);
		this.schedule("update");
	}

	public void moveLeft() {
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			if (positionX > 30) {
				positionX -= 10;
			}
			setPosition(positionX, positionY);
		}
	}

	public void moveRight() {
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			if (positionX < screenWidth() - 30) {
				positionX += 10;
			}
			setPosition(positionX, positionY);
		}
	}

	public void shoot() {

		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			if (ammunition > 0) {
				ammunition--;
				delegate.createShoot(new Shoot(positionX, positionY + 25));
			}
		}
	}

	public void setDelegate(ShootEngineDelegate delegate) {
		this.delegate = delegate;
	}

	public void explode() {
		SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), R.raw.nave);
		this.unschedule("update");
		float dt = 0.2f;
		CCScaleBy a1 = CCScaleBy.action(dt, 2f);
		CCFadeOut a2 = CCFadeOut.action(dt);
		CCSpawn s1 = CCSpawn.actions(a1, a2);
		this.runAction(CCSequence.actions(s1));
		SoundEngine.sharedEngine().pauseSound();
	}

	public void catchAccelerometer() {
		Accelerometer.sharedAccelerometer().catchAccelerometer();
		this.accelerometer = Accelerometer.sharedAccelerometer();
		this.accelerometer.setDelegate(this);
	}

	@Override
	public void accelerometerDidAccelerate(float x, float y) {

		this.currentAccelX = x;
		this.currentAccelY = y;

		System.out.println("X: " + x);
		System.out.println("Y: " + y);

	}

	public void update(float dt) {

		if (this.currentAccelX < 0) {
			if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {

				if (this.positionX < screenWidth() - 64) {
					this.positionX++;
				}
			}
		}

		if (this.currentAccelX > 0) {
			if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {

				if (this.positionX > 64) {

					this.positionX--;
				}
			}
		}

		if (this.currentAccelY < 0) {
			if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {

				if (this.positionY < screenHeight() - 64) {
					this.positionY++;
				}

			}
		}
		if (this.currentAccelY > 0) {
			if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {

				if (this.positionY > 64) {
					this.positionY--;
				}
			}
		}
		// Configura posicao da nave
		this.setPosition(CGPoint.ccp(this.positionX, this.positionY));
	}

}
