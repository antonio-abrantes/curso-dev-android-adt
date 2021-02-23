package com.tgameasteroids;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import static com.tgameasteroids.DeviceSettings.*;
import com.tgameasteroids.Button.ButtonDelegate;

public class FinalScreen extends CCLayer implements ButtonDelegate {

	private ScreenBackground background;
	private Button beginButton;

	public CCScene scene() {
		CCScene scene = CCScene.node();
		scene.addChild(this);
		return scene;
	}

	public FinalScreen() {

		// background
		this.background = new ScreenBackground(Assets.FUNDO);
		this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
		this.addChild(this.background);

		SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.gameover, true);

		CCSprite title = CCSprite.sprite(Assets.FINALEND);
		title.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2, screenHeight() - 130)));
		this.addChild(title);

		this.setIsTouchEnabled(true);
		this.beginButton = new Button(Assets.PLAY);
		this.beginButton.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2, screenHeight() - 300)));
		this.beginButton.setDelegate(this);
		addChild(this.beginButton);
	}

	@Override
	public void buttonClicked(Button sender) {
		if (sender.equals(this.beginButton)) {
			SoundEngine.sharedEngine().pauseSound();
			CCDirector.sharedDirector().replaceScene(new TitleScreen().scene());
		}
	}
}
