package com.neusiri.model;

import javax.persistence.*;

/**
 * @author zhangdj
 * @date 2020-07-02 15:55
 * @Entity 告诉jpa这是一个实体类（和数据库表映射）
 * @Table(name = "t_department") 指定和哪个表映射 如果省略默认表明是department
 */
@Entity
@Table(name = "t_department")
public class Department {

    /**
     * @Id 这是一个主键
     * @GeneratedValue(strategy = GenerationType.IDENTITY) 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 和表对应的列 名称可以省略 默认和属性名一致
     */
    @Column(name = "name",length = 128)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
