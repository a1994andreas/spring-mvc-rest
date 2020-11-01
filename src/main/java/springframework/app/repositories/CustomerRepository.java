package springframework.app.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.app.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
