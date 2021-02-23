package com.tgameasteroids;

public interface PauseDelegate {
	public void resumeGame();
	public void quitGame();
	public void pauseGameAndShowLayer();
}
