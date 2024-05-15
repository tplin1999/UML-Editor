package Shape;

import java.awt.Graphics;

public abstract class BasicLine {
	private BasicObj startObj, endObj;
	private String startPortIndex, endPortIndex;
	
	// constructor
	public BasicLine (BasicObj startObj, String startPortIndex, BasicObj endObj, String endPortIndex) {
		this.startObj = startObj;
		this.startPortIndex = startPortIndex;
		this.endObj = endObj;
		this.endPortIndex = endPortIndex;
	}
	// return start Object X coordinate
	public int getStartX() {
		return startObj.getPortX(startPortIndex);
	}
	// return start Object Y coordinate
	public int getStartY() {
		return startObj.getPortY(startPortIndex);
	}
	// return end Object X coordinate
	public int getEndX() {
		return endObj.getPortX(endPortIndex);
	}
	// return end Object Y coordinate
	public int getEndY() {
		return endObj.getPortY(endPortIndex);
	}
	// draw method (abstract)
	public abstract void draw(Graphics g);
}
