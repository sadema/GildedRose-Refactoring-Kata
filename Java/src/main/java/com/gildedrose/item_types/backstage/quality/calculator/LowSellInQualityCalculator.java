package com.gildedrose.item_types.backstage.quality.calculator;

import com.gildedrose.item_types.backstage.quality.QualityCalculator;

public class LowSellInQualityCalculator implements QualityCalculator {

    @Override
    public boolean applyTo(int sellIn) {
        return sellIn > 0 && sellIn <= 5;
    }

    @Override
    public int getQualityUpdate() {
        return 3;
    }

}
