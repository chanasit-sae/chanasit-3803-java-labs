package saetkong.chanasit.exercises.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise3 extends exercise2{
  public exercise3(String title) {
    super(title);
  }

  public void setFrameFeatures() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }
  
  public void addComponent(Container contentPane) {
    super.addComponent(contentPane);

    nameLabel.setText("Name:");
    JTextField nameTextField = new JTextField("Chanasit",15);
    super.namePanel.add(nameTextField);

    contentPane.setLayout(new BorderLayout());
    contentPane.add(namePanel, BorderLayout.NORTH);
    contentPane.add(foodPanel, BorderLayout.SOUTH);
  }
  public static void creatAndShowGUI() {
    exercise3 window = new exercise3("673040380-3");
    JPanel panel = new JPanel();
    window.addComponent(panel);
    window.add(panel);
    window.setFrameFeatures();
  }

  public static void main(String[] args) {
    creatAndShowGUI();
  }
}
