package com.bjpowernode.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author cty
 * @date 2021/9/17 9:00
 */
public class Page<T> implements Serializable {
    //总记录数
    private int totalRecords;
    //总页数
    private int totalPages;
    //当前页
    private int currentPage;
    //每页显示记录数
    private int pageSize;
    //每页显示记录数集合
    private List<T> list;

    public Page(int totalRecords, int currentPage, int pageSize, List<T> list) {
        this.totalRecords = totalRecords;
        this.totalPages = (totalRecords % pageSize == 0) ? (totalRecords / pageSize) : ((totalRecords / pageSize) + 1);
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
    }

    public Page() {
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
