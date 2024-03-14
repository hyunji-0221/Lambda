package com.von.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Double, Double> absDouble = Math::abs;

    //Math.min / Math.max
    public static BiFunction<Integer,Integer,Integer> maxInt = Math::max;
    public static BiFunction<Double,Double,Double> maxDouble = Math::max;
    public static BiFunction<Long,Long,Long> maxLong = Math::max;
    public static BiFunction<Float,Float,Float> maxFloat = Math::max;

    //외부 값 없는 double 랜덤
    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer,Integer,Integer> randomInt = (a,b) ->(int)(Math.random() * (b-a) +a);

    //Math.ceil
    public static Function<Double,Double> ceilDouble = Math::ceil;


    //Math.floor
    public static Function<Double,Double> floorDouble = Math::floor;

    //Math.round
    public static Function<Double,Long> roundDouble = Math::round;
    public static Function<Float,Integer> roundFloat = Math::round;

    //double


    //Integer.parseInt 외 숫자 관련된 메소드 전부 작성
}
