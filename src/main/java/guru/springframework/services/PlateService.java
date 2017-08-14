package guru.springframework.services;


import guru.springframework.domain.Plate;

public interface PlateService {
    Iterable<Plate> listAllPlates();

    Plate getPlateById(Integer id);

    Plate savePlate(Plate plate);
}
