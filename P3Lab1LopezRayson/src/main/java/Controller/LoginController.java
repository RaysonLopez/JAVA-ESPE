/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Session;
import View.Login;
import View.MainAdmin;
import View.MainStudents;
import connectionBD.ConnectionBDStudents;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Rayson
 */
public  class LoginController {
    Login login;
    ConnectionBDStudents connection;
    Session session;
    private ImageIcon[]imagenes;
    private int indice=0;
    public LoginController(Login login){
        this.login=login;
        this.session=new Session();
        this.connection=connection.getInstance();
        initListener();
        initComponents();
        startTimer();
    }
    public void initComponents(){
        login.errorUser.setVisible(false);
        login.errorPassword.setVisible(false);
        ClassLoader classLoader=getClass().getClassLoader();
        imagenes=new ImageIcon[]{
            new ImageIcon(classLoader.getResource("ImagesBG/espe.jpg")),
            new ImageIcon(classLoader.getResource("ImagesBG/espe2.jpg")),
            new ImageIcon(classLoader.getResource("ImagesBG/Espel.jpg")),
            new ImageIcon(classLoader.getResource("ImagesBG/Iasa.jpg"))
        };
    }
    public void startTimer(){
       Timer timer=new Timer(5000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chanceImage();
            }
        });
        timer.start();
    }
    public void initListener(){
        login.btnClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarRojo.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarMorado.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarMorado.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarNegro.png")));
            }
        });
                login.btnClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarRojo.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarMorado.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarMorado.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.btnClose.setIcon(new ImageIcon(getClass().getResource("/Icons/cerrarNegro.png")));
            }
        });
        login.btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
 
        login.TextUser.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(login.TextUser.getText().equals("usuario")){
                    login.TextUser.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(login.TextUser.getText().isEmpty()){
                    login.TextUser.setText("usuario");
                }
            }
        });
        login.textPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(login.textPassword.getEchoChar()=='*'){
                    login.textPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(login.textPassword.getText().isEmpty()){
                    login.textPassword.setText("Contraseña");
                }
            }
        });
        login.pnOverlay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                trasparentBG();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                opaqueBG();
            }
        });
    }
    public void opaqueBG(){
        login.pnOverlay.setOpaque(false);
        login.pnOverlay.repaint();
    }
    public void trasparentBG(){
    login.pnOverlay.setOpaque(true);
    Graphics2D g2d = (Graphics2D) login.pnOverlay.getGraphics();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); 
    g2d.setColor(new Color(0, 0, 0,128)); 
    g2d.fillRect(0, 0, login.pnOverlay.getWidth(), login.pnOverlay.getHeight());
    g2d.dispose();
    }
    public final void start(){
        String user=login.TextUser.getText();
        String password=login.textPassword.getText();
        if(validateData()){
            session.setUser(user);
            session.setPassword(password);
            if(connection.find(user,password)){
              login.dispose();
              MainStudents mainStudent=new MainStudents();
              mainStudent.setVisible(true);
            }else if(session.getUser().equals("admin")&&session.getPassword().equals("admin")){
              login.dispose();
              MainAdmin mainAdmin=new MainAdmin();
              mainAdmin.setVisible(true);
            }
            
        }else{
            JOptionPane.showMessageDialog(login, "Usuario o contraseña invalidos","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void chanceImage(){
        indice=(indice+1)%imagenes.length;
        login.pnOverlay.removeAll();
        JLabel label=new JLabel(imagenes[indice]);
        label.setSize(login.pnOverlay.getSize());
        login.pnOverlay.add(label);
        login.pnOverlay.revalidate();
        login.pnOverlay.repaint();
    }
    public boolean validateData(){
    boolean isValid = true;
        // Validaciones para el campo de usuario
    String user = login.TextUser.getText();
    if (user.isEmpty()) {
        login.errorUser.setText("Error: El campo de usuario no puede estar vacío");
        login.errorUser.setVisible(true);
        isValid = false;
    } else if (user.length() < 3) {
        login.errorUser.setText("Error: El campo de usuario debe tener al menos 3 caracteres");
        login.errorUser.setVisible(true);
        isValid = false;
    } else {
        login.errorUser.setText("");
        login.errorUser.setVisible(false);
    }

    // Validaciones para el campo de contraseña
    String password = login.textPassword.getText();
    if (password.isEmpty()) {
        login.errorPassword.setText("Error: El campo de contraseña no puede estar vacío");
        login.errorPassword.setVisible(true);
        isValid = false;
    } else {
        login.errorPassword.setVisible(false);
        login.errorPassword.setText("");
    }
        
    return isValid;
    }
}
