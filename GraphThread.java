//dont mess with This :)

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public  class GraphThread extends Thread{

		private GraphHandler handler;

		private double deltaTime = 0;


		public GraphThread(GraphHandler handler){
			this.handler = handler;
		}

		@Override
		public void run(){//this happens repeatedly when the start function is called, dont worry about understanding this, I dont 
			long lastTime = System.currentTimeMillis();
			int count = 0;
			int millCount = 0;
			while(true){
				if((System.currentTimeMillis() - 17 < lastTime)) continue;
				deltaTime = (1.0 * System.currentTimeMillis()-lastTime)/1000;

				handler.update();

				count++;
				millCount+=System.currentTimeMillis()-lastTime;
				if(millCount >= 1000){
					//System.out.println("60 Frames in: " + millCount + "ms");
					//System.out.println("Count: " + count);
					count = 0;
					millCount = 0;
				}
				lastTime = System.currentTimeMillis();
			}
		}

		public double getDeltaTime(){
			return deltaTime;
		}

	}
