package com.reto.carpooling.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UsuarioDTO {


    private Long usuarioId;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String numeroTelefono;

    @NotBlank
    private String direccion;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[*_-])[A-Za-z\\d*_-]{8,15}$",
            message = "La contraseña debe tener entre 8 y 15 caracteres. También debe contener por lo menos: 1 letra en mayúscula, 1 letra en minúscula, " +
                      "1 número y un caracter de los siguientes: *_-")
    private String password;

}
