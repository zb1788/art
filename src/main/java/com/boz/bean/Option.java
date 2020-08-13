package com.boz.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Option {
    private Integer optionid;
    private String optionname;
    private Integer optionorder;


    public Integer getOptionid() {
        return optionid;
    }

    public void setOptionid(Integer optionid) {
        this.optionid = optionid;
    }

    public String getOptionname() {
        return optionname;
    }

    public void setOptionname(String optionname) {
        this.optionname = optionname;
    }

    public Integer getOptionorder() {
        return optionorder;
    }

    public void setOptionorder(Integer optionorder) {
        this.optionorder = optionorder;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionid=" + optionid +
                ", optionname='" + optionname + '\'' +
                ", optionorder=" + optionorder +
                '}';
    }
}
