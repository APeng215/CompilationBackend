package com.apeng.compilationbackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/compilation/api")
public class APIController {

    @PostMapping("/lexicalAnalysis")
    public String lexicalAnalyze(@RequestBody String rowString) throws IOException {
        System.out.println(rowString);
        return rowString;
    }

    @PostMapping("/llAnalysis")
    public String llAnalysis(@RequestBody String rowString) throws IOException {
        System.out.println(rowString);
        return rowString;
    }

    @PostMapping("/operatorFirstAnalysis")
    public String operatorFirstAnalysis(@RequestBody String rowString) throws Exception {
        System.out.println(rowString);
        return rowString;
    }

    @PostMapping("/lrAnalysis")
    public String lrAnalysis(@RequestBody String rowString) throws Exception {
        System.out.println(rowString);
        return rowString;
    }



}

