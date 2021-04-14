package com.gildedrose;

public abstract class DelegateItem {

    protected final Item item;

    protected DelegateItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

}
