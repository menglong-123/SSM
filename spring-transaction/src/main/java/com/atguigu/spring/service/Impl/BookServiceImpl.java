package com.atguigu.spring.service.Impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/*
    声明式事务的配置步骤：
        1. 在Spring的配置文件中配置事务管理器
        2. 开启事务的注解驱动
        3. 然后在需要被事务管理的方法上，添加@Transactional，该方法就会被事务管理
        @Transactional可以标识在方法上，也可以标识在类上（此时该类中所有方法都被事务管理）
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Transactional(timeout = 3,
                isolation = Isolation.DEFAULT,
//            noRollbackFor = ArithmeticException.class,
//            noRollbackForClassName = "java.lang.ArithmeticException"
            propagation = Propagation.REQUIRES_NEW
    )
    public void buyBook(Integer userId, Integer bookId){
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // 查询图书的价格
        Double price = bookDao.getPriceByBookId(bookId);
        // 更新图书的库存
        bookDao.updateStock(bookId);
        // 更新用户的余额
        bookDao.updataBalance(userId, price);

//        System.out.println(1/0);
    }
}
