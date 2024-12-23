package in.sbmbank.entity_interface.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "account_holder")
public class AccountHolderEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer totalAmount;




}
