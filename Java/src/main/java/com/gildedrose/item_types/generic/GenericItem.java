package com.gildedrose.item_types.generic;

import com.gildedrose.BaseItem;
import com.gildedrose.DelegateItem;

public class GenericItem extends DelegateItem implements BaseItem {

    private GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static GenericItem of(String name, int sellIn, int quality) {
        return new GenericItem(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn(1);
    }

    @Override
    protected void updateQuality() {
        if (isNegativeSellIn()) {
            decreaseQuality(2);
        }
        else {
            decreaseQuality(1);
        }
    }

}
