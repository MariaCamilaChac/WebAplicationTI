/**

 */
package com.uniminuto.model;


/**
 * Esta clase define la ficha T y contiene métodos extraidos de Coordenada para inicializar la ficha dentro del tablero
 * al igual que contiene la funcionalidad de rotar
 * @author Company iTetramino
 * @version 0.2
 * @see Tetromino para comprender la extensión
 
 */
public class FichaT extends Tetromino {
    /** 
    * estado0, almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha verticalmente hacía abajo
    */
    public int[][] estado0 = {{1, 1, 1}, {0, 1, 0}, {0, 1, 0}};
    /**
     * estado1, almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha horizontalmente hacía la derecha 
     */
    public int[][] estado1 = {{0, 0, 1}, {1, 1, 1}, {0, 0, 1}};
    /**
     * estado2, almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha verticalmente hacía arriba 
     */
    public int[][] estado2 = {{0, 1, 0}, {0, 1, 0}, {1, 1, 1}};
    /**
     * estado3. almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha horizontalmente hacía la izquierda
     */
    public int[][] estado3 = {{1, 0, 0}, {1, 1, 1}, {1, 0, 0}};

    /**
     * @param ubicacion *  @see clase Tetromino se toma la ubicación inicial dada por el tablero, y el estado inicial de la ficha
     * @param estado, estado inicial de la ficha
    */ 
    public FichaT(Coordenada ubicacion, int estado) {
        super(ubicacion, estado);
        if (estado < 0 || estado > 3) {
            this.estado = -1;
        }
        this.estados.add(0, this.estado0);
        this.estados.add(1, this.estado1);
        this.estados.add(2, this.estado2);
        this.estados.add(3, this.estado3);
    }
    /**
    * @see Tetromino
    * método para rotar a la derecha, se usa con los estados inicializados anteriormente
    */
    @Override
    public void rotarDerecha() {
        if (this.estado == 3) {
            this.estado = 0;
        } else {
            this.estado++;
        }
    }
    /**
    * @see Tetromino
    * método para rotar a la derecha, se usa con los estados inicializados anteriormente
    */
    @Override
    public void rotarIzquierda() {
        if (this.estado == 0) {
            this.estado = 3;
        } else {
            this.estado--;
        }
    }
}
