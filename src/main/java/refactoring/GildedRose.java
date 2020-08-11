package refactoring;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.setSellIn(item.updateSellIn());
            item.setQuality(item.updateQuality());
        }
    }
}