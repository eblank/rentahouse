package com.tenement.service.webMagic.pipeline;

import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.*;
import com.tenement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by LXPENG on 2016/4/29.
 */
@Service
public class HouseInfoPipeline implements Pipeline {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private TownMapper townMapper;
    @Autowired
    private CountyMapper countyMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        JSONObject items = new JSONObject(resultItems.getAll());

        Landlord landlord = (Landlord)items.get("landlord");
        ClassUtil.setDefaultValues(landlord);
        landlordMapper.insert(landlord);

        House house = (House)items.get("house");
        house.setContact(landlord.getId());
        //todo 表town 字段错误 name和url错误
        TownExample townExample = new TownExample();
        townExample.createCriteria().andUrlEqualTo(house.getTown());
        Town town = townMapper.selectByExample(townExample).get(0);
        //县级
        County county = countyMapper.selectByPrimaryKey(Long.parseLong(town.getCountyCode()));
        //市级
        City city = cityMapper.selectByPrimaryKey(Long.parseLong(county.getCityCode()));
        //省级
        Province province = provinceMapper.selectByPrimaryKey(Long.parseLong(city.getProvinceCode()));

        house.setProvince(province.getName());
        house.setCity(city.getName());
        house.setCounty(county.getName());
        ClassUtil.setDefaultValues(house);
        houseMapper.insert(house);
    }
}
