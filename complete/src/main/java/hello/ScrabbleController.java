package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScrabbleController {

    @RequestMapping("/getScore")
    public Scrabble getScore(@RequestParam(value="word") String word) {
        return new Scrabble(word);
    }
}
