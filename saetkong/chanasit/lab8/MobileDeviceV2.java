package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV2 extends MobileDeviceV1 {
  protected JLabel osLabel; 
  protected JComboBox<String> osComboBox;
  protected String[] osOptions = {"Android", "iOS", "Windows","Others"};
  protected JPanel extraPanel;
  protected JLabel featureLabel;
  protected JTextArea featureTextArea;

  public MobileDeviceV2(String title) {
    super(title);
  }

  public void addComponents() {
    super.addComponents();
    extraPanel = new JPanel(new GridLayout(2,2));

    osLabel = new JLabel("Operating System:");    
    osComboBox = new JComboBox<>(osOptions);
    osComboBox.setSelectedItem("Android"); 
    osComboBox.setEditable(false);

    extraPanel.add(osLabel);
    extraPanel.add(osComboBox);

    featureLabel = new JLabel("Features:");
    featureTextArea = new JTextArea(3, 25);
    JScrollPane featureScrollerPane = new JScrollPane(featureTextArea);
    
    extraPanel.add(featureLabel);
    extraPanel.add(featureScrollerPane);
  
    mainPanel.add(extraPanel,BorderLayout.CENTER);
    add(mainPanel);
  }
  
  public static void createAndShowGUI() {
    MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
    mdv2.addComponents();
    mdv2.setFrameFeatures();
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  

}
