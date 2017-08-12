package pl.com.washme.servicepackage.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.washme.servicepackage.entity.ServicePackage;
import pl.com.washme.servicepackage.repository.ServicePackageRepository;

@Data
@Service
public class ServicePackageService {

    @Autowired
    private ServicePackageRepository servicePackageRepository;

    public void addServicePackage(ServicePackage servicePackage){
        servicePackageRepository.saveAndFlush(servicePackage);
    }

}
