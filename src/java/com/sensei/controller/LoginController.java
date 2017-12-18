package com.sensei.controller;

import com.sensei.model.User;
import com.sensei.service.UserService;
import com.sensei.utils.PasswordDigest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    UserService us;
    
    @RequestMapping()
    public String toLogin(Model model){
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "login";
    }
    
    @RequestMapping(value = "/check")
    public String checkLogin(HttpSession session, @ModelAttribute("loginBean") LoginBean loginBean, Model model){
        User user = us.findByUsername(loginBean.getUsername());
        if(user.getUsername() == null){
            model.addAttribute("message", "Username Salah..!");
            return "login";
        }
        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if(!encryptedPassword.equals(user.getPassword())){
            model.addAttribute("message", "Password Salah..!");
            return "login";
        }
        session.setAttribute("user", user);
        return "redirect:/index";
    }
    
}
