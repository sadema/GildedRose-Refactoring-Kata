package com.gildedrose.item_types.agedbrie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieItemTest {

    @ParameterizedTest
    @CsvSource({"48,49", "49,50", "50,50"})
    void updateQuality(int quality, int expected) {
        AgedBrieItem item = AgedBrieItem.of(0, quality);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"46,48", "47,49", "48,50", "49,50", "50,50"})
    void updateQualityWithNegativeSellIn(int quality, int expected) {
        AgedBrieItem item = AgedBrieItem.of(-1, quality);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,2", "2,1", "1,0", "0,-1", "-1,-2"})
    void updateSellIn(int sellIn, int expected) {
        AgedBrieItem item = AgedBrieItem.of(sellIn, 20);
        item.updateSellIn();
        assertEquals(expected, item.getSellIn());
    }
}
