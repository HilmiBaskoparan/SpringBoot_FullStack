package com.hilmibaskoparan.business.service.impl;

import com.hilmibaskoparan.bean.ModelMapperBean;
import com.hilmibaskoparan.business.dto.BlogDto;
import com.hilmibaskoparan.business.service.IBlogGenericsService;
import com.hilmibaskoparan.data.entity.BlogEntity;
import com.hilmibaskoparan.data.repository.IBlogRepository;
import com.hilmibaskoparan.exception.BadRequestException;
import com.hilmibaskoparan.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor    // Injection
@Log4j2
@Service
public class BlogGenericsServiceImpl implements IBlogGenericsService<BlogDto, BlogEntity> {

    // INJECTION
    /* INJECTION 1.YOL
    @Autowired // Field Injection
    private ModelMapperBean modelMapperBean;
    */

    /* INJECTION 2.YOL
    private ModelMapperBean modelMapperBean;
    @Autowired // Constructor Injection
    public BlogServiceImpl(ModelMapperBean modelMapperBean) {
        this.modelMapperBean = modelMapperBean;
    }*/

    // final: 1) FIELD: sabit   2)METHOD: Override edemezsin    3)CLASS: extends yapamazsın.
    // final: field verdiğinizde zorunlu olarak biz constructor oluşturulmasını istiyoruz.
    private final ModelMapperBean modelMapperBean;
    private final IBlogRepository iBlogRepository;

    // ### Model Mapper ###############################
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return modelMapperBean.modelMapperMethod().map(blogEntity, BlogDto.class);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        return modelMapperBean.modelMapperMethod().map(blogDto, BlogEntity.class);
    }

    // ### CRUD ###############################
    // CREATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceCreate(BlogDto blogDto) {
        if (blogDto != null) {
            BlogEntity blogEntityModel = dtoToEntity(blogDto);
            BlogEntity blogEntity = iBlogRepository.save(blogEntityModel);
            blogDto.setId(blogEntity.getId());
            blogDto.setSystemDate(blogDto.getSystemDate());
        } else if (blogDto == null) {
            throw new BadRequestException("BlogDto yoktur");
        }
        return blogDto;
    }

    // LIST
    @Override
    public List<BlogDto> blogServiceList() {
        Iterable<BlogEntity> blogEntityIterable =  iBlogRepository.findAll();
        List<BlogDto> blogDtoList = new ArrayList<>();
        for (BlogEntity entity : blogEntityIterable) {
            BlogDto blogDto = entityToDto(entity);
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }

    // FIND
    @Override
    public BlogDto blogServiceFindById(Long id) {
        BlogEntity blogEntity = null;
        if (id != null) {
            blogEntity = iBlogRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException(id + " nolu ID bulunamadı."));
        } else if (id == null) {
            throw new BadRequestException(id + " BlogDto NULL Geldi."); // 400 Error
        }

        return entityToDto(blogEntity);
        /*return entityToDto(iBlogRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(id + " nolu ID bulunamadı.")));*/
    }

    // DELETE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceDeleteById(Long id) {
        BlogDto blogDto = blogServiceFindById(id);
        BlogEntity blogEntity = dtoToEntity(blogDto);
        iBlogRepository.delete(blogEntity);
        return blogDto;
    }

    // UPDATE
    @Transactional // Create, Delete, Update
    @Override
    public BlogDto blogServiceUpdateById(Long id, BlogDto blogDto) {
        BlogDto blogDtoFind = blogServiceFindById(id);
        BlogEntity blogEntity = dtoToEntity(blogDtoFind);

        if (blogEntity != null) {
            blogEntity.setId(id);
            blogEntity.setHeader(blogDto.getHeader());
            blogEntity.setContent(blogDto.getContent());
            iBlogRepository.save(blogEntity);
            blogDto.setId(blogEntity.getId());
            blogDto.setSystemDate(blogEntity.getSystemDate());
        }

        return entityToDto(blogEntity);
    }

    // ### PAGEABLE ###############################
    // List: pageable
    @Override
    public List<BlogDto> blogServiceAllList() {
        Iterable<BlogEntity> blogEntityList = iBlogRepository.findAll();
        List<BlogDto> blogDtoList = new ArrayList<>();

        for (BlogEntity blogEntity: blogEntityList) {
            BlogDto blogDto = entityToDto(blogEntity);
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }

    // List: Page page,size
    @Override
    public Page<BlogEntity> blogServicePagination(int currentPage, int pageSize) {
        return null;
    }

    // List: page, pageable
    @Override
    public Page<BlogEntity> blogServicePagination(Pageable pageable, BlogDto blogDto) {
        return null;
    }

    // ### PROFILE ###############################
    // ÇOKLU VERİ EKLE
    @Override
    public List<BlogDto> speedDataService() {
        List<BlogDto> blogDtoList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BlogDto blogDto = BlogDto.builder()
                    .header("header" + i)
                    .content("content" + i)
                    .build();
            blogServiceCreate(blogDto);
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }

    // ÇOKLU VERİ EKLE
    @Override
    public String allDeleteService() {
        iBlogRepository.deleteAll();
        log.info("Silindi");
        return "Silindi.";
    }

    // APP INFORMATION
    @Override
    public String appInformationService(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String localhost = request.getLocalAddr();
        String session = request.getSession().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri).append(" ").append(localhost).append(" ").append(session);
        return stringBuilder.toString();
    }
}
