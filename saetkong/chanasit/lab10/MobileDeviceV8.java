package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab9.MobileDeviceV7;
import java.util.List;
import java.util.ArrayList;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
  private String selected_radio;

  public MobileDeviceV8(String title) {
    super(title);
  }

  protected void addListeners() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
      getSelectedRadio();
      JOptionPane.showMessageDialog(null,infoMessage() , "Device Information", JOptionPane.INFORMATION_MESSAGE);
    } else if (e.getSource() == resetButton) {
      DeviceNameTextField.setText("");
      BrandTextField.setText("");
      PriceTextField.setText("");
      featureTextArea.setText("");
      deviceRatingSlider.setValue(5);

    }
  }

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
