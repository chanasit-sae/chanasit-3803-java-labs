package saetkong.chanasit.lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;

//when user press custom menu item the JColorChooser panel will pop up 
//and when press OK the color of the text fields will change
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 3/3/2025
public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 implements ActionListener{
  protected JMenuItem customMI;//create custom menu item
  protected JMenu configMenu, colorMenu;

  public MobileDeviceCompleteV4(String title) {
    super(title);
  }

  public void addListeners() {
    super.addListeners();
    customMI.addActionListener(this);
  }
  
  //adding custom menu item into color menu and add it to the config menu
  @Override
  protected void addMenus() {
    super.addMenus();
    configMenu = new JMenu("Config");
    colorMenu = new JMenu("Color");
    customMI = new JMenuItem("Custom");

    colorMenu.add(customMI);
    configMenu.add(colorMenu);
    menuBar.add(configMenu);
  }

  //add action to custom menu item
  public void actionPerformed(ActionEvent e) {
    super.actionPerformed(e);
    Object src = e.getSource();
    if (src == customMI) {

      Color oldColor = deviceNameField.getForeground();//get the old selected color
      Color newColor = JColorChooser.showDialog(this, "Choose Text Color", oldColor);//pop up a window for user to choose color

      if (newColor == null) return; //if press cancel the color won't change

      //change the color for all the text fields
      deviceNameField.setForeground(newColor); 
      brandField.setForeground(newColor); 
      priceField.setForeground(newColor); 
    }
  }  

  public static void createAndShowGUI() {
    MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device CompleteV4");
    window.addComponents();
    window.addMenus();
    window.setFrameFeatures();
    window.addListeners();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater((new Runnable() {
      public void run(){
        createAndShowGUI();
      }
    }));
  }
}



