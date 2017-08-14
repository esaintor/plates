package guru.springframework.services;

import guru.springframework.domain.Plate;
import guru.springframework.repositories.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateServiceImpl implements PlateService {
    private PlateRepository plateRepository;

    @Autowired
    public void setPlateRepository(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public Iterable<Plate> listAllPlates() {
        return plateRepository.findAll();
    }

    @Override
    public Plate getPlateById(Integer id) {
        return plateRepository.findOne(id);
    }

    @Override
    public Plate savePlate(Plate plate) {
        return plateRepository.save(plate);
    }
}
