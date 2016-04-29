package com.tenement.service.webMagic.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.*;
import com.tenement.model.City;
import com.tenement.model.CityExample;
import com.tenement.model.County;
import com.tenement.model.Town;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class FilterOptionPipeline implements Pipeline {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CountyMapper countyMapper;
    @Autowired
    private TownMapper townMapper;

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        JSONObject cityJson = (JSONObject)JSONObject.toJSON(resultItems.getAll().get("city"));
        String cityName = cityJson.get("name").toString();
        //获取市id
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andNameEqualTo(cityName);
        List<City> cityList = cityMapper.selectByExample(cityExample);
        String cityCode = cityList.get(0).getId() + "";

        //保存县级
        JSONObject countyJson = cityJson.getJSONObject("county");
        String countyName = countyJson.getString("name");
        String countyUrl = countyJson.getString("url");
        if (StringUtils.isBlank(countyName) || StringUtils.isBlank(countyUrl)) {
            return;
        }
        County county = new County();
        county.setName(countyName);
        county.setUrl(countyUrl);
        county.setCityCode(cityCode);
        ClassUtil.setDefaultValues(county);
        try {
            countyMapper.insert(county);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String countyCode = county.getId() + "";

        //保存区镇级
        JSONArray townArray = countyJson.getJSONArray("town");
        if (townArray == null || townArray.size() < 1) {
            return;
        }
        for (Object o : townArray) {
            Town town = (Town)o;
            town.setCountyCode(countyCode);
            ClassUtil.setDefaultValues(town);
            try {
                townMapper.insert(town);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
