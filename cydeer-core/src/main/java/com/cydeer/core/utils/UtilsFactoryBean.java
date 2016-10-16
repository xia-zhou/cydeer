package com.cydeer.core.utils;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Cydeer on 15/9/9.
 */
public class UtilsFactoryBean implements FactoryBean<IUtils>{
    private Class<IUtils> clz;
    private String instance;

    public UtilsFactoryBean() {
    }

    public IUtils getObject() throws Exception {
        if(this.clz == null) {
            throw new IllegalArgumentException("必须设置组件类对象");
        } else {
            return Utils.get(this.clz, this.instance);
        }
    }

    public Class<IUtils> getObjectType() {
        return this.clz;
    }

    public boolean isSingleton() {
        return true;
    }

    public final void setClz(Class<IUtils> clz) {
        this.clz = clz;
    }

    public final void setInstance(String instance) {
        this.instance = instance;
    }
}
