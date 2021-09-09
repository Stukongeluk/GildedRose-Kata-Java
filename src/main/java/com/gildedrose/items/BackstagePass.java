package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends NormalItem {
    private final int backstageSellIn10DaysThreshold = 10;
    private final int backstageSellIn5DaysThreshold = 5;
    private final int backstageConcertPassedSellInThreshold = 0;

    @Override
    public void updateItemQuality(Item item) {
        int backstageQualityValue = getQualityChange(item);
        if (backstageQualityValue > 0) {
            increaseQuality(item, backstageQualityValue);
        } else {
            decreaseQuality(item, item.quality);
        }
    }

    protected int getQualityChange(Item item) {
        if (item.sellIn < backstageConcertPassedSellInThreshold) {
            return 0;
        } else if (item.sellIn <= backstageSellIn5DaysThreshold) {
            return 3;
        } else if (item.sellIn <= backstageSellIn10DaysThreshold) {
            return 2;
        }
        return 1;
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
