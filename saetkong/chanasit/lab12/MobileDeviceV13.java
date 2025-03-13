package saetkong.chanasit.lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import saetkong.chanasit.lab7.MobileDevice;

//this program extends from MobileDeviceV12
//adding "Add" and "Display" button 
//add button: when pressing will create a new object of device with information user puts in and add it to an ArrayList
//display buttin: when pressing will show all the device in the ArrayList of MobileDevices
//coded by: chanasit saetkong
//modify date: 13/3/2025

public class MobileDeviceV13 extends MobileDeviceV12 implements ActionListener {
  protected String deviceMessage = ""; //the message for displaying
  protected JButton addButton, displayButton;
  protected ArrayList<MobileDevice> deviceList = new ArrayList<>(); //container of all MobileDevice

  protected MobileDeviceV13(String title) {
    super(title);
  }
  
  //adding listener to add and display button
  public void addListeners() {
    super.addListeners();  
    addButton.addActionListener(this);
    displayButton.addActionListener(this);
  }

  //add "add" and "display" button at the bottom of the program
  public void addComponents() {
    super.addComponents();
    addButton = new JButton("Add");
    displayButton = new JButton("Display");
    confirmPanel.add(addButton);
    confirmPanel.add(displayButton);
  }

  //make add and display button calling its method
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

  //create a MobileDevice object and add it to the ArrayList then upadate the display text
  public void handleAddButton() {
    String deviceName = DeviceNameTextField.getText(); //get information from textfields
    String brand = BrandTextField.getText();
    double price = Double.parseDouble(PriceTextField.getText());

    if(TypeRadioSmartphone.isSelected()) {
      deviceList.add(new SmartPhone(deviceName, brand , price)); //create and add MobileDevice into the ArrayList with the type SmartPhone
      JOptionPane.showMessageDialog(null,"Smartphone " + deviceName + " is added" , "Message",JOptionPane.INFORMATION_MESSAGE);
    } else {
      deviceList.add(new Tablet(deviceName, brand , price)); //create and add MobileDevice into the ArrayList with the type tablet
      JOptionPane.showMessageDialog(null,"Tablet " + deviceName + " is added" , "Message",JOptionPane.INFORMATION_MESSAGE);
    }
    deviceMessage += deviceList.get(deviceList.size() - 1) + "\n"; //update the display text
  }

  //show all the MobileDevice as message
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
