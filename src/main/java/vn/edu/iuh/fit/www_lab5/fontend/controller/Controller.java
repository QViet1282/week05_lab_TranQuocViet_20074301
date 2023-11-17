package vn.edu.iuh.fit.www_lab5.fontend.controller;
@org.springframework.stereotype.Controller
public class Controller {
    @org.springframework.web.bind.annotation.GetMapping("/")
    public String index() {
        return "index";
    }
    @org.springframework.web.bind.annotation.GetMapping("/about")
    public String about() {
        return "about";
    }


}
