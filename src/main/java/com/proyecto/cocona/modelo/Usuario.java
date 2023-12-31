
package com.proyecto.cocona.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Daniela
 */
@Data // se usa dependencia lombok para generar getters y setters y constructor automaticamente
@Entity
@Table(name = "usuarios") // @Table sirve nombrar las tablas en la base de datos diferente a tu clase
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;


    @ToString.Exclude
    @OneToMany(mappedBy = "usuario") //relacion uno a muchos
    private List<Producto> productos;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
    
    public Usuario(){
    
    }

    public Usuario(int id, String nombre, String username, String email, String direccion, String telefono, String tipo, String password) {
        
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
        
        this.productos = productos;
        this.ordenes = ordenes;
    }
}
