package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //localhost:8080/hello
    public String hello(Model model){
        model.addAttribute("data", "hello!!!"); //model(data: hello)
        return "hello"; //template/hello.html(템플릿 엔진)
    }

    //mvc 템플릿 엔진
    @GetMapping("hello-mvc") //localhost:8080/hello-mvc
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //model(name: name)
        return "hello-template"; //template/hello-template.html
    }

    //api
    @GetMapping("hello-string")
    @ResponseBody //응답 http의 body에 직접 넣어 주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
    //localhost:8080?hello-string?name=spring
    //return: hello(name:spring)

    //객체를 반환하는 컨트롤러
    //localhost:8080/hello-api?name=spring
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환하면 객체가 json으로 변환됨
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
