package com.gildedrose.item_types.backstage.quality;

import com.gildedrose.item_types.backstage.quality.calculator.HighSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.calculator.LowSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.calculator.MiddleSellInQualityCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QualityCalculatorProviderTest {

    @ParameterizedTest
    @CsvSource({"12,HighSellInQualityCalculator", "7,MiddleSellInQualityCalculator", "3,LowSellInQualityCalculator"})
    void getQualityCalculator(int sellIn, String expected) {
        QualityCalculatorProvider provider = new QualityCalculatorProvider(
                Arrays.asList(
                        new HighSellInQualityCalculator(),
                        new MiddleSellInQualityCalculator(),
                        new LowSellInQualityCalculator())
        );
        Optional<QualityCalculator> optinalResult = provider.getQualityCalculator(sellIn);
        assertTrue(optinalResult.isPresent());
        QualityCalculator calculator = optinalResult.get();
        assertEquals(expected, calculator.getClass().getSimpleName());
    }
}
