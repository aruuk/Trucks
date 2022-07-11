package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Impl implements Service {
    Random random = new Random();
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    List<Trucks> list1 = new ArrayList<Trucks>();
    List<Driver> list2 = new ArrayList<Driver>();
    private int id;

    public Impl(List<Trucks> list1, List<Driver> list2, int id) {
        this.list1 = list1;
        this.list2 = list2;
        this.id = id;
    }

    @Override
    public void changeDriver(List<Trucks> list1, List<Driver> list2, int id) {


        //if already on the road
        if (list1.get(id).getStates().equals("ROUTE")) {
            System.out.println(ANSI_RED + "We can't change the driver, because he is already on the road!" + ANSI_RESET);
        }

        //assigning new driver
        else if (list1.get(id).getDriver().equals("1")) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.get(i).getBus().equals("Volvo")) {
                    list1.get(id).setDriver(list2.get(i).getName());
                    list2.get(i).setBus(list1.get(id).getNameOfTrucks());
                    System.out.println(ANSI_PURPLE + "Driver has been assigned successfully!" + ANSI_RESET);
                    break;
                    //
                }
            }
        }
        //changing driver if already has one
        else if (!list1.get(id).getDriver().equals("")) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(id).getDriver().equals(list2.get(i).getName())) {
                    list2.get(i).setBus("");
                    continue;
                }
                if (list2.get(i).getBus().equals("Renault")) {
                    list1.get(id).setDriver(list2.get(i).getName());
                    list2.get(i).setBus(list1.get(id).getNameOfTrucks());
                    System.out.println(ANSI_PURPLE + "Driver has been assigned successfully!" + ANSI_RESET);
                    break;
                    //

                }
            }
        } else if (list1.get(id).getStates().equals("REPAIR")) {
            System.out.println(ANSI_RED + "We can't assign or change a driver" + ANSI_RESET);
        }
    }

    @Override
    public void startDriving(List<Trucks> list1, List<Driver> list2, int id) {

        int k = random.nextInt(3 - 1) + 1;
        //if already on the road
        if (list1.get(id).getStates().equals("ROUTE")) {
            System.out.println(ANSI_RED + "The truck is already on the road" + ANSI_RESET);
        }
        //if under repair and need to change state
        else if (list1.get(id).getStates().equals("REPAIR") && !list1.get(id).getDriver().equals("")) {
            if (k == 1) {
                list1.get(id).setStates("ROUTE");
                System.out.println(ANSI_PURPLE + "Changed state from REPAIR to ROUTE" + ANSI_RESET);
            } else {
                list1.get(id).setStates("BASE");
                System.out.println(ANSI_PURPLE + "Changed state from REPAIR to STATE" + ANSI_RESET);
            }
        } else if (list1.get(id).getStates().equals("REPAIR") && list1.get(id).getDriver().equals("")) {
            if (k == 2) {
                list1.get(id).setStates("BASE");
                System.out.println(ANSI_PURPLE + "Changed state from REPAIR to BASE" + ANSI_RESET);

            }
        }
        // can't drive without a driver
        else if (list1.get(id).getStates().equals("BASE") && list1.get(id).getDriver().equals("")) {
            System.out.println(ANSI_RED + "You can't start driving without a driver" + ANSI_RESET);
        }
        //making a truck driving
        else if (!list1.get(id).getDriver().equals("")) {
            list1.get(id).setStates("ROUTE");
            System.out.println(ANSI_PURPLE + "Successfully started driving!" + ANSI_RESET);
        }

    }

    @Override
    public void startRepair(List<Trucks> list1, List<Driver> list2, int id) {
        //if base or route assigning REPAIR
        switch (list1.get(id).getStates()) {
            case "ROUTE" -> {
                list1.get(id).setStates("REPAIR");
                System.out.println(ANSI_PURPLE + "Successfully changed from ROUTE to REPAIR" + ANSI_PURPLE);
            }
            case "BASE" -> {
                list1.get(id).setStates("REPAIR");
                System.out.println(ANSI_PURPLE + "Successfully changed from BASE to REPAIR" + ANSI_PURPLE);
            }
            //if already under repairment
            case "REPAIR" -> System.out.println(ANSI_RED + "This truck is already under repairment!" + ANSI_RESET);

        }
    }

    public List<Trucks> getList1() {
        return list1;
    }

    public List<Driver> getList2() {
        return list2;
    }

}
