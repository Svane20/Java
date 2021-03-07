package com.mycompany.foodwaste_project.domain;

import java.util.ArrayList;

public class Game {

    Time time = new Time();

    private String name;
   
    private Room currentRoom;
    private String pName;
    private Room nextRoom;
    private String notificationMessage, questMessage;

    Characters p1 = new Characters();
    Point point = new Point();
    Smartphone ph = new Smartphone();
    monetarySystem m1 = new monetarySystem();

    ArrayList<Item> inventory = new ArrayList();
    ArrayList<Quests> questList = new ArrayList();
    ArrayList<Events> eventList = new ArrayList();

    public Game() {
        createRooms();
       
    }

    private static Game sSoleInstance;

    public static Game getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new Game();
        }

        return sSoleInstance;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHealth() {
        return p1.health;
    }

    public int getHunger() {
        return p1.hunger;
    }

    public double getMoney() {
        return m1.balance;
    }

    public String getName() {
        return pName;
    }

    public double getPoint() {
        return point.getPoint();
    }

    public void setName(String value) {
        pName = value;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public int getDay() {
        return time.getDateOfDays();
    }

    public int getTime() {
        return time.getDateOfHours();
    }

    public String getEventMessage() {
        return notificationMessage;
    }

    public String getQuestDescription() {
        checkQuest();
        return questMessage;
    }

    public void Buy(double price) {
        m1.balance = m1.balance - price;
    }

    public Room getNextRoom(String roomName) {
        return currentRoom.getExit(roomName);
    }

    public void goToRoom(String roomName) {

        nextRoom = currentRoom.getExit(roomName);

        if (nextRoom.isUnlocked() == false) {
            return;
        } else {
            currentRoom = nextRoom;
        }

        time.swichHour();

        if (p1.getHunger() <= 30) {
            p1.subHealth();
        }

        if (p1.getHunger() <= 0) {
            p1.hunger = 0;
        } else {
            p1.subHunger();
        }

        for (Item p : inventory) {

            if (!p.isFood()) {
                continue;
            }

            if (p.getHoursToRot() == 0) {
                p.setSpoilStatus(true);
            } else {
                p.setRotHoursMinus(1.00);

            }
        }
    }

    private void checkQuest() {
        for (Quests var : questList) {
            if (var.getDay() != time.getDateOfDays() || var.getFinished()) {
                questMessage = "No quest today, or you already completed it";
                continue;
            }

            questMessage = var.getDescription();
            break;
        }
    }

    public void createRooms() {
        Room outside, apartment, kitchen, livingroom, bedroom, supermarked, McDonalds, loesMarket;

        outside = new Room("in the Streets of Copenhagen", true);
        apartment = new Room("in the entrance of your apartment", false);
        kitchen = new Room("in your kitchen", true);
        livingroom = new Room("in your living room", true);
        bedroom = new Room("in the bedroom", true);
        supermarked = new Room("in Fakta", true);
        McDonalds = new Room("at McDonalds", true);
        loesMarket = new Room("you have entered Loes-Market", true);

        outside.setExit("fakta", supermarked);
        outside.setExit("apartment", apartment);
        outside.setExit("mcdonalds", McDonalds);
        outside.setExit("naturmarket", loesMarket);

        apartment.setExit("bedroom", bedroom);
        apartment.setExit("outside", outside);
        apartment.setExit("kitchen", kitchen);
        apartment.setExit("livingroom", livingroom);

        bedroom.setExit("apartment", apartment);
        bedroom.setExit("livingroom", livingroom);

        livingroom.setExit("apartment", apartment);
        livingroom.setExit("bedroom", bedroom);
        livingroom.setExit("Kitchen", kitchen);

        kitchen.setExit("apartment", apartment);
        kitchen.setExit("livingroom", livingroom);

        supermarked.setExit("outside", outside);

        McDonalds.setExit("outside", outside);

        loesMarket.setExit("outside", outside);

        currentRoom = outside;

        // Creating all the inventories for the rooms.
        ArrayList<Item> outsideItems = new ArrayList();
        ArrayList<Item> supermarkedItems = new ArrayList();
        ArrayList<Item> livingroomItems = new ArrayList();
        ArrayList<Item> kitchenItems = new ArrayList();
        ArrayList<Item> apartmentItems = new ArrayList();
        ArrayList<Item> bedroomItems = new ArrayList();
        ArrayList<Item> mcDonaldsItems = new ArrayList();
        ArrayList<Item> loesMarketItems = new ArrayList();

        // Adding items to the specific rooms
        Item uncookedchicken, meat, bread, milk, cake, rice, ryebread, cheeseburger, rice100g, burger, chickennuggets, key, letter, brownRice, meatloaf, apple, pineapple, onions, cucumber, tomatos;

        milk = new Item("milk", "This is milk!", 14, true, true, 20);
        meat = new Item("meat", "This is meat!", 35, true, true, 30);
        cake = new Item("cake", "This is a whole cake!", 60, true, true, 50);
        rice = new Item("rice", "This is 500g of white rice!", 25, true, true, 50);
        meatloaf = new Item("meatloaf", "This is meatloaf", 30, true, true, 30);
        brownRice = new Item("brownRice", "This is brownRice!", 60, true, true, 20);
        ryebread = new Item("ryebread", "This is a loaf of ryebread", 25, true, true, 25);
        cheeseburger = new Item("cheeseburger", "This is a cheeseburger!", 10, true, true, 30);
        rice100g = new Item("100g-Rice", "This is 100g of rice", 5, true, true, 10);
        burger = new Item("burger", "This is a burger!", 10, true, true, 28);
        chickennuggets = new Item("chickennuggets", "These are chicken nuggets", 25, true, true, 40);
        apple = new Item("apple", "This is a apple ", 20, true, true, 5);
        pineapple = new Item("pineapple", "This is pineapple", 15, true, true, 25);
        onions = new Item("onions", "This are onions", 10, true, true, 30);
        cucumber = new Item("cucumber", "This is cucumber", 8, true, true, 20);
        tomatos = new Item("tomato", "This are tomatos", 10, true, true, 30);

        // Quest items
        bread = new Item("bread", "This is a loaf of bread", 30, true, false, 25);
        key = new Item("key", "This is your apartment key", 0, false, false, 0);
        letter = new Item("letter", "This is a letter for your grandma", 0, false, false, 0);
        uncookedchicken = new Item("uncooked-chicken", "This is uncooked chicken", 0, false, false, 0);

        outsideItems.add(key);

        apartmentItems.add(letter);

        supermarkedItems.add(meat);
        supermarkedItems.add(milk);
        supermarkedItems.add(cake);
        supermarkedItems.add(rice);
        supermarkedItems.add(ryebread);
        supermarkedItems.add(bread);
        supermarkedItems.add(brownRice);
        supermarkedItems.add(meatloaf);
        kitchenItems.add(uncookedchicken);

        mcDonaldsItems.add(cheeseburger);
        mcDonaldsItems.add(burger);
        mcDonaldsItems.add(chickennuggets);

        loesMarketItems.add(rice100g);
        loesMarketItems.add(apple);
        loesMarketItems.add(pineapple);
        loesMarketItems.add(onions);
        loesMarketItems.add(cucumber);
        loesMarketItems.add(tomatos);

        outside.fillArray(outsideItems);
        supermarked.fillArray(supermarkedItems);
        kitchen.fillArray(kitchenItems);
        livingroom.fillArray(livingroomItems);
        apartment.fillArray(apartmentItems);
        bedroom.fillArray(bedroomItems);
        McDonalds.fillArray(mcDonaldsItems);
        loesMarket.fillArray(loesMarketItems);

        // Create Quests
        Quests questOne = new Quests(1, "You need to pickup the key outside your apartment, and unlock your house door!", "You just unlocked your front door.", outside, key);
        Quests questTwo = new Quests(2, "You need to pickup the letter inside your apartment, it is a letter for your grandma, you better bring it to the post office in fakta.", "You just gave your letter to the post office.", supermarked, letter);
        Quests questThree = new Quests(4, "Buy some bread in fakta and bring it home, just place it on the kitchen counter - Mom", "You just brought some bread home", kitchen, bread);
        Quests questFour = new Quests(6, "We bought way too much meat. Bring the uncooked chicken from the kitchen to fakta and get the money back. ", "You just returned some chicken to fakta", supermarked, uncookedchicken);

        questList.add(questOne);
        questList.add(questTwo);
        questList.add(questThree);
        questList.add(questFour);

        // Create Events
        Events e1 = new Events(3, "Instead of going to sleep, you went out with your friends. Doing the night you bought McDonalds and your food at home got spoiled.", -200);
        Events e2 = new Events(5, "Your electric bill just came in, and you used way to much electricity. Stop letting netflix run whileyou sleep", -450);

        eventList.add(e1);
        eventList.add(e2);

    }

    public void events(String msg) {
        String standardMessage = msg;
        notificationMessage = standardMessage;

        for (Events var : eventList) {

            if (var.getDay() == time.getDateOfDays()) {
                if (var.getDay() == 3) {
                    var.printDescription();
                    m1.setBalance(var.getPenalty());

                    inventory.forEach((items)
                            -> {
                        items.setSpoilStatus(true);
                    });
                    notificationMessage = var.getDescription();

                } else if (var.getDay() == 5) {
                    var.printDescription();
                    m1.setBalance(var.getPenalty());
                    notificationMessage = var.getDescription();

                }
            }
        }
    }

    public void play() {

        boolean finished = false;
    }

    public void eat(String item) {

        for (Item var : inventory) {

            if (var.getName().equals(item) && var.isFood()) {

                if (var.getSpoiledStatus()) {
                    p1.setHealth(10);
                    inventory.remove(var);
                    return;
                } else {
                    if ((p1.hunger + var.getNutrition()) >= 100) {
                        inventory.remove(var);
                        return;
                    } else {
                        inventory.remove(var);
                        p1.hunger += var.getNutrition();
                        return;
                    }

                }
            }
        }
    }

    public void throwout(String item) {

        for (Item var : inventory) {

            if (!var.getName().equals(item)) {
                continue;
            }

            if (!var.isFood()) {
                return;
            }

            if (var.getSpoiledStatus()) {
                point.setMinusPoint(5);
                inventory.remove(var);
                return;
            } else {
                point.setMinusPoint(10);
                inventory.remove(var);
                return;
            }
        }
    }

    public void donate(String item) {

        for (Item var : inventory) {

            if (!var.getName().equals(item)) {
                continue;
            }

            if (!var.isFood()) {
                return;
            }

            if (var.getSpoiledStatus()) {
                inventory.remove(var);
                return;
            } else {
                point.setPlusPoint(10);
                inventory.remove(var);
                return;
            }
        }

    }

    public void pickUp(String item) {

        for (Item var : currentRoom.items) {
            if (!var.getName().equals(item)) {
                continue;
            }

            if (!var.isBuyable()) {
                inventory.add(var);
                currentRoom.items.remove(var);
                return;
            } else {
                return;
            }
        }
    }

    public void dropItem(String item) {

        for (Item var : inventory) {

            if (!var.getName().equals(item)) {
                continue;
            }
            inventory.remove(var);
            currentRoom.getArray().add(var);
            return;
        }
    }

    public void useItem(String item) {

        if (inventory.isEmpty()) {
            return;
        }

        for (Item var : inventory) {
            if (!var.getName().equals(item)) {
                continue;
            }

            for (Quests quest : questList) {
                if (!quest.getObject().equals(var)) {
                    continue;
                }

                if (quest.getDay() != time.getDateOfDays()) {
                    return;
                }

                if (quest.getDestination() == currentRoom) {
                    System.out.println(quest.getSuccess());
                    inventory.remove(var);
                    quest.setFinished(true);

                    switch (quest.getDay()) {
                        case 1:
                            unlockApartment();
                            point.setPlusPoint(100);
                            break;
                        case 2:
                            point.setPlusPoint(200);
                            break;
                        case 3:
                            point.setPlusPoint(300);
                            break;
                        case 4:
                            point.setPlusPoint(400);
                            break;
                        case 5:
                            point.setPlusPoint(500);
                            break;
                        case 6:
                            point.setPlusPoint(600);
                            break;
                        case 7:
                            point.setPlusPoint(700);
                            break;
                        default:

                            break;
                    }

                    return;
                }
            }
        }
    }

    private void unlockApartment() {
        Room nextRoom = currentRoom.getExit("apartment");
        nextRoom.setUnlocked(true);
    }

    

    public void sleep() {
        if (currentRoom.getShortDescription() == "in the bedroom") {
            time.swichDayWithBed();
            String msg = "You just slept " + currentRoom.getShortDescription() + ". You had 6 hours of sleep. It is now day: " + time.getDateOfDays() + " and the clock is " + time.getDateOfHours();
            //time.checkForDaysQuitGame();
            events(msg);
        } else {
            time.swichDayOutsideOfBedroom();
            String msg = "You just slept " + currentRoom.getShortDescription() + ". You had 16 hours of sleep. It is now day: " + time.getDateOfDays() + " and the clock is " + time.getDateOfHours() + ". It is better to sleep inside your bedroom.";
            //time.checkForDaysQuitGame();
            events(msg);
        }
    }

    private void phone() {
        ph.phoneMode = true;
        ph.onPhone();
    }

    public boolean checkTimeIsZero() {
        if (time.getDateOfHours() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
