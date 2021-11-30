package com.williamdaw.RPG_game;

import javax.print.attribute.standard.Media;
import java.util.Scanner;

//interface rooms {
//    public void library
//    // stairs
//    // roof top
// font 13

///

class murder_sequance<MediaPlayer> {

//    String song = "song.mp3";
//    Media track = new Media(song);
//    MediaPlayer mediaPlayer = new MediaPlayer(track);
//    mediaPlayer.play();

}

public class Main {
    public static String murder_room;
    String[][] inventory = new String[5][2];
    public static String[] user_name = new String[2];
    public static void main(String[] args) throws Exception {
        String[] bedrooms = {"Guest", "Master", "Child"};
        String[] other_rooms = {"Porch", "Living Room", "Kitchen", "Boot Room"};
        String[] bathrooms = {"Downstairs Bathroom", "Upstairs Bathroom"};
        String[] murder_location_choice = new String[3];


//        Map<String, Integer> test_map = new HashMap<String, Integer>() { { "Here", 1 }, { } };
//        test_map["here"] == 1
        murder_location_choice[0] = bathrooms[(int) (Math.random() * (2) - 1)];
        murder_location_choice[1] = other_rooms[(int) (Math.random() * (4) - 1)];
        murder_location_choice[2] = bathrooms[(int) (Math.random() * (3) - 1)];
        murder_room = murder_location_choice[(int) (Math.random() * (2) - 1)];
        System.out.println(murder_room);
        House house = new House();
        for (String bedroom : bedrooms) house.add_room(new Bedroom(bedroom, 1));
        for (String room : other_rooms) house.add_room(new Room(room, 0));
        house.add_room(new Room[] { new Bathroom(null, 0), new Bathroom(House.get_room("Master Bedroom"), 1) });
        house.add_room(new Room[] { new Hallway(0), new Hallway(1) });
        System.out.println("enter username:");
        Scanner input = new Scanner(System.in);
        user_name = (input.nextLine()).split(" ");

    }
}

