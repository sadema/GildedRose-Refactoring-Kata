package com.gildedrose.item_types.backstage.quality.calculator;

import com.gildedrose.item_types.backstage.quality.QualityCalculator;

public class MiddleSellInQualityCalculator implements QualityCalculator {

    @Override
    public boolean applyTo(int sellIn) {
        return sellIn > 5 && sellIn <= 10;
    }

    @Override
    public int getQualityUpdate() {
        return 2;
    }

}
