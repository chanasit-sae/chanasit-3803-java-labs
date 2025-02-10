package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// MobileDeviceV7 extends MobileDeviceV6 to add image display and predefined device information.
// Coded by Chanasit Saetkong
// ID: 673040380-3
// Modify date: 10/2/2025

public class MobileDeviceV7 extends MobileDeviceV6 {
  private String imgPath = "images/S25-ultra.jpg";
  public MobileDeviceV7(String title) {
    super(title);
  } 

  // Override addComponents() to add the image panel and write device info
  public void addComponents() {
    super.addComponents();
    // create a new center panel to over write the old one
    JPanel centerWrapper2 = new JPanel(new BorderLayout());
    // load image panel form another class(ReadImage class)
    ReadImage imagePanel = new ReadImage(imgPath);

    // write the text for device fields (name, brand, price, features) in the text field
    DeviceNameTextField.setText("Samsung Galaxy S25 Ultra");
    BrandTextField.setText("Samsung");
    PriceTextField.setText("46900");
    featureTextArea.setText("- 6.8-inch AMELOD Display\n- 120Hz Refresh Rate\n- 5000mAh Battery with Fast Charging");

    // Add the old panel and image panel into the new one
    centerWrapper2.add(centerWrapper, BorderLayout.CENTER);
    centerWrapper2.add(imagePanel, BorderLayout.SOUTH);

    // over write the old center panel 
    mainPanel.add(centerWrapper2, BorderLayout.CENTER);
  }

  public static void createAndShowGUI() {
    MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
    mdv7.addComponents();
    mdv7.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
