package com.tgameasteroids;

import java.util.Random;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.sound.SoundEngine;

public class Musics {
	
	public static void musicasAleatorias() {
		
//		int musica = 0;
//		
//	 do {
//		 musica = new Random().nextInt(5);
//	} while (musica == 0);
//
//		switch (musica) {
//		case 1:
//			SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.musica, true);
//			break;
//		case 2:
//			SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.blazingstars, true);
//			break;
//		case 3:
//			SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.steamtechmayhem, true);
//			break;
//		case 4:
//			SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.lightyear, true);
//			break;
//		default:
//			break;
//		}
	}
	
	public static void musicaUnica() {
		SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.lightyear, true);
	}

}
