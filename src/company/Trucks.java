package company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Trucks {
    private int id;
    private String nameOfTruck;
    private State state;
    private Driver[] drivers;
    public Trucks() {
    }
    public static final GsonBuilder GSONBUILDER = new GsonBuilder();
    public static final Path WRITE_PATH = Paths.get("lorry.json");
    public static final Gson GSON = GSONBUILDER.setPrettyPrinting().create();
    public static Trucks makeTrucks(int id, String nameOfTruck,  State state, Driver[]drivers) {
        Trucks trucks = new Trucks();
        trucks.id = id;
        trucks.nameOfTruck = nameOfTruck;
        trucks.state = state;
        trucks.drivers = drivers;
        return trucks;
    }

    public static void write(String o) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, o, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /*public static String read() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char)a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTrucks() {
        return nameOfTruck;
    }

    public void setNameOfTrucks(String nameOfTruck) {
        this.nameOfTruck = nameOfTruck;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver[] drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return id + "   " + nameOfTruck +"                  " + state;
    }
}
