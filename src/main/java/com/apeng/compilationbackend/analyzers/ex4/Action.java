package com.apeng.compilationbackend.analyzers.ex4;

public record Action(int state, String symbol, String operator) {
    @Override
    public String toString() {
        return "{" +
                "state=" + state +
                ", symbol='" + symbol + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
