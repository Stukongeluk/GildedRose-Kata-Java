package com.gildedrose;

import com.gildedrose.items.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemTypeTest {
    @Test
    public void given_itemNameIsAgedBrie_when_gettingItem_then_returnAgedBrieItemClass() {
        ItemUpdater item = getItem(new Item("Aged Brie", 2, 0));
        assertEquals(AgedBrie.class, item.getClass());
    }

    @Test
    public void given_itemNameIsSulfuras_when_gettingItem_then_returnSulfurasItemClass() {
        ItemUpdater item = getItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        assertEquals(Sulfuras.class, item.getClass());
    }

    @Test
    public void given_itemNameIsBackstagePasses_when_gettingItem_then_returnBackstagePassesClass() {
        ItemUpdater item = getItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        assertEquals(BackstagePass.class, item.getClass());
    }

    @Test
    public void given_itemNameIsConjured_when_gettingItem_then_returnConjuredItemClass() {
        ItemUpdater item = getItem(new Item("Conjured Mana Cake", 3, 6));
        assertEquals(Conjured.class, item.getClass());
    }

    @Test
    public void given_itemNameIsNotOneOfTheKnownItems_when_gettingItem_then_returnNormalItemClass() {
        ItemUpdater item = getItem((new Item("Spiderman 2 game for PS5 includes Venom and Kraven", 524, 50)));
        assertEquals(NormalItem.class, item.getClass());
    }

    private ItemUpdater getItem(Item item) {
        ItemType type = ItemType.forName(item.name);
        return type.createItem();
    }
}
