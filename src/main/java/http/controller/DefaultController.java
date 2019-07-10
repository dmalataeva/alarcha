package http.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("")
    public String defaultOrder() {
        return "Default endpoint; service working!";
    }
}
