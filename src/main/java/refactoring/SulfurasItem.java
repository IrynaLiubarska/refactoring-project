package refactoring;

public class SulfurasItem extends Item{
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int updateSellIn() {
        return sellIn;
    }

    public int updateQuality() {
        return quality;
    }
}
