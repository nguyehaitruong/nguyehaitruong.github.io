/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class display extends JFrame{
    Screen game;
    public display(){
        
        setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        game=new Screen();
        add(game);
        this.addKeyListener(new handler());

    setVisible(true);
            }
    
    public static void main(String[] args) {
        display dis=new display();
    }
    private class handler implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
          
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
          
        }
       
        
        

        
    
}
}