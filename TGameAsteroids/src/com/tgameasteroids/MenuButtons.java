package com.tgameasteroids;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import com.tgameasteroids.Button.ButtonDelegate;
import static com.tgameasteroids.DeviceSettings.*;

public class MenuButtons extends CCLayer implements ButtonDelegate {
	
	private Button playButton;
	private Button highscoredButton;
	private Button helpButton;
	private Button soundButton;
	
	public MenuButtons() {
		this.setIsTouchEnabled(true);
		this.playButton = new Button(Assets.PLAY);
		this.highscoredButton = new Button(Assets.EXIT);
		this.helpButton = new Button(Assets.HELP);
		this.soundButton = new Button(Assets.SOUND);
		
		this.playButton.setDelegate(this);
		this.highscoredButton.setDelegate(this);
		this.helpButton.setDelegate(this);
		this.soundButton.setDelegate(this);
		
		// coloca botões na posição correta
		setButtonspPosition();
		addChild(playButton);
		addChild(highscoredButton);
		addChild(helpButton);
		addChild(soundButton);
	}
	
	
	
	private void setButtonspPosition() {
		// Buttons Positions
		playButton.setPosition(
		screenResolution(CGPoint.ccp(screenWidth() /2,
		screenHeight() - 250 )));
		highscoredButton.setPosition(
		screenResolution(CGPoint.ccp(screenWidth() /2 ,
		screenHeight() - 300 )));
		helpButton.setPosition(
		screenResolution(CGPoint.ccp(screenWidth() /2 ,
		screenHeight() - 350 )));
		soundButton.setPosition(
		screenResolution(CGPoint.ccp(screenWidth() /2 - 100,
		screenHeight() - 420 ))
		);
	}

	@Override
	public void buttonClicked(Button sender) {
		if (sender.equals(this.playButton)) {
			System.out.println("Botão Pressionado: Play");
			CCDirector.sharedDirector().replaceScene(
					CCFadeTransition.transition(1.0f,
					GameScene.createGame()));
		}
		if (sender.equals(this.highscoredButton)) {
			System.out.println("Botão Pressionado: Highscore");
			System.exit(0);
		}
		if (sender.equals(this.helpButton)) {
			System.out.println("Botão Pressionado: Help");
		}
		if (sender.equals(this.soundButton)) {
			System.out.println("Botão Pressionado: Sound");
		}
	}

}
