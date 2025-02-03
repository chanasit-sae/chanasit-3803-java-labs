package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//coded by: chanasit saetkong
//ID: 673040380-3
//date: 3/2/2025

// This class extends MySimpleWindow and provides a UI for entering basic mobile device details.
public class MobileDeviceV1 extends MySimpleWindow {
  //protected Labels and text fields.
  protected JLabel DeviceNameLabel;
  protected JTextField DeviceNameTextField;

  protected JLabel BrandLabel;
  protected JTextField BrandTextField;

  protected JLabel PriceLabel;
  protected JTextField PriceTextField;

  protected JLabel TypeLabel;
  protected ButtonGroup typeRadioGroup;

  protected JPanel mainPanel, confirmPanel;

  // Constructor: Calls superclass constructor and sets the window title.
  protected MobileDeviceV1(String title) {
    super(title);
  }

  // Overrides addComponents() to create and add UI elements.
  protected void addComponents() {
    //initializing panels
    mainPanel = new JPanel(new BorderLayout());
    JPanel formPanel = new JPanel(new GridLayout(4,2));
    JPanel typePanel = new JPanel(new GridLayout(1,2)); 
    confirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    //set device label and text field size
    DeviceNameLabel = new JLabel("Device Name:");
    DeviceNameTextField = new JTextField(15);

    //set brand label and text field size
    BrandLabel = new JLabel("Brand:");
    BrandTextField = new JTextField(15);

    //set price label and text field size
    PriceLabel = new JLabel("Price:");
    PriceTextField = new JTextField(15);

    //set type label and radio 
    TypeLabel = new JLabel("Type:");
    typeRadioGroup = new ButtonGroup();

    //adding components to formPanel
    formPanel.add(DeviceNameLabel);
    formPanel.add(DeviceNameTextField);
    formPanel.add(BrandLabel);
    formPanel.add(BrandTextField);
    formPanel.add(PriceLabel);
    formPanel.add(PriceTextField);
    formPanel.add(TypeLabel);

    //creating radio button and grouping them
    JRadioButton TypeRadioSmartphone = new JRadioButton("Smartphone",true);
    JRadioButton TypeRadioTablet = new JRadioButton("Tablet");
    typeRadioGroup.add(TypeRadioSmartphone);
    typeRadioGroup.add(TypeRadioTablet);

    //adding radio buttom group to the typePanel
    typePanel.add(TypeRadioSmartphone);
    typePanel.add(TypeRadioTablet);

    //add typePanel to formPanel
    formPanel.add(typePanel);

    //adding confirmation component and Panel
    resetButton = new JButton("Cancel");
    submitButton = new JButton("OK");
    confirmPanel.add(resetButton);
    confirmPanel.add(submitButton);

    mainPanel.add(formPanel,BorderLayout.NORTH);
    mainPanel.add(confirmPanel,BorderLayout.SOUTH);
    add(mainPanel);
  }

  // Creates and displays the GUI.
  public static void createAndShowGUI() {
    MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
    mdv1.addComponents();
    mdv1.setFrameFeatures();
  }
    
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
