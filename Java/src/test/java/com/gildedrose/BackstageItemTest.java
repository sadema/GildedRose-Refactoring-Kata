package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstageItemTest {

    @Test
    void updateSellIn() {
        BackstageItem item = BackstageItem.of(10, 20);
    }

    @Test
    void updateQualityWithMoreThanTenSellIn() {
        BackstageItem item = BackstageItem.of(11, 20);
        item.updateQualityWithMaximumCheck();
        assertEquals(21, item.getQuality());
    }

    @Test
    void updateQualityWithSellInBetweenFiveAndEleven() {
        BackstageItem item = BackstageItem.of(10, 25);
        item.updateQualityWithMaximumCheck();
        assertEquals(27, item.getQuality());
    }

    @Test
    void updateQualityWithPositiveSellInLessThanSix() {
        BackstageItem item = BackstageItem.of(5, 25);
        item.updateQualityWithMaximumCheck();
        assertEquals(28, item.getQuality());
    }

    @Test
    void updateQualityWithNegativeSellIn() {
        BackstageItem item = BackstageItem.of(-1, 25);
        item.updateQualityWithMaximumCheck();
        assertEquals(0, item.getQuality());
    }

}
