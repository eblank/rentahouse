package com.tenement.service.webMagic.scheduler;


/**
 * Created by LXPENG on 2016/3/15.
 */
public abstract class AbstractFrontier {
    protected abstract void put(Object key, Object value);

    protected abstract Object get(Object key);

    protected abstract Object delete(Object key);
}
