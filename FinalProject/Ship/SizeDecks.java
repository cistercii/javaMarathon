package FinalProject.Ship;

public enum SizeDecks {
        FourDecks(4, 1, "Четырехпалубный"),
        ThreeDecks(3, 2, "Трехпалубный"),
        TwoDecks(2,3, "Двупалубный"),
        OneDeck(1,4, "Однопалубный");

        private final int size;
        private final int count_ships;
        private final String name;

        SizeDecks(int size, int count_ships, String name) {
                this.size = size;
                this.count_ships = count_ships;
                this.name = name;
        }

        public int getSize() {
                return size;
        }

        public String getName() {
                return name;
        }

        public int getCount_ships() {
                return count_ships;
        }
}
