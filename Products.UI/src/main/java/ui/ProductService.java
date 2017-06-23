package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@Component
public class ProductService {
	
    private final OAuth2RestTemplate template; 
    
    @Autowired
    public ProductService(OAuth2RestTemplate template) {
        this.template = template;
    }

    @HystrixCommand(fallbackMethod = "fallbackProducts",
            commandProperties = {  
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            })
	public List<Product> getProducts() {
        ResponseEntity<Product[]> products = template.getForEntity("http://localhost:8080/products", Product[].class);
        return Arrays.asList(products.getBody());
	}
    
    public List<Product> fallbackProducts() {
    	List<Product> empty = new ArrayList<Product>();
        return empty;
    }
}
