package org.lyngby;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.lyngby.Phone;

import java.util.HashSet;
import java.util.Set;


@Getter
@ToString
@NoArgsConstructor
@Table(name = "person")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 25)
    private String name;


    @OneToMany
    @JoinColumn(name = "person_id")
    private Set<Phone> phones = new HashSet<>();


    public Person(String name) {
        this.name = name;
    }


    public void setPhones(Phone phone) {
        if (phones != null) {
            this.phones.add(phone);
        }
    }
}
