package saetkong.chanasit.exercises.gui3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SimpleFormV8 extends SimpleFormV7 implements ItemListener {
  protected JFileChooser fc = new JFileChooser();

  public SimpleFormV8(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();
    openMI.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == openMI) {
      int returnVal = fc.showOpenDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) { 
        String msg = "Opening: " + fc.getSelectedFile().getName();
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
      }
      else {
        JOptionPane.showMessageDialog(this, "Open file cancelled by the user", "Message", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }
    public static void createAndShowGUI() {
      SimpleFormV8 window = new SimpleFormV8("SimpleFormV8");
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




