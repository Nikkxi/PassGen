package net.supcmdr.passgen;

import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.crs.toolkit.layout.SWTGridData;
import com.crs.toolkit.layout.SWTGridLayout;

public class PassGen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8581147823226828218L;
	private JTextField outFld, inFld;
	JButton genButton;
	private static final String version = "4.0";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

				new PassGen().setVisible(true);

			}
		});

	}
	
	public PassGen(){

		super("PassGen v"+version);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(270,85);
		setLocation(300,200);
		setResizable(false);

		JPanel body = new JPanel(new SWTGridLayout(2, false));
		getContentPane().add(body);

		body.add(new JLabel("Input Pass Length"));

		inFld = new JTextField();

		SWTGridData data = new SWTGridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWTGridData.FILL;
		body.add(inFld, data);

		inFld.requestFocus();

		genButton = new JButton("Generate");

		body.add(genButton);

		outFld = new JTextField();
		outFld.setEditable(false);
		outFld.setFocusable(true);

		data = new SWTGridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWTGridData.FILL;
		body.add(outFld, data);

		applyInputFormatter();
		applyKeyBindings();

	}

	public void generatePassword(){
		password pass = new password();

		int passLength = 8;

		try{
			passLength = Integer.parseInt(inFld.getText());
			if (passLength < 8 || passLength > 15){
				JOptionPane.showMessageDialog(null, 
						"Incorrect password length given. "
								+ "Please enter a whole number between 8 and 15");
			} else {
				pass.setLength(passLength);
				pass.generate();
				outFld.setText(pass.getPassword());
			}
		}catch (Exception error){
			JOptionPane.showMessageDialog(null,
					"String given. "
							+ "Please enter a whole number between 8 and 15.");
		}
	}

	private void applyInputFormatter() {
		inFld.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent k){
				
			}
			@Override
			public void keyTyped(KeyEvent k){
				char c = k.getKeyChar();
				if( ((c<'0') || (c>'9')) && (c != KeyEvent.VK_BACK_SPACE)){
					k.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent k){
				
			}
		});
	}

	private void applyKeyBindings(){

		genButton.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent k){
				if(k.getKeyCode()==KeyEvent.VK_ENTER){
					generatePassword();
				}else if(k.getKeyCode()==KeyEvent.VK_SPACE){
					generatePassword();
				}else if(k.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
			@Override 
			public void keyTyped(KeyEvent k){
			}
			@Override 
			public void keyReleased(KeyEvent k){
			}
		});
		genButton.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent m){
				generatePassword();
			}
			@Override
			public void mouseEntered(MouseEvent m){	
			}
			@Override
			public void mouseExited(MouseEvent m){
			}
			@Override
			public void mousePressed(MouseEvent m) {
			}
			@Override
			public void mouseReleased(MouseEvent m) {
			}
		});

		inFld.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent k){
				if(k.getKeyCode()==KeyEvent.VK_ENTER){
					generatePassword();
				}else if(k.getKeyCode()==KeyEvent.VK_SPACE){
					generatePassword();
				}else if(k.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
			@Override
			public void keyTyped(KeyEvent k){
			}
			@Override
			public void keyReleased(KeyEvent k) {
			}
		});
		
		outFld.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent k){
				if(k.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
			@Override
			public void keyTyped(KeyEvent k){
			}
			@Override
			public void keyReleased(KeyEvent k) {
			}
		});
		
		outFld.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				outFld.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// Do Nothing
			}
			
		});

	}

}
