/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controllerandbean;

import id.co.mxc.dao.UserService;
import id.co.mxc.model.User;
import id.co.mxc.util.PasswordDigest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    UserService us;
    
    @RequestMapping()
    public String doLogin(Model model){
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "login";
    }
    
    @RequestMapping(value="/check")
    public String checkLogin(HttpSession session, @ModelAttribute("loginBean") LoginBean loginBean, Model model){
        User user = us.findByUsername(loginBean.getUserName());
        if(user.getUserName()==null){
            model.addAttribute("message", "WRONG USERNAME");
            return "login";
        }
        String encryptedPassword = PasswordDigest.createEncryptedPassword(loginBean.getPassword());
        if(!encryptedPassword.equals(user.getPassword())){
            model.addAttribute("message", "WRONG PASSWORD");
            return "login";
        }
        
        session.setAttribute("user", user);
        return "redirect:/index";
    }
}
