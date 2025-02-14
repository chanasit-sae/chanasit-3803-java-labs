package saetkong.chanasit.exercises.gui3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SimpleFormV7 extends SimpleFormV6 implements ItemListener {

  public SimpleFormV7(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();
    male.addItemListener(this);
    female.addItemListener(this);
    other.addItemListener(this);

    newMI.addItemListener(this);
    openMI.addItemListener(this);
    quitMI.addItemListener(this);
  }

  public void itemStateChanged(ItemEvent e) {
    Object src = e.getSource();
    int state = e.getStateChange();

    if (src == male && state == ItemEvent.SELECTED) {
      JOptionPane.showMessageDialog(this, male.getText() + " is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
    } else if (src == female && state == ItemEvent.SELECTED) {
      JOptionPane.showMessageDialog(this, female.getText()+ " is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
    } else if (src == other && state == ItemEvent.SELECTED) {
      JOptionPane.showMessageDialog(this, other.getText()+ " is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public String getMessage() {
    return nameTxt.getText() + " lives at " + 
      addrTxtArea.getText() + " gender is " + 
      getGender() + "know these languages: " 
      + getLanguages();
  }

  public String getInfoAsText() {
    return nameTxt.getText() + 
      " lives in " + addrTxtArea.getText() + 
      " gender is " + getGender() + 
      " knows these languages: " + getLanguages();
  }

  public String getGender() {
    if (male.isSelected()) return male.getText();
    else if (female.isSelected()) return female.getText();
    else if (other.isSelected()) return other.getText();
    else return null;
  }

  public String getLanguages() {
    String result = "";
    if (python.isSelected()) result += python.getText() + " ";
    if (java.isSelected()) result += java.getText() + " ";
    if (javascript.isSelected()) result += javascript.getText() + " ";
    if (result == "") return null;
    return result;
  }

  public static void createAndShowGUI() {
    SimpleFormV6 window = new SimpleFormV7("SimpleFormV7");
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



