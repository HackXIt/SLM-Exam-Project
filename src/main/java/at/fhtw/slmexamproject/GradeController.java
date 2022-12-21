package at.fhtw.slmexamproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {
    
    @GetMapping("api/mark")
    public ResponseEntity<String> calculateMark(@RequestParam int percentage) {
        if(percentage < 0 || percentage > 100) {
            return new ResponseEntity<>("Percentage must be in range 0-100", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(percentage < 50) {
            return new ResponseEntity<>("5", HttpStatus.OK);
        } else if (percentage < 63) {
            return new ResponseEntity<>("4", HttpStatus.OK);
        } else if (percentage < 75) {
            return new ResponseEntity<>("3", HttpStatus.OK);
        } else if (percentage < 88) {
            return new ResponseEntity<>("2", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("1", HttpStatus.OK);
        }
    }
}
