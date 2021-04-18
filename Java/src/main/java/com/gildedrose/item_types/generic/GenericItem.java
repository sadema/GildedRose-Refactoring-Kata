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

//    public void updateQualityWithMaximumCheck() {
//        if (!item.name.equals("Aged Brie")
//                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//            if (item.quality > 0) {
//                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                    item.quality = item.quality - 1;
//                }
//            }
//        } else {
//            if (item.quality < 50) {
//                item.quality = item.quality + 1;
//
//                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                    if (item.sellIn < 11) {
//                        if (item.quality < 50) {
//                            item.quality = item.quality + 1;
//                        }
//                    }
//
//                    if (item.sellIn < 6) {
//                        if (item.quality < 50) {
//                            item.quality = item.quality + 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//            item.sellIn = item.sellIn - 1;
//        }
//
//        if (item.sellIn < 0) {
//            if (!item.name.equals("Aged Brie")) {
//                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                    if (item.quality > 0) {
//                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                            item.quality = item.quality - 1;
//                        }
//                    }
//                } else {
//                    item.quality = item.quality - item.quality;
//                }
//            } else {
//                if (item.quality < 50) {
//                    item.quality = item.quality + 1;
//                }
//            }
//        }
//    }

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
