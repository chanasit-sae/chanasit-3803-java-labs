package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV5 extends MobileDeviceV4 {
  protected JList<String> vendorsJList;
  protected String[] vendors = {"AIS","True","DTAC","Shopee"};
  protected JLabel deviceAvailable;
  protected JLabel deviceRatingLabel;
  protected JPanel centerWrapper;

  public MobileDeviceV5(String title) {
    super(title);
  }

  public void addComponents() {
    super.addComponents();
    centerWrapper = new JPanel(new BorderLayout());
    JPanel extraPanel2 = new JPanel(new GridLayout(2,2));
    deviceAvailable = new JLabel("The device is available at:");

    vendorsJList = new JList<String>(vendors);
    vendorsJList.setSelectedIndex(0);
    vendorsJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    
    JScrollPane ScrollPane = new JScrollPane(vendorsJList);

    deviceRatingLabel = new JLabel("Rate the device (0-10):");
    JSlider deviceRatingSilder = new JSlider(0, 10, 5);
    deviceRatingSilder.setMajorTickSpacing(1);
    deviceRatingSilder.setPaintTicks(true);
    deviceRatingSilder.setPaintLabels(true);

    extraPanel2.add(deviceAvailable);
    extraPanel2.add(vendorsJList);
    extraPanel2.add(deviceRatingLabel);

    centerWrapper.add(extraPanel, BorderLayout.NORTH);
    centerWrapper.add(extraPanel2, BorderLayout.CENTER);
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
