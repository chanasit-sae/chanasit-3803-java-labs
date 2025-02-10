package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab8.MobileDeviceV3;

//This class extended from MobileDeviceV3
//adding icons for new open save and exit 
//set the font size of the sub-menu to be in size according to its size
//set the color of the sub-menu to be in the color according to its color
//set the font of the sub-menu to be in the font according to its font 
//
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 10/2/2025

public class MobileDeviceV4 extends MobileDeviceV3 {
  protected ImageIcon newImgIcon;

  public MobileDeviceV4(String title) {
    super(title);
  }

  // Override addComponents method to add components (still calling the superclass method)
  public void addComponents() {
    super.addComponents();
  }

  //overide to add new features like icons, colors, fonts, and font sizes
  public void addMenus() {
    super.addMenus();
    setIcon();
    setColor();
    setFont();
    setFontSize();
  }

  // Method to set the icons for menu items by loading image resources from the classpath
  public void setIcon() {
    newMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));
    openMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/open_icon.png")));
    saveMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save_icon.png")));
    exitMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit_icon.png")));
  }

  // Method to set the colors for the menu items
  public void setColor() {
    redMI.setForeground(Color.RED);
    greenMI.setForeground(Color.GREEN);
    blueMI.setForeground(Color.BLUE);
  }

  // Method to set the font style for the menu items
  public void setFont() {
    font1MI.setFont(new Font("Serif", Font.PLAIN, 14));
    font2MI.setFont(new Font("SansSerif", Font.PLAIN, 14));
    font3MI.setFont(new Font("Monospaced", Font.PLAIN, 14));
  }

  // Method to set the font sizes for the menu items
  public void setFontSize() {
    smallMI.setFont(new Font("Arial", Font.PLAIN, 10));
    mediumMI.setFont(new Font("Arial", Font.PLAIN, 14));
    largeMI.setFont(new Font("Arial", Font.PLAIN, 18));
    extraLargeMI.setFont(new Font("Arial", Font.PLAIN, 22));
  }

  public static void createAndShowGUI() {
    MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
    mdv4.addComponents();
    mdv4.setFrameFeatures();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  


}


