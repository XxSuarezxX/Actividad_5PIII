package view;
import javax.swing.*;

import model.AVLTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AVLTreePanel extends JPanel {
    private AVLTree avlTree;
    private JTextField inputTextField;
    private JTextField deleteTextField;

    public AVLTreePanel() {
        avlTree = new AVLTree();

        setLayout(new BorderLayout());

        JPanel treePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                avlTree.draw(g2d, getWidth() / 2, 30, 200);
            }
        };

        add(treePanel, BorderLayout.CENTER);

        inputTextField = new JTextField();
        JButton insertButton = new JButton("Insertar");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputTextField.getText());
                    avlTree.insert(value);
                    inputTextField.setText("");
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteTextField = new JTextField();
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(deleteTextField.getText());
                    avlTree.delete(value);
                    deleteTextField.setText("");
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputTextField, BorderLayout.CENTER);
        inputPanel.add(insertButton, BorderLayout.EAST);

        JPanel deletePanel = new JPanel(new BorderLayout());
        deletePanel.add(deleteTextField, BorderLayout.CENTER);
        deletePanel.add(deleteButton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(inputPanel, BorderLayout.NORTH);
        controlPanel.add(deletePanel, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.NORTH);
    }
}
