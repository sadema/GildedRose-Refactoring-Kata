package com.gildedrose.item_types.backstage;

import com.gildedrose.BaseItem;
import com.gildedrose.DelegateItem;
import com.gildedrose.QualityCalculator;
import com.gildedrose.QualityCalculatorProvider;
import com.gildedrose.item_types.backstage.quality.HighSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.LowSellInQualityCalculator;
import com.gildedrose.item_types.backstage.quality.MiddleSellInQualityCalculator;

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

    @Override
    protected void updateSellIn() {
        item.sellIn -= 1;
    }

    @Override
    protected void updateQuality() {
        if (isNegativeSellIn()) {
            item.quality = 0;
        }
        else {
            updateQualityBySellIn();
        }
    }

    private void updateQualityBySellIn() {
        if (isNotMaximumQuality()) {
            Optional<QualityCalculator> qualityCalculator = qualityCalculatorProvider.getQualityCalculator(this);
            qualityCalculator.ifPresent(it -> {
                it.updateQuality(item);
            });
        }
    }

}
