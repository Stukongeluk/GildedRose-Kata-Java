package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            ItemType itemType = getItemType(item);
            ItemUpdater concreteItem = itemType.createItem();
            concreteItem.decreaseSellIn(item);
            concreteItem.updateItemQuality(item);
        }
    }

    private ItemType getItemType(Item item) {
        return ItemType.forName(item.name);
    }
}
