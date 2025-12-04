package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "shows")
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="show_time")
    private LocalDate showtime;

    @Column(name="end_time")
    private LocalDate endTime;

    @Column(name="status")
    private String status;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getShowtime() {
        return showtime;
    }

    public void setShowtime(LocalDate showtime) {
        this.showtime = showtime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
