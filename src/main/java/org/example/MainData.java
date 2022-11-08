package org.example;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ht
 */
@Getter
@Setter
@EqualsAndHashCode
public class MainData {

    @ExcelProperty(value = "学校", index =0)
    private String school;
    @ExcelProperty(value = "地区", index = 1)
    private String area;
    @ExcelProperty(value = "学科", index = 2)
    private String subject;

    @ExcelProperty(value = "判断1", index = 3)
    private String isLogical;

    @ExcelProperty(value = "判断2", index = 4)
    private String isInfoTech;

    @ExcelProperty(value = "判断3", index = 5)
    private String isDataPractice;

}
