package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasItemTest {


    @Test
    void testUpdateQuality() {
        SulfurasItem item = SulfurasItem.of(0);
        item.updateQuality();
        assertEquals(80, item.getQuality());
    }

    @Test
    void testUpdateSellIn() {
        SulfurasItem item = SulfurasItem.of(-1);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn());
    }

}
