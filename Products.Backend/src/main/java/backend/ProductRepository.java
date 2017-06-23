package backend;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		
		list.add(new Product("Apfel", "Der einheimische Klassiker.", 123.23f));
		list.add(new Product("Banane", "Krumm.", 23.23f));
		list.add(new Product("Kiwi", "Pelzig und lecker.", 29.99f));
		
		return list;
	}
	
}
