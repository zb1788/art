package com.boz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("testLogLevel")
    public String testLogLevel(){

        logger.error("error:{}","error level");
        logger.info("info:{}","info level");
        logger.debug("debug:{}","debug level");
        System.out.println("this is print log");
        return null;
    }
}
