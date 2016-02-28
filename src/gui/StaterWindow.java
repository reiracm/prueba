package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class StaterWindow extends JPanel {
MainFrame frame;
	
	/**
	 * Create the panel.
	 */
	public StaterWindow(MainFrame frame) {
		super();
		
		this.frame = frame;
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.changeContentPane(new SecondPanel(frame));
			}
		});
		btnNewButton.setBounds(411, 261, 120, 23);
		add(btnNewButton);
		
		JLabel lblPrueba = new JLabel("");
		lblPrueba.setIcon(new ImageIcon("imgs\\NEH2APIihWE4LH_1_b.jpg"));
		lblPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrueba.setBackground(new Color(255, 0, 0));
		lblPrueba.setBounds(0, 0, 600, 315);
		add(lblPrueba);

	}

}
