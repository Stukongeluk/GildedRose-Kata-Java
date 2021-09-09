package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends NormalItem {
    private final int agedBrieDefaultQualityIncrease = 1;

    @Override
    public void updateItemQuality(Item item) {
        increaseQuality(item, agedBrieDefaultQualityIncrease); // Does the brie quality also increase twice as fast after sellIn date??
    }

    private void increaseQuality(Item item, int qualityIncrease) {
        int maxQuality = 50;
        if (item.quality < maxQuality) {
            item.quality = item.quality + qualityIncrease;
        }
        if (item.quality > maxQuality) {
            item.quality = 50;
        }
    }
}
