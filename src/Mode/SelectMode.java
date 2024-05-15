package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Frame.DrawPanel;
import Shape.BasicObj;

public class SelectMode extends Mode implements MouseListener, MouseMotionListener {
	private Point StartP = null;
	private boolean Move_or_Drag = false;
	
	// constructor
	public SelectMode(DrawPanel DP) {
		super(DP);
	}
	public void mousePressed(MouseEvent e) {
		StartP = e.getPoint();
		
		boolean overlap = false;
		for (BasicObj basicobj : DP.getObjList()) {
			if (overlap) { // one object have been selected, unselected others
				basicobj.setSelected(false);
			}
			else { // no object have been selected
				overlap = basicobj.inSelectPressed(StartP);
				Move_or_Drag = overlap;
			}
		}
		DP.repaint();
	}
	public void mouseReleased (MouseEvent e) {
		// reset dragged area
		DP.getSelectDraggedArea().setBounds(0, 0, 0, 0);
		DP.repaint();
	}
	public void mouseDragged (MouseEvent e) {
		int OffsetX = e.getX() - StartP.x;
		int OffsetY = e.getY() - StartP.y;
		
		if (Move_or_Drag) { // move Object
			int GroupNumber = -1;
			for (BasicObj BasicObj: DP.getObjList()) {
				if (BasicObj.getSelected()) {
					GroupNumber = BasicObj.getGroupNumber();
				}
			}
			for (BasicObj BasicObj: DP.getObjList()) {
				if (BasicObj.getSelected()) {
					BasicObj.moveObj(OffsetX, OffsetY);
				}
				else if (BasicObj.getGroupNumber() == GroupNumber && GroupNumber != -1) {
					BasicObj.moveObj(OffsetX, OffsetY);
				}
				else {
					;
				}
			}
			
			StartP.x = e.getX();
			StartP.y = e.getY();
		}
		else { // drag an area
			for (BasicObj basicobj : DP.getObjList()) {
				basicobj.inSelectDragged(DP);
			}
			
			if (OffsetX > 0 && OffsetY > 0)
				DP.getSelectDraggedArea().setBounds(StartP.x, StartP.y, Math.abs(OffsetX), Math.abs(OffsetY));
			if (OffsetX > 0 && OffsetY < 0)
				DP.getSelectDraggedArea().setBounds(StartP.x, e.getY(), Math.abs(OffsetX), Math.abs(OffsetY));
			if (OffsetX < 0 && OffsetY > 0)
				DP.getSelectDraggedArea().setBounds(e.getX(), StartP.y, Math.abs(OffsetX), Math.abs(OffsetY));
			if (OffsetX < 0 && OffsetY < 0)
				DP.getSelectDraggedArea().setBounds(e.getX(), e.getY(), Math.abs(OffsetX), Math.abs(OffsetY));
		}
		DP.repaint();
	}
	
	public void mouseClicked (MouseEvent e) {}
	public void mouseMoved (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
}
