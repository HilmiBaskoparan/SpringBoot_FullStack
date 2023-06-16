package com.hilmibaskoparan.controller.api;

import com.hilmibaskoparan.business.dto.BlogDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPageableAndProfileApp {

    // Bütün veri eklesin
    public ResponseEntity<List<BlogDto>> speedDataService();

    // Bütün veriyi silsin
    public ResponseEntity<String> allDeleteService();

    // App Information
    public ResponseEntity<String> appInformationService(HttpServletRequest request, HttpServletResponse response);

    // ########## PAGEABLE ##########
    // List: pageable
    public ResponseEntity<List<BlogDto>> blogServiceAllList();

    // List: Page page,size
    public ResponseEntity<Page<BlogDto>> blogServicePagination(int currentPage, int pageSize);

    // List: page, pageable
    public ResponseEntity<Page<BlogDto>>  blogServicePagination(Pageable pageable,BlogDto blogDto);

}
