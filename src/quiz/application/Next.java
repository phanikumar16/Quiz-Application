package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Next extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Next(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/instruction.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1470, 320);
        add(image);
        
        JLabel heading = new JLabel("Welcome " + name + ", first go through the instructions.");
        heading.setBounds(50, 20, 750, 40);
        heading.setFont(new Font("segoe print", Font.BOLD, 25));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel instructions = new JLabel();
        instructions.setBounds(50, 100, 700, 380);
        instructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
        instructions.setText(
            "<html>"+ 
                "1. 1 mark for each question." + "<br><br>" +
                "2. No negative marks are there for incorrect answers." + "<br><br>" +
                "3. Timer will be there for each question , so be aware of it." + "<br><br>" +
                "4. No backward option will be there , you can attempt a question once."+ "<br><br>" +
                "5. If timer is completed , then it will automatically moves to the next question. " + "<br><br>" +
                "6. After completing the attempt , marks will be displayed at the end. " + "<br><br>" +
                "7. Good Luck." + "<br><br>" +
            "<html>"
        );
        add(instructions);
        
        
        back = new JButton("Back");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(200, 500, 90, 31);
        //back.setBackground(new Color(30, 144, 254));
        back.setForeground(new Color(0, 0, 0));
        //back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setFont(new Font("Serif", Font.BOLD, 20));
        start.setBounds(450, 500, 90, 30);
        start.setForeground(new Color(0, 0, 0));
        //start.setBackground(new Color(30, 144, 254));
        //start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        
        
        setSize(900, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Option(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Next("User");
    }
}