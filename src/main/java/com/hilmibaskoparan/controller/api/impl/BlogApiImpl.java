package com.hilmibaskoparan.controller.api.impl;

import com.hilmibaskoparan.business.dto.BlogDto;
import com.hilmibaskoparan.business.service.IBlogGenericsService;
import com.hilmibaskoparan.controller.api.IBlogGenericsApi;
import com.hilmibaskoparan.error.ApiResult;
import com.hilmibaskoparan.util.FrontEndURL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

@RestController
@CrossOrigin(origins = FrontEndURL.FRONTEND_URL)    // CORS
@RequestMapping("/blog/api/v1")
public class BlogApiImpl implements IBlogGenericsApi<BlogDto> {

    private final IBlogGenericsService iBlogGenericsService;
    private ApiResult apiResult;

    // ### ROOT ###############################
    // localhost:4040
    // localhost:4040/index
    @Override
    @GetMapping({"/", "/index"})
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok("index");
    }

    // ### CRUD ###############################
    // CREATE
    // localhost:4040/blog/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogServiceCreate(@Valid @RequestBody BlogDto blogDto) {
        //return ResponseEntity.status(200).body(iBlogGenericsService.blogServiceCreate(blogDto));
        //return ResponseEntity.status(HttpStatus.OK).body(iBlogGenericsService.blogServiceCreate(blogDto));
        return ResponseEntity.ok(iBlogGenericsService.blogServiceCreate(blogDto));
    }

    // LIST
    // localhost:4040/blog/api/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<BlogDto>> blogServiceList() {
        return ResponseEntity.ok(iBlogGenericsService.blogServiceAllList());
    }

    // FIND
    // localhost:4040/blog/api/v1/find
    // localhost:4040/blog/api/v1/find/0
    // localhost:4040/blog/api/v1/find/1
    @Override
    @GetMapping({"/find", "/find/{id}"})
    public ResponseEntity<?> blogServiceFindById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("Blog Api Null Pointer Exception Geldi");
            throw new NullPointerException(id + " Blog Api Null Veri Geldi.");
        } else if (id == 0) {
            log.error("Blog Api 0 BadRequest Geldi");
            //ApiResult(int status, String error, String path, String message)
            apiResult = new ApiResult(400, "Bad Request", "localhost:2222/blog/api/v1/find/0", "Kötü İstek");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.ok(iBlogGenericsService.blogServiceFindById(id));
    }

    // DELETE
    // localhost:4040/blog/api/v1/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> blogServiceDeleteById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iBlogGenericsService.blogServiceDeleteById(id));
    }

    // UPDATE
    // localhost:4040/blog/api/v1/update/1
    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> blogServiceUpdateById(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody BlogDto blogDto) {
        blogDto.setId(id);
        return ResponseEntity.ok(iBlogGenericsService.blogServiceUpdateById(id, blogDto));
    }

    ///////////////
    // SPEED
    // localhost:4040/blog/api/v1/speed/data
    @Override
    @GetMapping("/speed/data")
    public ResponseEntity<List<BlogDto>> speedDataService() {
        return ResponseEntity.ok(iBlogGenericsService.speedDataService());
    }

    // DELETE ALL
    // localhost:4040/blog/api/v1/all/delete
    @Override
    @GetMapping("/all/delete")
    public ResponseEntity<String> allDeleteService() {
        return ResponseEntity.ok(iBlogGenericsService.allDeleteService());
    }

    // APP INFORMATION
    // localhost:4040/blog/api/v1/app/information
    @Override
    @GetMapping("/app/information")
    public ResponseEntity<String> appInformationService(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(iBlogGenericsService.appInformationService(request, response));
    }

    /////////////////
    // PAGE, PAGEABLE
    @Override
    public ResponseEntity<List<BlogDto>> blogServiceAllList() {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(Pageable pageable, BlogDto blogDto) {
        return null;
    }

    @Override
    public ResponseEntity<Page<BlogDto>> blogServicePagination(Pageable pageable, Object d) {
        return null;
    }
}
