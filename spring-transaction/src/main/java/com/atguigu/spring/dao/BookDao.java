package com.atguigu.spring.dao;

public interface BookDao {
    // 根据图书id查询价格
    Double getPriceByBookId(Integer bookId);
    // 更新bookid的库存
    void updateStock(Integer bookId);
    // 更新用户的余额
    void updataBalance(Integer userId, Double price);
}
