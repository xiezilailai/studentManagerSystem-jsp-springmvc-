package com.xiezilailai.example.entities;

import java.sql.Date;

/**
 * Created by 蝎子莱莱123 on 2016/2/13.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "studentinfo", schema = "jkxystudent", catalog = "")
public class StudentinfoEntity {
    private int id;
    private String nickname;
    private String realname;
    private Byte sex;
    private String borndate;
    private String profession;
    private String subject;
    private String hobby;
    private String remark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "borndate")
    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentinfoEntity that = (StudentinfoEntity) o;

        if (id != that.id) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (borndate != null ? !borndate.equals(that.borndate) : that.borndate != null) return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (borndate != null ? borndate.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
