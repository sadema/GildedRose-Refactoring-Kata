package com.gildedrose;

public class BackstageItem extends DelegateItem implements BaseItem {

    private BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static BackstageItem of(int sellIn, int quality) {
        return new BackstageItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    protected void updateQuality() {
        if (isNegativeSellIn()) {
            item.quality = 0;
        }
        else {
            if (isNotMaximumQuality()) {
                updateQualityBySellIn(item.sellIn);
            }
        }
    }

    private void updateQualityBySellIn(int sellIn) {
        if (sellIn <= 5) {
            item.quality += 3;
        }
        else {
            if (sellIn <= 10) {
                item.quality += 2;
            }
            else {
                item.quality += 1;
            }
        }
    }

}
