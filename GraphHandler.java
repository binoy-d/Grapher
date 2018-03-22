import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class GraphHandler{

		private GraphFrame frame;
		private GraphThread thread;


		public GraphHandler(){
			frame = new GraphFrame(this);
			((Thread)(thread = new GraphThread(this))).start();
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


	}
