package Main.controller;

import Main.dto.UserDto;
import Main.persistence.entity.User;
import Main.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return this.userService.create(userDto);
    }

    @GetMapping
    public List<User> findAllUser(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(String id){
        return this.userService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") String id) {
        this.userService.updateById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") String id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
