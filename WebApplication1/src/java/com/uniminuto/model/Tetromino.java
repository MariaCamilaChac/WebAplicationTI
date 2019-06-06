package com.uniminuto.model;

import java.util.ArrayList;
/**
 * Esta clase define las funcionalidades que contendran las fichas T e I y contiene métodos extraidos de Coordenada para inicializar la ficha dentro del tablero
 * al igual que contiene la funcionalidad de trasladar
 * @author Company iTetramino
 * @version 0.2
 */


public class Tetromino {
        

    protected ArrayList<int[][]> estados = new ArrayList<>();   
 /**
 * estado es una variable de tipo entero, que almacena el estado de la ficha
 */
    protected int estado;
    /**
     * ubicacion es una variable de tipo coordenada, esta variable se implementa en @see clase FichaI y FichaT
    */
    protected Coordenada ubicacion;
    
 /**
     * @param ubicacion *  @see Tetromino 
     * se toma la ubicación inicial dada por el tablero, y el estado inicial de la ficha
     * @param estado, estado inicial de la ficha
    */ 
    public Tetromino(Coordenada ubicacion, int estado){
        this.estado = estado;
        this.ubicacion = ubicacion;
    }
    /**
    * @return el estado actual de la ficha
    */
    public int obtenerEstado(){
        return this.estado;
    }
    
    public void rotarDerecha(){}
    
    public void rotarIzquierda(){}
    
   /**
    * @return Un String dejando libre el tamaño según el tablero 
    * inicialmente se dará forma con corchetes para evidenciar la longitud de la ficha
    */
    
    public String obtenerForma(){
        
    /**
     * @param temp, almacena el estado incial y da la longitud de la ficha
     */
        int temp[][] = estados.get(estado);
        String forma = "{";
        for (int i = 0; i < temp.length; i++){
            forma += "{";
            for( int j = 0; j < temp.length; j++){
                forma += temp[i][j];
                if(j != (temp.length - 1)){
                    forma += ",";
                }
            }
            forma += "}";
        }
        forma += "}";
        return forma;
    }
    
    /**
     * El método desplazarIzquierda toma la ubicación en la que se encuentre la ficha
     * en este caso la columna inicio y la columna fin disminuiran su posición en uno
     */
   
    public void desplazarIzquierda(){
        this.ubicacion.columnaInicio--;
        this.ubicacion.columnaFin--;
    }
    
    /**
     * El método desplazarIzquierda toma la ubicación en la que se encuentre la ficha
     * en este caso la columna inicio y la columna fin disminuiran su posición en uno
     */
    public void desplazarDerecha(){
        this.ubicacion.columnaInicio++;
        this.ubicacion.columnaFin++;
    }
    
    /**
     * El método desplazarIzquierda toma la ubicación en la que se encuentre la ficha
     * en este caso la columna inicio y la columna fin disminuiran su posición en uno
     * @return Coordenada
     */
    
    public Coordenada obtenerUbicación(){
        return this.ubicacion;
    }
    
    /**
     * El método desplazarIzquierda toma la ubicación en la que se encuentre la ficha
     * en este caso la columna inicio y la columna fin disminuiran su posición en uno
     * @param filaInicio ingresa la coordenada de la fila inicial de la ficha en el final del tablero
     * @param filaFin ingresa la coordenada de la fila final de la ficha en el final del tablero
     */
    public void caer(int filaInicio, int filaFin){
        this.ubicacion.filaInicio = filaInicio;
        this.ubicacion.filaFin = filaFin;
    }
}
