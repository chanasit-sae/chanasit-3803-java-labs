package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//coded by: chanasit saetkong
//ID: 673040380-3
//date: 3/2/2025

// This class extends MobileDeviceV2 and incorporates a menu bar for additional features.
public class MobileDeviceV3 extends MobileDeviceV2 {
  // Menu bar and its components
  protected JMenuBar menuBar;
  protected JMenu fileMenu;
  protected JMenuItem newMI, openMI, saveMI, exitMI;

  // Config menu and its submenus
  protected JMenu configMenu;
  protected JMenu sizeMI, colorMI, fontMI;
  protected JMenuItem smallMI, mediumMI, largeMI, extraLargeMI;
  protected JMenuItem blackMI, redMI, greenMI, blueMI;
  protected JMenuItem font1MI, font2MI, font3MI;

  // Constructor: Calls superclass constructor and sets the window title.
  public MobileDeviceV3(String title) {
    super(title);
  }

  // Overrides addComponents() to add the menu bar along with existing UI components.
  public void addComponents() {
    super.addComponents();
    addMenus();
  }
  
  // Method to initialize and add menus to the menu bar.
  public void addMenus() {
    // Create the "File" menu with items: New, Open, Save, Exit
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    newMI = new JMenuItem("New");
    openMI = new JMenuItem("Open");
    saveMI = new JMenuItem("Save");
    exitMI = new JMenuItem("Exit");

    // Add file menu items to the "File" menu.
    fileMenu.add(newMI);
    fileMenu.add(openMI);
    fileMenu.add(saveMI);
    fileMenu.add(exitMI);
    menuBar.add(fileMenu);

    // Add file menu items to the "File" menu.
    configMenu = new JMenu("Config");
    addSizeMenuItems();
    addColorMenuItems();
    addFontMenuItems();
    menuBar.add(configMenu);

    // Add "File" menu to the menu bar.
    setJMenuBar(menuBar);
  }

  // Method to add size-related menu items to the "Config" menu.
  public void addSizeMenuItems() {
    // Create size options.
    sizeMI = new JMenu("Size");
    smallMI = new JMenuItem("Small");
    mediumMI = new JMenuItem("Medium");
    largeMI = new JMenuItem("Large");
    extraLargeMI = new JMenuItem("Extra Large");

    // Add size options to the "Size" submenu.
    sizeMI.add(smallMI);
    sizeMI.add(mediumMI);
    sizeMI.add(largeMI);
    sizeMI.add(extraLargeMI);

    // Add the "Size" submenu to the "Config" menu.
    configMenu.add(sizeMI);
  }

  // Method to add color-related menu items to the "Config" menu.
  public void addColorMenuItems() {
    // Create color options.
    colorMI = new JMenu("Color");
    blackMI = new JMenuItem("Black");
    redMI = new JMenuItem("Red");
    greenMI = new JMenuItem("Green");
    blueMI = new JMenuItem("Blue");

    // Add color options to the "Color" submenu.
    colorMI.add(blackMI);
    colorMI.add(redMI);
    colorMI.add(greenMI);
    colorMI.add(blueMI);
    
    // Add the "Color" submenu to the "Config" menu.
    configMenu.add(colorMI);
  }

  // Method to add font-related menu items to the "Config" menu.
  public void addFontMenuItems() {
    // Create font options.
    fontMI = new JMenu("Font");
    font1MI = new JMenuItem("Font 1");
    font2MI = new JMenuItem("Font 2");
    font3MI = new JMenuItem("Font 3");
    
    // Add font options to the "Font" submenu.
    fontMI.add(font1MI);
    fontMI.add(font2MI);
    fontMI.add(font3MI);

    // Add the "Font" submenu to the "Config" menu.
    configMenu.add(fontMI);
  }

  // Creates and displays the GUI.
  public static void createAndShowGUI() {
    MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
    mdv3.addComponents();
    mdv3.setFrameFeatures();
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  

}
