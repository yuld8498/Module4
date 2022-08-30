package com.example.musicapp.service;

import com.example.musicapp.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //        static {
//        try {
//            SessionFactory sessionFactory = new Configuration()
//                    .configure("hibernate.conf.xml")
//                    .buildSessionFactory();
//            sessionFactory.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public List<Song> findAll() {
        String Strquery = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(Strquery, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findASong(Long id) {
        String Strquery = "SELECT s FROM Song AS s WHERE s.id= :id";
        TypedQuery<Song> query = entityManager.createQuery(Strquery, Song.class);
        return query.getSingleResult();
    }

    @Override
    public void addASong(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List<Song> list = findAll();
            if (!list.equals(song)) {
                session.saveOrUpdate(song);
            } else {
                Song s = findASong(song.getId());
                s.setNameOfSong(song.getNameOfSong());
                s.setNameOfSinger(song.getNameOfSinger());
                s.setTypeOfSong(song.getTypeOfSong());
                s.setUrl(song.getUrl());
                session.saveOrUpdate(s);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Song UpdateASong(Song song) {
        return null;
    }

    @Override
    public Song choseASong(String Name) {
        return null;
    }

    @Override
    public void deleteASong(Song song) {

    }
}
