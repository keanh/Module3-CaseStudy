package model;

public class SmartPhone {
    private int id;
    private String name;
    private int price;
    private String origin;
    private String operatingSystem;
    private String language;
    private String screenType;
    private String resolution;
    private String wideScreen;
    private String rearCamera;
    private String frontCamera;
    private String ROM;
    private String RAM;
    private String weight;
    private String size;
    private String batteryType;
    private String batteryCapacity;
    private String pictureLink;

    public SmartPhone(int id, String name, int price,String pictureLink) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureLink = pictureLink;
    }

    public SmartPhone(String name, int price, String origin, String operatingSystem, String language,
                      String screenType, String resolution, String wideScreen, String rearCamera, String frontCamera,
                      String ROM, String RAM, String weight, String size, String batteryType, String batteryCapacity,
                      String pictureLink) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.operatingSystem = operatingSystem;
        this.language = language;
        this.screenType = screenType;
        this.resolution = resolution;
        this.wideScreen = wideScreen;
        this.rearCamera = rearCamera;
        this.frontCamera = frontCamera;
        this.ROM = ROM;
        this.RAM = RAM;
        this.weight = weight;
        this.size = size;
        this.batteryType = batteryType;
        this.batteryCapacity = batteryCapacity;
        this.pictureLink = pictureLink;
    }

    public SmartPhone(int id, String name, int price, String origin, String operatingSystem,
                      String language, String screenType, String resolution, String wideScreen,
                      String rearCamera, String frontCamera, String ROM, String RAM, String weight,
                      String size, String batteryType, String batteryCapacity, String pictureLink) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.operatingSystem = operatingSystem;
        this.language = language;
        this.screenType = screenType;
        this.resolution = resolution;
        this.wideScreen = wideScreen;
        this.rearCamera = rearCamera;
        this.frontCamera = frontCamera;
        this.ROM = ROM;
        this.RAM = RAM;
        this.weight = weight;
        this.size = size;
        this.batteryType = batteryType;
        this.batteryCapacity = batteryCapacity;
        this.pictureLink = pictureLink;
    }

    public SmartPhone() {
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getWideScreen() {
        return wideScreen;
    }

    public void setWideScreen(String wideScreen) {
        this.wideScreen = wideScreen;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
