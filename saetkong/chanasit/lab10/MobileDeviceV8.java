package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab9.MobileDeviceV7;
import java.util.List;
import java.util.ArrayList;

//This class extended from MobileDeviceV7
//adding action listner to OK and cancel button 
//-clicl OK will show a message dialog listing infomation in the program
//-click cancel will clear all textfield and clear selections
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 17/2/2025

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
  private String selected_radio;

  //calling super constructor 
  public MobileDeviceV8(String title) {
    super(title);
  }

  //add action listener to ok and cancel button
  protected void addListeners() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
  }

  //perform action based on the button clicked
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == submitButton) {//clicking ok button shows message dialog
      getSelectedRadio();
      JOptionPane.showMessageDialog(null,infoMessage() , "Device Information", JOptionPane.INFORMATION_MESSAGE);
    } else if (e.getSource() == resetButton) {//clicking cancel clears all text and selection
      DeviceNameTextField.setText("");
      BrandTextField.setText("");
      PriceTextField.setText("");
      featureTextArea.setText("");
      deviceRatingSlider.setValue(5);
      typeRadioGroup.clearSelection();
      osComboBox.setSelectedItem("Android"); 
      vendorsJList.clearSelection();
    }
  }

  //format of the message showing on message dialog
  public String infoMessage() {
    return "Device Name: " + DeviceNameTextField.getText() + 
      "\nBrand: " + BrandTextField.getText() + 
      "\nPrice: " + PriceTextField.getText() + 
      "\nType: " + selected_radio + 
      "\nOperating System: " +  osComboBox.getSelectedItem() + 
      "\nFeatures: " + featureTextArea.getText() + 
      "\nAvailable at: " + vendorsJList.getSelectedValue() + 
      "\nRating: " + deviceRatingSlider.getValue();
  }

  //use to check which radio button is being selected
  public void getSelectedRadio() {
    if(TypeRadioSmartphone.isSelected())
    {
      selected_radio = "Smartphone";
    }
    else if(TypeRadioTablet.isSelected())
    {
      selected_radio = "tablet";
    }
    else {
      selected_radio = "dasd";
    }
  }

  public static void createAndShowGUI() {
    MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
    mdv8.addComponents();
    mdv8.addListeners();
    mdv8.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
