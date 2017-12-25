package com.newview.bysj.domain.authority;

import javax.persistence.Embeddable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 联系方式
 *
 * 是个内嵌对象
 * 不映射在数据库表中的实体类，嵌在Entity类中作为属性存在
 */
@Embeddable
@DynamicInsert(true)
@DynamicUpdate(true)
public class Contact {
    /**
     * QQ
     */
    private String qq;
    /**
     * 电话
     */
    private String moblie;
    /**
     * 邮编 【目前未用到】
     */
    private String zipCode;
    /**
     * 邮箱
     */
    private String email;

    public Contact() {
        super();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
