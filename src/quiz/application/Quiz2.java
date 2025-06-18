
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz2 extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question,nam;
    JRadioButton opn1, opn2, opn3, opn4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz2(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 800);
       // getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(130, 460, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(qno);
        
        question = new JLabel();
        question.setBounds(170, 460, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Who is the father of C language?";
        questions[0][1] = "Steve Jobs";
        questions[0][2] = "James Gosling";
        questions[0][3] = "Dennis Ritchie";
        questions[0][4] = "Rasmus Lerdorf";

        questions[1][0] = "What is an example of iteration in C?";
        questions[1][1] = "for";
        questions[1][2] = "while";
        questions[1][3] = "do-while";
        questions[1][4] = "All the Above";

        questions[2][0] = "All keywords in C are in ____________";
        questions[2][1] = "LowerCase letters";
        questions[2][2] = "UpperCase letters";
        questions[2][3] = "CamelCase letters";
        questions[2][4] = "None of the mentioned";

        questions[3][0] = "What is #include <stdio.h>?";
        questions[3][1] = "Preprocessor directive";
        questions[3][2] = "Inclusion directive";
        questions[3][3] = "File inclusion directive";
        questions[3][4] = "None of the mentioned";

        questions[4][0] = "scanf() is a predefined function in______header file.";
        questions[4][1] = "stdlib. h";
        questions[4][2] = "ctype. h";
        questions[4][3] = "stdio. h";
        questions[4][4] = "stdarg. h";

        questions[5][0] = "Which is valid C expression?";
        questions[5][1] = "int my_num = 100,000;";
        questions[5][2] = "int my_num = 100000;";
        questions[5][3] = "int my num = 1000;";
        questions[5][4] = "int $my_num = 10000;";

        questions[6][0] = "In C language, FILE is of which data type?";
        questions[6][1] = "int";
        questions[6][2] = "char";
        questions[6][3] = "struct";
        questions[6][4] = "None of the mentioned";

        questions[7][0] = "The standard header _______ is used for variable list arguments (…) in C.";
        questions[7][1] = "<stdio.h >";
        questions[7][2] = "<stdlib.h>";
        questions[7][3] = "<math.h>";
        questions[7][4] = "<stdarg.h>";

        questions[8][0] = "What is the output of this statement \"printf(\"%d\", (a++))\"?";
        questions[8][1] = "The value of (a + 1)";
        questions[8][2] = "The current value of a";
        questions[8][3] = "Error message";
        questions[8][4] = "Garbage";

        questions[9][0] = "What feature makes C++ so powerful?\n";
        questions[9][1] = "Easy implementation";
        questions[9][2] = "Reusing the old code";
        questions[9][3] = "Easy memory management";
        questions[9][4] = "All of the above";
        
        answers[0][1] = "Dennis Ritchie";
        answers[1][1] = "All the Above";
        answers[2][1] = "LowerCase letters";
        answers[3][1] = "Preprocessor directive";
        answers[4][1] = "stdio. h";
        answers[5][1] = "int my_num = 100000;";
        answers[6][1] = "struct";
        answers[7][1] = "<stdarg.h>";
        answers[8][1] = "The current value of a";
        answers[9][1] = "All of the above";
        
        opn1 = new JRadioButton();
        opn1.setBounds(170, 520, 700, 30);
        opn1.setFont(new Font("Dialog", Font.PLAIN, 25));
        add(opn1);
        
        opn2 = new JRadioButton();
        opn2.setBounds(170, 560, 700, 30);
        opn2.setFont(new Font("Dialog", Font.PLAIN, 25));
        add(opn2);
        
        opn3 = new JRadioButton();
        opn3.setBounds(170, 600, 700, 30);
        opn3.setFont(new Font("Dialog", Font.PLAIN, 25));
        add(opn3);
        
        opn4 = new JRadioButton();
        opn4.setBounds(170, 640, 700, 30);
        opn4.setFont(new Font("Dialog", Font.PLAIN, 25));
        add(opn4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opn1);
        groupoptions.add(opn2);
        groupoptions.add(opn3);
        groupoptions.add(opn4);
        
        next = new JButton("Next");
        next.setBounds(1130, 530, 160, 40);
        next.setFont(new Font("Serif", Font.PLAIN, 28));
        next.setForeground(Color.black);
        next.addActionListener(this);
        add(next);
        
        
        submit = new JButton("Submit");
        submit.setBounds(1130, 650, 160, 40);
        submit.setFont(new Font("Serif", Font.BOLD, 25));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        nam = new JLabel("Keep an eye on timer..." );
        nam.setBounds(1090, 400, 290, 40);
        nam.setFont(new Font("Serif", Font.PLAIN, 28));
        nam.setForeground(Color.black);
        add(nam);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opn1.setEnabled(true);
            opn2.setEnabled(true);
            opn3.setEnabled(true);
            opn4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } 
        else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 1;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        
        String time = "Time left - " + timer + " seconds"; 
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 23));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 520);
        } else {
            g.drawString("Times up!!", 1150, 520);
        }
        
        timer--; 
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 30;
        } else if (timer < 0) {
            timer = 30;
            opn1.setEnabled(true);
            opn2.setEnabled(true);
            opn3.setEnabled(true);
            opn4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 1;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opn1.setText(questions[count][1]);
        opn1.setActionCommand(questions[count][1]);
        
        opn2.setText(questions[count][2]);
        opn2.setActionCommand(questions[count][2]);
        
        opn3.setText(questions[count][3]);
        opn3.setActionCommand(questions[count][3]);
        
        opn4.setText(questions[count][4]);
        opn4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz2("User");
    }
}