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
public class MainData2{

    @ExcelProperty(value = "职位名", index =0)
    private String positionName;

    @ExcelProperty(value = "职位链接", index = 1)
    private String positionLink;

    @ExcelProperty(value = "资历", index = 2)
    private String experience;

    @ExcelProperty(value = "公司名", index = 3)
    private String companyName;

    @ExcelProperty(value = "公司标签", index = 4)
    private String companyTag;

    @ExcelProperty(value = "薪资", index = 5)
    private String salary;

    @ExcelProperty(value = "公司规模", index = 6)
    private String companyScale;

    @ExcelProperty(value = "职位标签", index = 7)
    private String positionTag;

    @ExcelProperty(value = "城市", index = 8)
    private String city;

    @ExcelProperty(value = "学历", index = 9)
    private String scholar;

    @ExcelProperty(value = "公司分类", index = 10)
    private String companyClassification;

    @ExcelProperty(value = "数字产品制造业", index = 11)
    private String criteria1;

    @ExcelProperty(value = "数字产品服务业", index = 12)
    private String criteria2;

    @ExcelProperty(value = "数字技术应用页", index = 13)
    private String criteria3;

    @ExcelProperty(value = "数字要素驱动页", index = 14)
    private String criteria4;


    @ExcelProperty(value = "数字化效率提升页", index = 15)
    private String criteria5;


    @ExcelProperty(value = "优化升级数字基础设施", index = 16)
    private String criteria6;

    @ExcelProperty(value = "充分发挥数据要素作用", index = 17)
    private String criteria7;

    @ExcelProperty(value = "大力推进产业数字化转型", index = 18)
    private String criteria8;

    @ExcelProperty(value = "加快推进产业数字化转型", index = 19)
    private String criteria9;

    @ExcelProperty(value = "持续提升公共服务数字化水平", index = 20)
    private String criteria10;

    @ExcelProperty(value = "健全完善数字经济治理体系", index = 21)
    private String criteria11;

    @ExcelProperty(value = "着力强化数字经济安全体系", index = 22)
    private String criteria12;

    @ExcelProperty(value = "有效拓展数字经济国际合作", index = 23)
    private String criteria13;

}
