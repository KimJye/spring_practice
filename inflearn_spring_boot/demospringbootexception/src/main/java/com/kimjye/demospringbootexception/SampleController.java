package com.kimjye.demospringbootexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(){
        throw new SampleException();
    }

    // SampleController안에서 발생하는 SampleException이라는 예외가 발생하면 이 핸들러를 사용하겠다.
    @ExceptionHandler(SampleException.class)
    public AppError sampleError(SampleException e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReasone("I DONT KNOW");
        return appError;
    }
}
