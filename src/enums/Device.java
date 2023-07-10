package enums;

public enum Device {
    SmartHub(0x01),
    EnvSensor(0x02),
    Switch(0x03),
    Lamp(0x04),
    Socket(0x05),
    Clock(0x06);

    private int id;

    Device(int id) {
        this.id = id;
    }
}
