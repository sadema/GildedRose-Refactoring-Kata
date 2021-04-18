package com.gildedrose.item_types.conjured;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemTest {

    @ParameterizedTest
    @CsvSource({"3,1", "2,0", "1,0", "0,0", "-1,0"})
    void updateQuality(int quality, int expected) {
        ConjuredItem item = ConjuredItem.of("Conjured Mana Cake", 0, quality);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,2", "2,1", "1,0", "0,-1", "-1,-2"})
    void updateSellIn(int sellIn, int expected) {
        ConjuredItem cut = ConjuredItem.of("Conjured Mana Cake", sellIn, 0);
        cut.updateSellIn();
        assertEquals(expected, cut.getSellIn());
    }

}
