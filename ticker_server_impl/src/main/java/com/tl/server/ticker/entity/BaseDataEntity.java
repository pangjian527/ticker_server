package com.tl.server.ticker.entity;

import com.tl.rpc.base.BaseData;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.action.spi.Executable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Entity
@Table(name = "t_base_data")
public class BaseDataEntity {

    private String id;
    //年份
    private int year;
    //号码
    private int number;
    //生肖编码
    private String zodiacCode;
    //颜色编码
    private String colorCode;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Column(name = "zodiac_code")
    public String getZodiacCode() {
        return zodiacCode;
    }

    public void setZodiacCode(String zodiacCode) {
        this.zodiacCode = zodiacCode;
    }

    @Column(name = "color_code")
    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public static BaseDataEntity formBaseDataEntity(BaseData baseData){
        BaseDataEntity entity = new BaseDataEntity();

        entity.colorCode = baseData.getColorCode();
        entity.id = baseData.getId();
        entity.year = baseData.getYear();
        entity.number = baseData.getNumber();
        entity.zodiacCode = baseData.getZodiacCode();

        return entity;
    }

    public BaseData toBaseData(){
        BaseData baseData = new BaseData();

        baseData.setColorCode(this.colorCode);
        baseData.setId(this.id);
        baseData.setNumber(this.number);
        baseData.setYear(this.year);
        baseData.setZodiacCode(this.zodiacCode);

        return baseData;
    }

}
