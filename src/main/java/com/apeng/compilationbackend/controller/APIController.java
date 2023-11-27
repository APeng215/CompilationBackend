package com.apeng.compilationbackend.controller;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.apeng.compilationbackend.analyzers.ex1.LexicalAnalyzer;
import com.apeng.compilationbackend.analyzers.ex2.LLAnalyzer;
import com.apeng.compilationbackend.analyzers.ex3.OperatorFirstAnalyzer;
import com.apeng.compilationbackend.analyzers.ex4.LRAnalyzer;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/compilation/api")
public class APIController {

    @PostMapping("/lexicalAnalysis")
    public String lexicalAnalyze(@RequestBody String rowString) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(rowString);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("preProcessedString", lexicalAnalyzer.getPreProcessedString());
        jsonObject.put("key2Code", lexicalAnalyzer.getKey2CodeStr());
        jsonObject.put("result", lexicalAnalyzer.getResult());
        return jsonObject.toString(JSONWriter.Feature.PrettyFormat);
    }

    @PostMapping("/llAnalysis")
    public String llAnalysis(@RequestBody String rowString) {
        LLAnalyzer llAnalyzer = new LLAnalyzer(rowString);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstSets", llAnalyzer.getFirstSetsStr());
        jsonObject.put("followSets", llAnalyzer.getFollowSetsStr());
        jsonObject.put("analyzingTable", llAnalyzer.getAnalyzingTableStr());
        jsonObject.put("analysisResult", llAnalyzer.getAnalysisResult().toString());
        return jsonObject.toString(JSONWriter.Feature.PrettyFormat);
    }

    @PostMapping("/operatorFirstAnalysis")
    public String operatorFirstAnalysis(@RequestBody String rowString) throws Exception {
        OperatorFirstAnalyzer operatorFirstAnalyzer = new OperatorFirstAnalyzer(rowString);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSentenceCorrect", operatorFirstAnalyzer.isSentenceCorrect());
        jsonObject.put("firstvtSet", operatorFirstAnalyzer.getFirstvtSetStr());
        jsonObject.put("lastvtSet", operatorFirstAnalyzer.getLastvtSetStr());
        jsonObject.put("priorityTable", operatorFirstAnalyzer.getPriorityTableStr());
        jsonObject.put("analysisResult", operatorFirstAnalyzer.getAnalysisResult());
        return jsonObject.toString(JSONWriter.Feature.PrettyFormat);
    }

    @PostMapping("/lrAnalysis")
    public String lrAnalysis(@RequestBody String rowString) {
        LRAnalyzer lrAnalyzer = new LRAnalyzer(rowString);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("C", lrAnalyzer.getCStr());
        jsonObject.put("analysisTable", lrAnalyzer.getAnalysisTable().toString());
        jsonObject.put("analysisProcess", lrAnalyzer.getAnalysisProcess().toString());
        return jsonObject.toString(JSONWriter.Feature.PrettyFormat);
    }



}

