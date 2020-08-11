package refactoring;

public class OtherItem extends Item {
    public OtherItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    public int updateSellIn() {
        return --sellIn;
    }

    public int updateQuality() {
        if (quality > 0 && sellIn <= 0) return quality - 2;
        return --quality;
    }
}
