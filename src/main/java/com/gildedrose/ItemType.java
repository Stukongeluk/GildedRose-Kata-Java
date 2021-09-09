package com.gildedrose;

import com.gildedrose.items.*;

public enum ItemType {
    AGED_BRIE("Aged Brie") {
        @Override
        public ItemUpdater createItem() {
            return new AgedBrie();
        }
    },
    SULFURAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public ItemUpdater createItem() {
            return new Sulfuras();
        }
    },
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public ItemUpdater createItem() {
            return new BackstagePass();
        }
    },
    CONJURED("Conjured Mana Cake") {
        @Override
        public ItemUpdater createItem() {
            return new Conjured();
        }
    },
    NORMAL();

    private String name;

    ItemType(String name) {
        this.name = name;
    }

    ItemType() {
        this(null);
    }

    public static ItemType forName(String name) {
        for (ItemType itemType : ItemType.values()) {
            if (name.equals(itemType.name)) {
                return itemType;
            }
        }
        return NORMAL;
    }

    public ItemUpdater createItem() {
        return new NormalItem();
    }
}
