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
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

//    @GetMapping("/list")
//    public List<UserEntity> allUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity getAllUsers() {
//
//        try {
//               return ResponseEntity.ok("All users: \n" + );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("An error has occurred!");
//        }
//    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("The user is completely added.");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id) + " user has been deleted"); //I will probably correct it for the modern option
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserEntity user,
                                     @RequestParam Long familyId) {
        try {
            return ResponseEntity.ok(userService.createUser(user, familyId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

//    @PutMapping("/createUser")
//    public ResponseEntity updateUser(@RequestParam Long familyId) {
//        try {
//
//        } catch (Exception e) {
//
//        }
//    }

}
