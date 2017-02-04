package com.prits.backend.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pritesh Patel on 2/4/2017.
 */
public class Page<E> {

    private int pageNumber;
    private int pagesAvailable;
    private List<?> pageItems = new ArrayList<Object>();

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<?> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<?> pageItems) {
        this.pageItems = pageItems;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", pagesAvailable=" + pagesAvailable +
                ", pageItems=" + pageItems +
                '}';
    }
}