package com.yfkj.bms.controller;

import com.yfkj.bms.controller.v1.UserController;

import java.util.Timer;
import java.util.TimerTask;

public class RemindTask extends TimerTask {
        public void run() {
            System.out.println("插入");
        }
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(),0,3000);
    }
}
