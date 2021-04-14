package com.gildedrose;

public abstract class DelegateItem implements BaseItem {

    protected final Item item;

    protected DelegateItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return item.toString();
    }

    protected boolean isNotMaximumQuality() {
        return item.quality < 50;
    }

    protected boolean isNegativeSellIn() {
        return item.sellIn < 0;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public void updateSellInAndQuality() {
        updateSellIn();
        updateQuality();
    }

    protected abstract void updateSellIn();

    protected abstract void updateQuality();

}
