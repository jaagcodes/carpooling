package com.reto.carpooling.service;

import com.reto.carpooling.dto.UsuarioDTO;
import com.reto.carpooling.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public UsuarioDTO encontrarUsuarioPorEmail(String email) throws Exception;

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) throws Exception;


}
