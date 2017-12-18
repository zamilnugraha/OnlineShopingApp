/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controllerandbean;

import id.co.mxc.dao.ProductDao;
import id.co.mxc.model.Cart;
import id.co.mxc.model.Product;
import id.co.mxc.model.User;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductDao productDao;
    int pertambahan;
    
    @RequestMapping("/{id}")
    public String getProductById(@PathVariable Integer id, Model model){
        Product product = productDao.findById(id);
        model.addAttribute("product", product);
        return "detailproduct";
    }
    @RequestMapping("/all")
    public String allProduct(Model model){
        List<Product> products = productDao.findAllProduct();
        model.addAttribute("products",products);
        return "category";
    }
    
    @RequestMapping("/categories/{size}")
    public String getProductBySize(@PathVariable String size, Model model){
        List<Product> products = productDao.findBySize(size);
        model.addAttribute("products",products);
        return "category";
    }
    
    @RequestMapping("/cart")
    public String toCart(){
        return "cart";
    }
    
    @RequestMapping("/checkout")
    public String checkOut(HttpSession session){
        String hargaan = session.getAttribute("hargaTotal").toString();
        User user = (User) session.getAttribute("user");
        if(user==null){
        session.setAttribute("hargaan", "You need to log in first in order to process forward.");
        }
        else{
        session.setAttribute("iterator", 0);
        session.removeAttribute("cartBean");
        session.setAttribute("hargaan", hargaan);}
        return "checkout";
    }
    
    @RequestMapping("/remove/{key}")
    public String removeCart(HttpSession session, @PathVariable Integer key, Model model){
        DecimalFormat df = new DecimalFormat("###,###.##");
        int hargaTotal = 0;
        String hargaTotalan;
        int iterator;
        CartBean cartBean = (CartBean) session.getAttribute("cartBean");
        cartBean.getCartList().remove(key);
        
        Map<Integer, Product> products = cartBean.getCartList();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            hargaTotal+= entry.getValue().getProductPrice();
        }
        iterator = cartBean.getCartList().size();
        hargaTotalan = df.format(hargaTotal);
        session.setAttribute("iterator", iterator);
        session.setAttribute("hargaTotal", hargaTotalan);
        
        return "cart";
    }
    
    @RequestMapping("/addCart/{id}")
    public String addCart(HttpSession session, @PathVariable Integer id, Model model){
        Product product = productDao.findById(id);
        int iterator;
        DecimalFormat df = new DecimalFormat("###,###.##");
        double hargaTotal = 0;
        
        CartBean cartBean = (CartBean) session.getAttribute("cartBean"); 
        if(cartBean==null){
            cartBean = new CartBean();
        }
        pertambahan++;
        cartBean.getCartList().put(pertambahan, product);
        iterator = cartBean.getCartList().size();
        
        Map<Integer, Product> products = cartBean.getCartList();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            hargaTotal+= entry.getValue().getProductPrice();
        }
        
        String hargaTotalan = df.format(hargaTotal);
        

        session.setAttribute("hargaTotal", hargaTotalan);
        session.setAttribute("iterator", iterator);
        session.setAttribute("cartBean", cartBean);
        return "redirect:/product/all";

    }
}
