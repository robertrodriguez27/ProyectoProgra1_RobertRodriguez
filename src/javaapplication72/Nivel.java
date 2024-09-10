/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication72;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandro
 */
public class Nivel {
     private int[][] mapa;  // Representación del nivel, 0 = vacío, 1 = moneda
    private int ancho;
    private int alto;
    private Mario mario;
    private List<Enemigo> enemigos; // Lista para almacenar enemigos

    public Nivel(Mario mario) {
        this.ancho = 10; // Ancho del nivel
        this.alto = 5;  // Alto del nivel
        this.mapa = new int[alto][ancho];
        this.mario = mario;
        this.enemigos = new ArrayList<>(); // Inicializar la lista de enemigos

        // Inicializar el mapa con algunas monedas
        generarMonedas();

        // Agregar algunos enemigos para el ejemplo
        enemigos.add(new Enemigo(2, 2, mario));
        enemigos.add(new Enemigo(5, 3, mario));
    }

    // Método para generar monedas en el nivel de manera aleatoria
    private void generarMonedas() {
        for (int i = 0; i < 10; i++) { // Por ejemplo, 10 monedas en total
            int x = (int) (Math.random() * ancho);
            int y = (int) (Math.random() * alto);
            mapa[y][x] = 1; // Colocar una moneda en una posición aleatoria
        }
    }

    // Método para actualizar el nivel y recolectar monedas
    public void actualizar() {
        recolectarMoneda();
        for (Enemigo enemigo : enemigos) {
            enemigo.mover(); // Mover cada enemigo
        }
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
    public void dibujar() {
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                boolean esEnemigo = false;
                for (Enemigo enemigo : enemigos) {
                    if (x == enemigo.getPosX() && y == enemigo.getPosY()) {
                        System.out.print("E "); // Representar al enemigo con 'E'
                        esEnemigo = true;
                        break;
                    }
                }
                if (esEnemigo) continue;
                
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
}