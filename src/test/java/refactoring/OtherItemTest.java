package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OtherItemTest {

    public static final String OTHER = "other";

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInUnder0() {
        // quality == 50 && sellIn <= 0
        Item other1 = new OtherItem(OTHER, -1, 50);
        Item other2 = new OtherItem(OTHER, 0, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(-2, other1.getSellIn());
        assertEquals(48, other1.getQuality());
        assertEquals(-1, other2.getSellIn());
        assertEquals(48, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween0And5() {
        // quality == 50 && sellIn > 0 && sellIn<=5
        Item other1 = new OtherItem(OTHER, 5, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{other1});

        gildedRose.updateQuality();

        assertEquals(4, other1.getSellIn());
        assertEquals(49, other1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween6And10() {
        // quality == 50 && sellIn >5 && sellIn < 10
        Item other1 = new OtherItem(OTHER, 6, 50);
        Item other2 = new OtherItem(OTHER, 7, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(5, other1.getSellIn());
        assertEquals(49, other1.getQuality());
        assertEquals(6, other2.getSellIn());
        assertEquals(49, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInOver10() {
        // quality == 50 && sellIn >= 10
        Item other1 = new OtherItem(OTHER, 11, 50);
        Item other2 = new OtherItem(OTHER, 12, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(10, other1.getSellIn());
        assertEquals(49, other1.getQuality());
        assertEquals(11, other2.getSellIn());
        assertEquals(49, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInUnder0() {
        // quality > 50 && sellIn <= 0

        Item other1 = new OtherItem(OTHER, -1, 60);
        Item other2 = new OtherItem(OTHER, 0, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(-2, other1.getSellIn());
        assertEquals(58, other1.getQuality());
        assertEquals(-1, other2.getSellIn());
        assertEquals(58, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween0And5() {
        // quality > 50 && sellIn > 0 && sellIn <=5
        Item other1 = new OtherItem(OTHER, 5, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{other1});

        gildedRose.updateQuality();

        assertEquals(4, other1.getSellIn());
        assertEquals(59, other1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween6And10() {
        // quality > 50 && sellIn >5 && sellIn < 10
        Item other1 = new OtherItem(OTHER, 6, 60);
        Item other2 = new OtherItem(OTHER, 7, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(5, other1.getSellIn());
        assertEquals(59, other1.getQuality());
        assertEquals(6, other2.getSellIn());
        assertEquals(59, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInOver10() {
        // quality > 50 && sellIn >= 10
        Item other1 = new OtherItem(OTHER, 11, 60);
        Item other2 = new OtherItem(OTHER, 12, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();
        
        assertEquals(10, other1.getSellIn());
        assertEquals(59, other1.getQuality());
        assertEquals(11, other2.getSellIn());
        assertEquals(59, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInOver10() {
        // quality < 50 && sellIn >= 10
        Item other1 = new OtherItem(OTHER, 11, 45);
        Item other2 = new OtherItem(OTHER, 12, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(10, other1.getSellIn());
        assertEquals(44, other1.getQuality());
        assertEquals(11, other2.getSellIn());
        assertEquals(44, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween6And10() {
        // quality < 50 && sellIn >5 && sellIn < 10
        Item other1 = new OtherItem(OTHER, 6, 45);
        Item other2 = new OtherItem(OTHER, 7, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(5, other1.getSellIn());
        assertEquals(44, other1.getQuality());
        assertEquals(6, other2.getSellIn());
        assertEquals(44, other2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween0And5() {
        // quality < 50 && sellIn > 0 && sellIn <=5
        Item other1 = new OtherItem(OTHER, 5, 45);
        GildedRose gildedRose = new GildedRose(new Item[]{other1});

        gildedRose.updateQuality();

        assertEquals(4, other1.getSellIn());
        assertEquals(44, other1.getQuality());
    }
    
    @Test
    
    public void shouldUpdateQualityWhenQualityUnder50AndSellInUnder0() {
        Item other1 = new OtherItem(OTHER, -1, 45);
        Item other2 = new OtherItem(OTHER, 0, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{other1, other2});

        gildedRose.updateQuality();

        assertEquals(-2, other1.getSellIn());
        assertEquals(43, other1.getQuality());
        assertEquals(-1, other2.getSellIn());
        assertEquals(43, other2.getQuality());
    }
}
