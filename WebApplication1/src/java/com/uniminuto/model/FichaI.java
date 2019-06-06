
package com.uniminuto.model;
/**
 * Esta clase define la ficha I y contiene métodos extraidos de Coordenada para inicializar la ficha dentro del tablero
 * al igual que contiene la funcionalidad de rotar
 * @author Company iTetramino
 * @version 0.2
 */

public class FichaI extends Tetromino {
    
    /** 
    * estado 0, almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha verticalmente 
    */
    public int[][] estado0 = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}};
    /**
     * estado1, almacena en la matriz valores de 1 para la coordenada en X,Y que van a dar forma a la ficha horizontalmente  
     */
    public int[][] estado1 = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    /**
    * @param ubicacion *  @see Tetromino 
    * se toma la ubicación inicial dada por el tablero, y el estado inicial de la ficha
    * @param estado, estado inicial de la ficha
    */ 
    public FichaI(Coordenada ubicacion, int estado) {
        super(ubicacion, estado);
/**
 * se toma el condicional para cambiar de estado
 */
        if (estado < 0 || estado > 1) {
            this.estado = -1;
        }
        this.estados.add(0, this.estado0);
        this.estados.add(1, this.estado1);
    }

    @Override
/**
 * @see clase tetromino
 * método para rotar a la derecha, se usa con los estados inicializados anteriormente
 */
    public void rotarDerecha() {
        if (this.estado == 1) {
            this.estado = 0;
        } else {
            this.estado++;
        }
    }

    @Override
    
 /**
  * @see clase Tetromino
  * método para rotar a la izquierda, se usa con los estados inicializados anteriormente
  */
    public void rotarIzquierda() {
        if (this.estado == 0) {
            this.estado = 1;
        } else {
            this.estado--;
        }
    }
}
