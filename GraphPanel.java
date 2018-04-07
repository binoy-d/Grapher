import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public  class GraphPanel extends JPanel{//a jpanel we put inside the jframe to contain the graph

		private GraphHandler handler;
		private double scaleX = 50;//allows you to fit more points on screen 
		private double scaleY = 10;
		private int xOffset = 500;//controls where center of graph should be
		private int yOffset = 500;//this would be halfway because 500 pix / 1000 pix
		public GraphPanel(GraphHandler handler){
			this.handler = handler;
		}


		@Override
		public void paintComponent(Graphics g){//how you actually draw the points and lines
			//get the mouse location and store x and y to mouseX and mouseY
			PointerInfo a = MouseInfo.getPointerInfo();
      			Point b = a.getLocation();
      			int mouseX = (int) (b.getX());
      			int mouseY = (int) (b.getY());

			xOffset = (int)(mouseX-getLocationOnScreen().getX());//change location of the origin based on position of mouse
			yOffset = (int)(mouseY-getLocationOnScreen().getY());;
    
			Graphics2D g2d = (Graphics2D) g;//you pretty much always do this if you want to do any graphics
			g2d.setColor(Color.BLACK);//set the paint color to black
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());//clear out the screen with black
			g2d.setColor(Color.RED);//set paint color to red
			for(Coordinate c: handler.getCoordinates()){//for each coordinate in the coordinate list from the handler
				double y = yOffset-(scaleY*c.getY());//figure out where to piut it on screen based on scale, offset and actual coordinate
				g2d.fillRect((int)(c.getX()*scaleX)+xOffset,(int)y,5,5);//draw a tiny rectangle for each point, w = 5, h = 5
			}
			g2d.drawLine(xOffset,this.getHeight(),xOffset,0);//draw the x and y axis
			g2d.drawLine(0,yOffset,this.getWidth(),yOffset);

		}

	}
