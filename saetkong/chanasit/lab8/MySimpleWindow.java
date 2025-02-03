package saetkong.chanasit.lab8;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//coded by: chanasit saetkong
//ID: 673040380-3
//date: 3/2/2025

// This class extends JFrame and serves as the base class for other GUI programs.
public class MySimpleWindow extends JFrame {
  // Protected variables for buttons and panels, allowing access in subclasses.
  protected JButton resetButton;
  protected JButton submitButton;
  protected JPanel mainPanel;
  protected JPanel buttonPanel;

  // Constructor: Initializes the JFrame with a given title.
  public MySimpleWindow(String title) {
    super(title);
  }

  // Method to create and add components to the frame.
  protected void addComponents() {
    // Initializing buttons and panels
    resetButton = new JButton("Cancel");
    submitButton = new JButton("OK");
    mainPanel = new JPanel();
    buttonPanel = new JPanel();

    // Add buttons to the button panel
    buttonPanel.add(resetButton);
    buttonPanel.add(submitButton);
    
    //add button panel to the main panel
    mainPanel.add(buttonPanel);
    add(mainPanel);
  }

  protected void setFrameFeatures() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
    this.setLocationRelativeTo(null);
  }

  // Method to configure JFrame properties.
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
