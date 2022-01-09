package com.williamdaw.RPG_game;

public class PotentialMurderLocation extends Item {
    String Potential_name;
    public PotentialMurderLocation(String value) {
        super(value);
        Potential_name = this.value;
    }
    public String get_potential_murder_location_name() {
        return this.Potential_name;
    }

}
