package com.noahparker.graphicssort;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GraphicSort extends StateBasedGame {
	GraphicsState gs;
	
	
	public GraphicSort(String name) {
		super(name);
		gs = new GraphicsState();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(gs);
	}
	
	public static void main(String args[]) {
		try {
	         AppGameContainer container = new AppGameContainer(new GraphicSort("GraphicSort"));
	         container.setDisplayMode(820, 480, false);
	         container.setVSync(true);
	         container.setTargetFrameRate(60);
	         container.setShowFPS(true);
	         container.start();
	      } catch (SlickException e) {
	         e.printStackTrace();
	      }
	}
	
}
