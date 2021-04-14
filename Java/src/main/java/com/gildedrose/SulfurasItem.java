package com.gildedrose;

public class SulfurasItem extends DelegateItem implements BaseItem {

    private SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static SulfurasItem of(int sellIn) {
        return new SulfurasItem("Sulfuras, Hand of Ragnaros", sellIn, 80);
    }

    @Override
    protected boolean isMaximumQualityCheckEnabled() {
        return false;
    }

    @Override
    public void updateQuality() {
        // do Nothing intentionally
    }

    @Override
    public void updateSellIn() {
        // do Nothing intentionally
    }

}
