package rc.backendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Siren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private boolean isInWorkingCondition;
    private double latitude;
    private double longitude;
    @ManyToMany(mappedBy = "activatedSirens")
    @JsonBackReference
    private List<Fire> fireHistory = new ArrayList<>();

    public Siren(){}

    public Siren(long id, String status, boolean isInWorkingCondition, double latitude, double longitude, List<Fire> fireHistory) {
        this.id = id;
        this.status = status;
        this.isInWorkingCondition = isInWorkingCondition;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fireHistory = fireHistory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isInWorkingCondition() {
        return isInWorkingCondition;
    }

    public void setIsInWorkingCondition(boolean isinWorkingCondition) {
        isInWorkingCondition = isinWorkingCondition;
    }

    public List<Fire> getFireHistory() {
        return fireHistory;
    }

    public void setFireHistory(List<Fire> fireHistory) {
        this.fireHistory = fireHistory;
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
