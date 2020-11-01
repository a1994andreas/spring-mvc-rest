package springframework.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.app.domain.Customer;
import springframework.app.services.CustomerService;
import springframework.app.v1.mapper.CustomerMapper;
import springframework.app.v1.model.CustomerDTO;
import springframework.app.v1.model.CustomerListDTO;

@Controller
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers (){
        return new ResponseEntity<CustomerListDTO>(
            new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK
        );
    }

    @RequestMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById (@PathVariable Long id) {
        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id),HttpStatus.OK);
    }

}
