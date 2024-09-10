/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication72;

/**
 *
 * @author alessandro
 */
public class Moneda {
   private int posX;
    private int posY;
    private boolean recolectada;

    public Moneda(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.recolectada = false;
    }

    // Método para recolectar la moneda
    public void recolectar() {
        this.recolectada = true;
    }

    // Verifica si la moneda ya fue recolectada
    public boolean isRecolectada() {
        return recolectada;
    }

    // Obtener la posición X de la moneda
    public int getPosX() {
        return posX;
    }

    // Obtener la posición Y de la moneda
    public int getPosY() {
        return posY;
    }
} 

