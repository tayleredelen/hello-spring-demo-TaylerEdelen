package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    //Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Tae");
        names.add("CT");
        names.add("Tegan");
        names.add("Gordon");
        model.addAttribute("names", names);
        return "hello-list";
    }

}



//---------------------COMMENTED OUT MY CODE, ADDED CODE FROM VIDEO---------------------
//package org.launchcode.hellospring.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@ResponseBody
////@RequestMapping("hello")
//public class HelloSpringController {
//
//    //handles request path at /hello
////    @GetMapping("hello")
//////    @ResponseBody
////    public String hello() {
////        return "Hello, Spring!";
////    }
//
//
//    @GetMapping("goodbye") //lives at /hello/goodbye since RequestMapping outstide of class
////    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    //create a handler for requests of form /hello?name=launchcode
////    @GetMapping("hello")
////    @PostMapping("hello")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    //allows both get and post request mapping, adding value tells it that it lives at path hello
////    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        String properGreeting = HelloController.createMessage(name, language);
//        return "<h3 style = 'color: crimson;'>" + properGreeting + "</h3>"; //text is crimson color, and bolder/larger with html tag h3
//    }
//
//    //handler that handles requests of the form /hello/launchcode
//    //now launchcode is part of the path, not a query parameter it's a path parameter
//    @GetMapping("hello/{name}")
////    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) { //pathvariable tells sb that we are looking for the dynamic data
//        return "Hello, " + name + "!";
//    }
//
//
////    @GetMapping("form") //default form method is get
////    public String helloForm() {
////        return "<html>" +
////                "<body>" +
////                "<form action = 'hello' method = 'post'>" + //now when form is rendered a post request will be submitted
////                //specify where form should be submit in opening form tag, tells it submit a request to /hello
////                "<input type = 'text' name = 'name'>" +
////                //name is param identifier used to submit whatever is in form input
////                "<input type = 'submit' value = 'Greet me!'>" +
////                //value is what button will say
////                "</form>" +
////                "</body>" +
////                "</html>";
////    }
//
//    @GetMapping("form")
//    public String helloForm() {
//        return "form";
//    }
//
//    public static String createMessage(String name, String language) {
//        switch(language) {
//            case "Spanish":
//                return "Hola, " + name;
//            case "French":
//                return "Bonjour, " + name;
//            case "Italian":
//                return "Ciao, " + name;
//            case "German":
//                return "Hallo, " + name;
//            case "English":
//            default:
//                return "Hello, " + name; //English is default
//        }
//    }



