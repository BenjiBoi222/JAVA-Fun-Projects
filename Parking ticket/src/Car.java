public class Car {
    private String PlateNumber;
    private int CarSize;
    private int StayingHour;
    private int Money;

    public Car(String plateNumber, int carSize, int stayingHour, int money) {
        PlateNumber = plateNumber;
        CarSize = carSize;
        StayingHour = stayingHour;
        Money = money;
    }


    //Getters
    public String getPlateNumber() {
        return PlateNumber;
    }
    public int getCarSize() {
        return CarSize;
    }
    public int getStayingHour() {
        return StayingHour;
    }
    public int getMoney() {return Money; }

    //Setters
    public void incrementStayingHour() {StayingHour++; }
    public void setMoney(int money) {
        Money = money;
    }
}