package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//coded by: chanasit saetkong
//ID: 673040380-3
//date: 3/2/2025

// This class extends MobileDeviceV1 and enhances the interface with additional fields.
public class MobileDeviceV2 extends MobileDeviceV1 {
  // Label and combo box for selecting the operating system.
  protected JLabel osLabel; 
  protected JComboBox<String> osComboBox;
  protected String[] osOptions = {"Android", "iOS", "Windows","Others"};
  // Panel for extra fields (OS selection and features).
  protected JPanel extraPanel;
  // Label and text area for listing device features.
  protected JLabel featureLabel;
  protected JTextArea featureTextArea;

  // Constructor: Calls superclass constructor and sets the window title.
  public MobileDeviceV2(String title) {
    super(title);
  }

  // Overrides addComponents() to add new UI elements.
  public void addComponents() {
    // Call the parent method to set up basic components.
    super.addComponents();
    // Create a panel with GridLayout (2 rows, 2 columns) to hold new fields.
    extraPanel = new JPanel(new GridLayout(2,2));

    // Initialize the label and combo box for selecting the operating system.
    osLabel = new JLabel("Operating System:");    
    osComboBox = new JComboBox<>(osOptions);
    // Set "Android" as the default selection.
    osComboBox.setSelectedItem("Android"); 
    osComboBox.setEditable(false);

    // Add OS label and combo box to extraPanel.
    extraPanel.add(osLabel);
    extraPanel.add(osComboBox);

    // Initialize the label and text area for entering device features.
    featureLabel = new JLabel("Features:");
    featureTextArea = new JTextArea(3, 25);
    JScrollPane featureScrollerPane = new JScrollPane(featureTextArea);
    
    // Initialize the label and text area for entering device features.
    extraPanel.add(featureLabel);
    extraPanel.add(featureScrollerPane);
  
    // Add extraPanel to mainPanel at the CENTER position, ensuring it appears above buttons.
    mainPanel.add(extraPanel,BorderLayout.CENTER);
    add(mainPanel);
  }
  
  // Creates and displays the GUI.
  public static void createAndShowGUI() {
    MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
    mdv2.addComponents();
    mdv2.setFrameFeatures();
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  

}
