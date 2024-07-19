package com.mycompany.p2lab1lopezrayson;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI frame = new AppGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BotonIngresar();
		
		
		
		
	}
        public void BotonIngresar(){
            VentasLopezRayson ventas=new VentasLopezRayson();
            JButton IngresarBoton = new JButton("Ingresar");
		IngresarBoton.setBounds(130,99,200,30);
		contentPane.add(IngresarBoton);
                IngresarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            ventas.MenuPrincipal();
			}
		});
        }
	
}
