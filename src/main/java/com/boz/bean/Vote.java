package com.boz.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "auxsys_vote")
public class Vote {
    @Id
    private String id;

    @Field("title")
    private String name;//查找的时候字段名是根据bean的字段名来查（这里就是name而不是title）

    @Field("status")
    private String status;

    @Field("createtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private String createtime;

    @Field("options")
    private List<Option> options; //对应MongoDB内容是"options":[{"optionid":1,"optionname":"aaa","optionorder":0}]


    //如果数组里不是对象(对应数据库内容是"author":["mike","jam"])
    //private String [] auther;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", createtime='" + createtime + '\'' +
                ", options=" + options +
                '}';
    }
}
