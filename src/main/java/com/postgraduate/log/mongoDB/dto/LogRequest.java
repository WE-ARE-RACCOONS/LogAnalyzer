package com.postgraduate.log.mongoDB.dto;

import com.postgraduate.log.mongoDB.entity.Env;

public record LogRequest(Env env, String logId, Integer executeTime, String methodName, String exceptionMessage) {}
