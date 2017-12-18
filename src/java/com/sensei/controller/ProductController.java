package com.sensei.controller;

import com.sensei.DAO.ProductDAO;
import com.sensei.model.Product;
import com.sensei.model.User;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductDAO productDAO;
    int tampung;

    @RequestMapping("/{id}")
    public String getProductById(@PathVariable Integer id, Model model) {
        Product product = productDAO.findProductById(id);
        model.addAttribute("product", product);
        return "detailproduct";
    }

    @RequestMapping("/all")
    public String allProduct(Model model) {
        List<Product> products = productDAO.findAllProduct();
        model.addAttribute("products", products);
        return "category";
    }

    @RequestMapping("/categories/{size}")
    public String getProductBySize(@PathVariable String size, Model model) {
        List<Product> products = productDAO.findProductBySize(size);
        model.addAttribute("products", products);
        return "category";
    }

    @RequestMapping("/orderDetail")
    public String toOrderDetail() {
        return "orderdetail";
    }

    @RequestMapping("/checkout")
    public String checkOut(HttpSession session) {
        String harga = session.getAttribute("hargaTotal").toString();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.setAttribute("harga", "Silahkan login terlebih dahulu..!");
        } else {
            session.setAttribute("iterator", 0);
            session.removeAttribute("OrderDetailBean");
            session.setAttribute("harga", harga);
        }
        return "checkout";
    }

    @RequestMapping("/remove/{key}")
    public String removeOrderDetail(HttpSession session, @PathVariable Integer key, Model model) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        int hargaTotal = 0;
        String hargaTotals;
        int iterator;
        OrderDetailBean orderDetailBean = (OrderDetailBean) session.getAttribute("orderDetailBean");
        orderDetailBean.getOrderList().remove(key);

        Map<Integer, Product> products = orderDetailBean.getOrderList();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            hargaTotal += entry.getValue().getHarga();
        }
        iterator = orderDetailBean.getOrderList().size();
        hargaTotals = df.format(hargaTotal);
        session.setAttribute("iterator", iterator);
        session.setAttribute("hargaTotal", hargaTotals);

        return "orderdetail";
    }

    @RequestMapping("/addOrderDetail/{id}")
    public String addCart(HttpSession session, @PathVariable Integer id, Model model) {
        Product product = productDAO.findProductById(id);
        int iterator;
        DecimalFormat df = new DecimalFormat("###,###.##");
        double hargaTotals = 0;

        OrderDetailBean orderDetailBean = (OrderDetailBean) session.getAttribute("orderDetailBean");
        if (orderDetailBean == null) {
            orderDetailBean = new OrderDetailBean();
        }
        tampung++;
        orderDetailBean.getOrderList().put(tampung, product);
        iterator = orderDetailBean.getOrderList().size();

        Map<Integer, Product> products = orderDetailBean.getOrderList();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            hargaTotals += entry.getValue().getHarga();
        }

        String hargaTotal = df.format(hargaTotals);

        session.setAttribute("hargaTotal", hargaTotal);
        session.setAttribute("iterator", iterator);
        session.setAttribute("orderDetailBean", orderDetailBean);
        return "redirect:/product/all";

    }
}
