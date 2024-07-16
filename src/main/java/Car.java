public class Car {
    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    private String CarName;
    private String carModel;

    public class engine{

        private String EngineName;

        public String getEngineName() {
            return EngineName;
        }

        public void setEngineName(String engineName) {
            EngineName = engineName;
        }
    }
}
