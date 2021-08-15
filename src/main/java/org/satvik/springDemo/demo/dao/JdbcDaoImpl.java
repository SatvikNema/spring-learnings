package org.satvik.springDemo.demo.dao;

import org.apache.derby.jdbc.ClientDriver;
import org.satvik.springDemo.demo.pojo.CircleTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

    public void getCount(){
        String query = "SELECT COUNT(*) FROM CIRCLE";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class);
        System.out.println("Number of circles: "+count);
    }

    public void getCircleTempJdbc(int id){
        String query = "SELECT name FROM circle where id = ?";
        System.out.println(query+" ->");
        String circleName = jdbcTemplate.queryForObject(query, new Object[]{id}, String.class);
        System.out.println("name of circle with id "+id+" is: "+circleName);

        query = "\nSELECT * from circle where id = ?";
        System.out.println(query+" ->");
        CircleTemp circleTemp = jdbcTemplate.queryForObject(query, new Object[]{id}, new CircleMapper());
        System.out.println(circleTemp.toString());

        query = "\nSELECT * FROM CIRCLE";
        System.out.println(query+" ->");
        List<CircleTemp> circleTemps = jdbcTemplate.query(query, new CircleMapper());
        circleTemps.forEach(System.out::println);
    }

    public CircleTemp getCircleTemp(int id) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CIRCLE WHERE ID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            CircleTemp circleTemp = null;
            if (rs.next()) {
                circleTemp = new CircleTemp(id, rs.getString("name"));
            }
            circleTemp.setName(circleTemp.getName().trim());
            rs.close();
            ps.close();
            return circleTemp;
        } catch(Exception e){
            System.out.println("error: "+e);
            return null;
        } finally {
            try {
                conn.close();
            }catch(SQLException e){
                System.out.println("error while closing the connection");
            }
        }
    }

    private static final class CircleMapper implements RowMapper<CircleTemp> {

        @Override
        public CircleTemp mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            CircleTemp circle = new CircleTemp();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));
            return circle;
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertCircle(CircleTemp circle){
        String query = "insert into circle (id, name) values (?, ?)";
        jdbcTemplate.update(query, circle.getId(), circle.getName());
    }
}

