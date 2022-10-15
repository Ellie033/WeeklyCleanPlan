package com.example.demo;

public class Plantable {

    private DateOfPlan datePlan = new DateOfPlan();
    private int weekNumber = datePlan.weekOfCurrentDate();

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void printRule(){
        BathroomRule();
        VacuumRule();
        KitchenRule();
    }
    public void BathroomRule() {

        System.out.println();
        System.out.println("Aufpassen ");
        String rule = "Bad: Spiegel, Boden Handtuch tauschen";
        System.out.println(rule);
    }
    public void VacuumRule() {
        String rule = "Saugen: Die Treppe";
        System.out.println(rule);
    }
    public void KitchenRule() {
        String rule = "Küche: Gelber Sack Müll, Rest Müll";
        String ruleTrash = "Müll: Bad Müll";

        System.out.println(rule);
        System.out.println(ruleTrash);
    }

    public void firstSet(){
        printTableRowZero();
        printTableRowOne();
        printTableRowTwo();
        printTableRowZero();
        printTableRowOne();
        printTableRowTwo();
        printRule();
    }

    public void secondSet(){
        printTableRowOne();
        printTableRowTwo();
        printTableRowZero();
        printTableRowOne();
        printTableRowTwo();
        printTableRowZero();
        printRule();
    }

    public void thirdSet(){
        printTableRowTwo();
        printTableRowZero();
        printTableRowOne();
        printTableRowTwo();
        printTableRowZero();
        printTableRowOne();
        printRule();
    }

    // The column head of the table
    public void printTableRow() {

        String tableHead = "|  " + " " + datePlan.currentDate();
        String bathroom = "| Bad";
        String trash = "| Müll";
        String vacuumFloor = "| Sau";
        String seperatorEnd = "|";

        System.out.printf("%-20s", tableHead);
        System.out.printf("%-10s", bathroom);
        System.out.printf("%-10s", trash);
        System.out.printf("%-10s", vacuumFloor);
        System.out.printf("%-10s%n", seperatorEnd);
    }

    // If the current week n modulo 3 equals 0,then this row is the plan of this
    // week
    public void printTableRowZero() {
        String time1 = "|week " + weekNumber;
        String time2 = datePlan.getDateAsString(weekNumber);
        String bathroom = "|  C";
        String trash = "|  E";
        String vacuumFloor = "|  A";
        String seperatorEnd = "|";

        System.out.printf("%-10s", time1);
        System.out.printf("%10s", time2);
        System.out.printf("%-10s", bathroom);
        System.out.printf("%-10s", trash);
        System.out.printf("%-10s", vacuumFloor);
        System.out.printf("%-10s%n", seperatorEnd);
        setWeekNumber(++weekNumber);
    }

    // If the current week n modulo 3 equals 1,then this row is the plan of this
    // week
    public void printTableRowOne() {
        String time1 = "|week " + weekNumber;
        String time2 = datePlan.getDateAsString(weekNumber);
        String bathroom = "|  E";
        String trash = "|  A";
        String vacuumFloor = "|  C";
        String seperatorEnd = "|";

        System.out.printf("%-10s", time1);
        System.out.printf("%10s", time2);
        System.out.printf("%-10s", bathroom);
        System.out.printf("%-10s", trash);
        System.out.printf("%-10s", vacuumFloor);
        System.out.printf("%-10s%n", seperatorEnd);
        setWeekNumber(++weekNumber);
    }

    // If the current week n modulo 3 equals 2,then this row is the plan of this
    // week
    public void printTableRowTwo() {
        String time1 = "|week " + weekNumber;
        String time2 = datePlan.getDateAsString(weekNumber);
        String bathroom = "|  A";
        String trash = "|  C";
        String vacuumFloor = "|  E";
        String seperatorEnd = "|";

        System.out.printf("%-10s", time1);
        System.out.printf("%10s", time2);
        System.out.printf("%-10s", bathroom);
        System.out.printf("%-10s", trash);
        System.out.printf("%-10s", vacuumFloor);
        System.out.printf("%-10s%n", seperatorEnd);
        setWeekNumber(++weekNumber);
    }


}

