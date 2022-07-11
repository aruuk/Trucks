package company;

import java.util.List;

public interface Service {
    void changeDriver(List<Trucks> list1, List<Driver> list2, int id) ;
    void startDriving(List<Trucks> list1, List<Driver> list2, int id);
    void startRepair(List<Trucks> list1, List<Driver> list2, int id);
}
