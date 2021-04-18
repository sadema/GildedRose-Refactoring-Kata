package com.gildedrose;

import com.gildedrose.item_types.sulfuras.SulfurasItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemTest {


    @Test
    void testUpdateQuality() {
        SulfurasItem item = SulfurasItem.of(0);
        item.updateSellInAndQuality();
        assertEquals(80, item.getQuality());
    }

    @Test
    void testUpdateSellIn() {
        SulfurasItem item = SulfurasItem.of(-1);
        item.updateSellIn();
        assertEquals(-1, item.getSellIn());
    }

}
