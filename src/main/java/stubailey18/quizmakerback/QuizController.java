package stubailey18.quizmakerback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins = "https://stubailey18.com")
public class QuizController {

    @Autowired
    private QuizRepo repo;
    
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable long id) throws Exception {
        Optional<Quiz> quiz = repo.findById(id);
        if (quiz.isPresent()) {
            return ResponseEntity.ok(quiz.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return repo.save(quiz);
    }

    @PutMapping("/{id}")
    public void updateQuiz(@PathVariable long id, @RequestBody Quiz quiz) {
        quiz.setId(id);
        repo.save(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable long id) {
        repo.deleteById(id);
    }
}
