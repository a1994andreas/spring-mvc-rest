package springframework.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springframework.app.domain.Customer;
import springframework.app.services.CustomerService;
import springframework.app.v1.mapper.CustomerMapper;
import springframework.app.v1.model.CustomerDTO;
import springframework.app.v1.model.CustomerListDTO;

@Controller
@RequestMapping({"customers"})
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

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer (@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>( customerService.addCustomer(customerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer (@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>( customerService.updateCustomer(id,customerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
