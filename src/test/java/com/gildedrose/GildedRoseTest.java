package com.gildedrose;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void given_normalItemWithSellIn0_when_qualityIsUpdated_then_decreaseSellIn() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void given_normalItemWithQuality0_when_qualityIsUpdated_then_doNothing() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void given_normalItemWithQuality50AndSellIn1_when_qualityIsUpdated_then_decreaseQuality() {
        Item[] items = new Item[] { new Item("foo", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void given_normalItemWithSellIn0AndQuality4_when_qualityIsUpdated_then_decreaseQualityBy2() {
        Item[] items = new Item[] { new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void given_normalItemWithNegativeQuality_when_qualityIsUpdated_then_setQualityTo0() {
        Item[] items = new Item[] { new Item("foo", 1, -3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // Brie

    @Test
    void given_agedBrieItemWithSellIn10AndQuality0_when_qualityIsUpdated_then_increaseQualityBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void given_agedBrieItemWithSellIn10AndQuality50_when_qualityIsUpdated_then_doNothing() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // Backstage
    @Test
    void given_backstagePassesWithSellInAbove10_when_qualityIsUpdated_then_increaseQualityBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void given_backstagePassesWithSellIn10_when_qualityIsUpdated_then_increaseQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void given_backstagePassesWithSellIn2_when_qualityIsUpdated_then_increaseQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void given_backstagePassesWithSellIn0AndQuality50_when_qualityIsUpdated_then_qualityDropsTo0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void given_backstagePassesWithQualityOf49_when_qualityIsUpdated_then_increaseQualityBy3ToMax50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // Sulfuras

    @Test
    void given_sulfurasItemWithQuality50_when_qualityIsUpdated_then_qualityStays80() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void given_sulfurasItemWithSellIn5_when_qualityIsUpdated_then_SellInStays5() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
    }

    // Conjured

    @Test
    void given_conjuredItemWithQuality4_when_qualityIsUpdated_then_decreaseQualityBy2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void given_conjuredItemWithNegativeSellIn_when_qualityIsUpdated_then_decreaseQualityBy4() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -4, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
