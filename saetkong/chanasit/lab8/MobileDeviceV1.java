package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV1 extends MySimpleWindow {
  protected JLabel DeviceNameLabel;
  protected JTextField DeviceNameTextField;

  protected JLabel BrandLabel;
  protected JTextField BrandTextField;

  protected JLabel PriceLabel;
  protected JTextField PriceTextField;

  protected JLabel TypeLabel;
  protected ButtonGroup typeRadioGroup;

  MobileDeviceV1(String title) {
    super(title);
  }


  public void addComponents() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel formPanel = new JPanel(new GridLayout(4,2));
    JPanel typePanel = new JPanel(new GridLayout(1,2)); 
    JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    DeviceNameLabel = new JLabel("Device Name:");
    DeviceNameTextField = new JTextField(15);

    BrandLabel = new JLabel("Brand:");
    BrandTextField = new JTextField(15);

    PriceLabel = new JLabel("Price:");
    PriceTextField = new JTextField(15);

    resetButton = new JButton("Cancel");
    submitButton = new JButton("OK");

    TypeLabel = new JLabel("Type:");
    JRadioButton TypeRadioSmartphone = new JRadioButton("Smartphone",true);
    JRadioButton TypeRadioTablet = new JRadioButton("Tablet");
    typeRadioGroup = new ButtonGroup();

    formPanel.add(DeviceNameLabel);
    formPanel.add(DeviceNameTextField);
    formPanel.add(BrandLabel);
    formPanel.add(BrandTextField);
    formPanel.add(PriceLabel);
    formPanel.add(PriceTextField);
    formPanel.add(TypeLabel);

    typeRadioGroup.add(TypeRadioSmartphone);
    typeRadioGroup.add(TypeRadioTablet);

    typePanel.add(TypeRadioSmartphone);
    typePanel.add(TypeRadioTablet);

    formPanel.add(typePanel);

    confirmPanel.add(resetButton);
    confirmPanel.add(submitButton);


    setLayout(new BorderLayout());
    mainPanel.add(formPanel,BorderLayout.NORTH);
    mainPanel.add(confirmPanel,BorderLayout.SOUTH);
    add(mainPanel);
  }

  protected void setFrameFeatures() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
    this.setLocationRelativeTo(null);
  }

  public static void createAndShowGUI() {
    MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
    mdv1.addComponents();
    mdv1.setFrameFeatures();
  }
    
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
