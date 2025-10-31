package com.tuempresa.facturacion.modelo;

import lombok.*;
import javax.persistence.*;

@Embeddable
@Getter @Setter
public class Direccion {

    @Column(length = 30)
    private String viaPublica;

    @Column(length = 5)
    private int codigoPostal;

    @Column(length = 20)
    String municipio;

    @Column(length = 30)
    String provincia;
}
