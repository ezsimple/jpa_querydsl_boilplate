package com.example.demo2.api.hello.service;

import com.example.demo2.api.entity.CouponRandomEntity;
import com.example.demo2.api.hello.dto.UserDto;
import com.example.demo2.api.repository.CouponRandomRepository;
import com.example.demo2.api.repository.UserRepository;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    private UserRepository userRepository;
    private CouponRandomRepository couponRandomRepository;

    @Autowired
    public HelloService(UserRepository userRepository,
                        CouponRandomRepository couponRandomRepository) {
        this.userRepository = userRepository;
        this.couponRandomRepository = couponRandomRepository;
    }


    public List<UserDto> findByUserId(String id) {
        List<UserDto> list = userRepository.findByUserId(id).fetch();
        return list;
    }

    public List<CouponRandomEntity> bulkInsert() {
        List<CouponRandomEntity> coupons = new ArrayList<>();
        String key = String.valueOf(DateTimeUtils.currentTimeMillis());
        for (int i = 0; i < 2; i++) {
            CouponRandomEntity couponRandomEntity = new CouponRandomEntity();
            couponRandomEntity.setRandomCouponNo(key+i);
        }
        return couponRandomRepository.saveAll(coupons);
    }

}
