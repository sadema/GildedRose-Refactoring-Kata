package com.gildedrose.item_types.backstage.quality;

import com.gildedrose.Item;
import com.gildedrose.QualityCalculator;

public class LowSellInQualityCalculator implements QualityCalculator {

    @Override
    public boolean applyTo(int sellIn) {
        return sellIn > 0 && sellIn <= 5;
    }

    @Override
    public void updateQuality(Item item) {
        item.quality += 3;
    }

}
