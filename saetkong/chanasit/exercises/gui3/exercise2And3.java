package saetkong.chanasit.exercises.gui3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exercise2And3 extends SimpleFormV5 implements ActionListener  {

  public exercise2And3(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();
  }

  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
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


