package com.tenement.service.webMagic.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.CityMapper;
import com.tenement.mapper.CountryMapper;
import com.tenement.mapper.ProvinceMapper;
import com.tenement.model.City;
import com.tenement.model.Country;
import com.tenement.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class CityListPipeline implements Pipeline {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;

    /**
     * 获取省市与对应url数据
     *
     * @param resultItems
     * @param task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        //保存国家
        Country country = new Country();
        country.setName("中国");
        ClassUtil.setDefaultValues(country);
        try {
            countryMapper.insert(country);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String countryCode = country.getId() + "";
        System.out.println(countryCode);

        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            //一级地区名称（省） 保存到数据库
            String provinceString = entry.getKey();
            Province province = new Province();
            province.setCountryCode(countryCode);
            province.setName(provinceString);
            ClassUtil.setDefaultValues(province);
            try {
                provinceMapper.insert(province);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            String provinceCode = province.getId() + "";

            //二级地区对象（市）
            JSONArray cityArray = (JSONArray)entry.getValue();
            for (Object object : cityArray) {
                City city = (City)object;
                city.setProvinceCode(provinceCode);
                ClassUtil.setDefaultValues(city);
                try {
                    cityMapper.insert(city);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
