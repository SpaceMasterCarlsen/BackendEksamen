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
    private LocalDateTime timestamp;
    private String status;
    private double latitude;
    private double longitude;
    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "fire_siren", joinColumns = @JoinColumn(name = "fire_id"),
    inverseJoinColumns = @JoinColumn(name = "siren_id"))
    private List<Siren> activatedSirens = new ArrayList<>();

    public Fire(){}

    public Fire(long id, LocalDateTime timestamp, String status, double latitude, double longitude, List<Siren> activatedSirens) {
        this.id = id;
        this.timestamp = timestamp;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activatedSirens = activatedSirens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
