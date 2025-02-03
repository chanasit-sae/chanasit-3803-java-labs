package saetkong.chanasit.lab9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import saetkong.chanasit.lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3 {
  protected ImageIcon newImgIcon;

  public MobileDeviceV4(String title){
    super(title);
  }

  public void addComponents() {
    super.addComponents();
  }

  public void addMenus() {
    super.addMenus();
    setIcon();
    setColor();
    setFont();
    setFontSize();
  }

  public void setIcon() {
    newMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));
    openMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/open_icon.png")));
    saveMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save_icon.png")));
    exitMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit_icon.png")));
  }

  public void setColor() {
    redMI.setForeground(Color.RED);
    greenMI.setForeground(Color.GREEN);
    blueMI.setForeground(Color.BLUE);
  }

  public void setFont() {
    font1MI.setFont(new Font("Serif", Font.PLAIN, 14));
    font2MI.setFont(new Font("SansSerif", Font.PLAIN, 14));
    font3MI.setFont(new Font("Monospaced", Font.PLAIN, 14));
  }

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


