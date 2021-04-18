package com.gildedrose.item_types.backstage;

import com.gildedrose.BaseItem;
import com.gildedrose.DelegateItem;
import com.gildedrose.item_types.backstage.quality.QualityCalculator;
import com.gildedrose.item_types.backstage.quality.QualityCalculatorProvider;
import com.gildedrose.item_types.backstage.quality.calculator.HighSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.calculator.LowSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.calculator.MiddleSellInQualityCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BackstageItem extends DelegateItem implements BaseItem {

    private final QualityCalculatorProvider qualityCalculatorProvider;

    private BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        List<QualityCalculator> qualityCalculators = Arrays.asList(
                new HighSellInQualityCalculator(),
                new MiddleSellInQualityCalculator(),
                new LowSellInQualityCalculator()
        );
        qualityCalculatorProvider = new QualityCalculatorProvider(qualityCalculators);
    }

    public static BackstageItem of(int sellIn, int quality) {
        return new BackstageItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

//    @Override
//    protected boolean isNegativeSellInCheckEnabled() {
//        return true;
//    }

//    @Override
//    public void updateSellInAndQuality() {
//        updateQuality();
//        updateSellIn();
//    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn(1);
    }

    @Override
    protected void updateQuality() {
        updateQualityBySellIn();
    }

    private void updateQualityBySellIn() {
        if (isNegativeSellIn()) {
            setItemQualityToZero();
        }
        else {
            Optional<QualityCalculator> qualityCalculator = qualityCalculatorProvider.getQualityCalculator(this.getSellIn());
            qualityCalculator.ifPresent(it -> {
                increaseQuality(it.getQualityUpdate());
            });
        }
    }

}
