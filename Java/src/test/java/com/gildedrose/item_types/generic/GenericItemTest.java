package com.gildedrose.item_types.generic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericItemTest {

    @ParameterizedTest
    @CsvSource({"4,3", "3,2", "2,1", "1,0", "0,0", "-1,0", "-2,0"})
    void updateQuality(int quality, int expected) {
        GenericItem item = GenericItem.of("any name", 0, quality);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"4,2", "3,1", "2,0", "1,0", "0,0", "-1,0", "-2,0"})
    void updateQualityWithNegativeSellIn(int quality, int expected) {
        GenericItem item = GenericItem.of("any name", -1, quality);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,2", "2,1", "1,0", "0,-1", "-1,-2"})
    void updateSellIn(int sellIn, int expected) {
        GenericItem cut = GenericItem.of("any name", sellIn, 0);
        cut.updateSellIn();
        assertEquals(expected, cut.getSellIn());
    }

}
