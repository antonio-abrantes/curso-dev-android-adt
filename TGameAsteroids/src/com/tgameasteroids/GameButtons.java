package com.tgameasteroids;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;
import static com.tgameasteroids.DeviceSettings.*;
import com.tgameasteroids.Button.ButtonDelegate;

public class GameButtons extends CCLayer implements ButtonDelegate {

	private Button leftControl;
	private Button rightControl;
	private Button shootButton;
	private Button pauseButton;
	
	private GameScene delegate;
	
	public static GameButtons gameButtons() {
		return new GameButtons();
	}

	public GameButtons() {


		this.setIsTouchEnabled(true);
		
		this.leftControl = new Button(Assets.ESQUERDA);
		this.rightControl = new Button(Assets.DIREITA);
		this.shootButton = new Button(Assets.ATIRAR);
		this.pauseButton = new Button(Assets.PAUSAR);
		
		//this.soundButton.setDelegate(this)
		this.leftControl.setDelegate(this);
		this.rightControl.setDelegate(this);
		this.shootButton.setDelegate(this);
		this.pauseButton.setDelegate(this);
		
		setButtonspPosition();

		addChild(leftControl);
		addChild(rightControl);
		addChild(shootButton);
		addChild(pauseButton);
		
	}
	
	private void setButtonspPosition() {

		leftControl.setPosition(screenResolution(CGPoint.ccp( 40  , 40 ))) ;
		rightControl.setPosition(screenResolution(CGPoint.ccp( 100 , 40 ))) ;
		shootButton.setPosition(screenResolution(CGPoint.ccp( screenWidth() -40 , 40 ))) ;
		pauseButton.setPosition(screenResolution(CGPoint.ccp( 40  , screenHeight() - 30 ))) ;
	}

		public void setDelegate(GameScene gameScene) {
		this.delegate = gameScene;
		
	}
		@Override
		public void buttonClicked(Button sender) {

		if (sender.equals(this.leftControl)) {
			System.out.println("Esquerda!");
			this.delegate.moveLeft();
		}

		if (sender.equals(this.rightControl)) {
			System.out.println("Direita!");
			this.delegate.moveRight();
		}

		if (sender.equals(this.shootButton)) {
			System.out.println("Tiro");
			this.delegate.shoot();
		}

		if (sender.equals(this.pauseButton)) {
			System.out.println("pause");
			this.delegate.pauseGameAndShowLayer();
		}
	}

}
