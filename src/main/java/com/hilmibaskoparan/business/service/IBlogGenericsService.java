package com.hilmibaskoparan.business.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogGenericsService<D, E> extends IProfileApp {

    // ########## MODAL MAPPER ##########
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    // ########## CRUD OPERATIONS ##########
    // CREATE
    public D blogServiceCreate(D d);

    // LIST
    public List<D> blogServiceList();

    // FIND
    public D blogServiceFindById(Long id);

    // DELETE
    public D blogServiceDeleteById(Long id);

    // UPDATE
    public D blogServiceUpdateById(Long id, D d);


    // ########## PAGEABLE ##########
    // List: pageable
    public List<D> blogServiceAllList();

    // List: Page page,size
    public Page<E> blogServicePagination(int currentPage, int pageSize);

    // List: page, pageable
    public Page<E> blogServicePagination(Pageable pageable, D d);

}
