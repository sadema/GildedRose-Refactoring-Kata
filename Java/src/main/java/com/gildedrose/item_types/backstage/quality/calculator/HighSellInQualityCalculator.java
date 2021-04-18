package com.gildedrose.item_types.backstage.quality.calculator;

import com.gildedrose.item_types.backstage.quality.QualityCalculator;

public class HighSellInQualityCalculator implements QualityCalculator {

    @Override
    public boolean applyTo(int sellIn) {
        return sellIn >= 10;
    }

    @Override
    public int getQualityUpdate() {
        return 1;
    }

}
