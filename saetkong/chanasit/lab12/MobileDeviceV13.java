package saetkong.chanasit.lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import saetkong.chanasit.lab7.MobileDevice;

public class MobileDeviceV13 extends MobileDeviceV12 implements ActionListener {
  protected String deviceMessage = "";
  protected JButton addButton, displayButton;
  protected ArrayList<MobileDevice> deviceList = new ArrayList<>();

  protected MobileDeviceV13(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();  
    addButton.addActionListener(this);
    displayButton.addActionListener(this);
  }

  public void addComponents() {
    super.addComponents();
    addButton = new JButton("Add");
    displayButton = new JButton("Display");
    confirmPanel.add(addButton);
    confirmPanel.add(displayButton);

  }

  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == addButton) {
      handleAddButton();
    } else if (src == displayButton) {
      handleDisplayButton();
    } else {
      super.actionPerformed(e);
    }
  }

  public void handleAddButton() {
    String deviceName = DeviceNameTextField.getText();
    String brand = BrandTextField.getText();
    double price = Double.parseDouble(PriceTextField.getText());

    if(TypeRadioSmartphone.isSelected()) {
      deviceList.add(new SmartPhone(deviceName, brand , price));
      JOptionPane.showMessageDialog(null,"Smartphone " + deviceName + " is added" , "Message",JOptionPane.INFORMATION_MESSAGE);
    } else {
      deviceList.add(new Tablet(deviceName, brand , price));
      JOptionPane.showMessageDialog(null,"Tablet " + deviceName + " is added" , "Message",JOptionPane.INFORMATION_MESSAGE);
    }

    deviceMessage += deviceList.get(deviceList.size() - 1) + "\n";
  }

  public void handleDisplayButton() {
    JOptionPane.showMessageDialog(null, deviceMessage, "Message",JOptionPane.INFORMATION_MESSAGE);
  }

  public static void createAndShowGUI() {
    MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
    mdv13.addComponents();
    mdv13.addListeners();
    mdv13.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
