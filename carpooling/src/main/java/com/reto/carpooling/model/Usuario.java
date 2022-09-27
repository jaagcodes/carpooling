package com.reto.carpooling.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email_unico",
                columnNames = "email"
        )
)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 2569408622064713625L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private String nombre;

    private String apellido;

    private String numeroTelefono;

    private String direccion;

    private String email;

    private String password;

}
