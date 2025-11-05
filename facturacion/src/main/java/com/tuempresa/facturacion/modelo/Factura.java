package com.tuempresa.facturacion.modelo;

import com.tuempresa.facturacion.calculadores.CalcularSiguienteNumeroParaAnyo;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter @Setter
@View(members = "anyo, numero, fecha;" + // Separados por coma significa en la misma línea
        "cliente;" + // Punto y coma significa nueva línea
        "detalles;" +
        "observaciones"
)
public class Factura {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Generar año actual
    int anyo;

    @Column(length = 6)
    @DefaultValueCalculator(value = CalcularSiguienteNumeroParaAnyo.class,
                            properties = @PropertyValue(name = "anyo")
    )
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Generar fecha actual
    LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;

    @TextArea
    String observaciones;

}
