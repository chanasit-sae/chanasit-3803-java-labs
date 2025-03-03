package saetkong.chanasit.lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;


//this class is written to make the program show the message in the text field when user press enter
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 3/3/2025
public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

  public MobileDeviceCompleteV2(String title) {
    super(title);
  }

  //adding listners to text field
  public void addListeners() {
    deviceNameField.addActionListener(this);
    brandField.addActionListener(this);
    priceField.addActionListener(this);
  }

  //adding action to the text field when pressing enter
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == deviceNameField) {
      JOptionPane.showMessageDialog(null, "You press Enter in Device Name Field: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(e.getSource() == brandField){
      JOptionPane.showMessageDialog(null, "Brand field says: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(e.getSource() == priceField) {
      JOptionPane.showMessageDialog(null, "Price entered: " + e.getActionCommand(), "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
  }


  public static void createAndShowGUI() {
    MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device CompleteV2");
    window.addComponents();
    window.addMenus();
    window.setFrameFeatures();
    window.addListeners();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater((new Runnable() {
      public void run(){
        createAndShowGUI();
      }
    }));
  }
}


