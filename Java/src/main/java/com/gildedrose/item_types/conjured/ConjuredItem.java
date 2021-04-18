package com.gildedrose.item_types.conjured;

import com.gildedrose.BaseItem;
import com.gildedrose.DelegateItem;

public class ConjuredItem extends DelegateItem implements BaseItem {

    private ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static ConjuredItem of(String name, int sellIn, int quality) {
        return new ConjuredItem(name, sellIn, quality);
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn(1);
    }

    @Override
    protected void updateQuality() {
       super.decreaseQuality(2);
    }

}
