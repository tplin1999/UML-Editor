package Mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Frame.DrawPanel;


public abstract class Mode implements MouseListener, MouseMotionListener {
	protected DrawPanel DP;
	
	// constructor
	public Mode (DrawPanel DP) {
		this.DP = DP;
	}
	
	public abstract void mousePressed(MouseEvent e) ;
	public abstract void mouseReleased(MouseEvent e) ;
	public abstract void mouseDragged(MouseEvent e) ;
	public abstract void mouseClicked(MouseEvent e) ;
	public abstract void mouseMoved(MouseEvent e) ;
	public abstract void mouseEntered(MouseEvent e) ;
	public abstract void mouseExited(MouseEvent e) ;
}
