package ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService; 

    @RequestMapping("/ui")
    public String list(Model model){
        Iterable<Product> products = productService.getProducts(); 
        model.addAttribute("products", products);
        return "products";
    }
}