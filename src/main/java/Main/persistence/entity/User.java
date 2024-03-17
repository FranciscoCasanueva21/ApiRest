package Main.persistence.entity;
import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Entity
@Data
@Document(collection = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String surname;
    private String age;
    private String celphone;
    private String email;

}
