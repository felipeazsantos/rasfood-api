package dev.felipeazsantos.api.rasfood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;


@Entity
@Table(name = "address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String state;

    private String city;

    private String quarter;

    private String complement;

    private String cep;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Address() {
    }

    public Address(String street, String state, String city, String quarter, String complement, String cep) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.quarter = quarter;
        this.complement = complement;
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", quarter='" + quarter + '\'' +
                ", complement='" + complement + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
