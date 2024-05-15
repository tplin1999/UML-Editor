package Mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Frame.DrawPanel;
import Shape.BasicObj;
import Shape.ClassObj;

public class ClassMode extends Mode implements MouseListener, MouseMotionListener {
	// constructor
	public ClassMode(DrawPanel DP) {
		super(DP);
	}
	
	public void mousePressed(MouseEvent e) {
		BasicObj basicObj = new ClassObj(e.getPoint().x, e.getPoint().y);
		DP.getObjList().add(basicObj);
		DP.repaint();
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
