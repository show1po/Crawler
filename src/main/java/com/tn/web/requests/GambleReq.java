package com.tn.web.requests;

import java.util.Date;

/**
 * Created by java on 2016/10/21.
 */

public class GambleReq {
    private String creator;
    private Date date;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
