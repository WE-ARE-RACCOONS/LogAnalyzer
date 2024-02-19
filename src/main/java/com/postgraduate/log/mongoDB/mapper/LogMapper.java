package com.postgraduate.log.mongoDB.mapper;

import com.postgraduate.log.mongoDB.dto.LogRequest;
import com.postgraduate.log.mongoDB.entity.Log;
import com.postgraduate.log.mongoDB.entity.ProdLog;

public class LogMapper {
    public static Log toInfo(LogRequest request) {
        return new Log(request.logId(), request.executeTime(), request.methodName());
    }

    public static Log toError(LogRequest request) {
        return new Log(request.logId(), request.executeTime(), request.methodName(), request.exceptionMessage());
    }

    public static ProdLog toProdInfo(LogRequest request) {
        return new ProdLog(request.logId(), request.executeTime(), request.methodName());
    }

    public static ProdLog toProdError(LogRequest request) {
        return new ProdLog(request.logId(), request.executeTime(), request.methodName(), request.exceptionMessage());
    }
}
