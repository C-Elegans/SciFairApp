/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.C_Elegans;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
  
import javax.swing.ImageIcon;

/**
 *
 * @author mnolan
 */
public class Person {
   private String person = "stickman.png";

    private int dx;
    private int dy= 0;
    private int x;
    private int y;
    private Image image;
    
    private boolean visible = true;  
    public Person(int xset, int yset) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(person));
        x=300;
        y=490;
        image = ii.getImage();
        
    }
    public void move(){
        x+=dx; 
        dy = dy - 1;
           y -= dy;
           if (x>655)x=655;
           if (x<5)x=5;
           if (y > 500){
               y = 500;
               dy = 0;
    }
    }
    
     public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, 64, 64);
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
     public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE){
            if (y>=496)dy = 10;
        }
        if (key == KeyEvent.VK_UP){
            if (y>=496)dy = 10;
        }
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        
    }
     public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
     }
    
}
