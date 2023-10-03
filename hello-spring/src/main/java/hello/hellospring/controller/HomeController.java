package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//controller가 static보다 우선순위가 높아서 컨트롤러가 실행되는 거임
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
