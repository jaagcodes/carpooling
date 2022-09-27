package com.reto.carpooling.factory;

import com.reto.carpooling.dto.UsuarioDTO;
import com.reto.carpooling.model.Usuario;

public class FactoryUsuarioDataTest {

    public static Usuario getUsuario(){
        Usuario usuarioEsperado = new Usuario();
        usuarioEsperado.setUsuarioId(1l);
        usuarioEsperado.setNombre("Cristiano");
        usuarioEsperado.setApellido("Ronaldo");
        usuarioEsperado.setEmail("cr7@email.com");
        usuarioEsperado.setDireccion("Cll 77 Sur");
        usuarioEsperado.setNumeroTelefono("12345678");
        usuarioEsperado.setPassword("Cr7*_-ronaldo");

        return usuarioEsperado;
    }

    public static UsuarioDTO getUsuarioDTO(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Cristiano");
        usuarioDTO.setApellido("Ronaldo");
        usuarioDTO.setEmail("cr7@email.com");
        usuarioDTO.setDireccion("Cll 77 Sur");
        usuarioDTO.setNumeroTelefono("12345678");
        usuarioDTO.setPassword("Cr7*_-ronaldo");

        return usuarioDTO;
    }
}
