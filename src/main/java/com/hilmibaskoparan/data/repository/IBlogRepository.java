package com.hilmibaskoparan.data.repository;

import com.hilmibaskoparan.data.entity.BlogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBlogRepository extends CrudRepository<BlogEntity, Long> {

    // Delivered Query
    BlogEntity findByHeader(String header);

    // Query
    @Query("select b from BlogEntity b")
    List<BlogEntity> myBlogList();

    // Native

    // JPQL

}
