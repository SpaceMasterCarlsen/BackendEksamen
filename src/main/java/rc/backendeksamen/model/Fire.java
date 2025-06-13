package rc.backendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDateTime timestamp;
    private boolean status;
    private double latitude;
    private double longitude;
    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "fire_siren", joinColumns = @JoinColumn(name = "fire_id"),
    inverseJoinColumns = @JoinColumn(name = "siren_id"))
    private List<Siren> activatedSirens = new ArrayList<>();

    public Fire(){}

    public Fire(String name, LocalDateTime timestamp, boolean status, double latitude, double longitude) {
        this.name = name;
        this.timestamp = timestamp;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Siren> getActivatedSirens() {
        return activatedSirens;
    }

    public void setActivatedSirens(List<Siren> activatedSirens) {
        this.activatedSirens = activatedSirens;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
