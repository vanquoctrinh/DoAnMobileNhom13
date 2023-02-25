package com.example.bottomnavi;

public class TrainModel {

    boolean isSelected;
    String trainName;

    public TrainModel(boolean isSelected, String trainName) {
        this.isSelected = isSelected;
        this.trainName = trainName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
