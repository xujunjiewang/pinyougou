package entity;

import java.io.Serializable;

public class PageParameter<T> implements Serializable {

    public T t;  //需要查询的实体类
    private Integer page;  //当前页数；
    private Integer size;   //每页显示记录数

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
