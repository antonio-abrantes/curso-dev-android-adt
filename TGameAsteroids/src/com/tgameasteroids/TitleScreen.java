package com.tgameasteroids;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
//import static com.tgameasteroids.DeviceSettings.screenResolution;

public class TitleScreen extends CCLayer {
	
	private ScreenBackground background;
	
		public TitleScreen() {
		this.background = new ScreenBackground(Assets.FUNDO);
		this.background.setPosition(
			 DeviceSettings.screenResolution(CGPoint.ccp(
				CCDirector.sharedDirector().winSize()
				.width / 2.0f,
				CCDirector.sharedDirector().winSize()
				.height / 2.0f
				)));
				this.addChild(this.background);
				
				//Logotipo
				CCSprite title = CCSprite.sprite(Assets.LOGO);
				title.setPosition(DeviceSettings.screenResolution(
				CGPoint.ccp( DeviceSettings.screenWidth() /2 ,DeviceSettings.screenHeight() - 130 )));
				this.addChild(title);
				
				MenuButtons menuLayer = new MenuButtons();
				this.addChild(menuLayer);
	}
	
	public CCScene scene() {
		CCScene scene = CCScene.node();
		scene.addChild(this);
		return scene;
	}
}
