/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.C_Elegans;

/**
 *
 * @author mnolan
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;




import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel  implements ActionListener{

    Image star;
    Timer timer;
    int x, y;
    int incy = 10;
    
    Person person = new Person(300,530);
    private ArrayList persons;
    Random r = new Random();
    /*private int[][] pos = {
        {300, 490}, {200, 480}, {150, 300}, {400, 445}, {256, 156}, {r.nextInt(600), r.nextInt(400)}, {r.nextInt(600), r.nextInt(400)}, {r.nextInt(600), r.nextInt(400)}, {r.nextInt(600), r.nextInt(400)}, {r.nextInt(600), r.nextInt(400)}, {r.nextInt(600), r.nextInt(400)}
    };*/

    public Board(int xsize, int ysize) {
        setBackground(Color.WHITE);

        ImageIcon ii = new ImageIcon(this.getClass().getResource("stickman.png"));
        star = ii.getImage();
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);

        x = 300;
        y = 500;
        //initPersons();
        timer = new javax.swing.Timer(20, this);
        timer.start();
    }
    /*private void initPersons() {
        persons = new ArrayList();

        for (int i=0; i<pos.length; i++ ) {
            persons.add(new Person(pos[i][0], pos[i][1]));
        }
    }*/


    public void paint(Graphics g) {
        super.paint(g);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        Graphics2D g2d = (Graphics2D)g;
        person.move();
        g2d.drawImage(person.getImage(), person.getX(), person.getY(),this);
        
        g2d.setColor(new Color(75,200,75));
        g.fillRect(0, 535, 600, 600);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    


    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            person.keyReleased(e);
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            person.keyPressed(e);
        }
    }
}