package com.gildedrose.item_types.backstage.quality;

public interface QualityCalculator {

    boolean applyTo(int sellIn);

    int getQualityUpdate();
}
