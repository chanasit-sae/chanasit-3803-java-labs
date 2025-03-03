package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//This class extended from MobileDeviceV9
//this class is written to make it so that when 
//user change the Operating system, vendors or rating 
//there will be a message pop-up to show the changed value
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 3/3/2025

public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener{

  //calling super constructor
  public MobileDeviceV10(String title) {
    super(title);
  }

  //adding action listener to the menu items
  protected void addListeners() {
    super.addListeners();
    osComboBox.addActionListener(this);
    vendorsJList.addListSelectionListener(this);
    deviceRatingSlider.addChangeListener(this);
  }

  //perform action based on the button clicked
  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);//calling super because this to keep the old acion
                             
    Object src = e.getSource();
    if (src == osComboBox) showOSChangeMessage(); 
  }

  //showing OS changing message
  public void showOSChangeMessage() {
    String selectedOS = (String)osComboBox.getSelectedItem(); 
    String msg = "You selected Operating System: " + selectedOS;
    JOptionPane.showMessageDialog(this, msg, "OS Selection" ,JOptionPane.INFORMATION_MESSAGE);
  }

  //show vendors list changing message
  public void valueChanged(ListSelectionEvent e) {
    if (e.getSource() == vendorsJList && !e.getValueIsAdjusting()) {
      String msg = "Device is available at: " + vendorsJList.getSelectedValue();
      JOptionPane.showMessageDialog(this, msg, "Vendor Selection" ,JOptionPane.INFORMATION_MESSAGE);
    }
  }

  //show rating slider changing message
  public void stateChanged(ChangeEvent e) {
    if (e.getSource() == deviceRatingSlider && !deviceRatingSlider.getValueIsAdjusting()) {
      String msg = "New rating: " + deviceRatingSlider.getValue();
      JOptionPane.showMessageDialog(this, msg, "Rating Adjustment" ,JOptionPane.INFORMATION_MESSAGE);
    }
  }

  //set font size of textField and textArea
  public static void createAndShowGUI() {
    MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
    mdv10.addComponents();
    mdv10.addListeners();
    mdv10.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}

