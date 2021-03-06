package com.newview.bysj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "remarkTemplateItemsOption")
@DynamicInsert(true)
@DynamicUpdate(true)
public class RemarkTemplateItemsOption implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 选项，如“很好”，“一般”，“较差”
     *
     * @generated
     */
    private String itemOption;
    /**
     * 选项编号，排序用
     *
     * @generated
     */
    private Integer no;
    /**
     * 评语项（文本）
     * 多对一
     *
     * @generated
     */
    @ManyToOne
    @JoinColumn(name = "remarkTemplateItems_id")
    private RemarkTemplateItems remarkTemplateItems;

    public RemarkTemplateItemsOption() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemOption() {
        return itemOption;
    }

    public void setItemOption(String itemOption) {
        this.itemOption = itemOption;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @JsonIgnore
    public RemarkTemplateItems getRemarkTemplateItems() {
        return remarkTemplateItems;
    }

    public void setRemarkTemplateItems(RemarkTemplateItems remarkTemplateItems) {
        this.remarkTemplateItems = remarkTemplateItems;
    }


}
