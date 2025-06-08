package com.design.base.model;

import java.io.Serializable;
import java.util.List;

public class Pager implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    private int pageNow = 1;
    private int pageSize = 2;
    private int offset;
    
    private int totalCount;
    private int totalPages;
    
    private String column;
    private String order = "ASC";

    //结果集
    private List<?> datas;
    
    public int getPageNow() {
        return this.pageNow;
    }
    
    public void setPageNow(int pageNow ) {
        this.pageNow = pageNow;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public void setPageSize(int pageSize ) {
        this.pageSize = pageSize;
    }
    
    public int getOffset() {
        return (this.pageNow-1)*this.pageSize;
    }
    
    public void setOffset(int offset ) {
        this.offset = offset;
    }
    
    public int getTotalCount() {
        return this.totalCount;
    }
    
    public void setTotalCount(int totalCount ) {
        this.totalCount = totalCount;
    }
    
    public int getTotalPages() {
        int page = this.totalCount/this.pageSize;
        return this.totalCount%this.pageSize==0?page:page+1;
    }
    
    public void setTotalPages(int totalPages ) {
        this.totalPages = totalPages;
    }
    
    public String getColumn() {
        return this.column;
    }
    
    public void setColumn(String column ) {
        this.column = column;
    }
    
    public String getOrder() {
        return this.order;
    }
    
    public void setOrder(String order ) {
        this.order = order;
    }
    
    public List<?> getDatas() {
        return this.datas;
    }
    
    public void setDatas(List<?> datas ) {
        this.datas = datas;
    }




}
