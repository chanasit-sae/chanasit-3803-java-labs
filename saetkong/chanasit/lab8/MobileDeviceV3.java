package saetkong.chanasit.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV3 extends MobileDeviceV2 {
  protected JMenuBar menuBar;
  protected JMenu fileMenu;
  protected JMenuItem newMI, openMI, saveMI, exitMI;

  protected JMenu configMenu;
  protected JMenu sizeMI, colorMI, fontMI;
  protected JMenuItem smallMI, mediumMI, largeMI, extraLargeMI;
  protected JMenuItem blackMI, redMI, greenMI, blueMI;
  protected JMenuItem font1MI, font2MI, font3MI;


  public MobileDeviceV3(String title) {
    super(title);
  }

  public void addComponents() {
    super.addComponents();
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    newMI = new JMenuItem("New");
    openMI = new JMenuItem("Open");
    saveMI = new JMenuItem("Save");
    exitMI = new JMenuItem("Exit");

    fileMenu.add(newMI);
    fileMenu.add(openMI);
    fileMenu.add(saveMI);
    fileMenu.add(exitMI);
    menuBar.add(fileMenu);

    configMenu = new JMenu("Config");
    addSizeMenuItems();
    addColorMenuItems();
    addFontMenuItems();
    menuBar.add(configMenu);


    setJMenuBar(menuBar);

  }

  public void addSizeMenuItems() {
    sizeMI = new JMenu("Size");
    smallMI = new JMenuItem("Small");
    mediumMI = new JMenuItem("Medium");
    largeMI = new JMenuItem("Large");
    extraLargeMI = new JMenuItem("Extra Large");

    sizeMI.add(smallMI);
    sizeMI.add(mediumMI);
    sizeMI.add(largeMI);
    sizeMI.add(extraLargeMI);

    configMenu.add(sizeMI);
  }

  public void addColorMenuItems() {
    colorMI = new JMenu("Color");
    blackMI = new JMenuItem("Black");
    redMI = new JMenuItem("Red");
    greenMI = new JMenuItem("Green");
    blueMI = new JMenuItem("Blue");

    colorMI.add(blackMI);
    colorMI.add(redMI);
    colorMI.add(greenMI);
    colorMI.add(blueMI);

    configMenu.add(colorMI);
  }

  public void addFontMenuItems() {
    fontMI = new JMenu("Font");
    font1MI = new JMenuItem("Font 1");
    font2MI = new JMenuItem("Font 2");
    font3MI = new JMenuItem("Font 3");
    
    fontMI.add(font1MI);
    fontMI.add(font2MI);
    fontMI.add(font3MI);

    configMenu.add(fontMI);
  }

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
