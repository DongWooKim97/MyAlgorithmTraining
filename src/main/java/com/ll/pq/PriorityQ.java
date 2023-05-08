package com.ll.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Vehicle> pQ = new PriorityQueue<>(Collections.reverseOrder());

        pQ.offer(new Vehicle("대중교통", 70));
        pQ.offer(new Vehicle("자가용", 45));
        pQ.offer(new Vehicle("도보", 400));
        pQ.offer(new Vehicle("자전거", 125));

        while (!pQ.isEmpty()) {
            Vehicle v = pQ.poll();
            System.out.println(v.getName() + " 시간 : " + v.getTime());
        }
    }
}

class Vehicle implements Comparable<Vehicle> {
    private final String name;
    private final int time;

    public Vehicle(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Vehicle target) {
        if (this.time < target.getTime()) return -1;
        else if (this.time > target.getTime()) return 1;
        return 0;
    }
}


