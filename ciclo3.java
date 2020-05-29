package com.mycompany.unis3calcimc;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author pedro
 */
public class CalcIMC extends JFrame {

    public static void main(String[] args) {
        float weight = 0, height = 0;
        do {
            try {
                String weightInput = JOptionPane.showInputDialog("Insira seu peso!");
                if (weightInput != null) {
                    // Casting
                    weight = Float.parseFloat(weightInput);

                    String heightInput = JOptionPane.showInputDialog("Insira sua altura!");
                    if (heightInput != null) {
                        height = Float.parseFloat(heightInput);
                    } else {
                        System.err.println("A altura é necessária para o cáculo");
                        break;
                    }

                } else {
                    System.err.println("O peso é necessário para o cálculo");
                    break;
                }
            } catch (Exception e) {
                System.err.println("Campo não pode ser vázio!");
            }

        } while (weight == 0 || height == 0);
        calculate(weight, height);
    }

    public static void calculate(float weight, float height) {
        float imc = weight / (float) Math.pow(2, height);
        processMessage(imc);

    }

    public static void processMessage(float imc) {

        if (imc < 17.00) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc)
                    + "\nSituação: Muito abaixo do peso!", "Resultado", 1);
        } else if (imc >= 17.00 && imc <= 18.49) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc)
                    + "\nSituação: Abaixo do peso!", "Resultado", 1);
        } else if (imc >= 18.50 && imc <= 24.99) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc)
                    + "\nSituação: Peso normal!", "Resultado", 1);
        } else if (imc >= 25.00 && imc <= 29.99) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc)
                    + "\nSituação: Acima do peso!", "Resultado", 1);
        } else if (imc >= 30.00 && imc <= 34.99) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc)
                    + "\nSituação: Obesidade I!", "Resultado", 1);
        } else if (imc >= 35.00 && imc <= 39.99) {
            JOptionPane.showMessageDialog(null, "IMC:  "+ String.format("%.2f", imc)
                    + "\nSituação: Obesidade II (severa)!", "Resultado", 1);
        } else if (imc >= 40.00) {
            JOptionPane.showMessageDialog(null, "IMC: " + String.format("%.2f", imc) 
                    + "\nSituação: Obesidade III (mórbida)!", "Resultado", 1);
        }
        
        int showTable = JOptionPane.showConfirmDialog(null, "Deseja visualizar a tabela?");
        if (showTable == 0) {
            CalcIMC calc = new CalcIMC();
            calc.createTable();
        }
    }
    
    public  void createTable() {
        Object [][] data = {
            {"Abaixo de 17", "Muito abaixo do peso"},
            {"Entre 17 e 18.49", "Abaixo do peso"},
            {"Entre 18.50 e 24.99", "Peso normal"},
            {"Entre 25 e 29.99", "Acima do peso"},
            {"Entre 30 e 34.99", "Obesidade I"},
            {"Entre 35 e 39.99", "Obesidade II (severa)"},
            {"Acima de 40", "Obesidade III (mórbida"}
        };
        
        String [] columns = {"Resultado", "Situação"};
        JPanel backPanel;
        JTable table;
        JScrollPane scroll;
        
        
        backPanel = new JPanel();
        backPanel.setLayout(new GridLayout(1, 1));
        table = new JTable(data, columns);
        scroll = new JScrollPane(table);
        backPanel.add(scroll);
        
        getContentPane().add(backPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 180);
        setVisible(true);
    }

}
