package com.sandbox_gradle.test_02_01.dao;

import com.sandbox_gradle.test_02_01.entities.Instrument;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImplementation implements InstrumentDao {

    private static final Logger logger = LoggerFactory.getLogger(InstrumentDaoImplementation.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override public void save(Instrument instrument) {
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        logger.info("Instrument saved with id: " + instrument.getInstrumentId());
    }
}