package com.harri.padroes_projetos_spring.repository;

import com.harri.padroes_projetos_spring.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
