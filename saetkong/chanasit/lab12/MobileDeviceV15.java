package saetkong.chanasit.lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable; 
import saetkong.chanasit.lab7.MobileDevice;

//this program extends from MobileDeviceV14
//adding "Format" menu item in "Config" menu item
//inside "Format" adding two radio button grouped together "Text" and "Binary"
//using Text radio button will write and read file in the text format
//it goes the same for Binary radio button 
//coded by: chanasit saetkong
//modify date: 13/3/2025

public class MobileDeviceV15 extends MobileDeviceV14 implements ActionListener, Serializable {
  protected JMenu FormatMenu;
  protected JRadioButton TextMI, BinaryMI;
  protected ButtonGroup menuRadioGroup;

  protected MobileDeviceV15(String title) {
    super(title);
  }

  //adding listener to menu item and radio button
  public void addListeners() {
    super.addListeners();  
    FormatMenu.addActionListener(this);
    TextMI.addActionListener(this);
    BinaryMI.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
  }

  public void addComponents() {
    super.addComponents();
    FormatMenu = new JMenu("Format");
    menuRadioGroup = new ButtonGroup();
    TextMI = new JRadioButton("Text", true);
    BinaryMI = new JRadioButton("Binary");

    menuRadioGroup.add(TextMI);
    menuRadioGroup.add(BinaryMI);

    //add text and binary radio button in format menu item
    FormatMenu.add(TextMI);
    FormatMenu.add(BinaryMI);
    configMenu.add(FormatMenu); //add format menu item under config
  }

  //override the old method to handle both text and binary format
  public void handleMenuSave() {
    if(TextMI.isSelected()) {
      saveInTextFormat();
    } else {
      saveInBinaryFormat();
    }
  } 

  //override the old method to handle both text and binary format
  public void handleMenuOpen() {
    if(TextMI.isSelected()) {
      openFromText();
    } else {
      openFromBinary();
    }
  } 

  //write the device into selected file in text format
  public void saveInTextFormat() {
    int result = fc.showSaveDialog(null);
    if (result == fc.APPROVE_OPTION) {
      // Get the selected file
      File file = fc.getSelectedFile();

      try (FileWriter fileWriter = new FileWriter(file)) {
        // Write data to the file
        fileWriter.write(deviceMessage);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    }
  }

  //write the device into selected file in binary format
  public void saveInBinaryFormat() {
    int result = fc.showSaveDialog(null);
    if (result == fc.APPROVE_OPTION) {
      // Get the selected file
      File file = fc.getSelectedFile();

      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
        // Write data to the file
        out.writeObject(deviceList);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    }
  }

  //if the user selected a text file it will import the devices into the program
  public void openFromText() {
    int result = fc.showOpenDialog(null);

    if (result == fc.APPROVE_OPTION) {//if selected a file to open
      File file = fc.getSelectedFile();
      
      //showing the path of the file opening
      String filePath = file.getAbsolutePath();
      JOptionPane.showMessageDialog(null,"Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE);

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        deviceMessage = ""; //reset the old display message
        deviceList.clear(); //reset the old list of device
        String line;
        while ((line = br.readLine()) != null) {
          //splitting text in each line and assign it to the appropriate variable
          String[] splittedString = line.split(":");
          String type = splittedString[0];

          int brandStartIndex = splittedString[1].indexOf("(");
          int brandEndIndex = splittedString[1].indexOf(")");
          String brand = splittedString[1].substring(brandStartIndex + 1, brandEndIndex);

          String name = splittedString[1].substring(1, brandStartIndex-1);

          int bahtIndex = splittedString[1].indexOf("Baht");
          String priceString = splittedString[1].substring(brandEndIndex + 1, bahtIndex-1);
          double price = Double.parseDouble(priceString);

          //check for the device type and create an object of its type using the variable from splitted text
          //and add it to the list of device
          if(type.equals("Smart Phone")) {
            deviceList.add(new SmartPhone(name , brand , price));
          } else {
            deviceList.add(new Tablet(name , brand , price));
          }

          //update the display message
          deviceMessage += deviceList.get(deviceList.size() - 1) + "\n";
        }

        JOptionPane.showMessageDialog(null,"Read devices from the file: " + filePath + " are as follows:\n" + deviceMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }   
    }
  }

  //if the user selected a binary file it will import the devices into the program
  public void openFromBinary() {
    int result = fc.showOpenDialog(null);

    if (result == fc.APPROVE_OPTION) {
      File file = fc.getSelectedFile();

      //showing the path of the file opening
      String filePath = file.getAbsolutePath();
      JOptionPane.showMessageDialog(null,"Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE);
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
        deviceList.clear(); //reset the old list of device
        deviceMessage = ""; //reset the old display message
                            
        //read the binary as an array of MobileDevice 
        @SuppressWarnings("unchecked")
        ArrayList<MobileDevice> deviceInBinary = (ArrayList<MobileDevice>) in.readObject();

        //iterate through the array and add each one to the program
        for(MobileDevice device : deviceInBinary) {
          deviceList.add(device);
          deviceMessage += deviceList.get(deviceList.size() - 1) + "\n"; //update display message
        }
      } catch (IOException | ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }   
    }
  }

  public static void createAndShowGUI() {
    MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
    mdv15.addComponents();
    mdv15.addListeners();
    mdv15.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
