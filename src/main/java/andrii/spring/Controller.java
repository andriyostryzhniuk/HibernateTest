package andrii.spring;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/main")
    public String printMainPage() {
        return "mainPage";
    }
}
