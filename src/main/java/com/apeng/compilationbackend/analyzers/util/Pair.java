package com.apeng.compilationbackend.analyzers.util;

public record Pair<A, B>(A first, B second) {

    public String toString() {
        return "(" + first + ", " + second + ")";
    }


}
