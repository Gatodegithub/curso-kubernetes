package com.asaavedm.springcloud.msvc.cursos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.asaavedm.springcloud.msvc.cursos.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
  
}
