package com.tgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Jogo1 extends SurfaceView implements Runnable {

	boolean running = false;
	Thread renderThread = null;
	SurfaceHolder holder;
	Paint paint;
	private int playerX = 400;
	private int playerY = 150;

	private int enemyX = 100;
	private int enemyY = 400;

	private int score;
	private boolean gameover;

	// 2º metodo de detectar colisões
	private int playerRadius = 50;
	private int enemyRadius = 50;
	private double distance;

	public Jogo1(Context context) {
		super(context);
		paint = new Paint();
		holder = getHolder();
	}

	@Override
	public void run() {
		while (running) {
			// System.out.println("Game Loop!");
			// verifica se a tela já está pronta
			if (!holder.getSurface().isValid())
				continue;

			// bloqueia o canvas
			Canvas canvas = holder.lockCanvas();
			canvas.drawColor(Color.BLACK);

			// Desenha

			drawPlayer(canvas);
			drawEnemy(canvas);

			// detecta colisão
			checkCollision(canvas);
			if (gameover) {
				stopGame(canvas);
				break;
			}

			// Botões
			drawButtons(canvas);

			// Atualiza placar
			drawScore(canvas);

			// atualiza e libera o canvas
			holder.unlockCanvasAndPost(canvas);
		}
	}

	private void stopGame(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		paint.setStyle(Style.FILL);
		paint.setColor(Color.RED);
		paint.setTextSize(50);
		canvas.drawText("GAME OVER!", 50, 150, paint);
		holder.unlockCanvasAndPost(canvas);
	}

	private void checkCollision(Canvas canvas) {
		// calcula a hipotenusa
		distance = Math.pow(playerY - enemyY, 2) + Math.pow(playerX - enemyX, 2);
		distance = Math.sqrt(distance);
		// verifica distancia entre os raios
		if (distance + 5 <= playerRadius + enemyRadius) {
			gameover = true;
		}
	}
	// private void checkCollision(Canvas canvas) {
	// if (playerX == enemyX && playerY == enemyY) {
	// gameover = true;
	// }
	// }

	private void drawButtons(Canvas canvas) {
		// Reiniciar
		paint.setStyle(Style.FILL);
		paint.setColor(Color.WHITE);
		paint.setTextSize(30);
		canvas.drawText("Reiniciar", 400, 400, paint);
		// Sair
		paint.setStyle(Style.FILL);
		paint.setColor(Color.WHITE);
		paint.setTextSize(30);
		canvas.drawText("Sair", 400, 460, paint);
	}
	
	public void init() {
		playerY = 450;
		playerX = 350;
		enemyX = 50;
		enemyY = 50;
		score = 0;
		gameover = false;
	}

	private void drawPlayer(Canvas canvas) {
		paint.setColor(Color.RED);
		canvas.drawCircle(playerX, playerY, playerRadius, paint);
	}

	private void drawEnemy(Canvas canvas) {
		paint.setColor(Color.GREEN);
		canvas.drawCircle(enemyX, enemyY, enemyRadius, paint);

		if (enemyX < playerX) {
			enemyX += 2;
		}

		if (enemyY < playerY) {
			enemyY += 2;
		}

		if (enemyX > playerX) {
			enemyX -= 2;
		}

		if (enemyY > playerY) {
			enemyY -= 2;
		}
	}

	public void addScore(int points) {
		score += points;
	}

	private void drawScore(Canvas canvas) {
		paint.setStyle(Style.FILL);
		paint.setColor(Color.WHITE);
		paint.setTextSize(50);
		canvas.drawText(String.valueOf(score), 350, 750, paint);
	}

	public void moveDown(int pixels) {
		playerY += pixels;
	}

	public void moveUp(int pixels) {
		playerY -= pixels;
	}

	public void moveLeft(int pixels) {
		playerX -= pixels;
	}

	public void moveRight(int pixels) {
		playerX += pixels;
	}

	public void resume() {
		running = true;
		renderThread = new Thread(this);
		renderThread.start();
	}
}