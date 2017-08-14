package guru.springframework.repositories;

import guru.springframework.domain.Plate;
import org.springframework.data.repository.CrudRepository;

public interface PlateRepository extends CrudRepository<Plate, Integer>{
}
