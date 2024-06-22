package com.harri.padroes_projetos_spring.service;

import com.harri.padroes_projetos_spring.entity.User;

public interface UserService {

    Iterable<User> buscarTodos();
    User buscarPorId(Long id);
    void inserir(User user);
    void atualizar(Long id, User user);
    void deletar(Long id);
}
