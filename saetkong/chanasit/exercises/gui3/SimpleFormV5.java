package saetkong.chanasit.exercises.gui3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleFormV5 extends SimpleFormV4 implements ActionListener  {

  public SimpleFormV5(String title) {
    super(title);
  }

  public void addListeners() {
    okButton.addActionListener(this);
    cancelButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == okButton) {
      JOptionPane.showMessageDialog(null,getInfoAsText());
      return;
    } 
  }

  public String getInfoAsText() {
    return nameTxt.getText() + " lives at " + addrTxtArea.getText();
  }

  public static void createAndShowGUI() {
    SimpleFormV5 window = new SimpleFormV5("SimpleFormV5");
    window.addComponents();
    window.addMenus();
    window.setFrameFeatures();
    window.addListeners();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}

