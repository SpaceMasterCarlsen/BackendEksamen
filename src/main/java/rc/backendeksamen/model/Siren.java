package rc.backendeksamen.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Siren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private boolean sirenOn;
    //TODO make latitude and longitude
    @ManyToMany(mappedBy = "activatedSirens")
    private List<Fire> fireHistory = new ArrayList<>();

    public Siren(){}

    public Siren(long id, String status, boolean sirenOn, List<Fire> fireHistory) {
        this.id = id;
        this.status = status;
        this.sirenOn = sirenOn;
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

    public boolean isSirenOn() {
        return sirenOn;
    }

    public void setSirenOn(boolean sirenOn) {
        this.sirenOn = sirenOn;
    }

    public List<Fire> getFireHistory() {
        return fireHistory;
    }

    public void setFireHistory(List<Fire> fireHistory) {
        this.fireHistory = fireHistory;
    }
}
