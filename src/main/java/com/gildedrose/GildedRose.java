package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") // Aged Brie is different from normal items
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Backstage passes also different from normal items
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // Sulfuras is different from normal items
                        decreaseQuality(items[i]); // Sulfuras doesn't lose quality
                    }
                }
            } else {
                increaseQuality(items[i]); // Only Aged Brie gains quality with each passing day
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Different logic for backstage passes
                    if (items[i].sellIn < 11) { // Quality should increase by 2
                        increaseQuality(items[i]);
                    }

                    if (items[i].sellIn < 6) { // Quality should increase by 3
                        increaseQuality(items[i]);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // SellIn doesn't change for Sulfuras
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1; // Sulfuras doesn't lose quality
                            }
                        }
                    } else {
                        items[i].quality = 0; // Backstage pass loses all quality when sellin date < 0
                    }
                } else {
                    increaseQuality(items[i]);
                }
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
