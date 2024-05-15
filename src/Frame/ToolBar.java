package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import Mode.*;
import Shape.BasicObj;

public class ToolBar {
	private JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
	public static JButton holdbtn = null;
	// button color
	private Color unHoldColor = new Color(80, 80, 80);
	private Color holdColor = new Color(0, 0, 0);
	
	// constructor
	public ToolBar(DrawPanel DP) {
		String[] toolName = {"select", "association", "generalization", "composition", "class", "usecase"};
		String[] imagePath = {"img/select.png", "img/association.png", "img/generalization.png", "img/composition.png", "img/class.png", "img/usecase.png"};
		Mode[] mode = {new SelectMode(DP), new AssociationMode(DP), new GeneralizationMode(DP), new CompositionMode(DP), new ClassMode(DP), new UsecaseMode(DP)};
		// setting Button
		for(int i = 0; i <= 5; i++) {
			ImageIcon icon = new ImageIcon(imagePath[i]);
			JButton btn = btn_setting(toolName[i], icon, DP, mode[i]);
			toolBar.add(btn);
		}
	}
	// setting Button
	private JButton btn_setting(String toolName, ImageIcon icon, DrawPanel DP, Mode mode) {
		JButton btn = new JButton();
		btn.setToolTipText(toolName);
		btn.setIcon(icon);
		btn.setFocusable(false);
		btn.setBackground(unHoldColor);
		btn.setBorderPainted(false);
		btn.setRolloverEnabled(true);
		
		btn.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				if(holdbtn != null)
					holdbtn.setBackground(unHoldColor);
				holdbtn = (JButton) e.getSource();
				holdbtn.setBackground(holdColor);
				DP.setMode(mode);
				
				for (BasicObj basicobj : DP.getObjList()) {
					basicobj.setSelected(false);
				}
				DP.repaint();
			}  
		});
		return btn;
	}
	// return toolBar
	public JToolBar getToolBar() {
		return toolBar;
	}
}
