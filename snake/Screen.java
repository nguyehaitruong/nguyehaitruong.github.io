/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.Graphics;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Screen extends JPanel implements Runnable{
    Thread thread;
    int [][]mt=new int[20][20];
    Snake snake;
    public Screen(){
       snake=new Snake();
       thread=new Thread(this);
       thread.start();

      
    }
    private int i =0;
    public void run(){
        while (true) {
            snake.movie();
            i++;
            try {
                sleep(20);
            } catch (InterruptedException exception) {
            }
            
            
        }
        
        
        
    }
    public void painmt(Graphics g){
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                g.fillRect(i*20+1,j*20+1,18,18 );
            }
        
    }

    public void  paint(Graphics g) {
        painmt(g);
        snake.painS(g);
        
        
        
    }
    
}
