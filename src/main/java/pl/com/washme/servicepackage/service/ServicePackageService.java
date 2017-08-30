package pl.com.washme.servicepackage.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.washme.common.model.ResultPage;
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

    public ResultPage<ServicePackage> getAllServicePackages(int pageNumber, int pageSize) {
        Page<ServicePackage> servicePackagesPage = servicePackageRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(servicePackagesPage.getContent(), servicePackagesPage.getNumber(), servicePackagesPage.getTotalPages());
    }
}
