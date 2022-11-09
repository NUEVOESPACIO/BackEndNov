
package com.sistema.examenes.controladores;

import com.sistema.examenes.entidades.Rol;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

   
    @CrossOrigin(origins={"http://localhost:4200", "https://frontendnov.web.app"})
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        
        usuario.setPerfil("default.png");
        Set<UsuarioRol> roles=new HashSet<>();
        
        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL");
        
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        
        return usuarioService.guardarUsuario(usuario, roles);
    
    }
    
  
   @CrossOrigin(origins={"http://localhost:4200", "https://frontendnov.web.app"})
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        
        return usuarioService.obtenerUsuario(username);
    }
    
   
     @CrossOrigin(origins={"http://localhost:4200", "https://frontendnov.web.app"})
    @DeleteMapping("/{usuarioId}") 
     public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
         
         usuarioService.eliminarUsuario(usuarioId);
         
    
    }
    
     
}
    
    
    
    
