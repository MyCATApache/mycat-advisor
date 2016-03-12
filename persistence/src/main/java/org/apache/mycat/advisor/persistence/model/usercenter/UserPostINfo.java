package org.apache.mycat.advisor.persistence.model.usercenter;

import org.apache.mycat.advisor.persistence.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cjl on 2016/3/11.
 */
@Table(name = "tab_post_info")
public class UserPostInfo extends BaseEntity implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String code;
    String note;
    Date insert_time;
    Date update_time;
    Integer status;
    Integer del_flag;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "UserPostInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", insert_time=" + insert_time +
                ", update_time=" + update_time +
                ", status=" + status +
                ", del_flag=" + del_flag +
                '}';
    }
}
