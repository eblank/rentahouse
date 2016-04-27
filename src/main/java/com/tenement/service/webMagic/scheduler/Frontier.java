package com.tenement.service.webMagic.scheduler;


import us.codecraft.webmagic.Page;

/**
 * Created by LXPENG on 2016/3/15.
 */
public interface Frontier {
    Page getNext() throws Exception;

    boolean putPage(Page page) throws Exception;

//    boolean visited(Page page);
}
