package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MobileDeviceV6 class extends MobileDeviceV5 to further customize styles for labels, text fields, JList, and buttons.
// Coded by Chanasit Saetkong
// ID: 673040380-3
// Modify date: 10/2/2025

public class MobileDeviceV6 extends MobileDeviceV5 {
  public MobileDeviceV6(String title) {
    super(title);
  }

  // Override the addComponents method to add custom styles for components
  public void addComponents() {
    super.addComponents();
    setLabelStyle();
    setTextFieldStyle();
    setJListColor();
    setConfrimButtonColor();
  }

  // Method to set the style (font and color) for the labels
  public void setLabelStyle() {
    DeviceNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
    DeviceNameLabel.setForeground(Color.decode("#000080"));

    BrandLabel.setFont(new Font("Arial", Font.BOLD, 14));
    BrandLabel.setForeground(Color.decode("#000080"));

    PriceLabel.setFont(new Font("Arial", Font.BOLD, 14));
    PriceLabel.setForeground(Color.decode("#000080"));

    TypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
    TypeLabel.setForeground(Color.decode("#000080"));

    osLabel.setFont(new Font("Arial", Font.BOLD, 14));
    osLabel.setForeground(Color.decode("#000080"));

    featureLabel.setFont(new Font("Arial", Font.BOLD, 14));
    featureLabel.setForeground(Color.decode("#000080"));

    deviceAvailable.setFont(new Font("Arial", Font.BOLD, 14));
    deviceAvailable.setForeground(Color.decode("#000080"));

    deviceRatingLabel.setFont(new Font("Arial", Font.BOLD, 14));
    deviceRatingLabel.setForeground(Color.decode("#000080"));
  }

  // Method to set the background and font style for text fields and text areas
  public void setTextFieldStyle() {
    DeviceNameTextField.setBackground(Color.LIGHT_GRAY);
    BrandTextField.setBackground(Color.LIGHT_GRAY);
    PriceTextField.setBackground(Color.LIGHT_GRAY);
    
    featureTextArea.setBackground(Color.decode("#FFFFCC"));
    featureTextArea.setForeground(Color.DARK_GRAY);
    featureTextArea.setFont(new Font("Arial", Font.ITALIC, 14));
  }

  // Method to customize the appearance of the JList (vendor list)
  public void setJListColor() {
    vendorsJList.setBackground(Color.LIGHT_GRAY);
    vendorsJList.setForeground(Color.decode("#006400"));
    vendorsJList.setSelectionBackground(Color.YELLOW);
    vendorsJList.setSelectionForeground(Color.BLACK);
    vendorsJList.setFont(new Font("Arial", Font.BOLD, 14));
  }

  // Method to set custom colors for the buttons (submit and reset)
  public void setConfrimButtonColor() {
    resetButton.setForeground(Color.RED);
    resetButton.setBackground(Color.WHITE);
    submitButton.setForeground(Color.GREEN);
    submitButton.setBackground(Color.WHITE);

  }

  public static void createAndShowGUI() {
    MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
    mdv6.addComponents();
    mdv6.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}

