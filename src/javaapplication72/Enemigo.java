/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication72;

/**
 *
 * @author alessandro
 */
public class Enemigo {
    protected int posX;
    protected int posY;

    public Enemigo(int startX, int startY) {
        this.posX = startX;
        this.posY = startY;
    }

    public void mover() {
        // Lógica para mover al enemigo
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
