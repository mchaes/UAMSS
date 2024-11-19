package com.example.demorest.contorladores;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorest.daos.CompraDAO;
import com.example.demorest.daos.UsuarioDAO;
import com.example.demorest.dtos.UsuarioDTO;
import com.example.demorest.entidades.Usuario;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioREST {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    CompraDAO compraDAO;

    Log log = LogFactory.getLog(UsuarioREST.class);
    //ruta http://localhost:8080/usuarios/1?cadena=hola&numero=3
    @GetMapping("/usuarios/{id}")
    public ResponseEntity <Usuario> obtenUsuario (@PathVariable("id") Integer idUsuario, String cadena, Integer numero){
        
        log.info("Buscando usuario con id:"+ idUsuario);
        log.info("cadena" +cadena+ ", nuemro"+numero);
        Usuario usuario = usuarioDAO.findById(idUsuario).get();
        //return new ResponseEntity<>(usuario, HttpStatus.OK);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){

        log.info("creando nuevo usuario con informacion:"+ usuario);

        Usuario usuarioACrear = new Usuario();
        usuarioACrear.setNombre(usuario.getNombre());
        usuarioACrear.setEmail(usuario.getEmail());
        usuarioACrear.setPassword(usuario.getPassword());
        Usuario usuarioNuevo = usuarioDAO.save(usuarioACrear);
        return ResponseEntity.ok(usuarioNuevo);
    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<Usuario>actualizarUsuario(@PathVariable("id") Integer id, UsuarioDTO infoUsuario){
        Optional<Usuario> usuario = usuarioDAO.findById(id);
        if(usuario.isPresent()){
            Usuario usuarioAActualizar = usuario.get();
            usuarioAActualizar.setNombre(infoUsuario.getNombre());
            usuarioAActualizar.setEmail(infoUsuario.getEmail());
            usuarioAActualizar.setPassword(infoUsuario.getPassword());
            usuarioAActualizar=usuarioDAO.save(usuarioAActualizar);
            return ResponseEntity.ok(usuarioAActualizar);
        }else{
            return ResponseEntity.of(usuario);
        }
    }

    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<Map<String,String>>borrarUsuario(@PathVariable("id") Integer id){
        compraDAO.borrarPorIdUsuario(id);
        usuarioDAO.deleteById(id);
        Map<String,String> respuesta = Collections.singletonMap("respuesta", "usuarioeliminado");
        return ResponseEntity.ok(respuesta);
    }
}
