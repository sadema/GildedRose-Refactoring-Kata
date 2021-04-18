package com.gildedrose;

public interface QualityCalculator {

    void updateQuality(Item item);

    boolean applyTo(int sellIn);
}
