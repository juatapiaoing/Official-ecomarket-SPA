package com.example.officialecomarketspa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.asm.IRelationship;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dactura")
    private int id;

    @Column(nullable = false)
    private Date fechaEmision;

    @Column(nullable = false)
    private BigDecimal total_pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", referencedColumnName = "orden_id", nullable = false)
    private Orden orden;

    @PrePersist
    public void prePersist() {
        fechaEmision = new Date();
    }


}
