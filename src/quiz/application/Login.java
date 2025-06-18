package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
 
    JButton  back,next;
    JTextField tfname;
    
    Login() {
       
        getContentPane().setBackground(Color.white);
        setContentPane(new JLabel());
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login3.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, -38, 600, 500);
        add(image);
        
        JLabel heading = new JLabel("Welcome to the quiz...");
        heading.setBounds(730, 50, 350, 40);
       // heading.setBackground(Color.CYAN);
        heading.setForeground(Color.red);
        heading.setFont(new Font("segoe print", Font.BOLD, 30));
        //heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel name = new JLabel("Enter your name :");
        name.setBounds(735, 140, 300, 50);
        name.setFont(new Font("segoe print", Font.BOLD, 28));
        name.setForeground(new Color(0, 0, 2));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        
        next = new JButton("Next");
        next.setFont(new Font("Serif", Font.BOLD, 20));
        next.setBounds(945, 250, 90, 25);
        next.setForeground(new Color(0, 0, 45));
        next.addActionListener(this);
        add(next);
        
        
        back = new JButton("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(735, 250, 90, 25);
        back.setForeground(new Color(0, 0, 45));
        back.addActionListener(this);
        add(back);
       
        
        
        setSize(1200, 450);
       // setContentPane(new JLabel(new ImageIcon("icons/login.jpeg")));
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            setVisible(false);
            new Next(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
         else {
            setVisible(false);
            new Login();
        }
        
    }
    
    public static void main(String[] args) {
        new Login();
    }
}