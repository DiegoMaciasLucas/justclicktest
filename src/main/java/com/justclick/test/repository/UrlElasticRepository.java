package com.justclick.test.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.justclick.test.model.ElasticFinal;
/**
 * *********************************************************************************************************
 * Name: UrlElasticRepository 
 * Description:ElasticsearchRepository class that permit to save data in the index
 * *********************************************************************************************************
 */
@Repository
public interface UrlElasticRepository extends ElasticsearchRepository<ElasticFinal, String> {

}
