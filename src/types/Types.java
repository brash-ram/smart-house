package types;

public class Types {

    public static class packet {
        public byte length;
        public payload payload;
        public byte src8;
    }

    public static class payload {
        public long src;
        public long dst;
        public long serial;
        public byte dev_type;
        public byte cmd;
        public byte[] cmd_body;
    }

    public static class device {
        public String dev_name;
        public byte[] dev_props;
    }

    public static class timer_cmd_body {
        public long timestamp;
    }

    public static class trigger {
        public byte op;
        public long value;
        public String name;
    }

    public static class env_sensor_props {
        public byte sensors;
        public trigger[] triggers;
    }

    public static class env_sensor_status_cmd_body {
        public long[] values;
    }
}
