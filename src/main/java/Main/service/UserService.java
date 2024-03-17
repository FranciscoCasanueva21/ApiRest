package Main.service;

import Main.dto.UserDto;
import Main.exceptions.Exception;
import Main.mapper.MapperImp;
import Main.persistence.entity.User;
import Main.persistence.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MapperImp mapperImp;

    public UserService(UserRepository userRepository, MapperImp mapperImp) {
        this.userRepository = userRepository;
        this.mapperImp = mapperImp;
    }

    public User create(UserDto userDto){
        User user = mapperImp.map(userDto);
        this.userRepository.save(user);
        return user;
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public Optional<User> findById(String id){
        if(id.isEmpty()){
            throw new Exception("ID empty", HttpStatus.NO_CONTENT);
        }
        return this.userRepository.findById(id);
    }

    public void updateById(String id){
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new Exception("User not found", HttpStatus.NOT_FOUND);
        }
        this.userRepository.updateUser(id);
    }

    public void deleteById(String id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new Exception("User not found", HttpStatus.NOT_FOUND);
        }
        this.userRepository.deleteById(id);
    }

}
