package com.gildedrose.item_types.agedbrie;

import com.gildedrose.BaseItem;
import com.gildedrose.DelegateItem;

public class AgedBrieItem extends DelegateItem implements BaseItem {

    private AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static AgedBrieItem of(int sellIn, int quality) {
        return new AgedBrieItem("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn(1);
    }

    protected void updateQuality() {
        if (isNotMaximumQuality()) {
            if (isNegativeSellIn()) {
                increaseQuality(2);
            }
            else {
                increaseQuality(1);
            }
        }
    }

}
