/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.C_Elegans;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author mnolan
 */
public class SciFairApp extends JFrame{
    public int xSize = 600;
    public int ySize = 600;
    public SciFairApp() {
        add(new Board(xSize, ySize));
        setTitle("Test App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(xSize, ySize);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static void main(String[] args) {
       new SciFairApp();
    }
}
