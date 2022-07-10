package company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    private int id;
    private String name;

    public static final GsonBuilder GSONBUILDER = new GsonBuilder();
    public static final Path WRITE_PATH = Paths.get("drivers.json");
    public static final Gson GSON2 = GSONBUILDER.setPrettyPrinting().create();

    public Driver() {
    }

    public static Driver driverMaker(int id, String name) {
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        return driver;
    }

    public static void writeDrivers(String o) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, o, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /*public static String readDrivers() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "  |" + name + "        |";
    }
}
