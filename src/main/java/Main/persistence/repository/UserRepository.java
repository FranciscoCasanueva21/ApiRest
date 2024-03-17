package Main.persistence.repository;

import Main.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
   Optional<User> findById(String id);

  public void updateUser(@Param("id") String id);

}
