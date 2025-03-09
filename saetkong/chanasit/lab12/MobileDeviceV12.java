package saetkong.chanasit.lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab10.MobileDeviceV11;
import java.util.List;
import java.util.ArrayList;


public class MobileDeviceV12 extends MobileDeviceV11 implements ActionListener {
  protected MobileDeviceV12(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();  
    DeviceNameTextField.addActionListener(this);
    BrandTextField.addActionListener(this);
    PriceTextField.addActionListener(this);
    
  }

  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
    Object srcObject = e.getSource();
    if (srcObject == DeviceNameTextField) {
      handleNormalTextField(DeviceNameTextField, BrandTextField);
    } else if (srcObject == BrandTextField) {
      handleNormalTextField(BrandTextField, PriceTextField);
    } else if (srcObject == PriceTextField) {
      handlePosNumTextField(PriceTextField, osComboBox);
    }
  }

  public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
    if(tf.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName(), "Notification", JOptionPane.INFORMATION_MESSAGE);

      tf.requestFocusInWindow();
      nextComponent.setEnabled(false);
    } else {
      JOptionPane.showMessageDialog(null, "You press Enter in Device Name Field: " + tf.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
      nextComponent.setEnabled(true);
    }
  }
  
  public void handlePosNumTextField(JTextField tf, JComponent nextComponent)
  {
    try {
      double num = Double.parseDouble(tf.getText());
    
      if(tf.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        return;
      }

      if(num <= 0) {
        JOptionPane.showMessageDialog(null, "Price must be a positive number", "Notification", JOptionPane.ERROR_MESSAGE);
        return;
      }

      JOptionPane.showMessageDialog(null, "Price is changed to  " + tf.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);

      nextComponent.setEnabled(true);
    }
    catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Please enter a valid number in " + tf.getName(), "Notification", JOptionPane.INFORMATION_MESSAGE);
      tf.requestFocusInWindow();
      nextComponent.setEnabled(false);
      return;
    }

  }


  public void addComponents() {
    super.addComponents();
    DeviceNameTextField.setName("Device Name");
    BrandTextField.setName("Brand");
    PriceTextField.setName("Price");
  }

  public static void createAndShowGUI() {
    MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
    mdv12.addComponents();
    mdv12.addListeners();
    mdv12.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
