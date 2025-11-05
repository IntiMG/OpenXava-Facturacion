package com.tuempresa.facturacion.modelo;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Getter @Setter
@View(name = "Simple", members = "id, nombre")
public class Cliente {
    @Id
    @Column(length = 6)
    int id;

    @Column(length = 50) @Required
    String nombre;

    @Embedded
    Direccion direccion;
}
