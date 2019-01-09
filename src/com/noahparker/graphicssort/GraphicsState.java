package com.noahparker.graphicssort;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GraphicsState extends BasicGameState {
	int[] data = new int[400];
	boolean[] draw = new boolean[400];
	Random r = new Random();
	int gSortCount = 0;
	int gIndex = 0;
	int gSingleSortCount = 0;
	int gCurrentIndex = 0;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		//populate data[]
		
		for(int i = 0; i<400; i++) {
			data[i] = r.nextInt(400);
			draw[i] = false;
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("Rendering", 10, 25);
		//sort(g);
		//sortOnce(g);
		sort(g);
		for(int i = 0; i<data.length;i++) {
			if(draw[i]) { //skip drawing and reset to false.
				draw[i] = false;
				g.setColor(Color.red);
				g.drawLine(i+i+10, 480, i+i+10, data[i]);
				g.setColor(Color.white);
			}else{
				g.drawLine(i+i+10, 480, i+i+10, data[i]);
				//System.out.println("Line x pos: "+(i+i+10));
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		//sort();
	}
	
	public void sort(Graphics g) {
		gSortCount++;
		if(gSortCount>0) { //delay
			gSortCount = 0;
			
			//System.out.println("gCurrentIndex: "+gCurrentIndex);
			for(int i = 0; i<data.length-1; i++) {
				int x = data[i]; //highlight x line
				int y = data[i+1];
				if(y>x) { //shift down
					
					data[i] = y;
					data[i+1] = x;
					draw[i] = true;
					draw[i+1] = true;
					return;
					//return to rest of render loop? 
				}
			}
			//System.out.println("sort function executed.");
		}
	}
	
	public void sortOnce(Graphics g) {
		
		gSingleSortCount++;
		if(gSingleSortCount>=200) {
			gSingleSortCount = 0;
		
			int x = data[gIndex];
			int y = 0;
			
			
			if(gIndex>=399) {
				gIndex = 0;
				return;
			}else{
				y = data[gIndex+1];
			}
			
			if(y>x) {
				data[gIndex] = y;
				data[gIndex+1] = x;
				//draw[gIndex] = true;
				//draw[gIndex+1] = true;
				g.setColor(Color.red);
				g.drawLine(gIndex+gIndex+10, 480, gIndex+gIndex+10, data[gIndex]);
			}
			gIndex++;
		}
	}
	
	

	@Override
	public int getID() {
		return 0;
	}

}
