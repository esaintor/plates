package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer number;
    private String text;
    private Date date;
    // private Type type;
    // private Conflict conflict;
    private String description;
    private String address;
    private BigDecimal price;

    
}
