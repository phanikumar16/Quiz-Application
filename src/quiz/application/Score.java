package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    JButton PA ,exit;
    String name;

    Score(String name, int score) {
        setBounds(400, 150, 750, 520);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(10, 150, 300, 250);
        add(img);
        
        JLabel greeting = new JLabel("Thank you for playing " + name + "..");
        greeting.setBounds(150, 30, 700, 40);
        greeting.setFont(new Font("Tahoma", Font.PLAIN, 28));
        add(greeting);
        
        JLabel label = new JLabel("Your score is " + score);
        label.setBounds(410, 200, 300, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(label);
        
        PA = new JButton("Play Again");
        PA.setFont(new Font("", Font.BOLD, 18));
        PA.setBounds(360, 290, 130, 30);
        PA.setBackground(Color.cyan);
        PA.setForeground(Color.red);
        PA.addActionListener(this);
        add(PA);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("", Font.BOLD, 20));
        exit.setBounds(550, 290, 130, 30);
        exit.setBackground(Color.cyan);
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        add(exit);
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == PA) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == exit){
            setVisible(false);
            //new Login();
        }
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}