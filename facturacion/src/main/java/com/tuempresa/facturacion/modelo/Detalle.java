package com.tuempresa.facturacion.modelo;

import lombok.*;
import javax.persistence.*;

@Embeddable
@Getter @Setter
public class Detalle {

    int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;
}
