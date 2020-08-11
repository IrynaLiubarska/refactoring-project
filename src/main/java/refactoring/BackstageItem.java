package refactoring;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int updateSellIn() {
        return --sellIn;
    }

    public int updateQuality() {
        if (sellIn < 0) return 0;
        if (quality >= 50) return quality;
        if (sellIn < 5) return quality + 3;
        if (sellIn < 10) return quality + 2;
        return ++quality;
    }
}
