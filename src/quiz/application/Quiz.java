package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question, nam;
    JRadioButton opn1, opn2, opn3, opn4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 800);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(130, 460, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 28));
        add(qno);
        
        question = new JLabel();
        question.setBounds(170, 460, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
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
        next.setFont(new Font("Serif", Font.PLAIN, 30));
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
        
        nam = new JLabel("Timer is running..." );
        nam.setBounds(1090, 400, 290, 40);
        nam.setFont(new Font("Serif", Font.BOLD, 35));
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
            
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
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
        new Quiz("User");
    }
}