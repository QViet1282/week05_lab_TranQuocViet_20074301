package vn.edu.iuh.fit.www_lab5.backend.models;

import com.neovisionaries.i18n.LocaleCode;
import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab5.backend.enums.Country;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id", length = 20)
    private long addressId;
    @Column(columnDefinition = "smallint(6)")
    private LocaleCode country;
    @Column(columnDefinition = "varchar(7)")
    private String zipcode;
    @Column(columnDefinition = "varchar(20)")
    private String number;
    @Column(columnDefinition = "varchar(50)")
    private String city;
    @Column(columnDefinition = "varchar(150)")
    private String street;

    public Address(LocaleCode country, String zipcode, String number, String city, String street) {
        this.country = country;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.street = street;
    }

    public Address() {

    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public LocaleCode getCountry() {
        return country;
    }

    public void setCountry(LocaleCode country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "address{" +
                "addressId=" + addressId +
                ", country=" + country +
                ", zipcode='" + zipcode + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

