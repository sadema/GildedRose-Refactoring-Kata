package com.gildedrose.item_types.sulfuras;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemTest {


    @ParameterizedTest
    @CsvSource({"3,80", "2,80", "1,80", "0,80", "-1,80"})
    void testUpdateQuality(int sellIn, int expected) {
        SulfurasItem item = SulfurasItem.of(sellIn);
        item.updateQuality();
        assertEquals(expected, item.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,3", "2,2", "1,1", "0,0", "-1,-1"})
    void testUpdateSellIn(int sellIn, int expected) {
        SulfurasItem item = SulfurasItem.of(sellIn);
        item.updateSellIn();
        assertEquals(expected, item.getSellIn());
    }

}
