package com.audio.electric.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/19 0019 14:06
 */
public class TablePage<T> implements Pageable {

        /** 每页显示条数 */
        private Integer pageSize = 20;

        /** 当前页 */
        private Integer currentPage = 1;

        /** 总页数 */
        private Integer pageNumber = 1;

        /** 查询到的总数据量 */
        private Long totalNumber = 0l;

        /** 数据集 */
        private List items;

    public TablePage(Integer currentPage, Integer pageSize) {
        this.currentPage = Integer.valueOf(currentPage == null?0:currentPage.intValue());
        this.pageSize = Integer.valueOf(pageSize == null?0:pageSize.intValue());
    }

    public TablePage(List<T> list, long totalNumber) {
        this.items = list;
        this.totalNumber = totalNumber;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber.intValue();
    }

    @Override
    public int getPageSize() {
        return this.pageSize.intValue();
    }


    @Override
    public int getOffset() {
        return this.currentPage.intValue()*this.pageNumber.intValue();
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return new TablePage((getPageNumber()+1),getPageSize());
    }

    @Override
    public Pageable previousOrFirst() {
        return this.hasPrevious()?this.previous():this.first();
    }

    @Override
    public boolean hasPrevious() {
        return this.currentPage.intValue() > 0;
    }

    public Pageable asPageable() {
        return new TablePage(this.currentPage.intValue(), this.pageSize.intValue());
    }

    @Override
    public TablePage first() {
        return new TablePage(Integer.valueOf(0), Integer.valueOf(this.getPageSize()));
    }

    public TablePage previous() {
        return this.getPageNumber() == 0?this:new TablePage(Integer.valueOf(this.getPageNumber() - 1), Integer.valueOf(this.getPageSize()));
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public List getItems() {
        return items;
    }
}
