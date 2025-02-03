package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab8.MobileDeviceV3;

public class MobileDeviceV5 extends MobileDeviceV4 {
  protected JList<String> vendorsJList;
  protected String[] vendors = {"AIS","True","DTAC","Shopee"};

  public MobileDeviceV5(String title) {
    super(title);
  }

  public void addComponents() {
    super.addComponents();
    extraPanel.setLayout(new GridLayout(4,2));
    JPanel centerWrapper = new JPanel(new BorderLayout());

    //JPanel panel = new JPanel(new GridLayout(3,1));
    //JPanel vendorPanel = new JPanel(new GridLayout(1,2));

    JLabel deviceAvailable = new JLabel("The device is available at:");
    
    vendorsJList = new JList<String>(vendors);
    vendorsJList.setSelectedIndex(0);
    vendorsJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
    JScrollPane ScrollPane = new JScrollPane(vendorsJList);

    JLabel deviceRatingLabel = new JLabel("Rate the device (0-10):");
    JSlider deviceRatingSilder = new JSlider(0, 10, 5);
    deviceRatingSilder.setMajorTickSpacing(1);
    deviceRatingSilder.setPaintTicks(true);
    deviceRatingSilder.setPaintLabels(true);

    //vendorPanel.add(deviceAvailable);
    //vendorPanel.add(vendorsJList);
    //panel.add(vendorPanel);
    //panel.add(deviceRatingLabel);
    //panel.add(deviceRatingSilder);

    extraPanel.add(deviceAvailable);
    extraPanel.add(vendorsJList);
    extraPanel.add(deviceRatingLabel);

    centerWrapper.add(extraPanel, BorderLayout.CENTER);
    centerWrapper.add(deviceRatingSilder, BorderLayout.SOUTH);

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
