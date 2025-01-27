package saetkong.chanasit.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MySimpleWindow extends JFrame {
  protected JButton resetButton;
  protected JButton submitButton;
  protected JPanel mainPanel;
  protected JPanel buttonPanel;

  public MySimpleWindow(String title) {
    super(title);
  }

  protected void addComponents() {
    resetButton = new JButton("Cancel");
    submitButton = new JButton("OK");
    mainPanel = new JPanel();
    buttonPanel = new JPanel();

    buttonPanel.add(resetButton);
    buttonPanel.add(submitButton);
    mainPanel.add(buttonPanel);

    add(mainPanel);
  }

  protected void setFrameFeatures() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
    this.setLocationRelativeTo(null);
  }

  public static void createAndShowGUI() {
    MySimpleWindow msw = new MySimpleWindow("My Simple Window");
    msw.addComponents();
    msw.setFrameFeatures();    
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }


}
