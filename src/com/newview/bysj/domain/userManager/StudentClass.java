package com.newview.bysj.domain.userManager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newview.bysj.domain.allUsers.Student;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 班级
 */
@Entity
@Table(name = "studentClass")
@DynamicInsert(true)
@DynamicUpdate(true)
public class StudentClass implements Serializable {

    /**
     *序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 班级编号
     * 忽略该属性转化为json，因为前后台交互数据时，不需要用到班级编号
     */
    @JsonIgnore
    private String no;
    /**
     * 班级名称
     */
    private String description;
    /**
     * 专业
     * 多对一
     */
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    /**
     * 学生
     * 一对多
     */
    @OneToMany(mappedBy = "studentClass")
    private List<Student> student;

    public StudentClass() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @JsonIgnore
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
