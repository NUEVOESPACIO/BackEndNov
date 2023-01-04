package com.sistema.examenes;

import com.sistema.examenes.security.JWTAuthorizationFilter;
import com.sistema.examenes.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {
    
        @Autowired
        private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario=new Usuario();
        usuario.setNombre("Cristian");
        usuario.setApellido("Ramirez");
        usuario.setUsername("Christian");
        usuario.setPassword("12345");
        usuario.setEmail("c1a@gmail.com");
        usuario.setTelefono("9328434");
        usuario.setPerfil("foto.png");        
        Rol rol = new Rol();
        rol.setRolId(1L);
        rol.setNombre("ADMIN");        
        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        UsuarioRol usuarioRol=new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);        
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
        System.out.println(usuarioGuardado.getUsername());*/        
    }
    
        @EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
                                .antMatchers(HttpMethod.GET, "/tipoempleos/listar").permitAll()
                                .antMatchers(HttpMethod.GET, "/*/*").permitAll()
				.anyRequest().authenticated();
		}
	}
    

}

