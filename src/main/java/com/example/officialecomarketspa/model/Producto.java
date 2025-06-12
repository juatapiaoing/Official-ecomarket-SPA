package com.example.officialecomarketspa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private TipoProducto tipo_producto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> stockList = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<Movimiento> movimientoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orden> ordenes = new ArrayList<>();

    public void addStock(Stock stock){
        stockList.add(stock);
    }

    public void addMovimiento(Movimiento movimiento){
        movimientoList.add(movimiento);
    }

}
