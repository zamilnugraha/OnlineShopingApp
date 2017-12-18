/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controllerandbean;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    @RequestMapping() 
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        return "redirect:/index";
    }
}
