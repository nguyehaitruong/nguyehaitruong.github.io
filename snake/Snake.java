/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Admin
 */
public class Snake {
    int snakelenght=1;
    int []x;
    int []y;
    long t1=0;
    public Snake(){
        x=new int[20];
        y=new int [20];
        
        x[0]=1;
        y[0]=1;
          
        
        
    }
    public void movie(){
        if(System.currentTimeMillis()-t1>1000){
            x[0]++;
            t1=System.currentTimeMillis();
            
        }
    }
    public void painS(Graphics g){
        g.setColor(Color.red);    
        for(int i=0;i<snakelenght;i++){
            g.fillRect(x[i]*20+1,y[i]*20+1,18,18 ) ;
        }
    }
    
    
}
