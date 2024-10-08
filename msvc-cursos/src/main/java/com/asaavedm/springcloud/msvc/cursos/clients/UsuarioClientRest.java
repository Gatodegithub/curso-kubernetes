package com.asaavedm.springcloud.msvc.cursos.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.asaavedm.springcloud.msvc.cursos.models.Usuario;

@FeignClient(name="msvc-usuarios", url="${msvc.usuarios.url}")
public interface UsuarioClientRest {

  @GetMapping("/{id}")
  Usuario detalle(@PathVariable Long id); 

  @PostMapping("/")
  Usuario crear(@RequestBody Usuario usuario);

  @GetMapping("/usuarios-por-curso")
  List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
