package Shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

import Frame.DrawPanel;

public abstract class BasicObj {
	protected String objname = "objname";
	protected int origin_x, origin_y;
	protected int width = 0, height = 0;
	protected int prot_width = 5, prot_height = 5;
	
	protected boolean selected = false;
	protected ArrayList<Integer> groupNumber = new ArrayList<Integer>();
	
	// constructor
	public BasicObj (int origin_x, int origin_y) {
		this.origin_x = origin_x;
		this.origin_y = origin_y;
	}
	// move Object
	public void moveObj(int OffsetX, int OffsetY) {
		origin_x = origin_x + OffsetX;
		origin_y = origin_y + OffsetY;
	}
	// check whether pressed point in Obj area
	public boolean inSelectPressed(Point p) {
		if (p.x >= origin_x && p.x <= origin_x + width && p.y >= origin_y && p.y <= origin_y + height) {
			selected = true;
		}
		else {
			selected = false;
		}
		return selected;
	}
	// check whether Obj in dragged area
	public boolean inSelectDragged(DrawPanel DP) {
		boolean inDraggedArea = true;
		
		int[][] obj_corners = {{origin_x, origin_y}, // left-up
				{origin_x + width, origin_y}, // right-up
				{origin_x + width, origin_y + height}, // right-down
				{origin_x, origin_y + height} }; // left-down
		
		for (int[] obj_corner : obj_corners) {
			if (DP.getSelectDraggedArea().contains(obj_corner[0], obj_corner[1]) == false) {
				inDraggedArea = false;
				break;
			}
		}
		selected = inDraggedArea;
		return inDraggedArea;
	}
	// check point in which port(0:North 1:East 2:South 3:West -1:not in Object)
	public String inWhichPort(Point p) {
		Point center = new Point();
		// left-up
		int x1 = origin_x;
		int y1 = origin_y;
		// right-down
		int x2 = origin_x + width;
		int y2 = origin_y + height;
		// center
		center.x = (x1 + x2) / 2;
		center.y = (y1 + y2) / 2;
		Point[] points = { new Point(x1, y1), new Point(x2, y1), new Point(x2, y2), new Point(x1, y2) };
		
		for (int i = 0; i < points.length; i++) {
			Polygon t = new Polygon();
			// (0,1,center) (1,2,center) (2,3,center) (3,0,center)
			int secondIndex = ((i + 1) % 4);
			t.addPoint(points[i].x, points[i].y);
			t.addPoint(points[secondIndex].x, points[secondIndex].y);
			t.addPoint(center.x, center.y);

			if (t.contains(p)) {
				return Integer.toString(i);
			}
		}
		return null;
	}
	// return selected
	public boolean getSelected () {
		return selected;
	}
	// change selected status
	public void setSelected (boolean status) {
		selected = status;
	}
	// change Object name
	public void setObjname (String objname) {
		this.objname = objname;
	}
	// group this Object
	public void setGroupNumber (int groupNumber) {
		this.groupNumber.add(groupNumber);
	}
	// get Object's group number
	public int getGroupNumber () {
		if (groupNumber.isEmpty()) {
			return -1;
		}
		else {
			return groupNumber.get(groupNumber.size()-1);
		}
	}
	// ungroup this Object
	public void unGroupNumber () {
		if (!groupNumber.isEmpty()) {
			groupNumber.remove(groupNumber.size()-1);
		}
	}
	// get port X coordinate value
	public int getPortX (String portIndex) {
		// 0:North 1:East 2:South 3:West
		if (portIndex.equals("0") || portIndex.equals("2")) {
			return (int)(origin_x + width * 0.5);
		}
		else if (portIndex.equals("1")) {
			return (int)(origin_x + width);
		}
		else if (portIndex.equals("3")) {
			return (int)(origin_x);
		}
		else { // bug
			System.out.println("BUG");
			return 0;
		}
	}
	// get port Y coordinate value
	public int getPortY (String portIndex) {
		// 0:North 1:East 2:South 3:West
		if (portIndex.equals("1") || portIndex.equals("3")) {
			return (int)(origin_y + height * 0.5);
		}
		else if (portIndex.equals("2")) {
			return (int)(origin_y + height);
		}
		else if (portIndex.equals("0")) {
			return (int)(origin_y);
		}
		else { // bug
			System.out.println("BUG");
			return 0;
		}
	}
	// draw method (abstract)
	public abstract void draw (Graphics g);
}
