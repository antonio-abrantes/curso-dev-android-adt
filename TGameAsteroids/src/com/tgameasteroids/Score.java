package com.tgameasteroids;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCBitmapFontAtlas;
import static com.tgameasteroids.DeviceSettings.*;

public class Score extends CCLayer {
	private int score;
	private CCBitmapFontAtlas text;
	private GameScene delegate;

	public void setDelegate(GameScene delegate) {
		this.delegate = delegate;
	}

	public Score() {

		this.score = 0;
		this.text = CCBitmapFontAtlas.bitmapFontAtlas(String.valueOf(this.score), "MinhaFonte.fnt");
		this.text.setScale((float) 270 / 270);
		this.setPosition(screenWidth() - 50, screenHeight() - 50);
		this.addChild(this.text);

	}

	public void increase() {
		score++;
		this.text.setString(String.valueOf(this.score));

		if (this.score == 100) {
			CCDirector.sharedDirector().replaceScene(new FinalScreen().scene());
		}
	}
}
