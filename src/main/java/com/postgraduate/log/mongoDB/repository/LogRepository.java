package com.postgraduate.log.mongoDB.repository;

import com.postgraduate.log.mongoDB.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
}