package pl.com.washme.servicetype.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.washme.servicetype.entity.ServiceType;
import pl.com.washme.common.model.ResultPage;
import pl.com.washme.servicetype.repository.ServiceTypeRepository;

@Data
@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public void addEditServiceType(ServiceType serviceType) {
        serviceTypeRepository.saveAndFlush(serviceType);
    }

    public void deleteServiceType(ServiceType serviceType) {
        serviceTypeRepository.delete(serviceType.getId());
    }

    public ServiceType findById(Long id) {
        return serviceTypeRepository.findOne(id);
    }

    public ResultPage<ServiceType> getAllServiceTypes(int pageNumber, int pageSize) {
        Page<ServiceType> serviceTypesPage = serviceTypeRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(serviceTypesPage.getContent(), serviceTypesPage.getNumber(), serviceTypesPage.getTotalPages());
    }
}
