package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DelegateItemTest {

    public class TestDelegateItem extends DelegateItem implements BaseItem {

        public TestDelegateItem(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        @Override
        protected void updateQuality() {

        }

        @Override
        protected void updateSellIn() {

        }
    }

    private TestDelegateItem cut;

    @BeforeEach
    void setup() {
    }

    @ParameterizedTest
    @CsvSource({"49,true", "50,false", "51,false"})
    void isNotMaximumQuality(int quality, boolean expected) {
        cut = new TestDelegateItem("some name", 1, quality);
        boolean result = cut.isNotMaximumQuality();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"49,false", "50,false", "51,true"})
    void isMaximumQualityExceeded(int quality, boolean expected) {
        cut = new TestDelegateItem("some name", 1, quality);
        boolean result = cut.isMaximumQualityExceeded();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"1,false", "0,false", "-1,true", "-2,true"})
    void isNegativeSellIn(int sellIn, boolean expected) {
        cut = new TestDelegateItem("some name", sellIn, 0);
        boolean result = cut.isNegativeSellIn();
        assertEquals(expected, result);
    }

    @Test
    void isNegativeSellInCheckEnabled() {
        cut = new TestDelegateItem("some name", 0, 0);
        boolean result = cut.isNegativeSellInCheckEnabled();
        assertFalse(result);
    }

    @Test
    void setItemQualityToZero() {
        cut = new TestDelegateItem("some name", 0, 0);
        cut.setItemQualityToZero();
        assertEquals(0, cut.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"3,2", "2,1", "1,0", "0,0", "-1,0"})
    void decreaseQualityWithOne(int quality, int expected) {
        cut = new TestDelegateItem("some name", 0, quality);
        cut.decreaseQuality(1);
        assertEquals(expected, cut.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"4,2", "3,1", "2,0", "1,0", "0,0", "-1,0"})
    void decreaseQualityWithTwo(int quality, int expected) {
        cut = new TestDelegateItem("some name", 0, quality);
        cut.decreaseQuality(2);
        assertEquals(expected, cut.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"48,49", "49,50", "50,50", "51,50"})
    void increaseQualityWithOne(int quality, int expected) {
        cut = new TestDelegateItem("some name", 0, quality);
        cut.increaseQuality(1);
        assertEquals(expected, cut.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"47,49", "48,50", "49,50", "50,50", "51,50"})
    void increaseQualityWithTwo(int quality, int expected) {
        cut = new TestDelegateItem("some name", 0, quality);
        cut.increaseQuality(2);
        assertEquals(expected, cut.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"2,1", "1,0", "0,-1", "-1,-2"})
    void decreaseSellIn(int sellIn, int expected) {
        cut = new TestDelegateItem("some name", sellIn, 0);
        cut.decreaseSellIn(1);
        assertEquals(expected, cut.getSellIn());
    }
}
