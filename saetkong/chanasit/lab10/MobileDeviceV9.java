package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab9.MobileDeviceV7;
import java.util.List;
import java.util.ArrayList;

//This class extended from MobileDeviceV8
//adding listener for menu item to perform the intended action
//-clicking new clears textField and selection 
//-clicking open opens file chooser
//    ->show the file name when selects a file
//-clicking save 
//    ->show message after saving
//-clicking exit closes the program
//-clikcing small medium large and extraLarge to changes the font size in the textField and textArea
//-clikcing black red green blue to changes the font color in the textField and textArea
//-clikcing font1 font2 font3 to changes the font family in the textField and textArea
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 17/2/2025

public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {
  protected JFileChooser fc = new JFileChooser();

  //calling super constructor
  public MobileDeviceV9(String title) {
    super(title);
  }

  //adding action listener to the menu items
  protected void addListeners() {
    super.addListeners();
    newMI.addActionListener(this);
    openMI.addActionListener(this);
    saveMI.addActionListener(this);
    exitMI.addActionListener(this);

    smallMI.addActionListener(this);
    mediumMI.addActionListener(this);
    largeMI.addActionListener(this);
    extraLargeMI.addActionListener(this);

    blackMI.addActionListener(this);
    redMI.addActionListener(this);
    greenMI.addActionListener(this);
    blueMI.addActionListener(this);

    font1MI.addActionListener(this);
    font2MI.addActionListener(this);
    font3MI.addActionListener(this);
  }

  //perform action based on the button clicked
  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);//calling super because this to keep the old acion

    if (e.getSource() == newMI) {//clears textField and selection
      DeviceNameTextField.setText("");
      BrandTextField.setText("");
      PriceTextField.setText("");
      featureTextArea.setText("");
      deviceRatingSlider.setValue(5);
      typeRadioGroup.clearSelection();
      osComboBox.setSelectedItem("Android"); 
      vendorsJList.clearSelection();
    } else if (e.getSource() == openMI) {//open file chooser and show choosing message
      int returnVal = fc.showOpenDialog(this);

      if (returnVal == JFileChooser.APPROVE_OPTION) { 
        String msg = "Opening: " + fc.getSelectedFile().getName();
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
      } 
    } else if (e.getSource() == saveMI) {//open file chooser and show saving message
      int returnVal = fc.showSaveDialog(this);

      if (returnVal == fc.APPROVE_OPTION) { 
        String msg = "Data is saved to " + fc.getSelectedFile().getName() + " successfully!";
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
      }  
    } 
    else if (e.getSource() == exitMI) System.exit(0);//exits program
    else if (e.getSource() == smallMI) setFontSize(10);//set font size respectively to the choosen menu item
    else if (e.getSource() == mediumMI) setFontSize(14);
    else if (e.getSource() == largeMI) setFontSize(18);
    else if (e.getSource() == extraLargeMI) setFontSize(22);
    else if (e.getSource() == blackMI) setFontColor(Color.BLACK);//set font color respectively to the choosen menu item
    else if (e.getSource() == redMI) setFontColor(Color.RED);
    else if (e.getSource() == greenMI) setForeground(Color.GREEN);
    else if (e.getSource() == blueMI) setForeground(Color.BLUE);
    else if (e.getSource() == font1MI) setFontFamily("Serif");//set font family respectively to the choosen menu item
    else if (e.getSource() == font2MI) setFontFamily("SansSerif");
    else if (e.getSource() == font3MI) setFontFamily("Monospaced");
  }

  //set font size of textField and textArea
  public void setFontSize(int size) {
    DeviceNameTextField.setFont(new Font(DeviceNameTextField.getFont().getFamily(), DeviceNameTextField.getFont().getStyle(), size));
    BrandTextField.setFont(new Font(BrandTextField.getFont().getFamily(), BrandTextField.getFont().getStyle(), size));
    PriceTextField.setFont(new Font(PriceTextField.getFont().getFamily(), PriceTextField.getFont().getStyle(), size));
    featureTextArea.setFont(new Font(featureTextArea.getFont().getFamily(), featureTextArea.getFont().getStyle(), size));
  }

  //set font family of textField and textArea
  public void setFontFamily(String font) {
    DeviceNameTextField.setFont(new Font(font, DeviceNameTextField.getFont().getStyle(), DeviceNameTextField.getFont().getSize()));

    BrandTextField.setFont(new Font(font, BrandTextField.getFont().getStyle(), BrandTextField.getFont().getSize()));
    PriceTextField.setFont(new Font(font, PriceTextField.getFont().getStyle(), PriceTextField.getFont().getSize()));
    featureTextArea.setFont(new Font(font, featureTextArea.getFont().getStyle(), featureTextArea.getFont().getSize()));
  }

  //set font color of textField and textArea
  public void setFontColor(Color color) {
      DeviceNameTextField.setForeground(color);
      BrandTextField.setForeground(color);
      PriceTextField.setForeground(color);
      featureTextArea.setForeground(color);
  }

  public static void createAndShowGUI() {
    MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
    mdv9.addComponents();
    mdv9.addListeners();
    mdv9.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
