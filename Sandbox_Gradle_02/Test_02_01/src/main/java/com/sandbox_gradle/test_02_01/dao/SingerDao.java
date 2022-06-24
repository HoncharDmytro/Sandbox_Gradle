package com.sandbox_gradle.test_02_01.dao;

import com.sandbox_gradle.test_02_01.entities.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();

    void save(Singer singer);

    void delete(Singer singer);

//////////////////////////////////////////NamedQueries////////////////////////////////////////////////////////

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);
}