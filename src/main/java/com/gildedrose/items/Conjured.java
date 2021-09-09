package com.gildedrose.items;

public class Conjured extends NormalItem {
    private final int conjuredDefaultQualityDecrease = 2;
    private final int conjuredAfterSellInQualityDecrease = 4;

    @Override
    protected int getQualityDecrease(int sellIn) {
        return sellIn < 0 ? conjuredAfterSellInQualityDecrease: conjuredDefaultQualityDecrease;
    }
}
