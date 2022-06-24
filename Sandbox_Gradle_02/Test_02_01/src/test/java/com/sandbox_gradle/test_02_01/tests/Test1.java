package com.sandbox_gradle.test_02_01.tests;

import com.sandbox_gradle.test_02_01.config.Config;
import com.sandbox_gradle.test_02_01.dao.SingerDao;
import com.sandbox_gradle.test_02_01.entities.Album;
import com.sandbox_gradle.test_02_01.entities.Singer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test1 {
    private static final Logger logger = LoggerFactory.getLogger(Test1.class);

    private static GenericApplicationContext ctx;
    private static SingerDao singerDao;

    @BeforeAll
    static void setUp(){
        ctx = new AnnotationConfigApplicationContext(Config.class);
        singerDao = ctx.getBean(SingerDao.class);
        Assertions.assertNotNull(singerDao);
    }

    @Test
    public void testFindAll(){
        List<Singer> singers = singerDao.findAll();
        Assertions.assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum(){
        List<Singer> singers = singerDao.findAllWithAlbum();
        Assertions.assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindByID(){
        Singer  singer = singerDao.findById(1L);
        Assertions.assertNotNull(singer);
        logger.info(singer.toString());
    }

    @Test
    public void testInsert(){
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, Calendar.SEPTEMBER, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1961, Calendar.AUGUST, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1962, Calendar.APRIL, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);
        Assertions.assertNotNull(singer.getId());

        List<Singer> singers = singerDao.findAllWithAlbum();
        Assertions.assertEquals(4, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testUpdate(){
        Singer singer = singerDao.findById(1L);
        Assertions.assertNotNull(singer);
        Assertions.assertEquals("Mayer", singer.getLastName());
        Album album = singer.getAlbums().stream().filter(a -> a.getTitle().equals("Battle Studies"))
                .findFirst().orElse(null);

        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @Test
    public void testDelete(){
        Singer singer = singerDao.findById(4L);
        //making sure such singer exists
        Assertions.assertNotNull(singer);
        singerDao.delete(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }


    private static void listSingers(List<Singer> singers) {
        logger.info(" ---- Listing singers:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            logger.info(s.toString());
            if (s.getAlbums() != null) {
                s.getAlbums().forEach(a -> logger.info("\t" + a.toString()));
            }
            if (s.getInstruments() != null) {
                s.getInstruments().forEach(i -> logger.info("\tInstrument: " + i.getInstrumentId()));
            }
        });
    }

    @AfterAll
    static void tearDown(){
        ctx.close();
    }
}
