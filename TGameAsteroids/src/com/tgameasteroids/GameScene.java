package com.tgameasteroids;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import com.tgameasteroids.ShootEngineDelegate;
import com.tgameasteroids.Shoot;

public class GameScene extends CCLayer
		implements MeteorsEngineDelegate, ShootEngineDelegate, PauseDelegate, EnergysEngineDelegate {
	private ScreenBackground background;

	private MeteorsEngine meteorsEngine;
	private CCLayer meteorsLayer;
	private List meteorsArray;

	private CCLayer playerLayer;
	private Player player;

	private CCLayer shootsLayer;
	private ArrayList shootsArray;

	private List playersArray;

	private CCLayer scoreLayer;
	private Score score;
	private int life;

	private CCLayer layerTop;

	private PauseScreen pauseScreen;

	private CCLayer ammuntionLayer;
	private Ammunition ammuntion;

	private EnergysEngine energysEngine;
	private CCLayer energysLayer;
	private List energysArray;

	private GameScene() {

		this.background = new ScreenBackground(Assets.FUNDO);
		this.background.setPosition(DeviceSettings.screenResolution(
				CGPoint.ccp(DeviceSettings.screenWidth() / 2.0f, DeviceSettings.screenHeight() / 2.0f)));
		this.addChild(this.background);

		preloadCache();

		this.meteorsLayer = CCLayer.node();
		this.addChild(this.meteorsLayer);

		this.playerLayer = CCLayer.node();
		this.addChild(this.playerLayer);

		this.shootsLayer = CCLayer.node();
		this.addChild(this.shootsLayer);

		this.scoreLayer = CCLayer.node();
		this.addChild(this.scoreLayer);

		this.layerTop = CCLayer.node();
		this.addChild(this.layerTop);

		this.ammuntionLayer = CCLayer.node();
		this.addChild(this.ammuntionLayer);

		this.energysLayer = CCLayer.node();
		this.addChild(this.energysLayer);

		GameButtons gameButtonsLayer = GameButtons.gameButtons();
		gameButtonsLayer.setDelegate(this);
		this.addChild(gameButtonsLayer);

		this.addGameObjects();
		this.setIsTouchEnabled(true);
	}

	public void moveLeft() {
		player.moveLeft();
	}

	public void moveRight() {
		player.moveRight();
	}

	@Override
	public void onExit() {
		super.onExit();
		System.out.println("Saiu do game");
	}

	public static CCScene createGame() {
		CCScene scene = CCScene.node();
		GameScene layer = new GameScene();
		scene.addChild(layer);
		return scene;
	}

	@Override
	public void createMeteor(Meteor meteor) {
		meteor.setDelegate(this);
		this.meteorsLayer.addChild(meteor);
		meteor.start();
		this.meteorsArray.add(meteor);
	}

	public void startGame() {
		// Música de fundo
		//Musics.musicasAleatorias();
		Musics.musicaUnica();
		// Captura o acelerometro
		player.catchAccelerometer();
		life = 5;
		System.out.println("Inicou o game");
	}

	@Override
	public void onEnter() {
		super.onEnter();
		this.startEngines();

		Runner.check().setGamePlaying(true);
		Runner.check().setGamePaused(false);
		SoundEngine.sharedEngine().setEffectsVolume(1f);
		SoundEngine.sharedEngine().setSoundVolume(1f);

		this.schedule("checkHits");
		this.startGame();
	}
	
	@Override
	public void quitGame() {
		SoundEngine.sharedEngine().setEffectsVolume(0f);
		SoundEngine.sharedEngine().setSoundVolume(0f);
		CCDirector.sharedDirector().replaceScene(new TitleScreen().scene());
	}

	//Função para carregar os sons do jogo no cache
	private void preloadCache() {
		SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), R.raw.disparo);

		SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), R.raw.nave);

		SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), R.raw.explosao);
		
		SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), R.raw.ricochet);
		
		SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), R.raw.reloadshoots);
	}

	//Sistema de pause
	public void pauseGameAndShowLayer() {
		if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
			this.pauseGame();
		}
		if (Runner.check().isGamePaused() && Runner.check().isGamePlaying() && this.pauseScreen == null) {
			this.pauseScreen = new PauseScreen();
			this.layerTop.addChild(this.pauseScreen);
			this.pauseScreen.setDelegate(this);
		}
	}
	
	private void pauseGame() {
		if (!Runner.check().isGamePaused() && Runner.check().isGamePlaying()) {
			Runner.setGamePaused(true);
		}
	}

	@Override
	public void resumeGame() {
		if (Runner.check().isGamePaused() || !Runner.check().isGamePlaying()) {
			// Continua o jogo
			this.pauseScreen = null;
			Runner.setGamePaused(false);
			this.setIsTouchEnabled(true);
		}
	}

	private void startEngines() {
		this.addChild(this.meteorsEngine);
		this.meteorsEngine.setDelegate(this);
	}

	private void addGameObjects() {

		this.meteorsArray = new ArrayList();
		this.meteorsEngine = new MeteorsEngine();

		this.player = new Player();
		this.playerLayer.addChild(this.player);

		this.shootsArray = new ArrayList();
		this.player.setDelegate(this);

		this.playersArray = new ArrayList();
		this.playersArray.add(this.player);

		this.score = new Score();
		this.scoreLayer.addChild(this.score);

		this.ammuntion = new Ammunition();
		this.ammuntionLayer.addChild(this.ammuntion);

		this.energysArray = new ArrayList();
		this.energysEngine = new EnergysEngine();

		System.out.println(this.energysArray.size());

		this.addChild(this.energysEngine);
		this.energysEngine.setDelegate(this);
	}

	//Chamadas de remoção de objetos
	@Override
	public void removeMeteor(Meteor meteor) {
		this.meteorsArray.remove(meteor);
	}
	
	@Override
	public void removeEnergy(Energy energy) {
		this.energysArray.remove(energy);
	}

	@Override
	public void removeShoot(Shoot shoot) {
		this.shootsArray.remove(shoot);
	}
	
	//Objetos para verificar colisão
	public void meteoroHit(CCSprite meteor, CCSprite shoot) {
		((Meteor) meteor).shooted();
		((Shoot) shoot).explode();
		this.score.increase();
	}

	public void energyHit(CCSprite energy, CCSprite player) {
		((Energy) energy).reloaded();
		this.player.setAmmunition(5);
		this.ammuntion.setAmmunition(this.player.getAmmunition());
		this.ammuntion.fullAmmunition();
		System.out.println("Quantidade de tiros novo: "+this.player.getAmmunition());
	}

	// Colisões com o meteoro
	public void playerHit(CCSprite meteor, CCSprite player) {
		((Meteor) meteor).shooted();
		life--;
		if (life == 0) {
			((Player) player).explode(); // Life player
			CCDirector.sharedDirector().replaceScene(new GameOverScreen().scene());
		}else{
			SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), R.raw.ricochet);
		}
	}

	//Area de detecção de colisões
	public CGRect getBoarders(CCSprite object) {
		CGRect rect = object.getBoundingBox();
		CGPoint GLpoint = rect.origin;
		CGRect GLrect = CGRect.make(GLpoint.x, GLpoint.y, rect.size.width, rect.size.height);
		return GLrect;
	}
	
	public void checkHits(float dt) {
		this.checkRadiusHitsOfArray(this.energysArray, this.playersArray, this, "energyHit");
		this.checkRadiusHitsOfArray(this.meteorsArray, this.shootsArray, this, "meteoroHit");
		this.checkRadiusHitsOfArray(this.meteorsArray, this.playersArray, this, "playerHit");
	}
	
	private boolean checkRadiusHitsOfArray(List<? extends CCSprite> array1, List<? extends CCSprite> array2,
			GameScene gameScene, String hit) {
		boolean result = false;
		for (int i = 0; i < array1.size(); i++) {

			// Primeiro Objeto
			CGRect rect1 = getBoarders(array1.get(i));

			for (int j = 0; j < array2.size(); j++) {

				// Segundo objeto
				CGRect rect2 = getBoarders(array2.get(j));
				// Colisão

				if (CGRect.intersects(rect1, rect2)) {
					System.out.println("Colision Detected: " + hit);
					result = true;

					Method method;

					try {
						method = GameScene.class.getMethod(hit, CCSprite.class, CCSprite.class);
						method.invoke(gameScene, array1.get(i), array2.get(j));

					} catch (SecurityException e1) {
						e1.printStackTrace();

					} catch (NoSuchMethodException e1) {
						e1.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();

					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	// Criação de objetos de ação do jogo
	@Override
	public void createShoot(Shoot shoot) {
		this.shootsLayer.addChild(shoot);
		shoot.setDelegate(this);
		shoot.start();
		this.shootsArray.add(shoot);
		// Diminui a quantide de tiros
		this.ammuntion.increaseAmmunition();
		System.out.println("NUM: Tiros: "+this.player.getAmmunition());
	}
	
	@Override
	public void createEnergy(Energy energy) {
		energy.setDelegate(this); //Quando adicionar um novo elemento que pode ser removido
		this.energysLayer.addChild(energy);
		energy.start();
		this.energysArray.add(energy);
	}

	public boolean shoot() {
		player.shoot();
		return true;
	}
	
}
