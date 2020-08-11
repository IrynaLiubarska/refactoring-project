package refactoring;

public abstract class Item {

    private String name;

  int sellIn;

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

     int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract int updateSellIn();
    public abstract int updateQuality();

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}