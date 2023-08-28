package org.lyngby;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.lyngby.Phone;


@Getter
@ToString
@NoArgsConstructor
@Table(name = "person")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private int id;

    @Column(name = "name", length = 25)
    private String name;

    @OneToOne
    @MapsId
    private Phone phone;

    public Person(String name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
