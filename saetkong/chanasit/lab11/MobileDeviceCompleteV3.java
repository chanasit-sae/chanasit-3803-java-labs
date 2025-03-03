package saetkong.chanasit.lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;


//this class is written to make the program shows a message when:
//user changes window show
//user moves the window position
//toggle show and hidden window 
//coded by: chanasit saetkong
//ID: 673040380-3
//modify date: 3/3/2025

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {
  private Timer resizeTimer, moveTimer;//use timer to make the message show only when user stop adjusting the window for a brief time

  public MobileDeviceCompleteV3(String title) {
    super(title);
    
    //setting the timer for how long user have to stop adjusting
    //when the timer is over it calls a method to show the message 
    resizeTimer = new Timer(500, e -> showResizeMessage());
    resizeTimer.setRepeats(false);

    moveTimer = new Timer(500, e -> showMoveMessage());
    moveTimer.setRepeats(false);
  }

  public void addListeners() {
    super.addListeners();
    this.addComponentListener(this);
  }

  //show message when the window is hidden
  @Override
  public void componentHidden(ComponentEvent e) {
    JOptionPane.showMessageDialog(null, "Window is now invisible", "Message", JOptionPane.INFORMATION_MESSAGE);
  } 

  //show message when the window is shown
  @Override
  public void componentShown(ComponentEvent e) {
    JOptionPane.showMessageDialog(null, "Window is now visible", "Message", JOptionPane.INFORMATION_MESSAGE);
  } 

  //reset the timer when new adjustment happends
  @Override
  public void componentMoved(ComponentEvent e) {
    moveTimer.restart();
  } 

  //reset the timer when new adjustment happends
  @Override
  public void componentResized(ComponentEvent e) {
    resizeTimer.restart();
  } 

  //show message when the window is moved
  public void showMoveMessage() {

    JOptionPane.showMessageDialog(null, "Window moved to: " + "X=" + this.getX() + " Y=" + this.getY(), "Message", JOptionPane.INFORMATION_MESSAGE);
  }

  //show message when the window is resized
  public void showResizeMessage() {
    JOptionPane.showMessageDialog(null, "Window resized to: " + this.getWidth() + " x " + this.getHeight() , "Message", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void createAndShowGUI() {
    MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device CompleteV3");
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


