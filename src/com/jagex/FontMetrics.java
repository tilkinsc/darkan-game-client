package com.jagex;

import java.awt.*;

public class FontMetrics {

    static String[] aStringArray4980 = new String[100];
    byte[] glyphWidths;
    public int verticalSpacing;
    public int topPadding;
    public int bottomPadding;
    byte[][] kerning;

    public int getKerning(int i_1, char var_2, int i_3) {
        return this.kerning != null ? this.kerning[i_1][var_2] : 0;
    }

    public int method6945(int i_1, byte b_2) {
        return this.glyphWidths[i_1] & 0xff;
    }

    public int getWidthNoSprites(String string_1) {
        return this.getTextWidth(string_1, null);
    }

    public int getTextWidth(String string_1, Sprite[] arr_2) {
        if (string_1 == null) {
            return 0;
        } else {
            int i_3 = -1;
            int i_4 = -1;
            int i_5 = 0;
            int i_6 = string_1.length();

            for (int i_7 = 0; i_7 < i_6; i_7++) {
                char var_8 = string_1.charAt(i_7);
                if (var_8 == 60) {
                    i_3 = i_7;
                } else {
                    if (var_8 == 62 && i_3 != -1) {
                        String string_9 = string_1.substring(i_3 + 1, i_7);
                        i_3 = -1;
                        if (string_9.equals("lt")) {
                            var_8 = 60;
                        } else if (string_9.equals("gt")) {
                            var_8 = 62;
                        } else if (string_9.equals("nbsp")) {
                            var_8 = 160;
                        } else if (string_9.equals("shy")) {
                            var_8 = 173;
                        } else if (string_9.equals("times")) {
                            var_8 = 215;
                        } else if (string_9.equals("euro")) {
                            var_8 = 8364;
                        } else if (string_9.equals("copy")) {
                            var_8 = 169;
                        } else {
                            if (!string_9.equals("reg")) {
                                if (string_9.startsWith("img=") && arr_2 != null) {
                                    try {
                                        int i_10 = Utils.parseInt(string_9.substring(4));
                                        i_5 += arr_2[i_10].scaleWidth();
                                        i_4 = -1;
                                    } catch (Exception exception_12) {
                                    }
                                }
                                continue;
                            }

                            var_8 = 174;
                        }
                    }

                    if (i_3 == -1) {
                        i_5 += this.glyphWidths[QuestIndexLoader.getByteForChar(var_8) & 0xff] & 0xff;
                        if (this.kerning != null && i_4 != -1) {
                            i_5 += this.kerning[i_4][var_8];
                        }

                        i_4 = var_8;
                    }
                }
            }

            return i_5;
        }
    }

    public int method6949(String string_1, int i_2, Sprite[] arr_3) {
        return this.method6987(string_1, new int[]{i_2}, aStringArray4980, arr_3);
    }

    int splitLines(String string_1, int[] ints_2, String[] arr_3, Sprite[] arr_4, boolean bool_5, byte b_6) {
        if (string_1 == null) {
            return 0;
        } else {
            int i_7 = 0;
            int i_8 = 0;
            int i_9 = -1;
            int i_10 = 0;
            int i_11 = 0;
            int i_12 = -1;
            int i_13 = -1;
            int i_14 = 0;
            int i_15 = string_1.length();

            for (int i_16 = 0; i_16 < i_15; i_16++) {
                int i_17 = QuestIndexLoader.getByteForChar(string_1.charAt(i_16)) & 0xff;
                int i_18 = 0;
                if (i_17 == 60) {
                    i_12 = i_16;
                } else {
                    int i_19;
                    if (i_12 != -1) {
                        if (i_17 != 62) {
                            continue;
                        }

                        i_19 = i_12;
                        String string_20 = string_1.substring(i_12 + 1, i_16);
                        i_12 = -1;
                        if (string_20.equals("br")) {
                            arr_3[i_14] = string_1.substring(i_8, i_16 + 1);
                            ++i_14;
                            if (i_14 >= arr_3.length) {
                                return 0;
                            }

                            i_8 = i_16 + 1;
                            i_7 = 0;
                            i_9 = -1;
                            i_13 = -1;
                            continue;
                        }

                        if (string_20.equals("lt")) {
                            i_18 += this.method6945(60, (byte) -64);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][60];
                            }

                            i_13 = 60;
                        } else if (string_20.equals("gt")) {
                            i_18 += this.method6945(62, (byte) -127);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][62];
                            }

                            i_13 = 62;
                        } else if (string_20.equals("nbsp")) {
                            i_18 += this.method6945(160, (byte) -89);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][160];
                            }

