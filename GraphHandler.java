import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class GraphHandler{

		private GraphFrame frame;// the frame
		private GraphThread thread;//the thread we are running this on

		private ArrayList<Coordinate> coordinates;//a list of each coordinate to graph

		public GraphHandler(){//construct objects, start the thread, run the graphing function
			frame = new GraphFrame(this);
			((Thread)(thread = new GraphThread(this))).start();
			coordinates = new ArrayList<Coordinate>();
			function();
		}

		public void function(){//fills the coordinates arraylist with points based on a function
			for(double x = -20; x<20; x+=0.5){
				//THE ACTUAL FUNCTION!
				double y = x*x*x+2;
				coordinates.add(new Coordinate(x,y));
			}
		}
		public void update(){//the thread will run this update function, which repaints the graphpanel
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
