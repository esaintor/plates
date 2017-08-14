package guru.springframework.bootstrap;

import guru.springframework.domain.Plate;
import guru.springframework.repositories.PlateRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PlateRepository plateRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setPlateRepository(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        for(int i=0;i<10;i++){
            Plate one = new Plate();
        one.setNumbers(1234);
        one.setLetters("УБУ");
        one.setDate(new Date());
        one.setAddress("Улаанбаатар, ХУ дүүрэг");
        one.setDescription("Жолооч зөрчил гаргасан");
        plateRepository.save(one);
        }

        Plate two = new Plate();
        two.setNumbers(2345);
        two.setLetters("УБА");
        two.setDate(new Date());
        two.setAddress("Улаанбаатар, ХУ дүүрэг");
        two.setDescription("Жолооч зөрчил гаргасан");
        plateRepository.save(two);
    }
}
