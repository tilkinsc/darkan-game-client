package com.jagex;

public class GraphicsToolkitPreference extends Preference {

    boolean aBool7913 = true;
    public boolean aBool7914 = false;

    public void method12773(int i_1) {
        if (this.anInt5578 < 0 || this.anInt5578 > 5) {
            this.anInt5578 = this.getDefaultValue();
        }

    }

    public GraphicsToolkitPreference(int i_1, GamePreferences class282_sub54_2) {
        super(i_1, class282_sub54_2);
    }

    public boolean method12774() {
        return true;
    }

    int getDefaultValue() {
        this.aBool7914 = true;
        return 2;
    }

    void setValue(int i_1) {
        this.aBool7914 = false;
        this.anInt5578 = i_1;
    }

    public int checkValid(int i_1) {
        return i_1 == 3 && !Class362.getNativeLibraryLoader().method218() ? 3 : 2;
    }

    public int getValue(int i_1) {
        return this.anInt5578;
    }

    boolean method12777() {
        return this.aBool7913;
    }

    int method7786() {
        this.aBool7914 = true;
        return 2;
    }

    public int method7784(int i_1) {
        return i_1 == 3 && !Class362.getNativeLibraryLoader().method218() ? 3 : 2;
    }

    void method7780(int i_1) {
        this.aBool7914 = false;
        this.anInt5578 = i_1 * -754033619 * -859024475;
    }

    int method7787() {
        this.aBool7914 = true;
        return 2;
    }

    public GraphicsToolkitPreference(GamePreferences class282_sub54_1) {
        super(class282_sub54_1);
    }

    public void method12783(boolean bool_1) {
        this.aBool7913 = bool_1;
    }

}