package com.example.springmvcdemo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home method called");
        return "index";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv) {
        // this also works cause parameters and the variable names in the url matches


        int result = num + num2;
        mv.addObject("result", result);
        mv.setViewName("result");//for result page


        return mv;
    }


    @RequestMapping("/addAlien")
    public String addAlien(@ModelAttribute Alien alien) { // model attribute is optional but name must be the same in the result page
        // this also works cause parameters and the variable names in the url matches
        System.out.println("add alien called");

        return "result";
    }




/*    @RequestMapping("/add")
this is servlet way of doing things
we pass the result variable with ${result} this in html file or <%= session.getAttribute("result") %>
after that we replaced session with Model, using model.addAttribute() method

after that we look into, frontend files
what if we want to change frontend technology afterwards
do we need to change all of the .jsp file extensions in string
no of course we will configure this in app properties folder



prefix: view folder
suffix: jsp

    public String add(HttpServletRequest req, HttpSession session){

        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1+num2;


        session.setAttribute("result",result);
        System.out.println(result);
        System.out.println("in add");
        return "result.jsp";
    }*/


    /*    @RequestMapping("addAlien")
    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
        Alien alien=new Alien();
        alien.setAid(aid);
        alien.setAname(aname);
        mv.addObject("alien",alien);
        mv.setViewName("result");

        return mv;
    }
    after doing above works we replace the usage of parameters
from one variable at a time to whole Object

We did this with the help of spring boot now we will do it with only spring
    */

}
