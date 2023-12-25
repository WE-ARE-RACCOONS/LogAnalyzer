package com.postgraduate.log.rabbitMQ.mqConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgraduate.log.mongoDB.dto.LogRequest;
import com.postgraduate.log.mongoDB.entity.Log;
import com.postgraduate.log.mongoDB.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.postgraduate.log.mongoDB.mapper.LogMapper.toError;
import static com.postgraduate.log.mongoDB.mapper.LogMapper.toInfo;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageConsumer {
    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void receive(String request) throws JsonProcessingException {
        LogRequest logRequest = objectMapper.readValue(request, LogRequest.class);
        log.info("Received message: {}", logRequest.toString());
        Log log = logRequest.exceptionMessage() == null ? toInfo(logRequest) : toError(logRequest);
        logRepository.save(log);
    }
}
