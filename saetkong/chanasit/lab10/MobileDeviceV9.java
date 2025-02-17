package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab9.MobileDeviceV7;
import java.util.List;
import java.util.ArrayList;

public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {
  protected JFileChooser fc = new JFileChooser();

  public MobileDeviceV9(String title) {
    super(title);
  }

  protected void addListeners() {
    super.addListeners();
    newMI.addActionListener(this);
    openMI.addActionListener(this);
    saveMI.addActionListener(this);

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

  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
    if (e.getSource() == newMI) {
      DeviceNameTextField.setText("");
      BrandTextField.setText("");
      PriceTextField.setText("");
      featureTextArea.setText("");
    } else if (e.getSource() == openMI) {
      int returnVal = fc.showOpenDialog(this);

      if (returnVal == JFileChooser.APPROVE_OPTION) { 
        String msg = "Opening: " + fc.getSelectedFile().getName();
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
      } 
    } else if (e.getSource() == saveMI) {
      int Check = fc.showSaveDialog(this);
      if (Check == fc.APPROVE_OPTION) { // if the user selects a file
        String msg = "Data is saved to " + fc.getSelectedFile().getName() + " successfully!";
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
      }  
    } 
    else if (e.getSource() == smallMI) setFontSize(10);
    else if (e.getSource() == mediumMI) setFontSize(14);
    else if (e.getSource() == largeMI) setFontSize(18);
    else if (e.getSource() == extraLargeMI) setFontSize(22);
    else if (e.getSource() == blackMI) setFontColor(Color.BLACK);
    else if (e.getSource() == redMI) setFontColor(Color.RED);
    else if (e.getSource() == greenMI) setForeground(Color.GREEN);
    else if (e.getSource() == blueMI) setForeground(Color.BLUE);
    else if (e.getSource() == font1MI) setFontFamily("Serif");
    else if (e.getSource() == font2MI) setFontFamily("SansSerif");
    else if (e.getSource() == font3MI) setFontFamily("Monospaced");
  }

  public void setFontSize(int size) {
    DeviceNameTextField.setFont(new Font(DeviceNameTextField.getFont().getFamily(), DeviceNameTextField.getFont().getStyle(), size));
    BrandTextField.setFont(new Font(BrandTextField.getFont().getFamily(), BrandTextField.getFont().getStyle(), size));
    PriceTextField.setFont(new Font(PriceTextField.getFont().getFamily(), PriceTextField.getFont().getStyle(), size));
    featureTextArea.setFont(new Font(featureTextArea.getFont().getFamily(), featureTextArea.getFont().getStyle(), size));
  }

  public void setFontFamily(String font) {
    DeviceNameTextField.setFont(new Font(font, DeviceNameTextField.getFont().getStyle(), DeviceNameTextField.getFont().getSize()));

    BrandTextField.setFont(new Font(font, BrandTextField.getFont().getStyle(), BrandTextField.getFont().getSize()));
    PriceTextField.setFont(new Font(font, PriceTextField.getFont().getStyle(), PriceTextField.getFont().getSize()));
    featureTextArea.setFont(new Font(font, featureTextArea.getFont().getStyle(), featureTextArea.getFont().getSize()));
  }

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
