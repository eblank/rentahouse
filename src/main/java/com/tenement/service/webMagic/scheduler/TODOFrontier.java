package com.tenement.service.webMagic.scheduler;


import us.codecraft.webmagic.Page;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LXPENG on 2016/3/15.
 */
public class TODOFrontier extends AbstractFrontier implements Frontier{
    private Set<Object> set = new HashSet<Object>();
    @Override
    protected void put(Object key, Object value) {

    }

    @Override
    protected Object get(Object key) {
        return null;
    }

    @Override
    protected Object delete(Object key) {
        return null;
    }

    public Page getNext() throws Exception {
        return null;
    }

    public boolean putPage(Page page) throws Exception {
        return false;
    }

    private String cacularUrl(String url) {
        //todo 压缩
        return url;
    }


}
