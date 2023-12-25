package com.postgraduate.log.mongoDB.mapper;

import com.postgraduate.log.mongoDB.dto.LogRequest;
import com.postgraduate.log.mongoDB.entity.Log;

public class LogMapper {
    public static Log toInfo(LogRequest request) {
        return new Log(request.logId(), request.executeTime(), request.methodName());
    }

    public static Log toError(LogRequest request) {
        return new Log(request.logId(), request.executeTime(), request.methodName(), request.exceptionMessage());
    }
}
