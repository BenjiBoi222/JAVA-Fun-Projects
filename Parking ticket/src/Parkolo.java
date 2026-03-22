import java.util.*;

public class Parkolo {
    private static List<String> UsedPlates = new ArrayList<>();
    private static List<Car> CarsInside = new ArrayList<>();

    //Cars inside the garage
    public static void AddNewCarInside(Car car){
        CarsInside.add(car);
        IO.println("----------------");
        IO.println("Car added: " + car.getPlateNumber());
        IO.println("----------------");
    }
    public static void CarRemove(Car car){
        CarsInside.remove(car);

        IO.println("--------------");
        IO.println("Car '" + car.getPlateNumber() + "' got removed from the garage after " + car.getStayingHour() + "hours");
        IO.println("--------------");
    }
    public static void ShowAllCars(){
        IO.println("--------------------");
        for(Car car : CarsInside){
            IO.println("Car plate: " + car.getPlateNumber() + " | Hours stayed: " + car.getStayingHour());
        }
        IO.println("--------------------");
    }
    public static void CheckForLeavingCars(){
        IO.println("--------------");
        for(Car car : CarsInside){
            if(calculatePayAmount(car.getCarSize(), car.getStayingHour()+1) > car.getMoney()){
                IO.println("Car '" + car.getPlateNumber() + "' is due to leave after " + car.getStayingHour() + "hours");
            }
        }
        IO.println("--------------");
    }
    public static Car FindCarByPlate(String plate){
        for(var car : CarsInside){
            if (car.getPlateNumber().equals(plate)) return car;
        }
        return null;
    }



    //Ticket calculations
    public static void PayForTicket(Car car) {
        int amount = calculatePayAmount(car.getCarSize(), car.getStayingHour());
        int carMoney = car.getMoney();
        if (carMoney >= amount) {
            car.setMoney(carMoney - amount);
            ParkoloManager.AddParkoloMoney(amount);

            IO.println("--------------------");
            IO.println("Car '" + car.getPlateNumber() + "' payed for " + car.getStayingHour() + "hours");
            IO.println("--------------------");
        }
        else {
            IO.println("--------------------");
            IO.println("Car '" + car.getPlateNumber() + "' couldn't pay for " + car.getStayingHour() + "hours | removed");
            IO.println("--------------------");

            CarRemove(car);
        }
    }
    private static int calculatePayAmount(int size, int hours){
        int amount = switch (size){
            case 1 -> 200;
            case 2 -> 300;
            case 4 -> 500;
            default -> 0;
        };

        return amount * hours;
    }
    //Car generation
    public static Car GenerateNewCar(){
        Random rand = new Random();

        //Plate making
        String plate = "";
        boolean uniquePlate = false;
        do {
            String letters = "";
            for (int i = 0; i < 3; i++) {
                char c = (char) ('A' + rand.nextInt(26));
                letters += c;
            }
            int number = rand.nextInt(999) + 1;
            plate = letters + "-" + String.format("%03d", number);

            if(!UsedPlates.contains(plate)) uniquePlate = true;
        }while(!uniquePlate);
        UsedPlates.add(plate);

        //=====
        //Car size
        int[] sizeOptions = {1,2,4};
        int carsize = sizeOptions[rand.nextInt(sizeOptions.length)];
        //=====
        //Money
        int money = rand.nextInt(600) * carsize;


        return new Car(plate, carsize, 0, money);
    }

    //Hour adding
    public static void AddAnHour(){
        for(Car car : CarsInside) car.incrementStayingHour();
    }
}
