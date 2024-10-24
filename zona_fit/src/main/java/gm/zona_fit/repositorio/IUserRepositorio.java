package gm.zona_fit.repositorio;

import gm.zona_fit.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepositorio  extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM \"user\" WHERE email = :email", nativeQuery = true)
    Optional<User> finByEmail(String email);
}
