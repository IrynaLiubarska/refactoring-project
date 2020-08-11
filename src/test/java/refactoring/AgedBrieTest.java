package refactoring;

import org.junit.Assert;
import org.junit.Test;

public class AgedBrieTest {

    public static final String AGED_BRIE = "aged brie";

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInUnder0() {
        // quality == 50 && sellIn <= 0
        Item brieItem1 = new AgedBrie(AGED_BRIE, -1, 50);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 0, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(-2, brieItem1.getSellIn());
        Assert.assertEquals(50, brieItem1.getQuality());
        Assert.assertEquals(-1, brieItem2.getSellIn());
        Assert.assertEquals(50, brieItem2.getQuality());
    }
    
    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween0And5() {
        // quality == 50 && sellIn > 0 && sellIn<=5
        Item brieItem1 = new AgedBrie(AGED_BRIE, 5, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1});

        gildedRose.updateQuality();

        Assert.assertEquals(4, brieItem1.getSellIn());
        Assert.assertEquals(50, brieItem1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween6And10() {
        // quality == 50 && sellIn >5 && sellIn < 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 6, 50);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 7, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();
        
        Assert.assertEquals(5, brieItem1.getSellIn());
        Assert.assertEquals(50, brieItem1.getQuality());
        Assert.assertEquals(6, brieItem2.getSellIn());
        Assert.assertEquals(50, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInOver10() {
        // quality == 50 && sellIn >= 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 11, 50);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 12, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(10, brieItem1.getSellIn());
        Assert.assertEquals(50, brieItem1.getQuality());
        Assert.assertEquals(11, brieItem2.getSellIn());
        Assert.assertEquals(50, brieItem2.getQuality());
    }


    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween0And5() {
        // quality > 50 && sellIn > 0 && sellIn <=5
        Item brieItem1 = new AgedBrie(AGED_BRIE, 5, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1});

        gildedRose.updateQuality();
        
        Assert.assertEquals(4, brieItem1.getSellIn());
        Assert.assertEquals(60, brieItem1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween6And10() {
        // quality > 50 && sellIn >5 && sellIn < 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 6, 60);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 7, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(5, brieItem1.getSellIn());
        Assert.assertEquals(60, brieItem1.getQuality());
        Assert.assertEquals(6, brieItem2.getSellIn());
        Assert.assertEquals(60, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInOver10() {
        // quality > 50 && sellIn >= 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 11, 60);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 12, 60);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(10, brieItem1.getSellIn());
        Assert.assertEquals(60, brieItem1.getQuality());
        Assert.assertEquals(11, brieItem2.getSellIn());
        Assert.assertEquals(60, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInUnder0() {
        // quality > 50 && sellIn <= 0
        Item brieItem1 = new AgedBrie(AGED_BRIE, -1, 60);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 0, 60);
        
        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(-2, brieItem1.getSellIn());
        Assert.assertEquals(60, brieItem1.getQuality());
        Assert.assertEquals(-1, brieItem2.getSellIn());
        Assert.assertEquals(60, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInOver10() {
        // quality < 50 && sellIn >= 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 11, 45);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 12, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();
        
        Assert.assertEquals(10, brieItem1.getSellIn());
        Assert.assertEquals(46, brieItem1.getQuality());
        Assert.assertEquals(11, brieItem2.getSellIn());
        Assert.assertEquals(46, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween6And10() {
        // quality < 50 && sellIn >5 && sellIn < 10
        Item brieItem1 = new AgedBrie(AGED_BRIE, 6, 45);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 7, 45);


        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();
        
        Assert.assertEquals(5, brieItem1.getSellIn());
        Assert.assertEquals(46, brieItem1.getQuality());
        Assert.assertEquals(6, brieItem2.getSellIn());
        Assert.assertEquals(46, brieItem2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween0And5() {
        // quality < 50 && sellIn > 0 && sellIn <=5
        Item brieItem1 = new AgedBrie(AGED_BRIE, 5, 45);
        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1});

        gildedRose.updateQuality();

        Assert.assertEquals(4, brieItem1.getSellIn());
        Assert.assertEquals(46, brieItem1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInUnder0() {
        // quality < 50 && sellIn <= 0
        Item brieItem1 = new AgedBrie(AGED_BRIE, -1, 45);
        Item brieItem2 = new AgedBrie(AGED_BRIE, 0, 45);

        GildedRose gildedRose = new GildedRose(new Item[]{brieItem1, brieItem2});

        gildedRose.updateQuality();

        Assert.assertEquals(-2, brieItem1.getSellIn());
        Assert.assertEquals(47, brieItem1.getQuality());
        Assert.assertEquals(-1, brieItem2.getSellIn());
        Assert.assertEquals(47, brieItem2.getQuality());
    }
}
