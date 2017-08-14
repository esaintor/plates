package guru.springframework.bootstrap;

import guru.springframework.domain.Product;
import guru.springframework.domain.Plate;
import guru.springframework.repositories.ProductRepository;
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

    private ProductRepository productRepository;
    private PlateRepository plateRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setPlateRepository(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Spring Framework TTT");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.com/wp-content/uploads/2015/04/rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring FrameworkMug");
        mug.setImageUrl("https://springframework.com/wp-content/uploads/2015/04/r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        // for(int i=0;i<10;i++){
        //     Plate one = new Plate();
        // one.setNumber(1234);
        // one.setText("УБУ");
        // one.setDate(new Date());
        // one.setAddress("Улаанбаатар, ХУ дүүрэг");
        // one.setDescription("Жолооч зөрчил гаргасан");
        // plateRepository.save(one);
        // }

        Plate two = new Plate();
        two.setNumber(2345);
        two.setText("УБА");
        two.setDate(new Date());
        two.setAddress("Улаанбаатар, ХУ дүүрэг");
        two.setDescription("Жолооч зөрчил гаргасан");
        plateRepository.save(two);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
