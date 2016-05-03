package com.tenement.service.webMagic.processor;

import com.tenement.model.House;
import com.tenement.model.Landlord;
import com.tenement.service.webMagic.pipeline.ConsolePipeline;
import com.tenement.service.webMagic.pipeline.HouseInfoPipeline;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXPENG on 2016/4/29.
 * 房屋详情页面分析提取
 */
@Service
public class HouseInfoProcessor implements PageProcessor {
    Site site = Site.me().setSleepTime(100).setRetryTimes(3);

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return this.site;
    }

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        Html html = page.getHtml();

        //分页链接 发现新链接
        List<String> pagerList = html.xpath("//div[@class='pager']/a[@class!=\"next\"]")
                .all();
        int num = pagerList.size();
        //房屋详情链接 发现新链接
        List<String> houseList = html.xpath("//div[@class='list clearfix']/dl/dd/h3/a/@href")
                .all();
        page.addTargetRequests(houseList);
        page.addTargetRequests(pagerList);

        //标题
        String mainTitle = html.xpath("//h1[@class='main-title font-heiti']/text()").get();
        if (StringUtils.isBlank(mainTitle)) {
            page.setSkip(true);
            return;
        }
        //房屋图片
        String primaryPicList = html.xpath("//img[@id='smainPic']/@src").get();
        //租金
        int housePrice = Integer.parseInt(html.xpath("//div[@class='main']//em[@class='house-price']/text()").get());
        //付款方式
        String payMethod = html.xpath("//div[@class='main']//span[@class='pay-method f16 c70']/text()").get();
        //卧室数 //todo 待分解
        String housePrimaryContent = html.xpath("//div[@class='main']//div[@class='fl house-type c70']/text()")
                .get();
        String[] list = housePrimaryContent.replaceAll("-", "").split(" ");

        List<String> roomList = new ArrayList<String>();
        for (String s : list) {
            if (StringUtils.isBlank(s)) {
                continue;
            }
            roomList.add(s);
        }
        String bedRoom = roomList.get(0);
        String livingRoom = roomList.get(1);
        String restRoom = roomList.get(2);
        String area = roomList.get(3).substring(2);
        String rentFloor = roomList.get(5).substring(2).split("/")[0];
        String floors = roomList.get(5).split("/")[1];
        String decoration = roomList.get(6);
        String toward = roomList.get(7).substring(4);
        String houseType = roomList.get(8).substring(2);

        String country = "中国";
        String province = "浙江";
        String city = "宁波";
        String county = html.xpath("//div[@class='main']//div[@class='fl xiaoqu c70']/a[1]/text()").get();
        String town = html.xpath("//div[@class='main']//div[@class='fl xiaoqu c70']/a[2]/text()").get();
        //地址
        String address = html.xpath("//div[@class='main']//div[@class='fl c70']/text()").get();
        //家具
        List<String> furnitureList = html.xpath("//div[@class='main']//span[@class='inlineblock']/text()").all();
        String description = html.xpath("//div[@class='description-content']/p/text()").get();
        String housingEstateDescription = html.xpath("//div[@class='main']//span[@class='pay-method f16 c70']/text()").get();
        //房屋联系人
//        String landlord = html.xpath("//div[@class='main']//div[@class='house-primary-content-wrap']//div[@class='fl tel cfff']/span[2]/text()").get();
//        String landlordname = landlord.split("\\(")[0];
//        Long landlordType = 0L;
//        Matcher m = Pattern.compile("\\((.*?)\\)").matcher(landlord);
//        if (m.find()) {
//            if (m.group(1).equals("个人")) {
//                landlordType = 1L;
//            } else {
//                landlordType = 2L;
//            }
//        }
        String landlordname = html.xpath("//div[@class='main']//div[@class='house-primary-content-wrap']//div[@class='fl tel cfff']/span[2]/text()").get();
        String landlordPhone = html.xpath("//div[@class='main']//div[@class='house-primary-content-wrap']//div[@class='fl tel cfff']/span[1]/text()").get();
        Long landlordType = 2L;

        //房屋信息
        House house = new House();
        house.setMainTitle(mainTitle);
        house.setPrimaryPicList(primaryPicList);
        house.setHousePrice(housePrice);
        house.setPayMethod(payMethod);
        house.setBedRoom(Integer.parseInt(bedRoom.substring(0, bedRoom.length() - 1)));
        house.setLivingRoom(Integer.parseInt(livingRoom.substring(0, livingRoom.length() - 1)));
        house.setRestRoom(Integer.parseInt(restRoom.substring(0, restRoom.length() - 1)));
        house.setArea(Long.parseLong(area));
        house.setRentFloor(Integer.parseInt(rentFloor.split("/")[0]));
        house.setFloors(Integer.parseInt(floors.substring(0, floors.length() - 1)));
        house.setDecoration(decoration);
        house.setToward(toward);
        house.setHouseType(houseType);
        house.setTown(town);
        house.setAddress(address);
        house.setFurniture(furnitureList.toString());
        house.setDescription(description);
        house.setHousingEstateDescription(housingEstateDescription);

        //联系人信息
        Landlord contacts = new Landlord();
        contacts.setName(landlordname);
        contacts.setMobile(landlordPhone);
        contacts.setType(landlordType);

        page.putField("house", house);
        page.putField("landlord", contacts);
    }

    public static void main(String[] args) {
        Spider.create(new HouseInfoProcessor())
                .addUrl("http://nb.58.com/haishu/zufang/1/b2j2/")
                .addPipeline(new HouseInfoPipeline())
                .run();
    }
}
