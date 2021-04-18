package com.gildedrose.item_types.backstage.quality.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowSellInQualityCalculatorTest {

    private LowSellInQualityCalculator cut;

    @BeforeEach
    void setup() {
        cut = new LowSellInQualityCalculator();
    }

    @ParameterizedTest
    @CsvSource({"4,true", "5,true", "6,false", "7,false"})
    void applyTo(int sellIn, boolean expected) {
        boolean result = cut.applyTo(sellIn);
        assertEquals(expected, result);
    }

    @Test
    void getQualityUpdate() {
        int result = cut.getQualityUpdate();
        assertEquals(3, result);
    }

}
