package com.von.api.proxy;

import java.util.function.Function;

public class TypeProxy {
    //mutale -> immutable로 바꿈
    public static Function<?,String> string = String::valueOf;

    //Integer.parseInt
    public static Function<String, Integer> integerOf = Integer::valueOf;
    public static Function<String, Double> doubleOf = Double::valueOf;
    public static Function<String, Float> floatOf = Float::valueOf;
}
