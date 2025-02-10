package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//this class extended from MobileDeviceV4
//overriding addComponents() to add a JList Component for Vendor Selection
//and a slider for rating device
//coded by chanasit saetkong
//ID: 673040380-3
//modify date: 10/2/2025  

public class MobileDeviceV5 extends MobileDeviceV4 {
  protected JList<String> vendorsJList;
  protected String[] vendors = {"AIS","True","DTAC","Shopee"};
  protected JLabel deviceAvailable;
  protected JLabel deviceRatingLabel;
  protected JPanel centerWrapper;
  protected JSlider deviceRatingSlider;

  public MobileDeviceV5(String title) {
    super(title);
  }

  // Override the addComponents() method to add new UI components specific to MobileDeviceV5
  public void addComponents() {
    super.addComponents();//call super for past components
    
    // Create a wrapper panel with BorderLayout
    centerWrapper = new JPanel(new BorderLayout());
    
    // Create another panel with GridLayout for organizing components
    JPanel extraPanel2 = new JPanel(new GridLayout(2,2));

    deviceAvailable = new JLabel("The device is available at:");
    vendorsJList = new JList<String>(vendors);
    vendorsJList.setSelectedIndex(0);
    vendorsJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    // Wrap the JList in a JScrollPane to allow scrolling when the list is too long
    JScrollPane ScrollPane = new JScrollPane(vendorsJList);

    // Initialize the JSlider to let users rate the device (values between 0 and 10)
    deviceRatingLabel = new JLabel("Rate the device (0-10):");
    deviceRatingSlider = new JSlider(0, 10, 5);
    deviceRatingSlider.setMajorTickSpacing(1);
    deviceRatingSlider.setPaintTicks(true);
    deviceRatingSlider.setPaintLabels(true);

    // Add the components to the second panel (extraPanel2)
    extraPanel2.add(deviceAvailable);
    extraPanel2.add(vendorsJList);
    extraPanel2.add(deviceRatingLabel);

    // Add the panels to the centerWrapper  
    centerWrapper.add(extraPanel, BorderLayout.NORTH);
    centerWrapper.add(extraPanel2, BorderLayout.CENTER);
    centerWrapper.add(deviceRatingSlider, BorderLayout.SOUTH);
    
    // Add centerWrapper panel to Override the old center panel
    mainPanel.add(centerWrapper, BorderLayout.CENTER);

  } 

  public static void createAndShowGUI() {
    MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
    mdv5.addComponents();
    mdv5.setFrameFeatures();
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
