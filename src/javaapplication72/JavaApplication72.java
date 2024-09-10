/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication72;

import java.util.Scanner;

/**
 *
 * @author alessandro
 */
public class JavaApplication72 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mario mario = new Mario(0, 0);
        Nivel nivel1 = new Nivel(mario);

        while (mario.getVidas() > 0) {
            nivel1.actualizar();
            nivel1.dibujar();

            System.out.println("Mover: [a] Izquierda, [d] Derecha, [w] Saltar");
            String accion = sc.nextLine();

            switch (accion) {
                case "a":
                    mario.moverIzquierda();
                    break;
                case "d":
                    mario.moverDerecha();
                    break;
                case "w":
                    mario.saltar();
                    break;
                default:
                    System.out.println("Acción no válida.");
            }
        }

        System.out.println("Game Over");
        sc.close();
    }
    }
