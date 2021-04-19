package com.gildedrose.item_types.backstage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstageItemTest {

    @ParameterizedTest
    @CsvSource({"2,1", "1,0", "0,-1", "-1,-2", "-2,-3"})
    void updateSellIn(int sellIn, int expected) {
        BackstageItem cut = BackstageItem.of(sellIn, 0);
        cut.updateSellIn();
        assertEquals(expected, cut.getSellIn());
    }

    @ParameterizedTest
    @CsvSource({"1,28", "0,28", "-1,0"})
    void updateQuality(int sellIn, int expected) {
        BackstageItem item = BackstageItem.of(sellIn, 25);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }
}
