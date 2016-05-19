package com.tenement.service.serviceImplements;

import com.base.BaseTest;
import com.tenement.service.CrawlService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by LXPENG on 2016/5/18.
 */
public class CrawlServiceImplTest extends BaseTest {
    @Autowired
    private CrawlService crawlService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCrawlCityList() throws Exception {

    }

    @Test
    public void testCrawlFilterOption() throws Exception {

    }

    @Test
    public void testGetUrl() throws Exception {
        String url = crawlService.getUrl("庄市", "500_1000", "", "", "", "");
        System.out.println(url);
    }

    @Test
    public void testCrawlHouseInfo() throws Exception {
        String testUrlString = "http://nb.58.com/zhuangshil/zufang/1/?minprice=500_1000&118eb2a3-d033-467e-8fff-79b5f48152db";
        crawlService.crawlHouseInfo(testUrlString);

    }

    @Test
    public void testCrawlHouseInfo2() throws Exception {
        String testUrlString = "http://nb.58.com/zhuangshil/zufang/1/?minprice=500_1000&118eb2a3-d033-467e-8fff-79b5f48152db2";
        crawlService.crawlHouseInfo(testUrlString);

    }

    @Test
    public void testGetHouseInfo() throws Exception {

    }
}
