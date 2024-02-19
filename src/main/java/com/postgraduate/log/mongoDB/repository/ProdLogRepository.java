package com.postgraduate.log.mongoDB.repository;

import com.postgraduate.log.mongoDB.entity.ProdLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdLogRepository extends MongoRepository<ProdLog, String> {
}