package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class Sulfuras implements ItemUpdater {
    private final int sulfurasConstantQuality = 80;

    @Override
    public void updateItemQuality(Item item) {
        if (item.quality != sulfurasConstantQuality) {
            item.quality = sulfurasConstantQuality;
        }
    }

    @Override
    public void decreaseSellIn(Item item) {
    }
}
