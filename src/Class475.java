public final class Class475 {

    static int anInt5622;

    public static int anInt5624;

    public static boolean supportsFullScreen = true;

    Class475() throws Throwable {
        throw new Error();
    }

    public static String method7926(CharSequence charsequence_0, int i_1) {
        int i_2 = charsequence_0.length();
        StringBuilder stringbuilder_3 = new StringBuilder(i_2);
        for (int i_4 = 0; i_4 < i_2; i_4++) {
            char var_5 = charsequence_0.charAt(i_4);
            if ((var_5 < 97 || var_5 > 122) && (var_5 < 65 || var_5 > 90) && (var_5 < 48 || var_5 > 57) && var_5 != 46 && var_5 != 45 && var_5 != 42 && var_5 != 95) {
                if (var_5 == 32) {
                    stringbuilder_3.append('+');
                } else {
                    byte b_6 = Class242.getByteForChar(var_5);
                    stringbuilder_3.append('%');
                    int i_7 = b_6 >> 4 & 0xf;
                    if (i_7 >= 10) {
                        stringbuilder_3.append((char) (i_7 + 55));
                    } else {
                        stringbuilder_3.append((char) (i_7 + 48));
                    }
                    i_7 = b_6 & 0xf;
                    if (i_7 >= 10) {
                        stringbuilder_3.append((char) (i_7 + 55));
                    } else {
                        stringbuilder_3.append((char) (i_7 + 48));
                    }
                }
            } else {
                stringbuilder_3.append(var_5);
            }
        }
        return stringbuilder_3.toString();
    }

    static final void method7927(IComponentDefinitions icomponentdefinitions_0, CS2Executor cs2executor_1, byte b_2) {
        cs2executor_1.intStackPtr -= 2;
        int i_3 = cs2executor_1.intStack[cs2executor_1.intStackPtr] - 1;
        int i_4 = cs2executor_1.intStack[cs2executor_1.intStackPtr + 1];
        if (i_3 >= 0 && i_3 <= 9) {
            Class274.method4883(icomponentdefinitions_0, i_3, i_4, cs2executor_1, -838566564);
        } else {
            throw new RuntimeException();
        }
    }
}
