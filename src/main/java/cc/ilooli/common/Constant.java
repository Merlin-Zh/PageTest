package cc.ilooli.common;

/**
 * 常数
 *
 * @author OVO
 * @date 2021/11/12
 */
public class Constant {
    public static final class Product {
        public static final String SERIES = "Series";
        public static final String MODEL = "Model";
        public static final String NAME = "Name";
        public static final String CURRENT = "Current";
        public static final String NOTE = "Note";
        public static final String BODY = "Body";

        public static final class Mccb {
            public static final String INM = "Inm";
            public static final String ICU = "Icu";
            public static final String OPERATING_MODE = "OperatingMode";
            public static final String POLES = "Poles";
            public static final String TRIPPING_WAY = "Trip";
            public static final String INSIDE_ATTACHMENT = "InsideAttachment";
            public static final String DIFFERENT_USES = "Use";
            public static final String QUADRUPOLE_CODE = "QuadrupoleCode";
            public static final String TRIPPING_SHAPE = "TrippingShape";
            public static final String CONNECTION_MODE = "ConnectionMode";
            public static final String ELECTRONIC_FUNCTION = "ElectronicFunction";
            public static final String OVERLOAD_ALARM = "OverloadAlarm";
            public static final String SHORT_TIME_DELAY_CODE = "ShortTimeDelayCode";
            public static final String LEAKAGE_MODEL = "LeakageModel";
            public static final String CONTROLLER = "Controller";
            public static final String FUNCTION = "Function";
            public static final String ELECTRONIC_INM_CURRENT = "ElectronicInmCurrent";
            public static final String INSTALLATION = "Installation";
            public static final String OUTSIDE_ATTACHMENT = "OutsideAttachment";
            public static final String SPECIAL_USE = "SpecialUse";
        }

        public static final class Acb{
            // 壳架
            public static final String INM = "Inm";
            // 分断能力
            public static final String ICU = "Icu";
            // 额定电流
            public static final String RAT = "Rat";
            // 极数
            public static final String POLES = "Poles";
            //安装方式
            public static final String INSTALLTION = "Installtion";
            // 连接方式
            public static final String CONNECTION = "Connection";
            // BW3G 额定电压
            public static final String VDC = "Vdc";
            // 控制电源电压
            public static final String SUPPLYVOLTAGE = "SupplyVoltage";
            // 控制器
            public static final String CONTROLLER = "Controller";
            // 辅助触头
            public static final String AUXILIARY = "Auxiliary";
            // 欠压
            public static final String UVT = "Uvt";
            // 类型
            public static final String TYPE = "Type";
            // 附件
            public static final String ASSIST = "Assist";
        }

        public static final class Mcb{
            public static final String LEAKAGE = "Leakage";
            public static final String INM = "Inm";
            public static final String GB = "GB";
            public static final String USE = "Use";
            public static final String PROTECTION = "Protection";
            public static final String ICU = "Icu";
            public static final String MAX_VOL = "MaxVol";
            public static final String POLES = "Poles";
            public static final String TELECOMMAND= "Telecommand";
            public static final String LEAKAGE_MODEL = "LeakageModel";
            public static final String ATTACH = "Attach";
            public static final String PADLOCK = "Padlock";
            public static final String SPECIALUSE = "SpecialUse";

            public static final String SHOUT = "MX+OF";
            public static final String ELECTRICAL_OPERATION = "R";

            public static final String WIDTH = "产品宽度=36mm";
            public static final String VOLTAGE = "本体电压=DC80V";
            public static final String LEAKSGE_STRING = "漏电电流";
        }
    }
}
