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
    public static final String BASE = "BASE";
    public static final String ROUTE = "ROUTE";
    public static final String REPAIR = "REPAIR";
    private int id;
    private String nameOfTruck;
    private String driver;
    private String states;
    public Trucks() {
    }
    public static final GsonBuilder GSONBUILDER = new GsonBuilder();
    public static final Path WRITE_PATH = Paths.get("lorry.json");
    public static final Gson GSON = GSONBUILDER.setPrettyPrinting().create();
    public static Trucks makeTrucks(int id, String nameOfTruck, String drivers,String states) {
        Trucks trucks = new Trucks();
        trucks.id = id;
        trucks.nameOfTruck = nameOfTruck;
        trucks.driver = drivers;
        trucks.states=states;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String drivers) {
        this.driver = drivers;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return id + "   " + nameOfTruck +"                  "+states;
    }
}
