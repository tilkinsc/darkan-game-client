import java.util.Iterator;

public class Class258 {

    Class258() throws Throwable {
        throw new Error();
    }

    static final void method4569(int i_0) {
        Iterator iterator_1 = client.aClass465_7334.iterator();
        while (iterator_1.hasNext()) {
            Class282_Sub50_Sub10 class282_sub50_sub10_2 = (Class282_Sub50_Sub10) iterator_1.next();
            Class521_Sub1_Sub1_Sub4 class521_sub1_sub1_sub4_3 = class282_sub50_sub10_2.aClass521_Sub1_Sub1_Sub4_9636;
            if (IndexLoaders.MAP_REGION_DECODER.getSceneObjectManager(-831174311) != null && class521_sub1_sub1_sub4_3.method15927(-831489293)) {
                IndexLoaders.MAP_REGION_DECODER.getSceneObjectManager(-1442376239).method3397(class521_sub1_sub1_sub4_3, true, 402306072);
            }
        }
    }

    public static Class357 method4570(RsByteBuffer rsbytebuffer_0, int i_1) {
        int i_2 = rsbytebuffer_0.readBigSmart();
        Class356 class356_3 = Class350_Sub3_Sub1.method15558(251815760)[rsbytebuffer_0.readUnsignedByte()];
        Class353 class353_4 = AccountCreationResponseOpcodes.method8155(152314627)[rsbytebuffer_0.readUnsignedByte()];
        int i_5 = rsbytebuffer_0.readShort();
        int i_6 = rsbytebuffer_0.readShort();
        return new Class357(i_2, class356_3, class353_4, i_5, i_6);
    }
}
