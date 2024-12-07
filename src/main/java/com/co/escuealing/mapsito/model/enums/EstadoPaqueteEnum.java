package com.co.escuealing.mapsito.model.enums;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
public enum EstadoPaqueteEnum {
    PENDIENTE,
    EN_PROCESO,
    ENVIADO,
    ENTREGADO;

    public EstadoPaqueteEnum next() {
        switch (this) {
            case PENDIENTE:
                return EN_PROCESO;
            case EN_PROCESO:
                return ENVIADO;
            case ENVIADO:
                return ENTREGADO;
            default:
                throw new IllegalStateException("No hay estados siguientes disponibles para: " + this);
        }
    }
}
