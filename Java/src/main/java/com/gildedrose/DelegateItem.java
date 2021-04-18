package com.gildedrose;

public abstract class DelegateItem {

    protected final static int MAX_QUALITY = 50;

    private final Item item;

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

    protected boolean isNegativeSellInCheckEnabled() {
        return false;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void updateSellInAndQuality() {
        updateSellIn();
        updateQuality();
    }

    protected abstract void updateQuality();

    protected abstract void updateSellIn();

    protected void setItemQualityToZero() {
        item.quality = 0;
    }

    protected void decreaseQuality(int qualityDecrease) {
        item.quality -= qualityDecrease;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    protected void increaseQuality(int qualityIncrease) {
        item.quality += qualityIncrease;
        if (isMaximumQualityExceeded()) {
            item.quality = MAX_QUALITY;
        }
    }

    protected void decreaseSellIn(int sellInDecrease) {
        item.sellIn -= sellInDecrease;
        if (isNegativeSellInCheckEnabled() && isNegativeSellIn()) {
            setItemQualityToZero();
        }
    }

}
