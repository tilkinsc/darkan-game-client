package com.jagex;

public class Class51 implements Interface2 {

    static int anInt488;

    Class62 aClass62_485;

    Index aClass317_487;

    Index aClass317_486;

    FontRenderer aFontRenderer_484;

    public void method11(boolean bool_1) {
        if (bool_1) {
            int i_2 = this.aClass62_485.aClass356_650.method6221(2056525513 * this.aClass62_485.anInt652 * 1860559737, 150480619 * client.GAME_WIDTH * 1426041429 * 765 * -1115795005, 1034015325) + -906350423 * this.aClass62_485.anInt651 * -1042975847;
            int i_3 = this.aClass62_485.aClass353_654.method6198(38429607 * this.aClass62_485.anInt648 * 959976471, 1176039023 * client.GAME_HEIGHT * -994133479 * 553 * -645779313, 1192108582) + this.aClass62_485.anInt655 * -2042627867 * -601422611;
            this.aFontRenderer_484.method378(this.aClass62_485.aString649, i_2, i_3, 2056525513 * this.aClass62_485.anInt652 * 1860559737, 38429607 * this.aClass62_485.anInt648 * 959976471, -1179509109 * this.aClass62_485.anInt659 * 1820776739, this.aClass62_485.anInt660 * -1985214661 * 1958427123, -533570239 * this.aClass62_485.anInt653 * -762236223, 1391502107 * this.aClass62_485.anInt656 * 533004051, -1240305753 * this.aClass62_485.anInt657 * 1235699735, null, null, null, 0, 0, (byte) 60);
        }
    }

    Class51(Index index_1, Index index_2, Class62 class62_3) {
        this.aClass62_485 = class62_3;
        this.aClass317_487 = index_1;
        this.aClass317_486 = index_2;
    }

    public void method20(boolean bool_1, int i_2) {
        if (bool_1) {
            int i_3 = this.aClass62_485.aClass356_650.method6221(this.aClass62_485.anInt652, client.GAME_WIDTH, 1847576923) + this.aClass62_485.anInt651;
            int i_4 = this.aClass62_485.aClass353_654.method6198(this.aClass62_485.anInt648, client.GAME_HEIGHT, 1796559558) + this.aClass62_485.anInt655;
            this.aFontRenderer_484.method378(this.aClass62_485.aString649, i_3, i_4, this.aClass62_485.anInt652, this.aClass62_485.anInt648, this.aClass62_485.anInt659, this.aClass62_485.anInt660, this.aClass62_485.anInt653, this.aClass62_485.anInt656, this.aClass62_485.anInt657, null, null, null, 0, 0, (byte) 28);
        }
    }

    public boolean method21() {
        boolean bool_1 = true;
        if (!this.aClass317_487.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        if (!this.aClass317_486.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        return bool_1;
    }

    public void method12(boolean bool_1) {
        if (bool_1) {
            int i_2 = this.aClass62_485.aClass356_650.method6221(2056525513 * this.aClass62_485.anInt652 * 1860559737, 150480619 * client.GAME_WIDTH * 1426041429 * 765 * -1115795005, 825441624) + -906350423 * this.aClass62_485.anInt651 * -1042975847;
            int i_3 = this.aClass62_485.aClass353_654.method6198(38429607 * this.aClass62_485.anInt648 * 959976471, 1176039023 * client.GAME_HEIGHT * -994133479 * 553 * -645779313, 2097685186) + this.aClass62_485.anInt655 * -2042627867 * -601422611;
            this.aFontRenderer_484.method378(this.aClass62_485.aString649, i_2, i_3, 2056525513 * this.aClass62_485.anInt652 * 1860559737, 38429607 * this.aClass62_485.anInt648 * 959976471, -1179509109 * this.aClass62_485.anInt659 * 1820776739, this.aClass62_485.anInt660 * -1985214661 * 1958427123, -533570239 * this.aClass62_485.anInt653 * -762236223, 1391502107 * this.aClass62_485.anInt656 * 533004051, -1240305753 * this.aClass62_485.anInt657 * 1235699735, null, null, null, 0, 0, (byte) 10);
        }
    }

    public void method16() {
        FontMetrics fontmetrics_1 = Class163.method2845(this.aClass317_486, -1949174501 * this.aClass62_485.anInt658 * -2111808237, (byte) 20);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_1, SpriteDefinitions.method1534(this.aClass317_487, -1949174501 * this.aClass62_485.anInt658 * -2111808237), true);
    }

    public boolean method10(int i_1) {
        boolean bool_2 = true;
        if (!this.aClass317_487.loadFile(this.aClass62_485.anInt658)) {
            bool_2 = false;
        }
        if (!this.aClass317_486.loadFile(this.aClass62_485.anInt658)) {
            bool_2 = false;
        }
        return bool_2;
    }

    public void method15() {
        FontMetrics fontmetrics_1 = Class163.method2845(this.aClass317_486, -1949174501 * this.aClass62_485.anInt658 * -2111808237, (byte) 108);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_1, SpriteDefinitions.method1534(this.aClass317_487, -1949174501 * this.aClass62_485.anInt658 * -2111808237), true);
    }

