package com.harri.padroes_projetos_spring.service.impl;

import com.harri.padroes_projetos_spring.entity.Endereco;
import com.harri.padroes_projetos_spring.entity.User;
import com.harri.padroes_projetos_spring.repository.EnderecoRepository;
import com.harri.padroes_projetos_spring.repository.UserRepository;
import com.harri.padroes_projetos_spring.service.UserService;
import com.harri.padroes_projetos_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User buscarPorId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void inserir(User user) {
        salvarUserComCep(user);
    }

    @Override
    public void atualizar(Long id, User user) {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isPresent()){
            salvarUserComCep(user);
        }
    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    private void salvarUserComCep(User user) {
        String cep = user.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        user.setEndereco(endereco);
        userRepository.save(user);
    }
}
