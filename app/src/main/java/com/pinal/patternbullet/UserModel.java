package com.pinal.patternbullet;

public class UserModel {
    int intValue;
    private boolean isImageVisible;


    public UserModel(int intValue) {
        this.intValue = intValue;
        this.isImageVisible =false; // Initial state: image is not visible
    }

    public boolean isImageVisible() {
        return isImageVisible;
    }

    public void setImageVisible(boolean visible) {
        isImageVisible = visible;
    }

    public void toggleImageVisibility() {
        isImageVisible = !isImageVisible;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }


}
