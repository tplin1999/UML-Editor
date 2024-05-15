package Shape;

import java.awt.Graphics;

public class AssociationLine extends BasicLine {
	private int arrowW = 10, arrowH = 10;
	
	// constructor
	public AssociationLine(BasicObj startObj, String startPortIndex, BasicObj endObj, String endPortIndex) {
		super(startObj, startPortIndex, endObj, endPortIndex);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		// line part
		int startX = getStartX();
		int startY = getStartY();
		int endX = getEndX();
		int endY = getEndY();
		g.drawLine(startX, startY, endX, endY);
		
		// arrow part
		int dx = endX - startX, dy = endY - startY;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + startX;
        ym = xm*sin + ym*cos + startY;
        xm = x;

        x = xn*cos - yn*sin + startX;
        yn = xn*sin + yn*cos + startY;
        xn = x;
        
        g.drawLine(endX, endY, (int)xm, (int)ym);
        g.drawLine(endX, endY, (int)xn, (int)yn);
	}
}
