package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieItemTest {

    @Test
    void updateQualityOfFifty() {
        AgedBrieItem item = AgedBrieItem.of(2, 50);
        item.updateQuality();
        assertEquals(50, item.getQuality());
    }

    @Test
    void updateQualityLessThanFifty() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateQuality();
        assertEquals(21, item.getQuality());
    }

    @Test
    void updateQualityLessThanFiftyAndPositiveSellIn() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateQuality();
        assertEquals(21, item.getQuality());
    }

    @Test
    void updateQualityLessThanFiftyAndNegativeSellIn() {
        AgedBrieItem item = AgedBrieItem.of(-2, 20);
        item.updateQuality();
        assertEquals(22, item.getQuality());
    }

    @Test
    void updateSellIn() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateSellIn();
        assertEquals(1, item.getSellIn());
    }
}
