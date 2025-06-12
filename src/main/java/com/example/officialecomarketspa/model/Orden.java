package com.example.officialecomarketspa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private int id;

    @Column
    private Date fecha_creacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadeOrden estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "orden",  cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Factura factura;

    @PrePersist
    protected void prePersist() {
        fecha_creacion = new Date();
    }

}
