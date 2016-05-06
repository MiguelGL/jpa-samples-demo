package com.mgl.jpa.mapping.samples.support;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class BaseJpaTestSupport {

    private static final String PU_NAME = "com.mgl.jpa_mapping-samples_PU";

    private static EntityManagerFactory emf;

    private EntityManager em;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory(PU_NAME);
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void tearDown() {
        if (em != null) {
            EntityTransaction transaction = em.getTransaction();
            if (transaction.isActive()) {
                if (transaction.getRollbackOnly()) {
                    transaction.rollback();
                } else {
                    transaction.commit();
                }
            }
            em.close();
            em = null;
        }
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

}
