package com.reto.carpooling.controller;

import com.reto.carpooling.dto.UsuarioDTO;
import com.reto.carpooling.model.Usuario;
import com.reto.carpooling.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {


    private final IUsuarioService usuarioService;

    private final ModelMapper modelMapper;

    @PostMapping(value="/registrarUsuario",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        UsuarioDTO usuarioRespuestaDTO = usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioRespuestaDTO);
    }

    @GetMapping(value="/encontrarUsuario/{email}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> encontrarUsuarioPorSuEmail(@PathVariable("email") String email) throws Exception {
        UsuarioDTO usuarioRespuestaDTO = usuarioService.encontrarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuarioRespuestaDTO);
    }

}
