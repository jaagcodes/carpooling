package com.reto.carpooling.service.impl;

import com.reto.carpooling.dto.UsuarioDTO;
import com.reto.carpooling.exception.ModelNotFoundException;
import com.reto.carpooling.exception.UserAlreadyExistsException;
import com.reto.carpooling.factory.FactoryUsuarioDataTest;
import com.reto.carpooling.model.Usuario;
import com.reto.carpooling.repository.IUsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class UsuarioServiceImplTest {

    @InjectMocks
    UsuarioServiceImpl usuarioService;

    @Mock
    IUsuarioRepository usuarioRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void encontrarUsuarioPorEmail() {
    }

    @Test
    void debeGuardarUsuario() throws Exception {

        Usuario usuarioEsperado = FactoryUsuarioDataTest.getUsuario();

        //Given: Yo como usuario hago la solicitud de guardar un Usuario
        UsuarioDTO usuarioDTO = FactoryUsuarioDataTest.getUsuarioDTO();

        //When: Le envío los valores correctamente
        when(usuarioRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(modelMapper.map(usuarioDTO,Usuario.class)).thenReturn(usuarioEsperado);
        usuarioService.guardarUsuario(usuarioDTO);

        //Then: El sistema guarda un usuario en base de Datos
        verify(usuarioRepository).save(any(Usuario.class));
    }

    @Test
    void userAlreadyExistsExceptionCuandoTratamosDeGuardarUsuario(){

        //Given
        Usuario usuarioEsperado = FactoryUsuarioDataTest.getUsuario();
        UsuarioDTO usuarioDTO = FactoryUsuarioDataTest.getUsuarioDTO();

        //When
        when(usuarioRepository.findByEmail(any())).thenReturn(Optional.of(usuarioEsperado));

        //Then
        Assertions.assertThrows(
                UserAlreadyExistsException.class,
                () -> {
                    usuarioService.guardarUsuario(usuarioDTO);
                }
        );
    }

    @Test
    void modelNotFoundExceptionCuandoBuscamosUnUsuarioQueNoExiste(){

        //Given
        Usuario usuarioEsperado = FactoryUsuarioDataTest.getUsuario();
        UsuarioDTO usuarioDTO = FactoryUsuarioDataTest.getUsuarioDTO();

        //When
        when(usuarioRepository.findByEmail(any())).thenReturn(Optional.empty());

        //Then
        Assertions.assertThrows(
                ModelNotFoundException.class,
                () -> {
                    usuarioService.encontrarUsuarioPorEmail(usuarioDTO.getEmail());
                }
        );
    }

}













