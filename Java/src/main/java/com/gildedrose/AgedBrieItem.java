package com.gildedrose;

public class AgedBrieItem extends DelegateItem implements BaseItem {

    private AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static AgedBrieItem of(int sellIn, int quality) {
        return new AgedBrieItem("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isNotMaximumQuality()) {
            increaseQuality();
        }
    }

    @Override
    public void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality() {
        if (isNegativeSellIn()) {
            item.quality = item.quality + 2;
        }
        else {
            item.quality = item.quality + 1;
        }
    }

}
