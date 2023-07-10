package enums;

public enum Cmd {
    WHOISHERE(0x01),
    IAMHERE(0x02),
    GETSTATUS(0x03),
    STATUS(0x04),
    SETSTATUS(0x05),
    TICK(0x06);

    private byte id;

    Cmd(int id) {
        this.id = (byte) id;
    }
}
