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
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    UserService us;
    
    @RequestMapping
    public String registerUser(Model model){
       RegistrationBean registerBean = new RegistrationBean();
       model.addAttribute("registerBean", registerBean);
       return "register";
    }
    
    @RequestMapping(value = "/save")
    public String saveRegistration(@ModelAttribute("registerBean") RegistrationBean registerBean, Model model){
        User user = new User();
        String encyptedPassword = PasswordDigest.createEncryptedPassword(registerBean.getPassword());
        
        user.setFullname(registerBean.getFullname());
        user.setAlamat(registerBean.getAlamat());
        user.setEmail(registerBean.getEmail());
        user.setNoHp(registerBean.getNoHp());
        user.setUsername(registerBean.getUsername());
        user.setPassword(registerBean.getPassword());
        
        User checkUser = us.findByUsername(registerBean.getUsername());
        
        if(checkUser.getUsername() == null){
            if(!registerBean.getPassword().equals(registerBean.getVerifyPassword())){
                model.addAttribute("message", "Password tersedia..!");
            }else if(registerBean.getPassword().equals(registerBean.getVerifyPassword())){
                us.saveUser(user);
                model.addAttribute("data", registerBean);
                return "successregistration";
            }
        }else if(checkUser.getUsername() != null){
            model.addAttribute("message", "Username tersedia..!");
        }
        return "editprofile";
    }
    
    @RequestMapping(value = "/edit")
    public String toEdit(Model model){
        RegistrationBean registerBean = new RegistrationBean();
        model.addAttribute("registerBean", registerBean);
        return "editprofile";
    }
    
    @RequestMapping(value = "/profile")
    public String checkProfile(){
        return "profile";
    }
    
    public String editUser(HttpSession session, RegistrationBean registerBean, Model model){
        User user = (User) session.getAttribute("user");
        String encyptedPassword = PasswordDigest.createEncryptedPassword(registerBean.getPassword());
        String verifyPassword = PasswordDigest.createEncryptedPassword(registerBean.getVerifyPassword());
            user.setFullname(registerBean.getFullname());
            user.setAlamat(registerBean.getAlamat());
            user.setEmail(registerBean.getEmail());
            user.setNoHp(registerBean.getNoHp());
            user.setUsername(user.getUsername());
        if(verifyPassword.equals(user.getPassword())){
            user.setPassword(encyptedPassword);
            us.editUser(user);
            return "successedit";
        }else{
            RegistrationBean registrationBeans = new RegistrationBean();
            model.addAttribute("message", "Masukkan password lama..!");
            model.addAttribute("registerBean", registrationBeans);
        }
        return "editprofile";
    }
    
}

