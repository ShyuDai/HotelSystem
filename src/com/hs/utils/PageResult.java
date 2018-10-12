package com.hs.utils;

import java.util.List;

public class PageResult<T> {

    //满足
    private int toatalCount;//总记录数
    private int pageNo;//当前页码
    private int pageSize;//页面容量
    private int pageCount;//总页数

    private List<T> list;

    public int getToatalCount() {
        return toatalCount;
    }

    public void setToatalCount(int toatalCount) {
        this.toatalCount = toatalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}


