package org.example;


import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="audi")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "audi_seat_rows")
    private Integer audiSeatRows;

    @Column(name = "audi_seat_columns")
    private Integer audiSeatColumns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAudiSeatRows() {
        return audiSeatRows;
    }

    public void setAudiSeatRows(Integer audiSeatRows) {
        this.audiSeatRows = audiSeatRows;
    }

    public Integer getAudiSeatColumns() {
        return audiSeatColumns;
    }

    public void setAudiSeatColumns(Integer audiSeatColumns) {
        this.audiSeatColumns = audiSeatColumns;
    }


    public AudiAddress getAudiaddress() {
        return Audiaddress;
    }

    public void setAudiaddress(AudiAddress audiaddress) {
        Audiaddress = audiaddress;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")   //create FK
    private AudiAddress Audiaddress;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "audi_id")   //create FK
    private List<Shows> shows=new ArrayList();

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }
}
