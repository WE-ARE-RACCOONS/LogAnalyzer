package com.postgraduate.log.mongoDB.service;

import com.postgraduate.log.mongoDB.entity.Log;
import com.postgraduate.log.mongoDB.entity.ProdLog;
import com.postgraduate.log.mongoDB.repository.LogRepository;
import com.postgraduate.log.mongoDB.repository.ProdLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogSaveService {
    private final LogRepository logRepository;
    private final ProdLogRepository prodLogRepository;

    public void saveDev(Log log) {
        logRepository.save(log);
    }

    public void saveProd(ProdLog log) {
        prodLogRepository.save(log);
    }
}
