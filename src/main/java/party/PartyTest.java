package main.java.party;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartyTest {
    @Test public void testPartyHasGreeting() {
        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.order();
        assertNotNull("Greeting is not null", party.getGreeting());
        assertEquals("Hello", party.getGreeting());
    }

    @Test public void testPartyHasNoGreeting() {
        Party.PartyBuilder partyBuilder = new Party.PartyBuilder(null);
        Party party = null;
        try {
            party = partyBuilder.order();
        } catch (Exception e) {
            assertNull("Greeting is required. No party created.", party);
        }
    }

    @Test public void testPartyHasBalloon() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 1)
                .material("mylar")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).order();
        assertNotNull("Ballon is not null", party.getBalloons().get(0));
        assertNull("Cake is null", party.getCakes());
    }

    @Test public void testPartyHasCake() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).order();
        assertNull("Balloon is null", party.getBalloons());
        assertNotNull("Cake is not null", party.getCakes().get(0));
    }

    @Test public void testPartyHasBothBalloonAndCake() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 1)
                .material("mylar")
                .build();
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).cake(cake1).order();
        assertNotNull("Balloon is not null", party.getBalloons().get(0));
        assertNotNull("Cake is not null", party.getCakes().get(0));
    }

    @Test public void testPartyHas2Cakes() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();
        Cake cake2 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).cake(cake2).order();
        assertEquals(2, party.getCakes().size());
    }

    @Test public void testBalloonColor() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 1)
                .material("mylar")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).order();
        assertEquals("red", party.getBalloons().get(0).getColor());
    }

    @Test public void testBalloonQty() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 3)
                .material("mylar")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).order();
        assertEquals(3, party.getBalloons().get(0).getQty());
    }

    @Test public void testBalloonMaterial() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 3)
                .material("mylar")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).order();
        assertEquals("mylar", party.getBalloons().get(0).getMaterial());
    }

    @Test public void testBalloonHasNoMaterial() {
        Balloon balloon1 = new Balloon.BalloonBuilder("red", 3)
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.balloon(balloon1).order();
        assertNull("No material", party.getBalloons().get(0).getMaterial());
    }

    @Test public void testCakeHasFlavor() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).order();
        assertEquals("chocolate", party.getCakes().get(0).getFlavor());
    }

    @Test public void testCakeHasSize() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).order();
        assertEquals("med", party.getCakes().get(0).getSize());
    }

    @Test public void testCakeHasShape() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).order();
        assertEquals("circle", party.getCakes().get(0).getShape());
    }

    @Test public void testCakeHasColor() {
        Cake cake1 = new Cake.CakeBuilder("chocolate", "med")
                .frostingFlavor("vanilla")
                .shape("circle")
                .color("brown")
                .build();

        Party.PartyBuilder partyBuilder = new Party.PartyBuilder("Hello");
        Party party = partyBuilder.cake(cake1).order();
        assertEquals("brown", party.getCakes().get(0).getColor());
    }
}
