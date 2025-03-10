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

public class MobileDeviceV15 extends MobileDeviceV14 implements ActionListener, Serializable {
  protected JMenu FormatMenu;
  protected JRadioButton TextMI, BinaryMI;
  protected ButtonGroup menuRadioGroup;

  protected MobileDeviceV15(String title) {
    super(title);
  }

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

    FormatMenu.add(TextMI);
    FormatMenu.add(BinaryMI);
    configMenu.add(FormatMenu);
  }

  public void handleMenuSave() {
    if(TextMI.isSelected()) {
      saveInTextFormat();
    } else {
      saveInBinaryFormat();
    }
  } 

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

  public void saveInBinaryFormat() {
    int result = fc.showSaveDialog(null);
    if (result == fc.APPROVE_OPTION) {

      File file = fc.getSelectedFile();
      try {
        byte[] data = deviceMessage.getBytes();
        OutputStream Stream = new FileOutputStream(file);
        Stream.write(data); 

        Stream.close();
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    }
  }

  public void openFromText() {
    int result = fc.showOpenDialog(null);

    if (result == fc.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      String filePath = file.getAbsolutePath();

      JOptionPane.showMessageDialog(null,"Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE);

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        deviceMessage = "";
        deviceList.clear();
        String line;
        while ((line = br.readLine()) != null) {
          String[] splittedString = line.split(":");
          String type = splittedString[0];

          int brandStartIndex = splittedString[1].indexOf("(");
          int brandEndIndex = splittedString[1].indexOf(")");
          String brand = splittedString[1].substring(brandStartIndex + 1, brandEndIndex);

          String name = splittedString[1].substring(1, brandStartIndex-1);

          int bahtIndex = splittedString[1].indexOf("Baht");
          String priceString = splittedString[1].substring(brandEndIndex + 1, bahtIndex-1);
          double price = Double.parseDouble(priceString);

          if(type.equals("Smart Phone")) {
            deviceList.add(new SmartPhone(name , brand , price));
          } else {
            deviceList.add(new Tablet(name , brand , price));
          }

          deviceMessage += deviceList.get(deviceList.size() - 1) + "\n";

        }

        JOptionPane.showMessageDialog(null,"Read devices from the file: " + filePath + " are as follows:\n" + deviceMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }   
    }
  }

  public void openFromBinary() {
    int result = fc.showOpenDialog(null);

    if (result == fc.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      String filePath = file.getAbsolutePath();

      JOptionPane.showMessageDialog(null,"Opening: " + filePath, "Message", JOptionPane.INFORMATION_MESSAGE);

      try (FileInputStream fis = new FileInputStream(file);
          DataInputStream dis = new DataInputStream(fis);
          BufferedReader br = new BufferedReader(new InputStreamReader(dis))){
        deviceMessage = "";
        deviceList.clear();

        String line;
        while ((line = br.readLine()) != null) {
          String[] splittedString = line.split(":");
          String type = splittedString[0];

          int brandStartIndex = splittedString[1].indexOf("(");
          int brandEndIndex = splittedString[1].indexOf(")");
          String brand = splittedString[1].substring(brandStartIndex + 1, brandEndIndex);

          String name = splittedString[1].substring(1, brandStartIndex-1);

          int bahtIndex = splittedString[1].indexOf("Baht");
          String priceString = splittedString[1].substring(brandEndIndex + 1, bahtIndex-1);
          double price = Double.parseDouble(priceString);

          if(type.equals("Smart Phone")) {
            deviceList.add(new SmartPhone(name , brand , price));
          } else {
            deviceList.add(new Tablet(name , brand , price));
          }

          deviceMessage += deviceList.get(deviceList.size() - 1) + "\n";

        }

        JOptionPane.showMessageDialog(null,"Read devices from the file: " + filePath + " are as follows:\n" + deviceMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

      } catch (IOException e) {
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
