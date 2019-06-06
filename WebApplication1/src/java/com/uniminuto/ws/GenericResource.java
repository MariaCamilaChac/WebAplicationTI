
package com.uniminuto.ws;

import com.uniminuto.model.Coordenada;
import com.uniminuto.model.FichaI;
import com.uniminuto.model.FichaT;
import com.uniminuto.model.Tetromino;
import java.util.concurrent.ExecutorService;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 * @author Company iTetramino
 * @version 0.2
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.uniminuto.ws.GenericResource
     *
     * @param ficha, interpreta a la ficha de manera general para almacenar en un switch la "fichai" y "fichat" debe ser escrito igual
     * @param metodo, interpreta la acción que se quiera ejercer sobre la ficha con estos mismos nombres "rotarDerecha" "rotarizquierda, "desplazarDerecha", "desplazarIzquierda", "obtenerEstado", "caer", "obtenerUbicacion
     * @param coordParam, almacena las coordenadas dadas por el usuario
     * @param estado, estado en el que se inicializa la ficha
     * @param filaI, variable para el método caer
     * @param filaF, variable para el método caer
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(
            @QueryParam("Ficha") String ficha,
            @QueryParam("Metodo") String metodo,
            @QueryParam("Coordenada") String coordParam,
            @QueryParam("Estado") int estado,
            @QueryParam("FilaInicio") int filaI,
            @QueryParam("FilaFin") int filaF
    ) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        String[] temp = coordParam.split(",");
        int filaInicio = Integer.parseInt(temp[0]);
        int filaFin = Integer.parseInt(temp[1]);
        int columnaInicio = Integer.parseInt(temp[2]);
        int columnaFin = Integer.parseInt(temp[3]);
        Coordenada coordenada = new Coordenada(filaInicio, filaFin, columnaInicio, columnaFin);
        Tetromino tempFicha;
        switch (ficha) {
            case "fichai":
                tempFicha = new FichaI(coordenada, estado);
                break;
            case "fichat":
                tempFicha = new FichaT(coordenada, estado);
                break;
            default:
                tempFicha = null;
                jsonObjBuilder.add("error", "No ha ingresado un nombre de ficha valido");
                metodo = "";
                break;
        }
        switch (metodo) {
            case "rotarDerecha":
                tempFicha.rotarDerecha();
                jsonObjBuilder.add("forma", tempFicha.obtenerForma());
                break;
            case "rotarIzquierda":
                tempFicha.rotarIzquierda();
                jsonObjBuilder.add("estado", tempFicha.obtenerForma());
                break;
            case "desplazarIzquierda":
                tempFicha.desplazarIzquierda();
                jsonObjBuilder.add("ubicacion", tempFicha.obtenerUbicación().toString());
                break;
            case "desplazarDerecha":
                tempFicha.desplazarDerecha();
                jsonObjBuilder.add("ubicacion", tempFicha.obtenerUbicación().toString());
                break;
            case "obtenerEstado":
                jsonObjBuilder.add("estado", "" + tempFicha.obtenerForma());
                break;
            case "obtenerUbicacion":
                jsonObjBuilder.add("ubicacion", tempFicha.obtenerUbicación().toString());
                break;
            case "caer":
                tempFicha.caer(filaI, filaF);
                jsonObjBuilder.add("ubicacion", tempFicha.obtenerUbicación().toString());
                break;
            case "":
                break;
            default:
                jsonObjBuilder.add("error", "No ha ingresado un metodo de ficha valido");
                break;
        }
        JsonObject jsonObj = jsonObjBuilder.build();
        return Response.ok(jsonObj.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Methods", "Content-Type, Accept, X-Request-With").build();
    }
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param asyncResponse, respuesta asincrona
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(@Suspended
    final AsyncResponse asyncResponse, final String content) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                doPutJson(content);
                asyncResponse.resume(javax.ws.rs.core.Response.ok().build());
            }
        });
    }

    private void doPutJson(String content) {
    }
}
