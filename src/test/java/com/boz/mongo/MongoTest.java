package com.boz.mongo;

import com.boz.bean.Vote;
import com.boz.repository.VoteRepository;
import com.mongodb.BasicDBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private VoteRepository voteRepository;


    @Test
    public void testFindByName(){
//        语文共享圈投票项列表

        Vote v = new Vote();
        v.setId("5c53f4ad6e0781292c8e9251");
        v.setName("aabbbb");
//        v.setStatus("3");

        List<Vote> lists = new ArrayList<>();
        lists.add(v);

        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC,"status")));
//        List<Vote> lists2 = mongoTemplate.find(query, Vote.class);
//        System.out.println(lists2);


        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"status"));

        Integer page = 1;
        Integer rows = 2;
        PageRequest pageRequest = new PageRequest(page-1,rows,sort);

//        List<Vote> lists1 = voteRepository.findAll(sort);


//        System.out.println(lists1);


        Page<Vote> p = voteRepository.findAll(pageRequest);
        List<Vote> lists1 = p.getContent();

        System.out.println(lists1);


//        String pattern_name = "的";
//        Pattern pattern= Pattern.compile("^.*"+pattern_name+".*$", Pattern.CASE_INSENSITIVE);
//
//        Query q = new Query();
//        q.addCriteria(Criteria.where("title").regex(pattern));
//        q.with(new Sort(new Sort.Order(Sort.Direction.ASC,"status")));

//        Query query = new Query(Criteria.where("title").regex(pattern));
//        List<Vote> a = mongoTemplate.find(q, Vote.class);
//        System.out.println(a);

//        Aggregation agg = newAggregation(
//                unwind("$options"),
//                match(Criteria.where("id").is("5c1c9491d5397b35bfce5405").and("options.optionorder").is("0")),
//                project("options")
//        );
//        AggregationResults<Object> results = mongoTemplate.aggregate(agg, "auxsys_vote", Object.class);
//        List<Object> resultList = results.getMappedResults();
//
//        System.out.println(resultList);
//        Query query = new Query(Criteria.where("id").is("5c53f50a6e078129c884df5a"));
//        mongoTemplate.remove(query,Vote.class);

//        mongoTemplate.insert(lists,"auxsys_vote");
//        mongoTemplate.insert(lists,Vote.class);


//        voteRepository.save(v);

//        System.out.println(voteRepository.findAll());
//        System.out.println(voteRepository.count());

//          voteRepository.delete("5c53f6926e0781494cf01709");

//          voteRepository.save(v);

    }



    @Test
    public void testGroup(){
        Criteria ca = Criteria.where("classId").is("140687834519428108").and("subjectCode").is("0002").and("createTime").is("20180329");

        List<AggregationOperation> operations = new ArrayList<>();
        operations.add(Aggregation.match(ca));
        operations.add(Aggregation.group(new String[]{"username", "trueName", "reportId", "classId", "subjectCode", "createTime"}).sum("praiseNum").as("praiseNum"));
        operations.add(Aggregation.sort(Sort.Direction.DESC,"praiseNum"));

        Aggregation aggregation = Aggregation.newAggregation(operations);
        AggregationResults aggreResult = mongoTemplate.aggregate(aggregation,"praiseRecord", BasicDBObject.class);
        List list = aggreResult.getMappedResults();
        System.out.println(list);
    }

}
