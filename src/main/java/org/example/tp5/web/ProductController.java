package org.example.tp5.web;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.tp5.entities.Product;
import org.example.tp5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/user/index")
    @PreAuthorize("hasRole('USER')")
    public String index(Model model) {
       List <Product> products= productRepository.findAll();
       model.addAttribute("productList", products);
       return "products";
    }

    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/user/index";
    }

    @PostMapping ("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct";
    }
    @PostMapping("/admin/saveProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newProduct";
        }
        productRepository.save(product);
        return "redirect:/admin/newProduct";

    }
    @GetMapping("/notAuthorized")
    public  String notAuthorized(){
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login(){
        return "login";

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";

    }
}
