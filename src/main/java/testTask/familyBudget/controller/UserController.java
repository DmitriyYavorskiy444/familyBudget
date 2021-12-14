package testTask.familyBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.UserAlreadyExistException;
import testTask.familyBudget.exception.UserNotFoundException;
import testTask.familyBudget.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id)); //I will probably correct it for the modern option
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

//    @GetMapping
//    public ResponseEntity getUsers() {
//        try {
////            userService.findAll();
//            return ResponseEntity.ok("The server is running..."); //I will probably correct it for the modern option
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("An error has occurred!");
//        }
//    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("The user is completely added."); //I will probably correct it for the modern option
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }
}
