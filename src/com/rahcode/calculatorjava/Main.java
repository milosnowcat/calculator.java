// TODO hacer una calculadora usando swing

package com.rahcode.calculatorjava;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    String[] operationStrings = new String[] {"+", "-", "*", "/"};

    public String filterZero (String text, String num) {
        if(text.equals("")) {
            num = "0" + num;
        }

        return num;
    }

    public String filterPoints(String text, String num) {
        if (num.equals(".") && (text.contains(num))) {
                num = "";

                for (String string : operationStrings) {
                    if(text.contains(string)) {
                        String[] current = (text + " ").split("\\" + string);

                        if(!current[1].contains(".")) {
                            num = ".";
                            text = current[1].substring(0, current[1].length() - 1);
                        }
                    }
                }
            num = filterZero(text, num);
        }

        return(num);
    }

    public void writeNumber(String num) {
        String text = textField.getText();

        String fileredString = filterPoints(text, num);

        textField.setText(text + fileredString);
    }

    public void makeOperation(String num1, String num2, Integer operation) {
        Float n1 = Float.parseFloat(num1);
        Float n2 = Float.parseFloat(num2);
        Float n3 = (float) 0;
        String res = "";
        DecimalFormat df = new DecimalFormat("#.##");
        
        switch (operation) {
            case 1:
                n3 = n1 + n2;
                break;
            
            case 2:
                n3 = n1 - n2;
                break;

            case 3:
                n3 = n1 * n2;
                break;

            case 4:
                n3 = n1 / n2;
                break;

            default:
                break;
        }

        res = df.format(n3);

        textField.setText(res);
    }

    public void getResult() {
        String text = textField.getText();
        Integer operation = 0;

        for (String string : operationStrings) {
            if(text.contains(string)) {
                operation = Arrays.asList(operationStrings).indexOf(string);
            }
        }

        String[] nums = text.split("\\" + operationStrings[operation]);

        makeOperation(nums[0], nums[1], operation + 1);
    }

    public void writeOperation(String operation) {
        Boolean flag = true;
        String text = textField.getText();

        for (String string : operationStrings) {
            if(text.contains(string)) {
                flag = false;
            }
        }

        if(Boolean.TRUE.equals(flag)) {
            if(text.equals("")) {
                writeNumber("0");
            }
            writeNumber(operation);
        } else {
            getResult();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 270, 380);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.window);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBounds(12, 12, 236, 50);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn1 = new JButton("1");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("1");
            }
        });
        btn1.setBounds(12, 85, 50, 50);
        contentPane.add(btn1);
        
        JButton btn2 = new JButton("2");
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("2");
            }
        });
        btn2.setBounds(74, 85, 50, 50);
        contentPane.add(btn2);
        
        JButton btn3 = new JButton("3");
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("3");
            }
        });
        btn3.setBounds(136, 85, 50, 50);
        contentPane.add(btn3);
        
        JButton btn4 = new JButton("4");
        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("4");
            }
        });
        btn4.setBounds(12, 147, 50, 50);
        contentPane.add(btn4);
        
        JButton btn5 = new JButton("5");
        btn5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("5");
            }
        });
        btn5.setBounds(74, 147, 50, 50);
        contentPane.add(btn5);
        
        JButton btn6 = new JButton("6");
        btn6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("6");
            }
        });
        btn6.setBounds(136, 147, 50, 50);
        contentPane.add(btn6);
        
        JButton btn7 = new JButton("7");
        btn7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("7");
            }
        });
        btn7.setBounds(12, 209, 50, 50);
        contentPane.add(btn7);
        
        JButton btn8 = new JButton("8");
        btn8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("8");
            }
        });
        btn8.setBounds(74, 209, 50, 50);
        contentPane.add(btn8);
        
        JButton btn9 = new JButton("9");
        btn9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("9");
            }
        });
        btn9.setBounds(136, 209, 50, 50);
        contentPane.add(btn9);
        
        JButton btnPoint = new JButton(".");
        btnPoint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber(".");
            }
        });
        btnPoint.setBounds(12, 273, 50, 50);
        contentPane.add(btnPoint);
        
        JButton btn0 = new JButton("0");
        btn0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeNumber("0");
            }
        });
        btn0.setBounds(74, 273, 50, 50);
        contentPane.add(btn0);
        
        JButton btnEqual = new JButton("=");
        btnEqual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getResult();
            }
        });
        btnEqual.setBounds(136, 273, 50, 50);
        contentPane.add(btnEqual);
        
        JButton btnClear = new JButton("C");
        btnClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
        btnClear.setBounds(198, 85, 50, 38);
        contentPane.add(btnClear);
        
        JButton btnAddition = new JButton("+");
        btnAddition.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeOperation("+");
            }
        });
        btnAddition.setBounds(198, 135, 50, 38);
        contentPane.add(btnAddition);
        
        JButton btnSubtraction = new JButton("-");
        btnSubtraction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeOperation("-");
            }
        });
        btnSubtraction.setBounds(198, 185, 50, 38);
        contentPane.add(btnSubtraction);
        
        JButton btnMultiplication = new JButton("*");
        btnMultiplication.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeOperation("*");
            }
        });
        btnMultiplication.setBounds(198, 235, 50, 38);
        contentPane.add(btnMultiplication);
        
        JButton btnDivision = new JButton("/");
        btnDivision.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeOperation("/");
            }
        });
        btnDivision.setBounds(198, 285, 50, 38);
        contentPane.add(btnDivision);
    }
}
