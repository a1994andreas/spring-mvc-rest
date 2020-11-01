package springframework.app.bootstrap;

import springframework.app.domain.Category;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springframework.app.domain.Customer;
import springframework.app.repositories.CategoryRepository;
import springframework.app.repositories.CustomerRepository;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository,CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initCategories();
        initCustomers();
    }


    public void initCategories()  {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );
    }

    public void initCustomers(){
        Customer customer1 = new Customer();
        customer1.setFirstName("Andreas");
        customer1.setLastName("paravoliasis");

        Customer customer2 = new Customer();
        customer2.setFirstName("John");
        customer2.setLastName("JOHN_LASTNAME");

        Customer customer3 = new Customer();
        customer3.setFirstName("Nick");
        customer3.setLastName("NICK_LASTNAME");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

    }
}
