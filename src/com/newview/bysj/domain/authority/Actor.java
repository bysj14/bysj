package com.newview.bysj.domain.authority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newview.bysj.domain.*;
import com.newview.bysj.domain.allUsers.Employee;
import com.newview.bysj.domain.allUsers.Student;
import com.newview.bysj.domain.allUsers.Tutor;
import com.newview.bysj.domain.allUsers.VisitingEmployee;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 所有用户的抽象父类，它的子类
 * @see Student  学生
 * @see Employee  校内老师
 * @see VisitingEmployee  校外职工
 * @see Tutor  所有老师抽象类
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DynamicInsert(true)
@DynamicUpdate(true)
public abstract class Actor implements Serializable {
    /**
     *  序列号
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    /**
     * 教师的编号、学生的学号、校外指导教师的标号
     */
    @Column(length = 12)
    private String no;

    @Column(length = 2)
    private String sex;

    @Column(length = 12)
    private String name;
    /**
     * 联系方式
     * 内嵌类
     * （联系方式的类，该类不单独映射到表中
     *  而是将该类中的属性作为该实体类中的属性，进行映射）
     */
    @Embedded
    private Contact contact;
    /**
     * 版本？？？
     */
    @Version
    @Column(name = "version")
    private Integer version;
    /**
     * 一对一
     * 一个用户对应一个账号
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * 一对多
     * 发布的通知？？
     * 一个通知多个人发布？
     */
    @OneToMany(mappedBy = "addressor", cascade = CascadeType.ALL)
    private List<Mail> mail;
    /**
     * 多对多
     * 收到的通知
     * 一个人可以收到多个通知，一个通知也可以发给多个人
     */
    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    private List<Mail> receiveMail;

    public Actor() {
        super();
    }

    public Actor(String no, String name) {
        this.no = no;
        this.name = name;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @JsonIgnore
     * 这个注解也可以放到属性上，但是必须要么都放属性上，要么都放方法上
     */
    @JsonIgnore
    public List<Mail> getMail() {
        return mail;
    }

    public void setMail(List<Mail> mail) {
        this.mail = mail;
    }
    @JsonIgnore
    public List<Mail> getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(List<Mail> receiveMail) {
        this.receiveMail = receiveMail;
    }

	/*@Override
	public String toString() {
		return "Actor [id=" + id + ", no=" + no + ", sex=" + sex + ", name=" + name + ", contact=" + contact
				+ ", version=" + version + ", user=" + user + ", mail=" + mail + ", receiveMail=" + receiveMail + "]";
	}*/
}

