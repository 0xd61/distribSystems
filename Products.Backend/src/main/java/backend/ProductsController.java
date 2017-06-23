package backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	@Autowired
    ProductRepository productRepository;
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> products()
	{    	
    	List<Product> list = productRepository.findAll(); 
    	return list;
    }
}