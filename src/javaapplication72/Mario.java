/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication72;

/**
 *
 * @author alessandro
 */
public class Mario {
   private int posX;
    private int posY;
    private int vidas;
    private int monedas;

    // Atributos para manejar el salto
    private boolean saltando;
    private int alturaSalto;  // Altura máxima del salto
    private int velocidadSalto; // Velocidad inicial de salto
    private int gravedad;      // Fuerza de gravedad
    private int alturaInicial;  // La posición Y inicial antes del salto

    public Mario(int startX, int startY) {
        this.posX = startX;
        this.posY = startY;
        this.vidas = 3;
        this.monedas = 0;
        this.saltando = false;
        this.alturaSalto = 5;   // Define la altura máxima del salto
        this.velocidadSalto = 10; // Velocidad inicial hacia arriba
        this.gravedad = 1;      // Fuerza de la gravedad (decrementa la velocidad)
    }

    // Método para mover a Mario hacia la izquierda
    public void moverIzquierda() {
        posX -= 1;
    }

    // Método para mover a Mario hacia la derecha
    public void moverDerecha() {
        posX += 1;
    }

    // Método para implementar la lógica del salto
    public void saltar() {
        if (!saltando) {
            saltando = true;
            alturaInicial = posY;
            int velocidadActual = velocidadSalto;

            // Ascenso
            while (velocidadActual > 0) {
                posY -= velocidadActual;
                velocidadActual -= gravedad;

                // Simular un tiempo de espera (bucle simplificado para ilustrar la idea)
                esperar(50);  // espera 50ms entre cada "frame"
            }

            // Descenso
            while (posY < alturaInicial) {
                posY += velocidadActual;
                velocidadActual += gravedad;

                if (posY >= alturaInicial) {
                    posY = alturaInicial;
                    saltando = false;
                }

                // Simular un tiempo de espera (bucle simplificado para ilustrar la idea)
                esperar(50);  // espera 50ms entre cada "frame"
            }
        }
    }

    // Método para simular un tiempo de espera
    private void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que Mario recolecte monedas
    public void recolectarMoneda() {
        monedas += 1;
    }

    // Método para que Mario pierda una vida
    public void perderVida() {
        vidas -= 1;
    }

    // Getters para acceder a los atributos de Mario
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getVidas() {
        return vidas;
    }

    public int getMonedas() {
        return monedas;
    }
}
    

