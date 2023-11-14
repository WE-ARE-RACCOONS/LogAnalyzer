package com.postgraduate.log.mongoDB.dto;

import com.postgraduate.log.mongoDB.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LogRequest {
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;

    public Log toEntity() {
        if (exceptionMessage == null)
            exceptionMessage = "";
        return new Log(logId, executeTime, methodName, exceptionMessage);
    }
}
