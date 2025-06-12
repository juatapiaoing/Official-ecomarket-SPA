package com.example.officialecomarketspa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private int id_movimiento;

    @Column
    private Date fecha;

    @Column(nullable = false)
    private String tipo_movimiento;

    @Column(nullable = false)
    private int cantidad;

    @Column(unique = false, nullable = false)
    private String proveedor;

    @Column(unique = false, nullable = false)
    private String ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stock")
    private Stock stock;


    @PrePersist
    protected void prePersist() {
        fecha = new Date();
    }
}
