package testTask.familyBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testTask.familyBudget.entity.FamilyEntity;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.UserAlreadyExistException;
import testTask.familyBudget.exception.UserNotFoundException;
import testTask.familyBudget.service.FamilyService;

@RestController
@RequestMapping("/api/v1/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @GetMapping
    public ResponseEntity getOneFamily(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(familyService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody FamilyEntity family) {
        try {
            familyService.registration(family);
            return ResponseEntity.ok("The family is completely added.");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFamily(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(familyService.delete(id) + " family has been deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred!");
        }
    }

}
