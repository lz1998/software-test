package net.lz1998.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyTest {
    /**
     * 测试id username+timestamp
     */
    @Id
    private String testId;

    @Column
    private String testName;
    @Column
    private String description;
    /**
     * 用户id
     */
    @Column
    private Long userId;

    /**
     * 测试json 全部前端处理
     * {
     *     steps:[
     *          {
     *              "xpath":"",
     *              "type":"input", input/click
     *              "value":"123"
     *          },
     *          {
     *              "xpath":"",
     *              "type":"input", input/click
     *              "value":"123"
     *          },
     *     ]
     * }
     */
    @Column
    private String testJsonStr;
}
