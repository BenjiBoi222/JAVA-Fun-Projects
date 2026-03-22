class Main{
    private static boolean GameRunning = true;
    void main(){
        Car car1 = new Car("TEST-222", 2, 2, 1000);
        Car car2 = new Car("TEST-444", 1, 3, 500);

        Parkolo.AddNewCarInside(car1);
        Parkolo.AddNewCarInside(car2);
        while(GameRunning){
            ParkoloManager.ShowMenu();
        }
    }

    public void StopGame(){
        GameRunning = false;
    }
}
