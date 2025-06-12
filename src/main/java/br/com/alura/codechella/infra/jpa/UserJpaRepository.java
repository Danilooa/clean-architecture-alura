package br.com.alura.codechella.infra.jpa;

import br.com.alura.codechella.infra.jpa.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserModel, Long> {
    
    UserModel findByCpf(String cpf);

}
