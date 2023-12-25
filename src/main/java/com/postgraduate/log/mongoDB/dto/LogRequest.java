package com.postgraduate.log.mongoDB.dto;

public record LogRequest(String logId, Integer executeTime, String methodName, String exceptionMessage) {}
