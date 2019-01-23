package pl.sstenzel.ug.javaee.florists.ejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.view.View;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

//@Entity
//@XmlRootElement
public class Fertilization {
    private long id;
//    private Date date;
    private String fertilizer;


    public Fertilization() {}
    public Fertilization(String fertilizer) {
//        this.date = date;
        this.fertilizer = fertilizer;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

//    public Date getDate() {
//        return date;
//    }
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public String getFertilizer() {
        return fertilizer;
    }
    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }



}
