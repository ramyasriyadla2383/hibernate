package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="audi_address")
public class AudiAddress {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)   //used to auto increment
    private Long id;

    @Column(name="streetname")
    private String streetName;

    @Column(name="area")
    private String area;

    @Column(name="city")
    private String city;

    @Column(name="pincode")
    private Integer pincode;

    @OneToOne(mappedBy = "Audiaddress")
    private Auditorium auditorium;

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
