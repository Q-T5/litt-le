package npc.martin.little.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping("/api/messages")
public class LittleController {
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Running VueJS in Spring Boot";
    }
}
