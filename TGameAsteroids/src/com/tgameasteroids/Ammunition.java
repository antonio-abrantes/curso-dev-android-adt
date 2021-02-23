package com.tgameasteroids;

import static com.tgameasteroids.DeviceSettings.*;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.opengl.CCBitmapFontAtlas;

public class Ammunition extends CCLayer {

	private int ammunition;
	private CCBitmapFontAtlas text;
	private GameScene delegate;

	public void setDelegate(GameScene delegate) {
		this.delegate = delegate;

	}

	public void setAmmunition(int ammunition) {
		this.ammunition = ammunition;
	}
	
	public Ammunition() {

		this.ammunition = 5;
		this.text = CCBitmapFontAtlas.bitmapFontAtlas(String.valueOf(this.ammunition), "MinhaFonte.fnt");
		this.text.setScale((float) 270 / 270);
		this.setPosition(screenWidth() - 50, screenHeight() - 100);
		this.addChild(this.text);

	}

	public void increaseAmmunition() {

		if (this.ammunition > 0) {
			this.ammunition--;
			this.text.setString(String.valueOf(this.ammunition));
		}
	}

	public void fullAmmunition() {
		System.out.println("FULL AMMUNITION: "+ this.ammunition);
		this.text.setString(String.valueOf(this.ammunition));
	}
}