    public void method22() {
        FontMetrics fontmetrics_2 = Class163.method2845(this.aClass317_486, this.aClass62_485.anInt658, (byte) 81);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_2, SpriteDefinitions.method1534(this.aClass317_487, this.aClass62_485.anInt658), true);
    }

    public void method23() {
        FontMetrics fontmetrics_1 = Class163.method2845(this.aClass317_486, -1949174501 * this.aClass62_485.anInt658 * -2111808237, (byte) 60);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_1, SpriteDefinitions.method1534(this.aClass317_487, -1949174501 * this.aClass62_485.anInt658 * -2111808237), true);
    }

    public void method18() {
        FontMetrics fontmetrics_1 = Class163.method2845(this.aClass317_486, -1949174501 * this.aClass62_485.anInt658 * -2111808237, (byte) 122);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_1, SpriteDefinitions.method1534(this.aClass317_487, -1949174501 * this.aClass62_485.anInt658 * -2111808237), true);
    }

    public void method19() {
        FontMetrics fontmetrics_1 = Class163.method2845(this.aClass317_486, -1949174501 * this.aClass62_485.anInt658 * -2111808237, (byte) 65);
        this.aFontRenderer_484 = Renderers.SOFTWARE_RENDERER.createFont(fontmetrics_1, SpriteDefinitions.method1534(this.aClass317_487, -1949174501 * this.aClass62_485.anInt658 * -2111808237), true);
    }

    public boolean method13() {
        boolean bool_1 = true;
        if (!this.aClass317_487.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        if (!this.aClass317_486.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        return bool_1;
    }

    public boolean method9() {
        boolean bool_1 = true;
        if (!this.aClass317_487.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        if (!this.aClass317_486.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        return bool_1;
    }

    public void method14(boolean bool_1) {
        if (bool_1) {
            int i_2 = this.aClass62_485.aClass356_650.method6221(2056525513 * this.aClass62_485.anInt652 * 1860559737, 150480619 * client.GAME_WIDTH * 1426041429 * 765 * -1115795005, 2080844430) + -906350423 * this.aClass62_485.anInt651 * -1042975847;
            int i_3 = this.aClass62_485.aClass353_654.method6198(38429607 * this.aClass62_485.anInt648 * 959976471, 1176039023 * client.GAME_HEIGHT * -994133479 * 553 * -645779313, 879742369) + this.aClass62_485.anInt655 * -2042627867 * -601422611;
            this.aFontRenderer_484.method378(this.aClass62_485.aString649, i_2, i_3, 2056525513 * this.aClass62_485.anInt652 * 1860559737, 38429607 * this.aClass62_485.anInt648 * 959976471, -1179509109 * this.aClass62_485.anInt659 * 1820776739, this.aClass62_485.anInt660 * -1985214661 * 1958427123, -533570239 * this.aClass62_485.anInt653 * -762236223, 1391502107 * this.aClass62_485.anInt656 * 533004051, -1240305753 * this.aClass62_485.anInt657 * 1235699735, null, null, null, 0, 0, (byte) 30);
        }
    }

    public boolean method17() {
        boolean bool_1 = true;
        if (!this.aClass317_487.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        if (!this.aClass317_486.loadFile(this.aClass62_485.anInt658 * -2111808237 * -1949174501)) {
            bool_1 = false;
        }
        return bool_1;
    }

    public static int method1072(int i_0, int i_1) {
        int i_2 = i_0 >>> 1;
        i_2 |= i_2 >>> 1;
        i_2 |= i_2 >>> 2;
        i_2 |= i_2 >>> 4;
        i_2 |= i_2 >>> 8;
        i_2 |= i_2 >>> 16;
        return i_0 & ~i_2;
    }

    public static void method1074(int[] ints_0, Object[] arr_1, int i_2, int i_3, int i_4) {
        if (i_2 < i_3) {
            int i_5 = (i_3 + i_2) / 2;
            int i_6 = i_2;
            int i_7 = ints_0[i_5];
            ints_0[i_5] = ints_0[i_3];
            ints_0[i_3] = i_7;
            Object object_8 = arr_1[i_5];
            arr_1[i_5] = arr_1[i_3];
            arr_1[i_3] = object_8;
            int i_9 = i_7 == Integer.MAX_VALUE ? 0 : 1;
            for (int i_10 = i_2; i_10 < i_3; i_10++) {
                if (ints_0[i_10] < (i_10 & i_9) + i_7) {
                    int i_11 = ints_0[i_10];
                    ints_0[i_10] = ints_0[i_6];
                    ints_0[i_6] = i_11;
                    Object object_12 = arr_1[i_10];
                    arr_1[i_10] = arr_1[i_6];
                    arr_1[i_6++] = object_12;
                }
            }
            ints_0[i_3] = ints_0[i_6];
            ints_0[i_6] = i_7;
            arr_1[i_3] = arr_1[i_6];
            arr_1[i_6] = object_8;
            method1074(ints_0, arr_1, i_2, i_6 - 1, 1230718276);
            method1074(ints_0, arr_1, i_6 + 1, i_3, -1167576845);
        }
    }
}