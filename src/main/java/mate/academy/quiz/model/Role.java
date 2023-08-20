package mate.academy.quiz.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Role(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Role() {
    }

    //TODO update ENUM and remake DB according to this
    public enum RoleEnum{
        USER("USER",2L),ADMIN("ADMIN",1L);
        RoleEnum(String name, Long id){
            this.name = name;
            this.id = id;
        }
        String name;
        Long id ;
    }
}
