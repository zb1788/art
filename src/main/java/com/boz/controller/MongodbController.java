package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.bean.Vote;
import com.boz.repository.VoteRepository;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mongodb")
public class MongodbController {

    //复杂查询用template
    @Autowired
    private MongoTemplate mongoTemplate;

    //简单查询用仓库
    @Autowired
    private VoteRepository voteRepository;


    //查询所有的
    @RequestMapping("findall")
    public JSONResult findall(){
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"status"));
        List<Vote> lists = voteRepository.findAll();
        return JSONResult.ok(lists);
    }

    //查询总数
    @RequestMapping("count")
    public JSONResult count(){
        long size = voteRepository.count();
        int count = Integer.valueOf(String.valueOf(size));
        System.out.println(count);

        Map map = new HashMap();
        map.put("total",count);
        return JSONResult.ok(map);
    }

    //查询所有的带分页
    @RequestMapping("findAllByPage")
    public JSONResult findAllByPage(){
        Integer page = 1;
        Integer rows = 2;
        PageRequest pageRequest = new PageRequest(page-1,rows);
        Page<Vote> p = voteRepository.findAll(pageRequest);

        //总条数
        long total = p.getTotalElements();

        List<Vote> lists = p.getContent();

        Map map = new HashMap();
        map.put("total",total);
        map.put("lists",lists);

        return JSONResult.ok(map);
    }


    //通过name查询
    @RequestMapping("findByNameSimple")
    public JSONResult findByNameSimple(){
        //1.简单查询
        //用name是应为bean里面字段为name
        Vote v = voteRepository.findByName("语文共享圈投票项列表");
        System.out.println(v);
        return JSONResult.ok(v);
    }


    @RequestMapping("findByName")
    public JSONResult findByName(){
        //2.复杂查询
        Query query = new Query(Criteria.where("title").is("语文共享圈投票项列表"));
        Vote a = mongoTemplate.findOne(query, Vote.class);
        System.out.println(a.toString());
        return JSONResult.ok(a);
    }


    //根据名字模糊查询
    @RequestMapping("findByNameLike")
    public JSONResult findByNameLike(){
        List<Vote> lists = voteRepository.findByNameLike("的");
        System.out.println(lists);

        //模糊查询
//        String pattern_name = "的";
//        Pattern pattern= Pattern.compile("^.*"+pattern_name+".*$", Pattern.CASE_INSENSITIVE);
//
//        Query query = new Query(Criteria.where("title").regex(pattern));
//        List<Vote> a = mongoTemplate.find(query, Vote.class);

        return JSONResult.ok(lists);
    }

    //排序
    @RequestMapping("findByNameSort")
    public JSONResult findByNameSort(){
        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC,"status")));
        List<Vote> lists = mongoTemplate.find(query, Vote.class);
        return JSONResult.ok(lists);
    }


    //带分页的模糊查询
    @RequestMapping("findByNameLikePage")
    public JSONResult findByNameLikePage(){
        Integer page = 1;
        Integer rows = 1;
        PageRequest pageRequest = new PageRequest(page-1,rows);

        //排序的话在page里加入sort
//        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"status"));
//        PageRequest pageRequest2 = new PageRequest(page-1,rows,sort);
        List<Vote> lists = voteRepository.findByNameLike("的",pageRequest);

        return JSONResult.ok(lists);
    }


    //查询小于LessThan,Between（在…之间）,Not（不包含） ,Near（查询地理位置相近的）

    @RequestMapping("updateDb")
    public JSONResult updateDb(){
        Query query = new Query(Criteria.where("id").is("5c1c9491d5397b35bfce5405"));
        Update update = new Update().set("name","爱爱爱");
        //更改单个
        mongoTemplate.updateFirst(query,update, Vote.class);
        //更改多个
        //mongoTemplate.updateMulti(query,update, Vote.class);


        return JSONResult.ok();
    }


//    插入重复数据
//　　insert: 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
//    save: 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作。
//
//    批操作
//　　insert: 可以一次性插入一整个列表，而不用进行遍历操作，效率相对较高
//　　save: 需要遍历列表，进行一个个的插入

    //增加
    @RequestMapping("add")
    public JSONResult add(){
        Vote v = new Vote();
        v.setName("aa");
        v.setStatus("2");

        List<Vote> lists = new ArrayList<>();
        lists.add(v);

        //单独增加一条
        mongoTemplate.save(v);
        //单独增加一条
        mongoTemplate.insert(v);
        //批量增加
        mongoTemplate.insert(lists,"auxsys_vote");
        return JSONResult.ok();
    }


    @RequestMapping("addSimple")
    public JSONResult addSimple(){
        Vote v = new Vote();
        v.setName("aa");
        v.setStatus("2");
        //如果不传id就是新增，传id就是更新
        mongoTemplate.save(v);
        return JSONResult.ok();
    }


    //删除
    @RequestMapping("delteSimple")
    public JSONResult delteSimple(){
        voteRepository.delete("5c53f6926e0781494cf01709");
        return JSONResult.ok();
    }


    //删除
    @RequestMapping("deleteById")
    public JSONResult delteById(){
        Query query = new Query(Criteria.where("id").is("5c53f50a6e078129c884df5a"));
        mongoTemplate.remove(query,Vote.class);
        return JSONResult.ok();
    }


    //复杂查询
    //聚合
    public JSONResult getGroupData(){
        Criteria ca = Criteria.where("classId").is("140687834519428108").and("subjectCode").is("0002").and("createTime").is("20180329");

        List<AggregationOperation> operations = new ArrayList<>();
        operations.add(Aggregation.match(ca));
        operations.add(Aggregation.group(new String[]{"username", "trueName", "reportId", "classId", "subjectCode", "createTime"}).sum("praiseNum").as("praiseNum"));
        operations.add(Aggregation.sort(Sort.Direction.DESC,"praiseNum"));

        Aggregation aggregation = Aggregation.newAggregation(operations);
        AggregationResults aggreResult = mongoTemplate.aggregate(aggregation,"praiseRecord", BasicDBObject.class);
        List list = aggreResult.getMappedResults();
        System.out.println(list);
        return JSONResult.ok(list);
    }


}
