package pl.training.backend.servicetype.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.backend.servicetype.entity.ServiceType;
import pl.training.backend.servicetype.repository.ServiceTypeRepository;

@Data
@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public void addServiceType(ServiceType serviceType){
        serviceTypeRepository.saveAndFlush(serviceType);
    }
}
