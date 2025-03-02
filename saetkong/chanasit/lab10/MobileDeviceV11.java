package saetkong.chanasit.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 17/2/2025

public class MobileDeviceV11 extends MobileDeviceV10 implements ActionListener{

  //calling super constructor
  public MobileDeviceV11(String title) {
    super(title);
  }

  //adding action listener to the menu items
  protected void addListeners() {
    super.addListeners();  
    TypeRadioSmartphone.addActionListener(this); 
    TypeRadioTablet.addActionListener(this);
  }

  //perform action based on the button clicked
  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);//calling super because this to keep the old acion

    Object src = e.getSource();
    if (src instanceof JRadioButton) {
      JRadioButton selected = (JRadioButton) src;
      String msg = selected.getText() + " is selected";
      JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void addMnemonicKeys() {
    // New menu item
    newMI.setMnemonic(KeyEvent.VK_N);
    newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    // Open menu item
    openMI.setMnemonic(KeyEvent.VK_O);
    openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    // Save menu item
    saveMI.setMnemonic(KeyEvent.VK_S);
    saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    // Exit menu item
    exitMI.setMnemonic(KeyEvent.VK_X);
    exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
  }

  //set font size of textField and textArea
  public static void createAndShowGUI() {
    MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
    mdv11.addComponents();
    mdv11.addListeners();
    mdv11.setFrameFeatures();
    mdv11.addMnemonicKeys();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}


