/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication72;

import java.util.ArrayList;

/**
 *
 * @author alessandro
 */
public class Nivel {
    private int[][] mapa;  // Representación del nivel, 0 = vacío, 1 = moneda
    private int ancho;
    private int alto;
    private Mario mario;

    public Nivel(Mario ancho) {
        this.ancho = ancho;
        this.alto = alto;
        this.mapa = new int[alto][ancho];
        this.mario = new Mario(0, alto - 1); // Mario comienza en la esquina inferior izquierda

        // Inicializar el mapa con algunas monedas
        generarMonedas();
    }

    // Método para generar monedas en el nivel de manera aleatoria
    private void generarMonedas() {
        for (int i = 0; i < 10; i++) { // Por ejemplo, 10 monedas en total
            int x = (int) (Math.random() * ancho);
            int y = (int) (Math.random() * alto);
            mapa[y][x] = 1; // Colocar una moneda en una posición aleatoria
        }
    }

    // Método para mover a Mario en el nivel
    public void moverMarioIzquierda() {
        mario.moverIzquierda();
        recolectarMoneda();
    }

    public void moverMarioDerecha() {
        mario.moverDerecha();
        recolectarMoneda();
    }

    public void saltarMario() {
        mario.saltar();
        recolectarMoneda();
    }

    // Método para recolectar monedas
    private void recolectarMoneda() {
        int marioX = mario.getPosX();
        int marioY = mario.getPosY();
        
        // Verificar si Mario está en la misma posición que una moneda
        if (marioX >= 0 && marioX < ancho && marioY >= 0 && marioY < alto && mapa[marioY][marioX] == 1) {
            mario.recolectarMoneda();
            mapa[marioY][marioX] = 0; // Eliminar la moneda del mapa
            System.out.println("Moneda recolectada! Total: " + mario.getMonedas());
        }
    }

    // Método para dibujar el nivel en la consola
    public void dibujarNivel() {
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                if (x == mario.getPosX() && y == mario.getPosY()) {
                    System.out.print("M "); // Representar a Mario con 'M'
                } else if (mapa[y][x] == 1) {
                    System.out.print("O "); // Representar una moneda con 'O'
                } else {
                    System.out.print(". "); // Representar espacio vacío con '.'
                }
            }
            System.out.println();
        }
    }

    // Método principal para ejecutar el juego
    public static void main(String[] args) {
        Nivel nivel = new Nivel(10); // Crear un nivel de 10x5

        // Simular algunos movimientos de Mario
        nivel.dibujarNivel();
        nivel.moverMarioDerecha();
        nivel.dibujarNivel();
        nivel.moverMarioDerecha();
        nivel.dibujarNivel();
        nivel.saltarMario();
        nivel.dibujarNivel();
        nivel.moverMarioIzquierda();
        nivel.dibujarNivel();
    }
}

   

