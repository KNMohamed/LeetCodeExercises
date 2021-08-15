package com.leetcode.challenges.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Timeout(value = 20, unit= TimeUnit.MILLISECONDS)
public class BestSumTest {

    private BestSum bestSum;

    @BeforeEach
    public void setUp(){
        bestSum = new BestSum();
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForBestSum")
    public void bestSumWithHighComplexity(int targetSum, List<Integer> numbers, List<Integer> expectedResult){
        List<Integer> result = bestSum.solve(targetSum,numbers);
        Collections.sort(result);  //O(NLogN)
        assertEquals(expectedResult,result);
    }

    private static Stream<Arguments> provideArgumentsForBestSum(){
        return Stream.of(
            Arguments.of(7,Arrays.asList(5,3,4,7),Arrays.asList(7)),
            Arguments.of(8,Arrays.asList(2,3,5),Arrays.asList(3,5)),
            Arguments.of(8,Arrays.asList(1,4,5),Arrays.asList(4,4)),
            Arguments.of(100,Arrays.asList(1,2,5,25),Arrays.asList(25,25,25,25))
        );
    }
}

