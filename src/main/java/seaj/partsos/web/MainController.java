package seaj.partsos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Login page
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    // Front page
    @GetMapping("/index")
    public String index() {
        return "index"; // index.html
    }

    // // Error page
    // @GetMapping("/error")
    // public String error() {
    // return "error"; // error.html
    // }

}
