package com.gildedrose;

public abstract class DelegateItem {

    protected final static int MAX_QUALITY = 50;

    protected final Item item;

    protected DelegateItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return item.toString();
    }

    protected boolean isNotMaximumQuality() {
        return item.quality < MAX_QUALITY;
    }

    protected boolean isMaximumQualityExceeded() {
        return item.quality > MAX_QUALITY;
    }

    protected boolean isNegativeSellIn() {
        return item.sellIn < 0;
    }

    protected boolean isMaximumQualityCheckEnabled() {
        return true;
    }

    protected void updateQualityWithMaximumCheck() {
        updateQuality();
        if (isMaximumQualityCheckEnabled() && isMaximumQualityExceeded()) {
            item.quality = MAX_QUALITY;
        }
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void updateSellInAndQuality() {
        updateQualityWithMaximumCheck();
        updateSellIn();
    }

    protected abstract void updateQuality();

    protected abstract void updateSellIn();

    protected void decreaseQuality(int qualityDecrease) {
        item.quality -= qualityDecrease;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
