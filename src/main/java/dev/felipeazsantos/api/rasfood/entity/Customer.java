package dev.felipeazsantos.api.rasfood.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name;

    private String email;


    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        addressList.add(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", addressList=" + addressList +
                '}';
    }
}
