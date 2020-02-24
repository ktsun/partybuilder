package main.java.party;

import java.util.ArrayList;

public class Party {
    private String greeting;                // required
    private ArrayList<Balloon> balloons;    // optional
    private ArrayList<Cake> cakes;          // optional

    private Party(Party.PartyBuilder builder) {
        this.greeting = builder.greeting;
        this.balloons = builder.balloons;
        this.cakes = builder.cakes;
    }

    public String getGreeting() {
        return greeting;
    }

    public ArrayList<Balloon> getBalloons() {
        return balloons;
    }

    public ArrayList<Cake> getCakes() {
        return cakes;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Party: greeting[" + this.greeting + "]\n";

        if (this.balloons != null) {
            for (Balloon balloon : balloons) {
                result += "Balloon ordered: " + balloon.toString() + "\n";
            }
        }

        if (this.cakes != null) {
            for (Cake cake : cakes) {
                result += "Cake ordered: " + cake.toString() + "\n";
            }
        }
        return result;
    }

    public static class PartyBuilder {
        private final String greeting;
        private ArrayList<Balloon> balloons;
        private ArrayList<Cake> cakes;

        public PartyBuilder(String greeting) {
            this.greeting = greeting;
        }

        public Party.PartyBuilder balloon(Balloon balloon) {
            if (balloons == null) {
                ArrayList<Balloon> balloons = new ArrayList<Balloon>();
                this.balloons = balloons;
            }
            balloons.add(balloon);
            return this;
        }

        public Party.PartyBuilder cake(Cake cake) {
            if (cakes == null) {
                ArrayList<Cake> cakes = new ArrayList<Cake>();
                this.cakes = cakes;
            }
            cakes.add(cake);
            return this;
        }

        public Party order() {
            Party party = new Party(this);
            validateParty(party);
            return party;
        }

        private void validateParty(Party party) {
            if (party == null) {
                throw new NullPointerException("Party is null.");
            }
            if (party.greeting == null) {
                throw new NullPointerException("Greeting is required.");
            }
        }
    }

    public static void main(String[] args) {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 1)
                .material("mylar")
                .build();

        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party party1 = new Party.PartyBuilder("Happy Birthday Jason")
                .balloon(balloon1)
                .balloon(new Balloon.BalloonBuilder("yellow", 2)
                        .material("latex")
                        .build())
                .cake(cake1)
                .order();
        System.out.println(party1);


    }
}