                            i_13 = 160;
                        } else if (string_20.equals("shy")) {
                            i_18 += this.method6945(173, (byte) -31);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][173];
                            }

                            i_13 = 173;
                        } else if (string_20.equals("times")) {
                            i_18 += this.method6945(215, (byte) -119);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][215];
                            }

                            i_13 = 215;
                        } else if (string_20.equals("euro")) {
                            i_18 += this.method6945(8364, (byte) -47);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][8364];
                            }

                            i_13 = 8364;
                        } else if (string_20.equals("copy")) {
                            i_18 += this.method6945(169, (byte) -65);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][169];
                            }

                            i_13 = 169;
                        } else if (string_20.equals("reg")) {
                            i_18 += this.method6945(174, (byte) -116);
                            if (this.kerning != null && i_13 != -1) {
                                i_18 += this.kerning[i_13][174];
                            }

                            i_13 = 174;
                        } else if (string_20.startsWith("img=") && arr_4 != null) {
                            try {
                                int i_21 = Utils.parseInt(string_20.substring(4));
                                i_18 += arr_4[i_21].scaleWidth();
                                i_13 = -1;
                            } catch (Exception exception_23) {
                            }
                        }

                        i_17 = -1;
                    } else {
                        i_19 = i_16;
                        i_18 += this.method6945(i_17, (byte) -58);
                        if (this.kerning != null && i_13 != -1) {
                            i_18 += this.kerning[i_13][i_17];
                        }

                        i_13 = i_17;
                    }

                    if (i_18 > 0) {
                        i_7 += i_18;
                        if (ints_2 != null) {
                            if (i_17 == 32) {
                                i_9 = i_16;
                                i_10 = i_7;
                                i_11 = bool_5 ? 1 : 0;
                            }

                            if (i_7 > ints_2[i_14 < ints_2.length ? i_14 : ints_2.length - 1]) {
                                if (i_9 >= 0) {
                                    arr_3[i_14] = string_1.substring(i_8, i_9 + 1 - i_11);
                                    ++i_14;
                                    if (i_14 >= arr_3.length) {
                                        return 0;
                                    }

                                    i_8 = i_9 + 1;
                                    i_9 = -1;
                                    i_7 -= i_10;
                                    i_13 = -1;
                                } else {
                                    arr_3[i_14] = string_1.substring(i_8, i_19);
                                    ++i_14;
                                    if (i_14 >= arr_3.length) {
                                        return 0;
                                    }

                                    i_8 = i_19;
                                    i_9 = -1;
                                    i_7 = i_18;
                                    i_13 = -1;
                                }
                            }

                            if (i_17 == 45) {
                                i_9 = i_16;
                                i_10 = i_7;
                                i_11 = 0;
                            }
                        }
                    }
                }
            }

            if (string_1.length() > i_8) {
                arr_3[i_14] = string_1.substring(i_8);
                ++i_14;
            }

            return i_14;
        }
    }

    public int method6951(String string_1, int i_2, Sprite[] arr_3, byte b_4) {
        int i_5 = this.method6987(string_1, new int[]{i_2}, aStringArray4980, arr_3);
        int i_6 = 0;

        for (int i_7 = 0; i_7 < i_5; i_7++) {
            int i_8 = this.getTextWidth(aStringArray4980[i_7], arr_3);
            if (i_8 > i_6) {
                i_6 = i_8;
            }
        }

        return i_6;
    }

    public Point method6954(String text, int width, int height, int index, Sprite[] arr_5) {
        if (index <= 0) {
            return new Point(0, height + this.topPadding);
        } else {
            if (index > text.length()) {
                index = text.length();
            }

            if (height == 0) {
                height = this.verticalSpacing;
            }

            int i_7 = this.splitLines(text, new int[]{width}, aStringArray4980, arr_5, false, (byte) -85);
            int i_8 = 0;

            for (int i_9 = 0; i_9 < i_7; i_9++) {
                int i_10 = aStringArray4980[i_9].length();
                if (i_10 + i_8 > index || i_9 == i_7 - 1 && index == text.length()) {
                    String string_11 = text.substring(i_8, index);
                    if (string_11.endsWith("<br>")) {
                        string_11 = "";
                        int i_10000 = i_8 + i_10;
                        ++i_9;
                    }

                    int i_12 = this.getTextWidth(string_11, arr_5);
                    int i_13 = this.topPadding + height * i_9;
                    return new Point(i_12, i_13);
                }

                i_8 += i_10;
            }

            return null;
        }
    }

    public int method6956(String string_1, int i_2, int i_3, int i_4, int i_5, Sprite[] arr_6) {
        if (i_3 == 0) {
            i_3 = this.verticalSpacing;
        }

        int i_8 = this.method6987(string_1, new int[]{i_2}, aStringArray4980, arr_6);
        if (i_8 == 0) {
            return 0;
        } else {
            if (i_5 < 0) {
                i_5 = 0;
            }

            i_5 /= i_3;
            if (i_5 >= i_8) {
                i_5 = i_8 - 1;
            }

            String string_9 = aStringArray4980[i_5];
            int i_10 = 0;
            int i_11 = 0;

            int i_12;
            for (i_12 = 0; i_12 < i_4 && i_10 < string_9.length(); i_12 = this.getTextWidth(string_9.substring(0, i_10), arr_6)) {
                i_11 = i_12;
                ++i_10;
            }

            if (i_10 == string_9.length() && string_9.endsWith("<br>")) {
                i_10 -= 4;
            }

            if (i_4 - i_11 < i_12 - i_4) {
                --i_10;
            }

            for (int i_13 = 0; i_13 < i_5; i_13++) {
                i_10 += aStringArray4980[i_13].length();
            }

            return i_10;
        }
    }

    FontMetrics(byte[] bytes_1) {
        RsByteBuffer stream = new RsByteBuffer(bytes_1);
        int check = stream.readUnsignedByte();
        if (check != 0) {
            throw new RuntimeException("");
        } else {
            boolean variadicWidth = stream.readUnsignedByte() == 1;
            this.glyphWidths = new byte[256];
            stream.readBytes(this.glyphWidths, 0, 256);
            if (variadicWidth) {
                int[] ints_5 = new int[256];
                int[] ints_6 = new int[256];

                int i_7;
                for (i_7 = 0; i_7 < 256; i_7++) {
                    ints_5[i_7] = stream.readUnsignedByte();
                }

                for (i_7 = 0; i_7 < 256; i_7++) {
                    ints_6[i_7] = stream.readUnsignedByte();
                }

                byte[][] bytes_12 = new byte[256][];

                int i_10;
                for (int i_8 = 0; i_8 < 256; i_8++) {
                    bytes_12[i_8] = new byte[ints_5[i_8]];
                    byte b_9 = 0;

                    for (i_10 = 0; i_10 < bytes_12[i_8].length; i_10++) {
                        b_9 += stream.readByte();
                        bytes_12[i_8][i_10] = b_9;
                    }
                }

                byte[][] bytes_13 = new byte[256][];

                int i_14;
                for (i_14 = 0; i_14 < 256; i_14++) {
                    bytes_13[i_14] = new byte[ints_5[i_14]];
                    byte b_15 = 0;

                    for (int i_11 = 0; i_11 < bytes_13[i_14].length; i_11++) {
                        b_15 += stream.readByte();
                        bytes_13[i_14][i_11] = b_15;
                    }
                }

                this.kerning = new byte[256][256];

                for (i_14 = 0; i_14 < 256; i_14++) {
                    if (i_14 != 32 && i_14 != 160) {
                        for (i_10 = 0; i_10 < 256; i_10++) {
                            if (i_10 != 32 && i_10 != 160) {
                                this.kerning[i_14][i_10] = (byte) Utils.calculateKerning(bytes_12, bytes_13, ints_6, this.glyphWidths, ints_5, i_14, i_10);
                            }
                        }
                    }
                }

                this.verticalSpacing = ints_6[32] + ints_5[32];
            } else {
                this.verticalSpacing = stream.readUnsignedByte();
            }

            stream.readUnsignedByte();
            stream.readUnsignedByte();
            this.topPadding = stream.readUnsignedByte();
            this.bottomPadding = stream.readUnsignedByte();
        }
    }

    public String fitText(String string, int maximumWidth, Sprite[] icons) {
        if (this.getTextWidth(string, icons) <= maximumWidth) {
            return string;
        } else {
            maximumWidth -= this.getTextWidth("...", null);
            int escapeStart = -1;
            int previous = -1;
            int width = 0;
            int length = string.length();
            String prefix = "";

            for (int i = 0; i < length; i++) {
                char current = string.charAt(i);
                if (current == 60) {
                    escapeStart = i;
                } else {
                    if (current == 62 && escapeStart != -1) {
                        String string_12 = string.substring(escapeStart + 1, i);
                        escapeStart = -1;
                        if (string_12.equals("lt")) {
                            current = 60;
                        } else if (string_12.equals("gt")) {
                            current = 62;
                        } else if (string_12.equals("nbsp")) {
                            current = 160;
                        } else if (string_12.equals("shy")) {
                            current = 173;
                        } else if (string_12.equals("times")) {
                            current = 215;
                        } else if (string_12.equals("euro")) {
                            current = 8364;
                        } else if (string_12.equals("copy")) {
                            current = 169;
                        } else {
                            if (!string_12.equals("reg")) {
                                if (string_12.startsWith("img=") && icons != null) {
                                    try {
                                        int id = Utils.parseInt(string_12.substring(4));
                                        width += icons[id].scaleWidth();
                                        previous = -1;
                                        if (width > maximumWidth) {
                                            return prefix + "...";
                                        }

                                        prefix = string.substring(0, i + 1);
                                    } catch (Exception exception_16) {
                                    }
                                }
                                continue;
                            }

                            current = 174;
                        }
                    }

                    if (escapeStart == -1) {
                        width += this.glyphWidths[QuestIndexLoader.getByteForChar(current) & 0xff] & 0xff;
                        if (this.kerning != null && previous != -1) {
                            width += this.kerning[previous][current];
                        }

                        previous = current;
                        int total = width;
                        if (this.kerning != null) {
                            total = width + this.kerning[current][46];
                        }

                        if (total > maximumWidth) {
                            return prefix + "...";
                        }

                        prefix = string.substring(0, i + 1);
                    }
                }
            }

            return string;
        }
    }

    public int method6972(String string_1, int i_2, int i_3, Sprite[] arr_4, int i_5) {
        if (i_3 == 0) {
            i_3 = this.verticalSpacing;
        }

        int i_6 = this.method6987(string_1, new int[]{i_2}, aStringArray4980, arr_4);
        int i_7 = i_3 * (i_6 - 1);
        return i_7 + this.bottomPadding + this.topPadding;
    }

    public int method6987(String string_1, int[] ints_2, String[] arr_3, Sprite[] arr_4) {
        return this.splitLines(string_1, ints_2, arr_3, arr_4, true, (byte) -40);
    }

    static final void method6989() {
        client.CURRENT_CUTSCENE = -1;
        client.anInt7341 = 1;
        NativeLibraryLoader.CUTSCENE_MAP_XTEAS = null;
        Class276.aNode_Sub35_3346 = null;
        Class79.method1390(1755874378);
    }

}