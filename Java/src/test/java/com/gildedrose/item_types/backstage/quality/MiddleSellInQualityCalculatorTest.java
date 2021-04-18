package com.gildedrose.item_types.backstage.quality;

import com.gildedrose.item_types.backstage.quality.calculator.MiddleSellInQualityCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MiddleSellInQualityCalculatorTest {

    @Test
    void applyToWithValidSellIn() {
        MiddleSellInQualityCalculator qualityCalculator = new MiddleSellInQualityCalculator();
        boolean result = qualityCalculator.applyTo(7);
        assertTrue(result);
    }

    @Test
    void applyToWithInValidSellIn() {
        MiddleSellInQualityCalculator qualityCalculator = new MiddleSellInQualityCalculator();
        boolean result = qualityCalculator.applyTo(12);
        assertFalse(result);
    }

    @Test
    void updateQuality() {
    }
}
