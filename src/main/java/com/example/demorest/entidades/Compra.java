package com.example.demorest.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("compras")
public class Compra {
    @Id
    private Integer id;
    @Column("id_usuario")
    private Integer idUsuario;
    private String producto;
    private Float precio;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }  
    
    
}
