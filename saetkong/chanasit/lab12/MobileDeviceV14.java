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
import saetkong.chanasit.lab7.MobileDevice;

//this program extends from MobileDeviceV13
//the program is now able to save all the device in ArrayList into a selected file using JFileChooser
//it can also read the file can import the list of devices into the program
//coded by: chanasit saetkong
//modify date: 13/3/2025
public class MobileDeviceV14 extends MobileDeviceV13 implements ActionListener {
  protected MobileDeviceV14(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();  
  }

  //make the save and open menu item call its method
  public void actionPerformed(ActionEvent e) {
    Object srcObj = e.getSource();
    if (srcObj == openMI) {
      handleMenuOpen();
    } else if (srcObj == saveMI) {
      handleMenuSave();
    } else {
      super.actionPerformed(e);
    } 
  }

  //if the user selected a file in JFileChooser in save menu the program will write the file with the list of device
  public void handleMenuSave() {
    int result = fc.showSaveDialog(null);
    if (result == fc.APPROVE_OPTION) {//if the user choose a file
      // Get the selected file
      File file = fc.getSelectedFile();

      try (FileWriter fileWriter = new FileWriter(file)) {
        // Write data to the file as text
        fileWriter.write(deviceMessage);
        fileWriter.close();
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  //if the user selected a file in JFileChooser in open menu it will import the devices into the program
  public void handleMenuOpen() {
    int result = fc.showOpenDialog(null);

    if (result == fc.APPROVE_OPTION) {//if selected a file to open
      // Get the selected file
      File file = fc.getSelectedFile();

      //showing the path of the file opening
      String filePath = file.getAbsolutePath();
      JOptionPane.showMessageDialog(null,"Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE);

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        deviceMessage = ""; //reset the old display message
        deviceList.clear(); //reset the old list of device
        String line;

        //iterate through every line in the file
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


  public static void createAndShowGUI() {
    MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
    mdv14.addComponents();
    mdv14.addListeners();
    mdv14.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
