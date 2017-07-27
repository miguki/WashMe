package pl.training.backend.carwash.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.backend.carwash.entity.CarWash;
import pl.training.backend.carwash.repository.CarWashRepository;
import pl.training.backend.client.entity.Client;

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

}
