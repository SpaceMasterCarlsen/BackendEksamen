package rc.backendeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Siren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String locationName;
    private boolean operationalStatus;
    @JsonProperty("isInWorkingCondition")
    private boolean isInWorkingCondition;
    private double latitude;
    private double longitude;
    @ManyToMany(mappedBy = "activatedSirens")
    @JsonBackReference
    private List<Fire> fireHistory = new ArrayList<>();

    public Siren(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public boolean isOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(boolean operationalStatus) {
        this.operationalStatus = operationalStatus;
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
