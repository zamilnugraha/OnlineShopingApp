/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controllerandbean;

import id.co.mxc.dao.UserService;
import id.co.mxc.model.User;
import id.co.mxc.util.PasswordDigest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("registration")
public class RegistrationController {
    
    @Autowired
    UserService us;
    
    @RequestMapping()
    public String register(Model model){
        RegistrationBean registerBean = new RegistrationBean();
        model.addAttribute("registerBean", registerBean);
        return "registration";
    }
    
    @RequestMapping(value="/save")
    public String saveRegistration(@ModelAttribute("registerBean") RegistrationBean registerBean, Model model){
        User user = new User();
        String encryptedPass = PasswordDigest.createEncryptedPassword(registerBean.getPassword());        
        
        user.setFullName(registerBean.getFullName());
        user.setEmail(registerBean.getEmail());
        user.setPhoneNumber(registerBean.getPhoneNumber());
        user.setUserName(registerBean.getUserName());
        user.setPassword(encryptedPass);
        
        
    
        User usercheck = us.findByUsername(registerBean.getUserName());
        
        if(usercheck.getUserName()==null){
            if(!registerBean.getPassword().equals(registerBean.getPasswordVerification())){
            model.addAttribute("message", "Password verification is incorrect.");
            }
            else if(registerBean.getPassword().equals(registerBean.getPasswordVerification())){
            us.saveUser(user);
            model.addAttribute("data", registerBean);
            return "successregistration";
            }
        }else if(usercheck.getUserName()!=null){
            model.addAttribute("message", "Username already taken.");
        }
        return"registration";
    }
    
    @RequestMapping(value="/edit")
    public String toEdit(Model model){
        RegistrationBean registerBean = new RegistrationBean();
        model.addAttribute("registerBean",registerBean);
        return "editprofile";
    }
    
    @RequestMapping(value="/profile")
    public String checkProfile(){
        return "profile";
    }
    
    @RequestMapping(value="/edit/save")
    public String editUser(HttpSession session, RegistrationBean registerBean, Model model){
        User user = (User) session.getAttribute("user");
        String encryptedPass = PasswordDigest.createEncryptedPassword(registerBean.getPassword());
        String verifEncrypt = PasswordDigest.createEncryptedPassword(registerBean.getPasswordVerification());
            user.setFullName(registerBean.getFullName());            
            user.setEmail(registerBean.getFullName());
            user.setPhoneNumber(registerBean.getEmail());
            user.setUserName(user.getUserName());
        
        if(verifEncrypt.equals(user.getPassword())){ 
            user.setPassword(encryptedPass);
            us.editUser(user);        
            return "successeditting";
        }else{
            RegistrationBean registerBeani = new RegistrationBean();
            model.addAttribute("message","You need to correctly insert your old password to edit the profile.");
            model.addAttribute("registerBean",registerBeani);
        }
            return "editprofile";        
    }
}
