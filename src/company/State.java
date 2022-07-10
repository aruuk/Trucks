package company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public enum State {
    BASE() {
        void chooseTruck() {
            Trucks trucks = new Trucks();
            Scanner scanner = new Scanner(System.in);
            if (trucks.getId() == scanner.nextInt()) {
                System.out.println("you choose " + trucks.getNameOfTrucks() + "truck!");

            }
        }


        @Override
        void changeDriver(Driver[]drivers) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1 -> Arrays.stream(drivers).filter(x -> x.getId() == 1).forEach(System.out::println);
                case 2-> Arrays.stream(drivers).filter(x -> x.getId() == 2).forEach(System.out::println);
                case 3 -> Arrays.stream(drivers).filter(x -> x.getId() ==3).forEach(System.out::println);
                default -> System.err.println("it is wrong num!");
            }

            //можно сменить водителя.
            //если у машины уже есть водитель, его можно сменить.
            //если нет свободных водителей, выдать ошибку.
        }

        @Override
        void startDriving(Trucks[] trucks) {    
            //если выбрана машина и водитель, которые не заняты, пусть поедет, иначе пусть выйдет ошибка.
            //если вызвана машина без водителя, пусть выйдет ошибка.
            //если вызван водитель без машины, пусть выведет ошибку.
            //можно отправить на ремонт.
        }

        @Override
        void doRepair() {
            Trucks trucks = new Trucks();
            trucks.setState(State.REPAIR);
            System.out.println("truck on repair");
        }
    },
    REPAIR() {
        @Override
        void changeDriver(Driver[] drivers) {
            System.err.println("you can't change driver on repair!");
        }

        @Override
        void startDriving(Trucks[]trucks) {
            //можно отправить в дорогу
            Scanner scanner = new Scanner(System.in);
            Arrays.stream(trucks).filter(x -> x.getId() == scanner.nextInt()).map(x -> x.getState().equals(State.REPAIR)).forEach(System.out::println);
            System.out.println("truck on rout!");
        }

        @Override
        void doRepair() {
            System.err.println("truck on repair!");
        }
    },
    ROUTE() {
        @Override
        void changeDriver(Driver[]drivers) {
            System.err.println("you can't change driver!");
        }

        @Override
        void startDriving(Trucks[]trucks) {
            Scanner scanner = new Scanner(System.in);
            Arrays.stream(trucks).filter(x -> x.getId() == scanner.nextInt()).map(x -> x.getState().equals(State.ROUTE)).forEach(System.out::println);
            System.err.println("truck on route!");
        }

        @Override
        void doRepair() {
            Trucks trucks = new Trucks();
            trucks.setState(State.REPAIR);
            System.out.println("truck on the repair!");
        }
    };

//    private String div;
//
//    State(String div) {
//        this.div = div;
//    }

    abstract void changeDriver(Driver[] drivers);

    abstract void startDriving(Trucks[]trucks);

    abstract void doRepair();
}

