package in.sbmbank.controller;

import in.sbmbank.FormBinding.loginFormBinding;
import in.sbmbank.FormBinding.signUpBinding;
import in.sbmbank.Service.serviceInterface.serviceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankController {

    @Autowired
    private serviceInterface serviceInterface;

    @GetMapping("/")
    public String loadIndexPage(Model model) {

        model.addAttribute("showLoginForm", false); // Set it to true or false based on your logic
        model.addAttribute("store", new signUpBinding());
        model.addAttribute("loginBinding", new loginFormBinding());

        return "index";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("store") signUpBinding store, Model model) {
        boolean isRegistered = serviceInterface.SaveAccountHolder(store);
        model.addAttribute("showLoginForm", false); // Set it to true or false based on your logic
        model.addAttribute("store", new signUpBinding());
        model.addAttribute("loginBinding", new loginFormBinding());
        model.addAttribute("success", true);

        return "index";
    }


    @PostMapping("/login")
    public String Login(@ModelAttribute("loginBinding") loginFormBinding loginBinding,
                        HttpSession session, Model model) {

        boolean loginCheck = serviceInterface.LoginAccountHolder(loginBinding);

        if (loginCheck) {


            String username = loginBinding.getUsername();
            String password = loginBinding.getPassword();

            session.setAttribute("username", username);
            session.setAttribute("password", password);

            return "UserAccount";
        }

        model.addAttribute("showLoginForm", false);
        model.addAttribute("store", new signUpBinding());
        model.addAttribute("loginBinding", new loginFormBinding());
        model.addAttribute("failed", true);
        return "index";

    }


    @PostMapping("/deposit")
    public String DepositAmount(Model model,
                                @RequestParam("depositAmount") Integer depositAmount,
                                HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Integer totalAmount = serviceInterface.Deposit(depositAmount, username, password);

        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("deposit", depositAmount);
        model.addAttribute("totalBalance", totalAmount);


        return "UserAccount";
    }

    @GetMapping("/logout")
    public String logout(Model model) {

        model.addAttribute("showLoginForm", false); // Set it to true or false based on your logic
        model.addAttribute("store", new signUpBinding());
        model.addAttribute("loginBinding", new loginFormBinding());

        return "index";
    }

}




