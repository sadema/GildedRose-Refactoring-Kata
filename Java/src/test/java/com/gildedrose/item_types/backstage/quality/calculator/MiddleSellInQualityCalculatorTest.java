package com.gildedrose.item_types.backstage.quality.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleSellInQualityCalculatorTest {

    private MiddleSellInQualityCalculator cut;

    @BeforeEach
    void setup() {
        cut = new MiddleSellInQualityCalculator();
    }

    @ParameterizedTest
    @CsvSource({"5,true", "6,true", "7,true", "8,true", "9,true", "10, false", "11,false"})
    void applyTo(int sellIn, boolean expected) {
        boolean result = cut.applyTo(sellIn);
        assertEquals(expected, result);
    }

    @Test
    void getQualityUpdate() {
        int result = cut.getQualityUpdate();
        assertEquals(2, result);
    }

}
