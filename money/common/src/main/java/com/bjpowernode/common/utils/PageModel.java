package com.bjpowernode.common.utils;

import java.io.Serializable;

/**
 * @author cty
 * @date 2021/12/16 19:18
 */
public class PageModel implements Serializable {
    private Integer firstPage = 1;
    private Long lastPage;
    private Integer pageSize = 10;
    private Long totalCount;
    private Long currentPage;

    public PageModel(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Long getLastPage() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public void setLastPage(Long lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                '}';
    }
}
