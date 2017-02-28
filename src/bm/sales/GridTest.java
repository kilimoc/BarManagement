/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.sales;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridTest extends JFrame {

  public static void main(String[] args) {
    int rows = 1;
    int cols = 4;
    GridTest gt = new GridTest(rows, cols);
    gt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gt.pack();
    gt.setVisible(true);
  }

  public GridTest(int rows, int cols) {
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(rows, cols));
    for (int i = 0; i < 3; i++) {
      JButton button = new JButton(Integer.toString(i + 1));
      pane.add(button);
    }
    ArrayList <String>holiday=new ArrayList();
  }

}