package Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Shape.BasicObj;

public class MenuBar {
	private JMenuBar menuBar = new JMenuBar(); // menu bar
	private int groupNumber = 0;
	
	// constructor
	public MenuBar(DrawPanel DP) {
		JMenu menu_File = new JMenu("File");
		
		JMenu menu_Edit = new JMenu("Edit");
		JMenuItem menuItem_changeName = new JMenuItem("Change Object Name");
		JMenuItem menuItem_group = new JMenuItem("Group");
		JMenuItem menuItem_unGroup = new JMenuItem("Ungroup");
		menu_Edit.add(menuItem_changeName);
		menu_Edit.add(menuItem_group);
		menu_Edit.add(menuItem_unGroup);
		
		menuBar.add(menu_File);
		menuBar.add(menu_Edit);
		
		changeNameItem_Setting(DP, menuItem_changeName);
		groupItem_Setting(DP, menuItem_group);
		unGroupItem_Setting(DP, menuItem_unGroup);
	}
	// setting change name item
	private void changeNameItem_Setting(DrawPanel DP, JMenuItem menuItem) {
		menuItem.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				JFrame inputTextFrame = new JFrame("Change Object Name");
				inputTextFrame.setSize(400, 100);
				inputTextFrame.getContentPane().setLayout(new GridLayout(0, 1));
				
				JPanel panel = null;
				panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				
				JTextField Text =  new JTextField("Object Name");
				panel.add(Text);
				inputTextFrame.getContentPane().add(panel);
				
				panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				
				JButton ok = new JButton("OK");
				panel.add(ok);
				
				JButton cancel = new JButton("Cancel");
				panel.add(cancel);
		
				inputTextFrame.getContentPane().add(panel);
				inputTextFrame.setLocationRelativeTo(null);
				inputTextFrame.setVisible(true);
				
				// setting OK button
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (BasicObj basicobj : DP.getObjList()) {
							if(basicobj.getSelected()) {
								basicobj.setObjname(Text.getText());
								DP.repaint();
								break;
							}
						}
						inputTextFrame.dispose();
					}
				});
				// setting Cancel button
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inputTextFrame.dispose();
					}
				});
			}  
		});		
	}
	// setting group item
	private void groupItem_Setting(DrawPanel DP, JMenuItem menuItem) {
		menuItem.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				ArrayList<Integer> alreadyGroup = new ArrayList<Integer>();
				for (BasicObj basicobj : DP.getObjList()) {
					if (basicobj.getSelected()) {
						basicobj.setGroupNumber(groupNumber);
						alreadyGroup.add(basicobj.getGroupNumber());
					}
					else if (alreadyGroup.contains(basicobj.getGroupNumber())) {
						basicobj.setGroupNumber(groupNumber);
					}
				}
				groupNumber++;
			}  
		});
	}
	// setting ungroup item
	private void unGroupItem_Setting(DrawPanel DP, JMenuItem menuItem) {
		menuItem.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				int unGroup = -1;
				// find selected object's group number
				for (BasicObj basicobj : DP.getObjList()) {
					if (basicobj.getSelected()) {
						unGroup = basicobj.getGroupNumber();
					}
				}
				// remove group number
				for (BasicObj basicobj : DP.getObjList()) {
					if (unGroup == basicobj.getGroupNumber()) {
						basicobj.unGroupNumber();
					}
				}
			}  
		});
	}
	// return MenuBar
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
