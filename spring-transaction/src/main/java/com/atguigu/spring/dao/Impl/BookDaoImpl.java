package com.atguigu.spring.dao.Impl;

import com.atguigu.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Double getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Double price = jdbcTemplate.queryForObject(sql, Double.class, bookId);
        return price;
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock - 1 where book_id = ?";
        int updated = jdbcTemplate.update(sql, bookId);
        System.out.println(updated);
    }

    @Override
    public void updataBalance(Integer userId, Double price) {
        String sql = "update user set balance = balance - ? where user_id = ?";
        int updated = jdbcTemplate.update(sql, price, userId);
        System.out.println(updated);
    }
}
