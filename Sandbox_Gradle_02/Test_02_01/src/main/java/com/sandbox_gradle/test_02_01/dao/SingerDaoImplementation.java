package com.sandbox_gradle.test_02_01.dao;

import com.sandbox_gradle.test_02_01.entities.Singer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("singerDao")
public class SingerDaoImplementation implements SingerDao {

    private static final Logger logger = LoggerFactory.getLogger(SingerDaoImplementation.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select s from Singer s", Singer.class)
                .getResultList();
    }

    public void save(Singer singer) {
        sessionFactory.getCurrentSession().persist(singer);
        logger.info("Singer saved with id: " + singer.getId());
    }

    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().remove(singer);
        logger.info("Singer deleted with id: " + singer.getId());
    }

//////////////////////////////////////////NamedQueries////////////////////////////////////////////////////////

    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory
                .getCurrentSession()
                .createNamedQuery("Singer.findAllWithAlbum", Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory
                .getCurrentSession()
                .createNamedQuery("Singer.findById", Singer.class)
                .setParameter("id", id)
                .uniqueResult();
    }
}
