package andrii.controllers;

import andrii.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

/*    @RequestMapping("/admin")
    public String adminPage() {

        System.out.println("ADMIN");
        return "redirect:/main";
    }*/

    @RequestMapping("/login")
    public String loginPage() {

        return "security/login";
    }

    @RequestMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }


        return "redirect:/main";
//        return "redirect:/login?logout";
    }

    @GetMapping("/registrationPage")
    public String registrationPage() {
        return "security/registration";
    }

    @PostMapping("/register")
    public String register(String username, String password) {

        userService.save(username, password);

        return "forward:/autoLogin";
    }

    @RequestMapping("/autoLogin")
    public String autoLogin(HttpServletRequest request, String username, String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/main";
    }

}
