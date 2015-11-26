package com.rail.injilaislam.railways;

public class Train_list {
    String train_name;
    String train_number;

    public void set_list(String t_name, String t_num) {
        this.train_name = t_name;
        this.train_number = t_num;
    }


    public String get_train_number() {
        return this.train_number;
    }

    public String get_train_name() {
        return this.train_name;
    }


}
