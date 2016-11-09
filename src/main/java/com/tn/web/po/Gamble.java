package com.tn.web.po;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Show on 2016/10/20.
 */
@Entity
public class Gamble {
    public Gamble() {
    }

    public Gamble(String creator, Date startTime) {
        this.creator = creator;
        this.startTime = startTime;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String creator;
    private Date startTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
