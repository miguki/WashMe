package pl.com.washme.carwash.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.com.washme.carwash.entity.CarWash;
import pl.com.washme.carwash.repository.CarWashRepository;
import pl.com.washme.common.model.ResultPage;

/**
 * Created by Jasiek on 27.07.2017.
 */
@Data
@Service
public class CarWashService {

    @Autowired
    private CarWashRepository carWashRepository;

    public void addCarWash(CarWash carWash) {
        carWashRepository.saveAndFlush(carWash);
    }

    public CarWash getCarWashById(Long id){
        return carWashRepository.findOne(id);
    }

    public ResultPage<CarWash> getAllCarWashes(int pageNumber, int pageSize) {
        Page<CarWash> carWashesPage = carWashRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(carWashesPage.getContent(), carWashesPage.getNumber(), carWashesPage.getTotalPages());
    }
}
