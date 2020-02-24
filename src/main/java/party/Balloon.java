package main.java.party;

public class Balloon {
    private String color;       // required
    private String material;    // optional
    private int qty;         // required

    private Balloon(BalloonBuilder builder) {
        this.color = builder.color;
        this.material = builder.material;
        this.qty = builder.qty;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Balloon: color[" + this.color + "], material[" + this.material + "], qty[" + this.qty + "]";
    }

    public static class BalloonBuilder {
        private final String color;
        private String material;
        private final int qty;

        public BalloonBuilder(String color, int qty) {
            this.color = color;
            this.qty = qty;
        }

        public BalloonBuilder material(String material) {
            this.material = material;
            return this;
        }

        public Balloon build() {
            Balloon balloon = new Balloon(this);
            validateBalloon(balloon);
            return balloon;
        }

        private void validateBalloon(Balloon balloon) {
            if (balloon == null) {
                throw new NullPointerException("Balloon is null.");
            }
            if (balloon.color == null) {
                throw new NullPointerException("Color is required.");
            }
            if (balloon.qty <= 0) {
                throw new NullPointerException("Qty is required.");
            }
        }
    }

    public static void main(String[] args) {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 1)
                .material("mylar")
                .build();
        System.out.println(balloon1);

        Balloon balloon2 = new Balloon.BalloonBuilder("yellow", 2)
                //no material
                .build();
        System.out.println(balloon2);

        try {
            Balloon balloon3 = new BalloonBuilder(null, 2)
                    //no material
                    .build();
            System.out.println(balloon3);
        } catch (Exception e) {
            System.out.println("balloon3 NullPointException: " + e.getMessage());
        }

        try {
            Balloon balloon4 = new BalloonBuilder("blue", 0)
                    //no material
                    .build();
            System.out.println(balloon4);
        } catch (Exception e) {
            System.out.println("balloon4 NullPointException: " +e.getMessage());
        }

        Balloon balloon5 = new Balloon.BalloonBuilder("green", 3)
                .material("mylar")
                .material("latex")
                .build();
        System.out.println(balloon5);
    }
}
