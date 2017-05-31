/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selendroidapptks;

import javax.swing.JFrame;

/**
 *
 * @author hpasarin
 */
public class Ventana  {
    private static int ancho;
    private static int alto;
    private static String titulo;
    private static int px,py;
    private static Ventana ventana;
    
    public Ventana(int ancho, int alto, String titulo, int px, int py) {
        this.ancho = ancho;
        this.alto = alto;
        this.titulo = titulo;
        this.px = px;
        this.py = py;
    }
    
    
    public static void main(String[] args) {
        
      ventana = new Ventana(500,500,"mostrar devices conectados: ",200,200);
      
        
    }
    
    
    
    
    
    
    
    
    
}
