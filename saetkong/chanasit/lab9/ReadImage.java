package saetkong.chanasit.lab9;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ReadImage extends JPanel{
  BufferedImage img;

  public ReadImage(String path) {
    try {
      img = ImageIO.read(new File(path));
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.drawImage(img, 0, 0, img.getWidth() / 2,img.getHeight() / 2, null);
  }

  public Dimension getPreferredSize() {
    if (img == null) return new Dimension(100, 100);
    else return new Dimension(img.getWidth()/2, img.getHeight()/2);
  }
}
