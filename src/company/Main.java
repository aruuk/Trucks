package company;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static company.Driver.*;
import static company.Trucks.*;

public class Main {

    public static void main(String[] args) {

        while (true) {

            Driver[] drivers = {
                    driverMaker(1,"Petr"),
                    driverMaker(2,"Askar"),
                    driverMaker(3,"Uson")
            };

            Trucks[] trucks = {
                    makeTrucks(1, "Volvo", State.BASE, drivers),
                    makeTrucks(2, "Renault", State.BASE, drivers),
                    makeTrucks(3, "DAF XT", State.BASE, drivers),
            };

            String jsonForTrucks = GSON.toJson(trucks);
            write(jsonForTrucks);
//            System.out.println(read());


            String jsonForDrivers = GSON2.toJson(drivers);
            writeDrivers(jsonForDrivers);
//            System.out.println(readDrivers());

            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("#  | Bus    | Driver    | State    ");
                    System.out.println("---+--------+-----------+-----------");
                    Arrays.stream(trucks).forEach(System.out::println);
                    System.out.println();
                    System.out.println("#  | Driver    | Bus");
                    System.out.println("---+-----------+-----------");
                    Arrays.stream(drivers).forEach(System.out::println);
                    break;
                case 1:
                    System.out.println("#  | Bus    | Driver    | State    ");
                    System.out.println("---+--------+-----------+-----------");
                    Arrays.stream(trucks).filter(x -> x.getId() == 1).forEach(System.out::println);
                    System.out.println();
                    System.out.println("#  | Driver    | Bus");
                    System.out.println("---+-----------+-----------");
                    Arrays.stream(drivers).filter(x -> x.getId() == 1).forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("#  | Bus    | Driver    | State    ");
                    System.out.println("---+--------+-----------+-----------");
                    Arrays.stream(trucks).filter(x -> x.getId() == 2).forEach(System.out::println);
                    System.out.println();
                    System.out.println("#  | Driver    | Bus");
                    System.out.println("---+-----------+-----------");
                    Arrays.stream(drivers).filter(x -> x.getId() == 2).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("#  | Bus    | Driver    | State    ");
                    System.out.println("---+--------+-----------+-----------");
                    Arrays.stream(trucks).filter(x -> x.getId() == 3).forEach(System.out::println);
                    System.out.println();
                    System.out.println("#  | Driver    | Bus");
                    System.out.println("---+-----------+-----------");
                    Arrays.stream(drivers).filter(x -> x.getId() == 3).forEach(System.out::println);
                    break;
                default:
                    System.err.println("error");
            }

            //State.BASE.changeDriver();
        }
    }
}