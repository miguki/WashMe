package pl.com.washme.servicetype.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.washme.servicetype.entity.ServiceType;
import pl.com.washme.servicetype.repository.ServiceTypeRepository;

@Data
@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public void addServiceType(ServiceType serviceType){
        serviceTypeRepository.saveAndFlush(serviceType);
    }

    public ServiceType findById(Long id){
        return serviceTypeRepository.findOne(id);
    }
}
