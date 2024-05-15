package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Frame.DrawPanel;

import Shape.BasicObj;

public abstract class LineMode extends Mode implements MouseListener, MouseMotionListener {
	private Point startP = null, endP = null;
	protected BasicObj startObj = null, endObj = null;
	protected String startPortIndex = null, endPortIndex = null;
	
	// constructor
	public LineMode (DrawPanel DP) {
		super(DP);
	}

	public void mousePressed(MouseEvent e) {
		startP = e.getPoint();
		ArrayList<BasicObj> objList = DP.getObjList();
		startPortIndex = null;
		// check whether pressed point in Object
		for (BasicObj basicObj: objList) {
			startPortIndex = basicObj.inWhichPort(startP);
			if (startPortIndex != null) {
				startObj = basicObj;
				break;
			}
		}
		DP.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		endP = e.getPoint();
		ArrayList<BasicObj> objList = DP.getObjList();
		endPortIndex = null;
		// check whether released point in Object
		for (BasicObj basicObj: objList) {
			endPortIndex = basicObj.inWhichPort(endP);
			if (endPortIndex != null) {
				endObj = basicObj;
				break;
			}
		}
		// check start Object and end Object are exists
		boolean startObjExist = (startPortIndex != null);
		boolean endObjExist = (endPortIndex != null);
		// check start,end object not at same Object and same port
		boolean notSameObjSamePort = false;
		if (startObjExist && endObjExist) {
			boolean notSameObj = (startObj != endObj);
			boolean notSamePort = !startPortIndex.equals(endPortIndex);
			notSameObjSamePort = (notSameObj || notSamePort);
		}
		// add line using abstract method
		if (notSameObjSamePort) {
			addLine();
		}
		else {
			System.out.println("add line failed.");
		}
		DP.repaint();
	}
	public abstract void addLine();
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
