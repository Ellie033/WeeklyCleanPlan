package com.example.demo;

public class CleanSchedule {

    public void printTable() {
        Plantable table = new Plantable();
        table.printTableRow();
        int n = new DateOfPlan().weekOfCurrentDate();
        if (n % 3 == 0) {
            table.firstSet();
        } else if (n % 3 == 1) {
            table.secondSet();
        } else if (n % 3 == 2) {
            table.thirdSet();
        }
    }

}

