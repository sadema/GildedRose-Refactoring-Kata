package com.gildedrose;

import com.gildedrose.item_types.agedbrie.AgedBrieItem;
import com.gildedrose.item_types.backstage.BackstageItem;
import com.gildedrose.item_types.conjured.ConjuredItem;
import com.gildedrose.item_types.generic.GenericItem;
import com.gildedrose.item_types.sulfuras.SulfurasItem;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        BaseItem[] items = new BaseItem[]{
                GenericItem.of("+5 Dexterity Vest", 10, 20), //
                AgedBrieItem.of(2, 0), //
                GenericItem.of("Elixir of the Mongoose", 5, 7), //
                SulfurasItem.of(0), //
                SulfurasItem.of(-1),
                BackstageItem.of(15, 20),
                BackstageItem.of(10, 49),
                BackstageItem.of(5, 49),
                ConjuredItem.of("Conjured Mana Cake", 3, 6)};

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (BaseItem item : items) {
                System.out.println(item);
                item.updateSellInAndQuality();
            }
            System.out.println();
        }
    }

}
