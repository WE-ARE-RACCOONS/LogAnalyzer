package com.postgraduate.log.mongoDB.usecase;

import com.postgraduate.log.mongoDB.dto.LogRequest;
import com.postgraduate.log.mongoDB.entity.Log;
import com.postgraduate.log.mongoDB.entity.ProdLog;
import com.postgraduate.log.mongoDB.service.LogSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.postgraduate.log.mongoDB.entity.Env.DEV;
import static com.postgraduate.log.mongoDB.mapper.LogMapper.*;

@RequiredArgsConstructor
@Service
@Transactional
public class LogManageUseCase {
    private final LogSaveService logSaveService;

    public void logSave(LogRequest request) {
        if (request.env().equals(DEV)) {
            Log log = request.exceptionMessage() == null ? toInfo(request) : toError(request);
            logSaveService.saveDev(log);
            return;
        }
        ProdLog log = request.exceptionMessage() == null ? toProdInfo(request) : toProdError(request);
        logSaveService.saveProd(log);
    }
}
