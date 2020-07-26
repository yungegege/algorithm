package com.cloudfly.algorithm.designpattern.danli;

public class LanHan {

    public static void main(String[] args) {
        LanHan lanHan = new LanHan();
        Money money = new Money(0);
        Test1 test1 = new Test1(lanHan);
        Test2 test2 = new Test2(lanHan);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    test1.add(money);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    test2.add(money);
                }
            }
        }).start();

        try {
            Thread.sleep(8000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(money.getMoney());
    }
}

class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Test1 {
    private LanHan lanHan;

    public Test1(LanHan lanHan) {
        this.lanHan = lanHan;
    }

    public void add(Money money) {
        synchronized (lanHan) {
            int n = money.getMoney();
//            System.out.println("test1: "+n);
            money.setMoney(n+1);
        }
    }
}

class Test2 {
    private LanHan lanHan;

    public Test2(LanHan lanHan) {
        this.lanHan = lanHan;
    }

    public void add(Money money) {
        synchronized (lanHan) {
            int n = money.getMoney();
//            System.out.println("test2: "+n);
            money.setMoney(n+1);
        }
    }
}
