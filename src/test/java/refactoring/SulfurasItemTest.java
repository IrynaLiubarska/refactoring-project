package refactoring;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasItemTest {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInUnder0() {
        // quality == 50 && sellIn <= 0
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, -1, 50);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 0, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();
        
        assertEquals(-1, sulfuras1.getSellIn());
        assertEquals(50, sulfuras1.getQuality());
        assertEquals(0, sulfuras2.getSellIn());
        assertEquals(50, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween0And5() {
        // quality == 50 && sellIn > 0 && sellIn<=5
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 5, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1});

        gildedRose.updateQuality();

        assertEquals(5, sulfuras1.getSellIn());
        assertEquals(50, sulfuras1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween6And10() {
        // quality == 50 && sellIn >5 && sellIn < 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 6, 50);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 7, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(6, sulfuras1.getSellIn());
        assertEquals(50, sulfuras1.getQuality());
        assertEquals(7, sulfuras2.getSellIn());
        assertEquals(50, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInOver10() {
        // quality == 50 && sellIn >= 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 11, 50);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 12, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(11, sulfuras1.getSellIn());
        assertEquals(50, sulfuras1.getQuality());
        assertEquals(12, sulfuras2.getSellIn());
        assertEquals(50, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInUnder0() {
        // quality > 50 && sellIn <= 0

        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, -1, 60);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 0, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(-1, sulfuras1.getSellIn());
        assertEquals(60, sulfuras1.getQuality());
        assertEquals(0, sulfuras2.getSellIn());
        assertEquals(60, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween0And5() {
        // quality > 50 && sellIn > 0 && sellIn <=5
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 5, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1});

        gildedRose.updateQuality();

        assertEquals(5, sulfuras1.getSellIn());
        assertEquals(60, sulfuras1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween6And10() {
        // quality > 50 && sellIn >5 && sellIn < 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 6, 60);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 7, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(6, sulfuras1.getSellIn());
        assertEquals(60, sulfuras1.getQuality());
        assertEquals(7, sulfuras2.getSellIn());
        assertEquals(60, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInOver10() {
        // quality > 50 && sellIn >= 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 11, 60);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 12, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(11, sulfuras1.getSellIn());
        assertEquals(60, sulfuras1.getQuality());
        assertEquals(12, sulfuras2.getSellIn());
        assertEquals(60, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInOver10() {
        // quality < 50 && sellIn >= 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 11, 45);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 12, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(11, sulfuras1.getSellIn());
        assertEquals(45, sulfuras1.getQuality());
        assertEquals(12, sulfuras2.getSellIn());
        assertEquals(45, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween6And10() {
        // quality < 50 && sellIn >5 && sellIn < 10
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 6, 45);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 7, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();
        
        assertEquals(6, sulfuras1.getSellIn());
        assertEquals(45, sulfuras1.getQuality());
        assertEquals(7, sulfuras2.getSellIn());
        assertEquals(45, sulfuras2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween0And5() {
        // quality < 50 && sellIn > 0 && sellIn <=5
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 5, 45);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1});

        gildedRose.updateQuality();
       
        assertEquals(5, sulfuras1.getSellIn());
        assertEquals(45, sulfuras1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInUnder0() {
        Item sulfuras1 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, -1, 45);
        Item sulfuras2 = new SulfurasItem(SULFURAS_HAND_OF_RAGNAROS, 0, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras1, sulfuras2});

        gildedRose.updateQuality();

        assertEquals(-1, sulfuras1.getSellIn());
        assertEquals(45, sulfuras1.getQuality());
        assertEquals(0, sulfuras2.getSellIn());
        assertEquals(45, sulfuras2.getQuality());
    }
}
