package springframework.app.services;

import springframework.app.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO addCustomer(CustomerDTO customerDTO);
}
