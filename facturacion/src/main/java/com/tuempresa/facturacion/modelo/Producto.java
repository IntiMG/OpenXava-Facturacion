package com.tuempresa.facturacion.modelo;

import lombok.*;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Producto {
    @Id
    @Column(length = 9)
    int numero;

    @Column(length = 50) @Required
    String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    Categoria categoria;

    @Money
    BigDecimal precio;

    @Files
    @Column(length = 32)
    String fotos;

    @TextArea
    String observaciones;
}
