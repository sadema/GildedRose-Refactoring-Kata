package com.gildedrose.item_types.backstage.quality.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighSellInQualityCalculatorTest {

    private HighSellInQualityCalculator cut;

    @BeforeEach
    void setup() {
        cut = new HighSellInQualityCalculator();
    }

    @ParameterizedTest
    @CsvSource({"9,false", "10, true", "11,true", "12,true"})
    void applyTo(int sellIn, boolean expected) {
        boolean result = cut.applyTo(sellIn);
        assertEquals(expected, result);
    }

    @Test
    void getQualityUpdate() {
        int result = cut.getQualityUpdate();
        assertEquals(1, result);
    }

}
