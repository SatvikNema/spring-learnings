package org.satvik.springDemo.demo.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImpl2 extends JdbcDaoSupport {
    public void getCount(){
        String query = "SELECT COUNT(*) FROM CIRCLE";
        Integer count = this.getJdbcTemplate().queryForObject(query, Integer.class);
        System.out.println("Number of circles: "+count);
    }
}
