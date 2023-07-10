import types.CustomJson;
import types.Src8;
import types.Types;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Types.packet packet = new Types.packet();
        Types.payload payload = new Types.payload();
        payload.serial = 1L;
        payload.dst = 0x3FFF;
        payload.cmd = 0x01;
        payload.src = 1;
        packet.payload = payload;
        packet.length = (byte) CustomJson.encodeObjToJson(payload).getBytes().length;
        packet.src8 = (byte) Src8.calculate(CustomJson.encodeObjToJson(payload).getBytes());

        Server.send(packet);
    }
}
