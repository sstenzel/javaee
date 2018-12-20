package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Card {

    private long id;
    private boolean onPaper;
    private boolean electronicVersion;
    private String description;

    public Card (){}

    public Card( boolean onPaper, boolean electronicVersion, String description) {
        super();
        this.onPaper = onPaper;
        this.electronicVersion = electronicVersion;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOnPaper() {
        return onPaper;
    }

    public void setOnPaper(boolean onPaper) {
        this.onPaper = onPaper;
    }

    public boolean isElectronicVersion() {
        return electronicVersion;
    }

    public void setElectronicVersion(boolean electronicVersion) {
        this.electronicVersion = electronicVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
