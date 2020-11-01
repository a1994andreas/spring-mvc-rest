package springframework.app.services;

import org.springframework.stereotype.Service;
import springframework.app.domain.Customer;
import springframework.app.repositories.CustomerRepository;
import springframework.app.v1.model.CategoryDTO;
import springframework.app.v1.model.CustomerDTO;
import springframework.app.v1.mapper.CustomerMapper;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTO = new LinkedList<>();
        customerRepository.findAll().iterator().forEachRemaining( customer -> {
            customer.populateCustomerURL();
            customerDTO.add(customerMapper.customerToCustomerDTO(customer.populateCustomerURL()));
        });
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).get().populateCustomerURL());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {

        Customer savedCustomer = customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO));

        return customerMapper.customerToCustomerDTO(savedCustomer.populateCustomerURL());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer =customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerDTO(savedCustomer.populateCustomerURL());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
