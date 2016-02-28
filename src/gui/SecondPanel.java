package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondPanel extends JPanel {
	
JFrame frame;
	
	JLabel lblSqr;
	Square square;
	
	JLabel lblGamebar;
	Gamebar gamebar;
	
	Thread square_t;
	
	boolean isStarted = false;
	
	/**
	 * Create the panel.
	 */
	public SecondPanel(JFrame frame) {
		this.frame = frame;
		
		setLayout(null);
		
		lblSqr = new JLabel();
		lblSqr.setBackground(Color.RED);
		lblSqr.setSize(10, 10);
		lblSqr.setOpaque(true);
		
		square = new Square(20, 600, 335);
		square_t = new Thread(square);
		
		lblSqr.setBounds(square.getPos_x(), square.getPos_y(), 10, 10);
		
		add(lblSqr);
		
		
		gamebar = new Gamebar(100, 600, 255);
		
		square.addObserver(gamebar);
		
		lblGamebar = new JLabel("");
		lblGamebar.setBounds(gamebar.getX_pos(), 255, 100, 15);
		lblGamebar.setOpaque(true);
		lblGamebar.setBackground(Color.BLUE);
		
		add(lblGamebar);
		
		
		//hilo que refresca el frame
		Thread refresh_t = new Thread(){
			public void run(){
				System.out.println("#HiloDeFrame");
				while(true){
					try {
						Thread.sleep(16);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblSqr.setBounds(square.getPos_x(), square.getPos_y(), 10, 10);
					lblGamebar.setBounds(gamebar.getX_pos(), 255, 100, 15);
					frame.setVisible(true);
				}
			}
		};
		
		refresh_t.start();
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(!isStarted){
					isStarted=true;
					square.setInitialVector(arg0.getX(), arg0.getY());
					square_t.start();
				}else{
					square.setInitialVector(arg0.getX(), arg0.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				gamebar.setX_pos(e.getX());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	


}
