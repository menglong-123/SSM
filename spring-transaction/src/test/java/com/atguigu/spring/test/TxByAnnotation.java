package com.atguigu.spring.test;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annatation.xml")
public class TxByAnnotation {
    @Autowired
    private BookController bookController;

    @Test
    public void testByBook(){
//        bookController.buyBook(1,2);
        bookController.check(1,new Integer[]{1,2});
    }
}
