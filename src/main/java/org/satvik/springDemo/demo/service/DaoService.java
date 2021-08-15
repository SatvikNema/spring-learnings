package org.satvik.springDemo.demo.service;

import org.satvik.springDemo.demo.dao.JdbcDaoImpl;
import org.satvik.springDemo.demo.pojo.CircleTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DaoService {

    @Autowired
    private JdbcDaoImpl jdbcDaoImpl;

    public void getCircle(int id){
        CircleTemp circleTemp = jdbcDaoImpl.getCircleTemp(id);
        System.out.println(circleTemp.toString());
    }

    public void getCount(){
        jdbcDaoImpl.getCount();
    }

    public void getCircleTempJdbc(int id){
        jdbcDaoImpl.getCircleTempJdbc(id);
    }

    public void insertCircle(CircleTemp circle){
        jdbcDaoImpl.insertCircle(circle);
    }
}
