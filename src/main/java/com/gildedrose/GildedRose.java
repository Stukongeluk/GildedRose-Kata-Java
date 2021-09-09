package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    public static final int BACKSTAGE_SELL_IN_10_DAYS_THRESHOLD = 10;
    public static final int BACKSTAGE_SELL_IN_5_DAYS_THRESHOLD = 5;
    public static final int BACKSTAGE_CONCERT_PASSED_SELL_IN_THRESHOLD = 0;

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
        int qualityIncrease = 1;
        int qualityDecrease = 1;

        switch (item.name) {
            case AGED_BRIE:
                decreaseSellIn(item);
                increaseQuality(item, qualityIncrease);
                break;
            case BACKSTAGE_PASSES:
                decreaseSellIn(item);
                if (item.sellIn < BACKSTAGE_CONCERT_PASSED_SELL_IN_THRESHOLD) {
                    decreaseQuality(item, item.quality);
                    break;
                } else if (item.sellIn <= BACKSTAGE_SELL_IN_5_DAYS_THRESHOLD) {
                    qualityIncrease = 3;
                } else if (item.sellIn <= BACKSTAGE_SELL_IN_10_DAYS_THRESHOLD) {
                    qualityIncrease = 2;
                }
                increaseQuality(item, qualityIncrease);
                break;
            case SULFURAS:
                break;
            case CONJURED:
                qualityDecrease = 2;
                decreaseSellIn(item);
                if (item.sellIn < 0) {
                    qualityDecrease = 4;
                }
                decreaseQuality(item, qualityDecrease);
                break;
            default:
                decreaseSellIn(item);
                if (item.sellIn < 0) {
                    qualityDecrease = 2;
                }
                decreaseQuality(item, qualityDecrease);
                break;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQuality(Item item, int amount) {
        int maxQuality = 50;
        if (item.quality < maxQuality) {
            item.quality = item.quality + amount;
        }
        if (item.quality > maxQuality) { // Quality should never be more than 50, fix this in a better way later
            item.quality = 50;
        }
    }

    private void decreaseQuality(Item item, int amount) {
        int minimumQuality = 0;
        if (item.quality > minimumQuality) {
            item.quality = item.quality - amount;
        }
        if (item.quality < minimumQuality) { // Quality should never be negative
            item.quality = minimumQuality;
        }
    }
}
