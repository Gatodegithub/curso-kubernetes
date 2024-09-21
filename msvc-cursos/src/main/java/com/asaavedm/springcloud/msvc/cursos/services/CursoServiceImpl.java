package com.asaavedm.springcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asaavedm.springcloud.msvc.cursos.clients.UsuarioClientRest;
import com.asaavedm.springcloud.msvc.cursos.models.Usuario;
import com.asaavedm.springcloud.msvc.cursos.models.entity.Curso;
import com.asaavedm.springcloud.msvc.cursos.repositories.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService {

  private final CursoRepository repository;

  private final UsuarioClientRest client;

  public CursoServiceImpl(CursoRepository repository, UsuarioClientRest client) {
      this.repository = repository;
      this.client = client;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Curso> listar() {
    return (List<Curso>) repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Curso> porId(Long id) {
    return repository.findById(id);
  }

  @Override
  @Transactional
  public Curso guardar(Curso curso) {
    return repository.save(curso);
  }

  @Override
  @Transactional()
  public void eliminar(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId) {
    throw new UnsupportedOperationException("Unimplemented method 'asignarUsuario'");
  }

  @Override
  public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {
    throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
  }

  @Override
  public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId) {
    throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
  }
  
}
