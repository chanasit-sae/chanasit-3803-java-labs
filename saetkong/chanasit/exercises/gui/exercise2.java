package saetkong.chanasit.exercises.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise2 extends JFrame{
  protected JButton food1, food2, food3;
  protected JPanel foodPanel, namePanel; 
  protected JLabel nameLabel;


  public exercise2(String title) {
    super(title);
  }

  public void setFrameFeatures() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }
  
  public void addComponent(Container contentPane) {
    namePanel = new JPanel();
    foodPanel = new JPanel();

    nameLabel = new JLabel("Chanasit:");
    namePanel.add(nameLabel);

    food1 = new JButton("japanese curry");
    food2 = new JButton("steak");
    food3 = new JButton("fried chicken");

    foodPanel.add(food1);
    foodPanel.add(food2);
    foodPanel.add(food3);

    contentPane.add(namePanel, BorderLayout.NORTH);
    contentPane.add(foodPanel, BorderLayout.SOUTH);
  }

  public static void creatAndShowGUI() {
    exercise2 window = new exercise2("673040380-3");
    JPanel panel = new JPanel();
    window.addComponent(panel);
    window.add(panel);
    window.setFrameFeatures();
  }

  public static void main(String[] args) {
    creatAndShowGUI();
  }
}
