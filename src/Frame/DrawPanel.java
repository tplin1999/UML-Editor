package Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import Mode.Mode;
import Shape.BasicLine;
import Shape.BasicObj;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel	//我自己的面板，用於繪圖和實現繪圖區域
{
	private Mode currentMode = null;
	private ArrayList<BasicObj> objList = new ArrayList<BasicObj>();
	private ArrayList<BasicLine> lineList = new ArrayList<BasicLine>();
	private Rectangle selectDraggedArea = new Rectangle();
	// color
	private Color objColor = new Color(0, 0, 0);
	private Color selectDraggedAreaColor = new Color(37, 148, 216);
	
	//覆蓋JPanel的paint方法，Graphics是繪圖的重要類，可以理解成一支畫筆
	// constructor
	public DrawPanel() {
	}
	// add mouse listener
	public void setMode (Mode NewMode) {
		removeMouseListener( (MouseListener) currentMode);
		removeMouseMotionListener( (MouseMotionListener) currentMode);
		addMouseListener( (MouseListener) NewMode);
		addMouseMotionListener( (MouseMotionListener) NewMode);
		currentMode = NewMode;
	}
	// paint object
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(objColor);
		for (BasicObj basicobj : objList) {
			basicobj.draw(g);
		}
		for (BasicLine line: lineList) {
			line.draw(g);
		}
		if (!selectDraggedArea.isEmpty()) {
			g.setColor(selectDraggedAreaColor);
			g.drawRect(selectDraggedArea.x, selectDraggedArea.y, selectDraggedArea.width, selectDraggedArea.height);
		}
	}
	// return objList
	public ArrayList<BasicObj> getObjList () {
		return objList;
	}
	// return lineList
	public ArrayList<BasicLine> getLineList () {
		return lineList;
	}
	// return selected dragged area
	public Rectangle getSelectDraggedArea () {
		return selectDraggedArea;
	}
	// sset selected dragged area
	public void setSelectDraggedArea (Rectangle rectangle) {
		selectDraggedArea = rectangle;
	}
}