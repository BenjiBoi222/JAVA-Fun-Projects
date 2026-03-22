public class ParkoloManager {
    private static int ParkoloMoney;

    public static void AddParkoloMoney(int parkoloMoney) {
        ParkoloMoney += parkoloMoney;
    }

    public static void ShowMenu(){
        IO.println("1) Show cars inside");
        IO.println("2) Add a new car");
        IO.println("3) Car leave");
        IO.println("Enter) Pass an hour");
        IO.println("Enter choosen option: ");

        switch (IO.readln()){
            case "1" -> ShowCars();
            case "2" -> AddNewCar();
            case "3" -> CarLeave();
            case "" -> PassAnHour();
            default -> IO.println("Wrong input! ");
        }
    }

    private static void ShowCars(){
        Parkolo.ShowAllCars();
    };

    private static void AddNewCar(){
        Car car = Parkolo.GenerateNewCar();
        Parkolo.AddNewCarInside(car);
    }

    private static void PassAnHour(){
        IO.println("==-Passed an hour-==");
        Parkolo.AddAnHour();
        Parkolo.CheckForLeavingCars();
    }

    public static void CarLeave(){
        Parkolo.ShowAllCars();
        String plate = IO.readln("Enter the plate of the car to be removed: ");
        Car car = Parkolo.FindCarByPlate(plate);
        if (car != null) Parkolo.CarRemove(car);
        else IO.println("Car with the given plate does not exist inside the garage! ");
    }
}
