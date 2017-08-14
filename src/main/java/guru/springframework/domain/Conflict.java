package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
public class Conflict {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String number;
    private String name;
    private String description;

    
}
