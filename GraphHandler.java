import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class GraphHandler{

		private GraphFrame frame;
		private GraphThread thread;

		private ArrayList<Coordinate> coordinates;

		public GraphHandler(){
			frame = new GraphFrame(this);
			((Thread)(thread = new GraphThread(this))).start();
			coordinates = new ArrayList<Coordinate>();
			function();
		}

		public void function(){
			for(double x = -20; x<20; x+=0.5){
				//THE ACTUAL FUNCTION!
				double y = x*x*x+2;
				coordinates.add(new Coordinate(x,y));
			}
		}
		public void update(){
      //the actual code that actually does stuff!
			//Paint canvas
			getGraphFrame().getGraphPanel().repaint();
		}

		public GraphFrame getGraphFrame(){
			return frame;
		}

		public GraphThread getGraphThread(){
			return thread;
		}

		public ArrayList<Coordinate> getCoordinates(){
	    return coordinates;
	  }

	}
