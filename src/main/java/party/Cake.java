package main.java.party;

public class Cake {
    private String flavor;              // required
    private String frostingFlavor;      // optional
    private String shape;               // optional
    private String size;                // required
    private String color;               // optional

    private Cake(Cake.CakeBuilder builder) {
        this.flavor = builder.flavor;
        this.frostingFlavor = builder.frostingFlavor;
        this.shape = builder.shape;
        this.size = builder.size;
        this.color = builder.color;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getFrostingFlavor() {
        return frostingFlavor;
    }

    public String getShape() {
        return shape;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cake: flavor[" + this.flavor + "], frostingFlavor[" + this.frostingFlavor + "], shape[" + this.shape + "], size[" + this.size + "], color[" + this.color + "]";
    }

    public static class CakeBuilder {
        private final String flavor;
        private String frostingFlavor;
        private String shape;
        private final String size;
        private String color;

        public CakeBuilder(String flavor, String size) {
            this.flavor = flavor;
            this.size = size;
        }

        public Cake.CakeBuilder frostingFlavor(String frostingFlavor) {
            this.frostingFlavor = frostingFlavor;
            return this;
        }

        public Cake.CakeBuilder shape(String shape) {
            this.shape = shape;
            return this;
        }

        public Cake.CakeBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Cake build() {
            Cake cake = new Cake(this);
            validateCake(cake);
            return cake;
        }

        private void validateCake(Cake cake) {
            if (cake == null) {
                throw new NullPointerException("Cake is null.");
            }
            if (cake.flavor == null) {
                throw new NullPointerException("Flavor is required.");
            }
            if (cake.size == null) {
                throw new NullPointerException("Size is required.");
            }
        }
    }

    public static void main(String[] args) {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();
        System.out.println(cake1);

        Cake cake2 = new Cake.CakeBuilder("vanilla", "large")
                //no frostingFlavor
                //no shape
                //no color
                .build();
        System.out.println(cake2);

        Cake cake3 = new Cake.CakeBuilder("vanilla", "small")
                //no frostingFlavor
                //no shape
                .color("yellow")
                .build();
        System.out.println(cake3);

        Cake cake4 = new Cake.CakeBuilder("vanilla", "large")
                //no frostingFlavor
                .shape("square")
                // no color
                .build();
        System.out.println(cake4);

        Cake cake5 = new Cake.CakeBuilder("chocolate", "small")
                .frostingFlavor("chocolate")
                //no shape
                //no color
                .build();
        System.out.println(cake5);

        try {
            Cake cake6 = new Cake.CakeBuilder(null, null)
                    //no material
                    .build();
            System.out.println(cake6);
        } catch (Exception e) {
            System.out.println("cake6 NullPointException: " + e.getMessage());
        }

        try {
            Cake cake7 = new Cake.CakeBuilder("vanilla", null)
                    //no material
                    .build();
            System.out.println(cake7);
        } catch (Exception e) {
            System.out.println("cake7 NullPointException: " + e.getMessage());
        }

        try {
            Cake cake8 = new Cake.CakeBuilder(null, "med")
                    //no material
                    .build();
            System.out.println(cake8);
        } catch (Exception e) {
            System.out.println("cake8 NullPointException: " + e.getMessage());
        }


        Cake cake9 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("star")
                .color("brown")
                .color("red")
                .build();
        System.out.println(cake9);
    }
}
