import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public  class GraphPanel extends JPanel{

		private GraphHandler handler;


		public GraphPanel(GraphHandler handler){
			this.handler = handler;
		}


		@Override
		public void paintComponent(Graphics g){
      //set up graphics
			Graphics2D g2d = (Graphics2D) g;
      //clear
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());


		}

	}
