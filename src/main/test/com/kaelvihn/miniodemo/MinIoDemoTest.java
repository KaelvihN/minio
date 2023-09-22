package com.kaelvihn.miniodemo;

import com.kaelvihn.miniodemo.config.MinioConfig;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : KaelvihN
 * @date : 2023/9/22 19:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MinIoDemoTest {
    @Resource
    private MinioConfig minioConfig;
    @Test
    public void test(){
        System.out.println("minioConfig = " + minioConfig);
    }
}
