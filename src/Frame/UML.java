																																																																																																																																																																																							package Frame;

import javax.swing.*;
import java.awt.*;

public class UML {
	private static JFrame F = new JFrame("UML Editior");
	private static DrawPanel DP = new DrawPanel(); // canvas
	private static MenuBar MB = new MenuBar(DP); // menu bar
	private static ToolBar TB = new ToolBar(DP); // tool bar
	
	public static void main(String[] args) {
		F.setJMenuBar(MB.getMenuBar());
		F.add(TB.getToolBar(), BorderLayout.WEST);
		F.add(DP);
		F.setSize(800, 800);        
		F.setVisible(true);    
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	}

}
