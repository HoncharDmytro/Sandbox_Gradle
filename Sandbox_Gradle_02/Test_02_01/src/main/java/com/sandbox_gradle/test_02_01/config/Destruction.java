package com.sandbox_gradle.test_02_01.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Destruction {
    private final Logger logger = LoggerFactory.getLogger(Destruction.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void getSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    //@PreDestroy
    public final void clearDB() {
        logger.info(" ... Deleting database files.");

        String sqlQuery = "TRUNCATE hibernate.singer;" +
                "TRUNCATE hibernate.album;" +
                "TRUNCATE hibernate.instrument;" +
                "TRUNCATE hibernate.singer_instrument;";
        sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);

        logger.info(" ... Database has bean cleared.");
    }

}
