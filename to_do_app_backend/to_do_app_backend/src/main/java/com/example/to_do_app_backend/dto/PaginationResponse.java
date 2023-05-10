package com.example.to_do_app_backend.dto;

import java.util.List;

public class PaginationResponse<T> {
    private final List<T> items;
    private final int size;
    private final int page;

    private final  int totalPage;

    private  final  Long totalItems;

    public PaginationResponse(List<T> tasks, int size, int page, int totalPage, Long totalItems){
        this.items = tasks;

        // The page is increased to take care of the reduction done in the task controller
        this.page = page +1;
        this.size = size;
        this.totalPage = totalPage;
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public Long getTotalItems() {
        return totalItems;
    }
}
