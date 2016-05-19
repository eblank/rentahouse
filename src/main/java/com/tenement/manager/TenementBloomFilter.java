package com.tenement.manager;

import com.tenement.mapper.UrlMapper;
import com.tenement.model.Url;
import com.tenement.model.UrlExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by LXPENG on 2016/5/18.
 */
@Service
public class TenementBloomFilter {
    private DuplicateRemover duplicateRemover;
    @Autowired
    private UrlMapper urlMapper;

    /**
     * 初始化查重队列
     * 读取数据库存在url
     * 加入布隆过滤器查重队列
     */
    @PostConstruct
    public void initialization() {
        if (duplicateRemover == null) {
            duplicateRemover = new BloomFilterDuplicateRemover(5000000, 0.001);
            //todo 读取数据库url 添加到BloomFilterDuplicateRemover.bloomFilter
            UrlExample urlExample = new UrlExample();
            List<Url> urlList = urlMapper.selectByExample(urlExample);
            for (Url url : urlList) {
                duplicateRemover.isDuplicate(new Request(url.getUrl()), null);
            }
        }
    }

    public DuplicateRemover getDuplicateRemover() {
        initialization();
        return duplicateRemover;
    }

    public void setDuplicateRemover(DuplicateRemover duplicateRemover) {
        this.duplicateRemover = duplicateRemover;
    }
}
