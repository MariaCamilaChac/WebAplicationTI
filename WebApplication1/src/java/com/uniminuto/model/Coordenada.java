
package com.uniminuto.model;
/**
 * Esta clase se basa en dar la coordenada dentro del tablero
 * @author Company iTetramino
 * @version 0.2
 */

public class Coordenada {
  
    public int filaInicio;
    public int filaFin;
    public int columnaInicio;
    public int columnaFin;
    
      /**
       * @param  filaInicio, entero requerido para usar el método coordenada e inicializar la fila, esto es respecto a X
       * @param filaFin, entero requerido para usar el método coordenada y verificar la fila final, esto es respecto a X
       * @param columnaInicio, entero requerido para usar el método coordenada e inicializar la columna, esto es respecto a Y
       * @param columnaFin, entero requerido para usar el método coordenada y verificar la columna final, esto es respecto a Y
        */
     
    public Coordenada(int filaInicio, int filaFin, int columnaInicio, int columnaFin) {
        this.filaInicio = filaInicio;
        this.filaFin = filaFin;
        this.columnaInicio = columnaInicio;
        this.columnaFin = columnaFin;
    }
 /**@return string con la coordenada*/ 
    @Override
    public String toString(){
        return filaInicio + "," + filaFin + "," + columnaInicio + "," + columnaFin;
    }
}
