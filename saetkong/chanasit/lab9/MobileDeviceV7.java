package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV7 extends MobileDeviceV6 {
  private String imgPath = "images/S25-ultra.jpg";
  public MobileDeviceV7(String title) {
    super(title);
  } 

  public void addComponents() {
    super.addComponents();
    JPanel centerWrapper2 = new JPanel(new BorderLayout());
    ReadImage imagePanel = new ReadImage(imgPath);

    
    DeviceNameTextField.setText("Samsung Galaxy S25 Ultra");
    BrandTextField.setText("Samsung");
    PriceTextField.setText("46900");
    featureTextArea.setText("- 6.8-inch AMELOD Display\n- 120Hz Refresh Rate\n5000mAh Battery with Fast Charging");
    //featureTextArea.setForeground(Color.DARK_GRAY);
    //featureTextArea.setFont(new Font("Arial", Font.ITALIC, 14));


    centerWrapper2.add(centerWrapper, BorderLayout.CENTER);
    centerWrapper2.add(imagePanel, BorderLayout.SOUTH);

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
