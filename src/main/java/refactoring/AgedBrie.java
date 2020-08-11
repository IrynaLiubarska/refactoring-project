package refactoring;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int updateSellIn() {
        return getSellIn() - 1;
    }

    public int updateQuality() {
        if (getQuality() >= 50) return getQuality();
        if (getSellIn() > 0) return getQuality() + 1;
        if (getSellIn() <0 )  return  getQuality() + 2;
       return getQuality();
    }
}
