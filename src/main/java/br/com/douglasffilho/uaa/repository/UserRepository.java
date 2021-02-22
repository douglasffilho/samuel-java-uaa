package br.com.douglasffilho.uaa.repository;

import br.com.douglasffilho.uaa.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
