package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class NormalItem implements ItemUpdater {
    private final int normalItemDefaultQualityDecrease = 1;
    private final int normalItemAfterSellInQualityDecrease = 2;

    @Override
    public void updateItemQuality(Item item) {
        decreaseQuality(item, getQualityDecrease(item.sellIn));
    }

    @Override
    public void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected int getQualityDecrease(int sellIn) {
        return sellIn < 0 ? normalItemAfterSellInQualityDecrease: normalItemDefaultQualityDecrease;
    }

    protected void decreaseQuality(Item item, int qualityDecrease) {
        int minimumQuality = 0;
        if (item.quality > minimumQuality) {
            item.quality = item.quality - qualityDecrease;
        }
        if (item.quality < minimumQuality) { // Quality should never be negative
            item.quality = minimumQuality;
        }
    }
}
