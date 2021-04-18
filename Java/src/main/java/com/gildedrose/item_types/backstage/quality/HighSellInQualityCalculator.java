package com.gildedrose.item_types.backstage.quality;

import com.gildedrose.Item;
import com.gildedrose.QualityCalculator;

public class HighSellInQualityCalculator implements QualityCalculator {

    @Override
    public boolean applyTo(int sellIn) {
        return sellIn > 10;
    }

    @Override
    public void updateQuality(Item item) {
        item.quality += 1;
    }

}
