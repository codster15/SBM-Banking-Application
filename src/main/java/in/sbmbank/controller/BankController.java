package in.sbmbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

    @GetMapping("/home")
    public String loadIndexPage(Model model){

        model.addAttribute("msg" , "Project Under Development . . .");

        return "index";
    }


}
