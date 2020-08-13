package com.boz.repository;

import com.boz.bean.Vote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface VoteRepository extends MongoRepository<Vote,String> {


    //根据名称查找符合的一个
    Vote findByName(String name);

    //模糊查询
    List<Vote> findByNameLike(String name);


    //带分页的
    List<Vote> findByNameLike(String name, Pageable pageable);


    //查询部分字段的
    //value中的status表示要查询的字段，？0表示函数的第一个参数
    //fields中的name，status的值为1表示要查询的字段，0是不查询
    @Query(value = "{'status':?0}",fields = "{'name':1,'status':1}")
    List<Vote> findByStatus(String status);


    //查询大于
    List<Vote> findByStatusGreaterThan(int status);

    List<Vote> findByCreatetimeGreaterThan(Date date);

    //查询小于LessThan,Between（在…之间）,Not（不包含） ,Near（查询地理位置相近的）



}
