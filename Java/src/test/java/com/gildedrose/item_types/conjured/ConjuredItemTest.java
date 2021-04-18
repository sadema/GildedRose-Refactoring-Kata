package com.gildedrose.item_types.conjured;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemTest {

    @Test
    void updateQuality() {
        ConjuredItem item = ConjuredItem.of("Conjured Mana Cake", 3, 6);
        item.updateQuality();
        assertEquals(4, item.getQuality());
    }

    @Test
    void updateSellIn() {
    }
}
