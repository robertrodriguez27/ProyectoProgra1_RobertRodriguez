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
    private Mario mario;

    public Enemigo(int startX, int startY, Mario mario) {
        this.posX = startX;
        this.posY = startY;
        this.mario = mario;
    }

    public void mover() {
        int marioX = mario.getPosX();
        int marioY = mario.getPosY();

        if (posX < marioX) {
            posX++;
        } else if (posX > marioX) {
            posX--;
        }

        if (posY < marioY) {
            posY++;
        } else if (posY > marioY) {
            posY--;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}