package Shape;

import java.awt.Graphics;

public class CompositionLine extends BasicLine {
	private int diamondW = 10, diamondH = 10;
	
	// constructor
	public CompositionLine(BasicObj startObj, String startPortIndex, BasicObj endObj, String endPortIndex) {
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
		double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + startX;
        ym = xm*sin + ym*cos + startY;
        xm = x;

        x = xn*cos - yn*sin + startX;
        yn = xn*sin + yn*cos + startY;
        xn = x;
        
        double xq = (diamondH*2/D)*startX + ((D-diamondH*2)/D)*endX;
        double yq = (diamondH*2/D)*startY + ((D-diamondH*2)/D)*endY;
   
        int[] xpoints = {endX, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {endY, (int) ym, (int) yq, (int) yn};

        g.fillPolygon(xpoints, ypoints, 4);
	}
}
