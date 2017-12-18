package id.co.mxc.controllerandbean;


import id.co.mxc.dao.ProductDao;
import id.co.mxc.model.Product;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    ProductDao productDao;
    
    @RequestMapping("")
    public String goToHome(Model model){
        List<Product> products = productDao.findAllProduct();
        model.addAttribute("products",products);
            return "index";
    }
}
