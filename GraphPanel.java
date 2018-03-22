import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public  class GraphPanel extends JPanel{

		private GraphHandler handler;
		private double scaleX = 50;
		private double scaleY = 10;
		private int xOffset = 500;
		private int yOffset = 500;
		public GraphPanel(GraphHandler handler){
			this.handler = handler;
		}


		@Override
		public void paintComponent(Graphics g){
			PointerInfo a = MouseInfo.getPointerInfo();
      Point b = a.getLocation();
      int mouseX = (int) (b.getX());
      int mouseY = (int) (b.getY());

			xOffset = (int)(mouseX-getLocationOnScreen().getX());
			yOffset = (int)(mouseY-getLocationOnScreen().getY());;
      //set up graphics
			Graphics2D g2d = (Graphics2D) g;
      //clear
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2d.setColor(Color.RED);
			for(Coordinate c: handler.getCoordinates()){
				double y = yOffset-(scaleY*c.getY());
				g2d.fillRect((int)(c.getX()*scaleX)+xOffset,(int)y,5,5);
			}
			g2d.drawLine(xOffset,this.getHeight(),xOffset,0);
			g2d.drawLine(0,yOffset,this.getWidth(),yOffset);

		}

	}
