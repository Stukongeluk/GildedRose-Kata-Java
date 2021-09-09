package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item:this.items) {
            updateItemQualiy(item);
        }
    }

    private void updateItemQualiy(Item item) {
        if (!item.name.equals("Aged Brie") // Aged Brie is different from normal items
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Backstage passes also different from normal items
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { // Sulfuras is different from normal items
                    decreaseQuality(item); // Sulfuras doesn't lose quality
                }
            }
        } else {
            increaseQuality(item); // Only Aged Brie gains quality with each passing day
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Different logic for backstage passes
                if (item.sellIn < 11) { // Quality should increase by 2
                    increaseQuality(item);
                }

                if (item.sellIn < 6) { // Quality should increase by 3
                    increaseQuality(item);
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { // SellIn doesn't change for Sulfuras
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1; // Sulfuras doesn't lose quality
                        }
                    }
                } else {
                    item.quality = 0; // Backstage pass loses all quality when sellin date < 0
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
