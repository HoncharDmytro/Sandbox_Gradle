package com.sandbox_gradle.test_02_01;

import com.sandbox_gradle.test_02_01.dao.SingerDao;
import com.sandbox_gradle.test_02_01.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        SingerDao singerDao = ctx.getBean(SingerDao.class);

        List<Singer> singers = singerDao.findAll();
        logger.info(" ---- Listing singers:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }

        System.in.read();
        ctx.close();
    }
}
