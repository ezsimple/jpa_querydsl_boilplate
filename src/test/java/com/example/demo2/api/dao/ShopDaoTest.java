package com.example.demo2.api.dao;

import com.example.demo2.api.entity.CustomerEntity;
import com.example.demo2.api.entity.ShopEntity;
import com.example.demo2.api.repository.CustomerRepository;
import com.example.demo2.api.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RequiredArgsConstructor
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopDaoTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopDao shopDao;

    @AfterEach
    void after() {
//        customerRepository.deleteAllInBatch();
//        shopRepository.deleteAllInBatch();
    }

    @BeforeEach
    void setUp() {
        CustomerEntity customer = (new CustomerEntity("거래처번호(업주번호)", "거래처명(상호)", "사업자번호", "대표자명"));
        customer = customerRepository.save(customer);

        ShopEntity shop = shopRepository.save(new ShopEntity("1", "name", customer));
        shopRepository.save(shop);
    }

    @Test
    void test() {
        List<String> result = shopDao.crossJoin().fetch();
        log.debug("{}", result);
    }

    @AfterEach
    void tearDown() {
    }


}