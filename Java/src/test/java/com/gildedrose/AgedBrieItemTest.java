package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieItemTest {

    @Test
    void updateQualityOfFifty() {
        AgedBrieItem item = AgedBrieItem.of(2, 50);
        item.updateQualityWithMaximumCheck();
        assertEquals(50, item.getQuality());
    }

    @Test
    void updateQualityWithLessThanFifty() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateQualityWithMaximumCheck();
        assertEquals(21, item.getQuality());
    }

    @Test
    void updateQualityWithLessThanFiftyAndPositiveSellIn() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateQualityWithMaximumCheck();
        assertEquals(21, item.getQuality());
    }

    @Test
    void updateQualityWithLessThanFiftyAndNegativeSellIn() {
        AgedBrieItem item = AgedBrieItem.of(-2, 20);
        item.updateQualityWithMaximumCheck();
        assertEquals(22, item.getQuality());
    }

    @Test
    void updateQualityWithFourtyNineAndNegativeSellIn() {
        AgedBrieItem item = AgedBrieItem.of(-2, 49);
        item.updateQualityWithMaximumCheck();
        assertEquals(50, item.getQuality());
    }

    @Test
    void updateSellIn() {
        AgedBrieItem item = AgedBrieItem.of(2, 20);
        item.updateSellIn();
        assertEquals(1, item.getSellIn());
    }
}
