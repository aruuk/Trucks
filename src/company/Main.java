package company;


import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static company.Driver.*;
import static company.Trucks.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static <JSONObject> void main(String[] args) {

        while (true) {

            Driver[] drivers = {
                    driverMaker(1, "Petr"),
                    driverMaker(2, "Askar"),
                    driverMaker(3, "Uson")
            };

            Trucks[] trucks = {
                    makeTrucks(1, "Volvo", "", "BASE"),
                    makeTrucks(2, "Renault", "", "BASE"),
                    makeTrucks(3, "DAF XT", "", "BASE"),
            };

            String jsonForTrucks = GSON.toJson(trucks);
            write(jsonForTrucks);
//            System.out.println(read());
            System.out.println("#  | Bus    | Driver    | State    ");
            System.out.println("---+--------+-----------+-----------");
            Arrays.stream(trucks).forEach(System.out::println);
            String jsonForDrivers = GSON2.toJson(drivers);
            writeDrivers(jsonForDrivers);

//            try {
//                String data2 =new String(Files.readAllBytes(Path.of("drivers.json")));
//                JSONObject jsonObject=new JSONObject(data2);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            Driver driver = new Driver();
            List<Trucks> list1 = new ArrayList<Trucks>(List.of(trucks));
            List<Driver> list2 = new ArrayList<Driver>(List.of(Driver.driverMaker(1,"Petr"),
                    Driver.driverMaker(2,"Askar"),
                    Driver.driverMaker(3,"Ivan")));
            reaction(list1, list2);


//            System.out.println(readDrivers());

//            Scanner scanner = new Scanner(System.in);
//            switch (scanner.nextInt()) {
//                case 0:
//                    System.out.println("#  | Bus    | Driver    | State    ");
//                    System.out.println("---+--------+-----------+-----------");
//                    Arrays.stream(trucks).forEach(System.out::println);
//                    System.out.println();
//                    System.out.println("#  | Driver    | Bus");
//                    System.out.println("---+-----------+-----------");
//                    Arrays.stream(drivers).forEach(System.out::println);
//                    break;
//                case 1:
//                    System.out.println("#  | Bus    | Driver    | State    ");
//                    System.out.println("---+--------+-----------+-----------");
//                    Arrays.stream(trucks).filter(x -> x.getId() == 1).forEach(System.out::println);
//                    System.out.println();
//                    System.out.println("#  | Driver    | Bus");
//                    System.out.println("---+-----------+-----------");
//                    Arrays.stream(drivers).filter(x -> x.getId() == 1).forEach(System.out::println);
//                    break;
//                case 2:
//                    System.out.println("#  | Bus    | Driver    | State    ");
//                    System.out.println("---+--------+-----------+-----------");
//                    Arrays.stream(trucks).filter(x -> x.getId() == 2).forEach(System.out::println);
//                    System.out.println();
//                    System.out.println("#  | Driver    | Bus");
//                    System.out.println("---+-----------+-----------");
//                    Arrays.stream(drivers).filter(x -> x.getId() == 2).forEach(System.out::println);
//                    break;
//                case 3:
//                    System.out.println("#  | Bus    | Driver    | State    ");
//                    System.out.println("---+--------+-----------+-----------");
//                    Arrays.stream(trucks).filter(x -> x.getId() == 3).forEach(System.out::println);
//                    System.out.println();
//                    System.out.println("#  | Driver    | Bus");
//                    System.out.println("---+-----------+-----------");
//                    Arrays.stream(drivers).filter(x -> x.getId() == 3).forEach(System.out::println);
//                    break;
//                default:
//                    System.err.println("error");
//            }

            //State.BASE.changeDriver();
        }
    }

    public static void reaction(List<Trucks> list1, List<Driver> list2) {
        //  int id;
        while (true) {
            try {
                System.out.println(ANSI_PURPLE + "Choose one of the TRUCK: " + ANSI_RESET);
                int id = scanner.nextInt();
                id--;
                System.out.println(ANSI_YELLOW + "----------------TRUCK-INFO-----------------" + ANSI_RESET);
                System.out.println("N                :" + list1.get(id).getId());
                System.out.println("BUS              :" + list1.get(id).getNameOfTrucks());
                System.out.println("Driver           :" + list1.get(id).getDriver());
                System.out.println("State            :" + list1.get(id).getStates());
                System.out.println(ANSI_PURPLE + "Press 1 to change or assign new DRIVER" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "Press 2 to start DRIVING" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "Press 3 to start REPAIRING" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "Press 4 if you wish to stop program" + ANSI_RESET);
                String choice = scanner.nextLine();
                if (choice.equals("4")) {
                    System.exit(0);
                }
                Impl actions = new Impl(list1, list2, id);
                switch (choice) {
                    case "1" -> actions.changeDriver(list1, list2, id);
                    case "2" -> actions.startDriving(list1, list2, id);
                    case "3" -> actions.startRepair(list1, list2, id);
                }
                list1 = actions.getList1();
                list2 = actions.getList2();
//                displayDrivers(list2);
//                displayTrucks(list1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(ANSI_RED + "You turned to a non-existent truck)!\n" +
                        "Number of trucks: " + list1.size());
            }
        }
    }

    public static void displayDrivers(List<Driver> list2) {
        System.out.println(ANSI_YELLOW + "----------------Drivers-----------------" + ANSI_RESET);
        System.out.println("|# |driver-id |  Driver |      Bus     |");
        System.out.println("|--|----------|---------|--------------|");
        for (Driver driverInfo : list2) {
            System.out.print(driverInfo.getId());
            System.out.print(driverInfo.getId());
            System.out.print(driverInfo.getName());
            System.out.print(driverInfo.getBus());
            System.out.println();
        }
    }

    public static void displayTrucks(List<Trucks> list1) {
        System.out.println(ANSI_YELLOW + "-----------------TRUCKS-------------------" + ANSI_RESET);
        System.out.println("|#id|      Bus      |    Driver   |State |");
        System.out.println("|---|---------------|-------------|------|");
        for (Trucks autoPark : list1) {
            System.out.print(autoPark.getId());
            System.out.print(autoPark.getNameOfTrucks());
            System.out.print(autoPark.getDriver() + " ");
            System.out.print(autoPark.getStates());
            System.out.println();
        }
    }
}