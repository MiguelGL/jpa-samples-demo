package com.mgl.jpa.mapping.samples.support;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@Accessors(fluent = true)
public abstract class BaseJpaTestSupport {

    private static final String DB_SPEC_SYSPROP = "db-spec";

    private static final String MYSQL_DB_SPEC = "mysql";
    private static final String DERBY_DB_SPEC = "derby";

    private static EntityManagerFactory emf;

    @Getter private EntityManager em;

    @BeforeClass
    public static void setUpClass() {
        String dbSpec = System.getProperty(DB_SPEC_SYSPROP, MYSQL_DB_SPEC);
        String PU_NAME;
        switch (dbSpec) {
            case MYSQL_DB_SPEC:
                PU_NAME = "com.mgl.jpa_mapping-samples_PU";
                break;
            case DERBY_DB_SPEC:
                PU_NAME = "com.mgl.jpa_mapping-samples_inmemory-PU";
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unsupported db spec. '%s'", dbSpec));
        }
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
