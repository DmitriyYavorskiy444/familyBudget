package testTask.familyBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("The server is running..."); //I will probably correct it for the modern option
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            if(userRepository.findByUserName(user.getUserName()) != null){
                return ResponseEntity.badRequest().body("The user with the same name already exists. Please change a name.");
            }
            userRepository.save(user);
            return ResponseEntity.ok("The user is completely added."); //I will probably correct it for the modern option
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }
}
