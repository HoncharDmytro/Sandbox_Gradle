package com.sandbox_gradle.test_02_01.dao;

import com.sandbox_gradle.test_02_01.entities.Singer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        return sessionFactory.getCurrentSession().createQuery("select s from Singer s").list();
    }

    public void save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with id: " + singer.getId());
    }

    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer deleted with id: " + singer.getId());
    }

//////////////////////////////////////////NamedQueries////////////////////////////////////////////////////////

    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findById").
                setParameter("id", id).uniqueResult();
    }
}
