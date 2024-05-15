package Mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Frame.DrawPanel;
import Shape.BasicObj;
import Shape.UsecaseObj;

public class UsecaseMode extends Mode implements MouseListener, MouseMotionListener  {
	// constructor
	public UsecaseMode (DrawPanel DP) {
		super(DP);
	}
	
	public void mousePressed(MouseEvent e) {
		BasicObj basicobj = new UsecaseObj(e.getPoint().x, e.getPoint().y);
		DP.getObjList().add(basicobj);
		DP.repaint();
	}
	public void mouseReleased (MouseEvent e) {}
	public void mouseDragged (MouseEvent e) {}
	public void mouseClicked (MouseEvent e) {}
	public void mouseMoved (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
}
