package com.ec.cluv.academy.model.response;

import com.ec.cluv.academy.model.enums.EnumMessages;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ResponseGenerico class
 *
 * @version $Revision: 1 $
 */
@Data
@AllArgsConstructor
public class ResponseGenerico<T> implements Serializable {

    private String codigoRespuestaName;
    private int codigoRespuestaValue;
    private String mensaje;
    private T objeto;
    private List<T> listado;
    private Long totalRegistros;

    public ResponseGenerico() {
    }

    public ResponseGenerico responseGenerico(String statusName, int statusValue, String error){
        ResponseGenerico<?> response = new ResponseGenerico<>();
        response.setCodigoRespuestaName(statusName);
        response.setCodigoRespuestaValue(statusValue);
        response.setMensaje(EnumMessages.INGRESO_FALLIDO.name() + ":" + error);

        return response;
    }
}
