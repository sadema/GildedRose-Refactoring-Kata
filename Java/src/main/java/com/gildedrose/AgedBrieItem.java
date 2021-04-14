package com.gildedrose;

public class AgedBrieItem extends DelegateItem implements BaseItem {

    private AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static AgedBrieItem of(int sellIn, int quality) {
        return new AgedBrieItem("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateSellIn() {
        item.sellIn -= 1;
    }

    protected void updateQuality() {
        if (isNotMaximumQuality()) {
            if (isNegativeSellIn()) {
                item.quality += 2;
            }
            else {
                item.quality += 1;
            }
        }
    }

}
