package com.postgraduate.log.mongoDB.presentation;

import com.postgraduate.log.mongoDB.dto.LogRequest;
import com.postgraduate.log.mongoDB.usecase.LogManageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController {
    private final LogManageUseCase logManageUseCase;

    @PostMapping("/save")
    public void save(@RequestBody LogRequest logRequest) {
        logManageUseCase.logSave(logRequest);
    }
}
