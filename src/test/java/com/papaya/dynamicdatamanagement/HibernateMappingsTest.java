package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.repository.FormDetailsRepository;
import io.hypersistence.optimizer.HypersistenceOptimizer;
import io.hypersistence.optimizer.core.config.JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootTest
public class HibernateMappingsTest {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private FormDetailsRepository formDetailsRepository;

    @PostConstruct
    void init() {
        new HypersistenceOptimizer(
                new JpaConfig(entityManagerFactory)
        );
    }

    @Test
    public void test() {
        formDetailsRepository.findAll();
    }
}
