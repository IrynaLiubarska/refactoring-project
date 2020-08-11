package refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstageItemTest {
    
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final int QUALITY_UNDER_50 = 49;
    public static final int QUALITY_OVER_50 = 51;
    public static final int EXPECTED_WHEN_SELL_IN_UNDER_ZERO = 0;
    public static final int QUALITY_EQUALS_50 = 50;
    public static final int SELL_IN_UNDER_ZERO = -1;
    public static final int SELL_IN_BETWEEN_5_AND_10 = 7;

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween0And5() {
        // quality == 50 && sellIn > 0 && sellIn<=5
        Item backstage1 = new BackstageItem(BACKSTAGE, 5, QUALITY_EQUALS_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1});

        gildedRose.updateQuality();
        
        shouldUpdateQualityWhenQualityEquals50AndSellInUnder0();
        assertEquals(4, backstage1.getSellIn());
        assertEquals(QUALITY_EQUALS_50, backstage1.getQuality());
        shouldUpdateQualityWhenQualityEquals50AndSellInBetween6And10();
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInBetween6And10() {
        // quality == 50 && sellIn >5 && sellIn < 10
        Item backstage11 = new BackstageItem(BACKSTAGE, 6, QUALITY_EQUALS_50);
        Item backstage12 = new BackstageItem(BACKSTAGE, SELL_IN_BETWEEN_5_AND_10, QUALITY_EQUALS_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage11, backstage12});

        gildedRose.updateQuality();
        assertEquals(5, backstage11.getSellIn());
        assertEquals(QUALITY_EQUALS_50, backstage11.getQuality());
        assertEquals(6, backstage12.getSellIn());
        assertEquals(QUALITY_EQUALS_50, backstage12.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInOver10() {
        // quality == 50 && sellIn >= 10
        Item backstage1 = new BackstageItem(BACKSTAGE, 11, QUALITY_EQUALS_50);
        Item backstage2 = new BackstageItem(BACKSTAGE, 12, QUALITY_EQUALS_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage2});

        gildedRose.updateQuality();

        assertEquals(10, backstage1.getSellIn());
        assertEquals(QUALITY_EQUALS_50, backstage1.getQuality());
        assertEquals(11, backstage2.getSellIn());
        assertEquals(QUALITY_EQUALS_50, backstage2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityEquals50AndSellInUnder0() {
        // quality == 50 && sellIn <= 0
        Item backstage1 = new BackstageItem(BACKSTAGE, SELL_IN_UNDER_ZERO, QUALITY_EQUALS_50);
        Item backstage2 = new BackstageItem(BACKSTAGE, 0, QUALITY_EQUALS_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage2});

        gildedRose.updateQuality();

        assertEquals(SELL_IN_UNDER_ZERO - 1, backstage1.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage1.getQuality());
        assertEquals(-1, backstage2.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween0And5() {
        // quality > 50 && sellIn > 0 && sellIn <=5
        Item backstage1 = new BackstageItem(BACKSTAGE, 5, QUALITY_OVER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1});

        gildedRose.updateQuality();

        assertEquals(4, backstage1.getSellIn());
        assertEquals(QUALITY_OVER_50, backstage1.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInBetween6And10() {
        // quality > 50 && sellIn >5 && sellIn < 10
        Item backstage1 = new BackstageItem(BACKSTAGE, 6, QUALITY_OVER_50);
        Item backstage2 = new BackstageItem(BACKSTAGE, SELL_IN_BETWEEN_5_AND_10, QUALITY_OVER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage2});

        gildedRose.updateQuality();

        assertEquals(5, backstage1.getSellIn());
        assertEquals(QUALITY_OVER_50, backstage1.getQuality());

        assertEquals(SELL_IN_BETWEEN_5_AND_10 - 1, backstage2.getSellIn());
        assertEquals(QUALITY_OVER_50, backstage2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInOver10() {
        // quality > 50 && sellIn >= 10
        Item backstage20 = new BackstageItem(BACKSTAGE, 11, QUALITY_OVER_50);
        Item backstage21 = new BackstageItem(BACKSTAGE, 12, QUALITY_OVER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage20, backstage21});

        gildedRose.updateQuality();

        assertEquals(10, backstage20.getSellIn());
        assertEquals(QUALITY_OVER_50, backstage20.getQuality());
        assertEquals(11, backstage21.getSellIn());
        assertEquals(QUALITY_OVER_50, backstage21.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityOver50AndSellInUnder0() {
        // quality > 50 && sellIn <= 0
        Item backstage1 = new BackstageItem(BACKSTAGE, SELL_IN_UNDER_ZERO, QUALITY_OVER_50);
        Item backstage2 = new BackstageItem(BACKSTAGE, 0, QUALITY_OVER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage2});

        gildedRose.updateQuality();

        assertEquals(SELL_IN_UNDER_ZERO - 1, backstage1.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage1.getQuality());
        assertEquals(-1, backstage2.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage2.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInOver10() {
        // quality < 50 && sellIn >= 10
        Item backstage6 = new BackstageItem(BACKSTAGE, 11, QUALITY_UNDER_50);
        Item backstage7 = new BackstageItem(BACKSTAGE, 12, QUALITY_UNDER_50);

        GildedRose gildedRose = new GildedRose(new Item[]{backstage6, backstage7});

        gildedRose.updateQuality();
        assertEquals(10, backstage6.getSellIn());
        assertEquals(QUALITY_UNDER_50 + 1, backstage6.getQuality());
        assertEquals(11, backstage7.getSellIn());
        assertEquals(QUALITY_UNDER_50 + 1, backstage7.getQuality());
    }


    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween6And10() {
        // quality < 50 && sellIn >5 && sellIn < 10
        Item backstage1 = new BackstageItem(BACKSTAGE, 6, QUALITY_UNDER_50);
        Item backstage5 = new BackstageItem(BACKSTAGE, SELL_IN_BETWEEN_5_AND_10, QUALITY_UNDER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage5});

        gildedRose.updateQuality();

        assertEquals(5, backstage1.getSellIn());
        assertEquals(QUALITY_UNDER_50 + 2, backstage1.getQuality());
        assertEquals(SELL_IN_BETWEEN_5_AND_10 - 1, backstage5.getSellIn());
        assertEquals(QUALITY_UNDER_50 + 2, backstage5.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInBetween0And5() {
        // quality < 50 && sellIn > 0 && sellIn <=5
        Item backstage = new BackstageItem(BACKSTAGE, 5, QUALITY_UNDER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage});

        gildedRose.updateQuality();

        assertEquals(4, backstage.getSellIn());
        assertEquals(QUALITY_UNDER_50 + 3, backstage.getQuality());
    }

    @Test
    public void shouldUpdateQualityWhenQualityUnder50AndSellInUnder0() {
        // quality < 50 && sellIn <= 0
        Item backstage1 = new BackstageItem(BACKSTAGE, SELL_IN_UNDER_ZERO, QUALITY_UNDER_50);
        Item backstage2 = new BackstageItem(BACKSTAGE, 0, QUALITY_UNDER_50);
        GildedRose gildedRose = new GildedRose(new Item[]{backstage1, backstage2});

        gildedRose.updateQuality();

        assertEquals(SELL_IN_UNDER_ZERO - 1, backstage1.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage1.getQuality());
        assertEquals(-1, backstage2.getSellIn());
        assertEquals(EXPECTED_WHEN_SELL_IN_UNDER_ZERO, backstage2.getQuality());
    }
}
