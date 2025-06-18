package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Option extends JFrame implements ActionListener{

    String name;
    JButton java, back ,C;
    
    Option(String name) {
        this.name = name;
        //Image backgroundImage = new ImageIcon("motivate1.jpg").getImage();
        //getContentPane().setBackground(Color.cyan);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Go with your strength " +name+".....");
        heading.setBounds(150, 100, 700, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        //heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        back = new JButton("Back");
        back.setBounds(350, 300, 90, 40);
        back.setFont(new Font("Calibi", Font.BOLD, 20));
        //back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);
        
        java = new JButton("Java");
        java.setBounds(250, 200, 90, 40);
        java.setFont(new Font("Calibi", Font.BOLD, 20));
        //java.setBackground(new Color(30, 144, 254));
        java.setForeground(Color.black);
        java.addActionListener(this);
        add(java);
        
        
        C = new JButton("C");
        C.setBounds(450, 200, 90, 40);
        C.setFont(new Font("Calibi", Font.BOLD, 20));
        //C.setBackground(new Color(30, 144, 254));
        C.setForeground(Color.black);
        C.addActionListener(this);
        add(C);
        
        
        
        setSize(800, 500);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == java) {
            setVisible(false);
            new Quiz(name);
        } 
        else if (ae.getSource() == C) {
            setVisible(false);
            new Quiz2(name);
            
        }
        
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Next(name);
        }
        else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Option("User");
    }
}