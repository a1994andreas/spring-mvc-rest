package springframework.app.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springframework.app.domain.Customer;
import springframework.app.v1.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

}
