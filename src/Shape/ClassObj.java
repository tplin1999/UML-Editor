package Shape;

import java.awt.Graphics;

public class ClassObj extends BasicObj {
	// constructor
	public ClassObj (int origin_x, int origin_y) {
		super(origin_x, origin_y);
		super.width = 160;
		super.height = 80;
	}
	@Override
	public void draw (Graphics g) {
		g.drawRect(origin_x, origin_y, width, height);
		g.drawLine(origin_x, origin_y + height/3, origin_x + width, origin_y + height/3);
		g.drawLine(origin_x, origin_y + height*2/3, origin_x + width, origin_y + height*2/3);
		g.drawChars(objname.toCharArray(), 0, objname.length(), (int)(origin_x + width*0.1), (int)(origin_y + height*0.5));
		
		if (selected == true) {
			int[][] port_xy = {{(int)(origin_x + width*0.5), (int)(origin_y - prot_height)}, // port N
								{(int)(origin_x + width), (int)(origin_y + height*0.5)}, // port E
								{(int)(origin_x + width*0.5), (int)(origin_y + height)}, // port S
								{(int)(origin_x - prot_width), (int)(origin_y + height*0.5)} }; // port W
			
			for (int[] xy : port_xy) {
				g.fillRect(xy[0], xy[1], prot_width, prot_height);
			}
		}
	}
}
