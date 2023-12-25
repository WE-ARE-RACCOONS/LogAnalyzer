package com.postgraduate.log.mongoDB.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.postgraduate.log.mongoDB.entity.LogType.ERROR;
import static com.postgraduate.log.mongoDB.entity.LogType.INFO;

@Document(collection = "log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Log {
    @Id
    private String id;
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;
    private LogType logType;
    @Indexed(expireAfterSeconds = 60*60*24*30) //30일
    private LocalDateTime logDate = LocalDateTime.now().plusHours(9);

    public Log(String logId, Integer executeTime, String methodName, String exceptionMessage) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
        this.logType = ERROR;
        this.exceptionMessage=exceptionMessage;
    }

    public Log(String logId, Integer executeTime, String methodName) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
        this.logType = INFO;
    }
}
