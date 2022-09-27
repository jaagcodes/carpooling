package com.reto.carpooling.service.impl;

import com.reto.carpooling.dto.UsuarioDTO;
import com.reto.carpooling.exception.ModelNotFoundException;
import com.reto.carpooling.exception.UserAlreadyExistsException;
import com.reto.carpooling.model.Usuario;
import com.reto.carpooling.repository.IUsuarioRepository;
import com.reto.carpooling.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public UsuarioDTO encontrarUsuarioPorEmail(String email) throws Exception{
       Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()->new ModelNotFoundException("no se encontró algún usuario con el email: "+email));
       return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) throws Exception{

        if(usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario usuarioPersistido = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioPersistido, UsuarioDTO.class);
    }



}
