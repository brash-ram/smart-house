package types;

public class Src8 {

    private static final int POLYNOMIAL = 0x07; // полином для CRC-8

    public static int calculate(byte[] payload) {
        int crc = 0;
        for (byte b : payload) {
            crc ^= b;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x80) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc <<= 1;
                }
            }
        }
        return (crc & 0xFF); // оставляем только 8 младших бит
    }
}
