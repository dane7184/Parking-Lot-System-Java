

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.BorderStyle;
import java.util.regex.Pattern;

public class ParkingLotSystem {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int floor = 0, spotPerFloor = 0;
        Date date = new Date();
        LocalDate localDate =  LocalDate.now();
        boolean isCheckFloor = false;
        int choose = 0;
        String[][] parkingSpot = new String[0][];
        String inputCarNumber;

//        String[] headers = {
//                "Floor ID",
//                "Total Spots",
//                "Occupied Spots",
//                "Available Spots",
//                "Rate"
//        };

        /*String regexFloor = "^[0-9]$";
        Pattern patternFloor = Pattern.compile(regexFloor);
        Matcher matcherFloor = patternFloor.matcher(regexFloor);
        int floorr = matcherFloor.find() ? matcherFloor.start() : 0;*/
        System.out.println("----------------------------------------------------------------");
        System.out.println(ANSI_YELLOW + "   \n---------------- Setup Parking Lot System ---------------\n" + ANSI_RESET);
        System.out.println("----------------------------------------------------------------");

        do {
            System.out.print("Enter the number of floors(max 50): ");
            if (!sc.hasNextInt()){
                System.out.println(ANSI_RED + "\nInvalid input! Please enter a number.\n" + ANSI_RESET);
                sc.next();
                continue;
            }
            floor = sc.nextInt();

            if (floor <= 0) {
                System.out.println( ANSI_RED + "\nPlease enter a positive integer\n" + ANSI_RESET);
            } else if (floor > 50) {
                System.out.println(ANSI_RED + "\nYou Enter the wrong number Floor number is max 50\n" + ANSI_RESET);
            }

        } while (floor <= 0 || floor > 50);

        do {
            System.out.print("Please Enter the number of spot per floor between 10 and 100 : ");

            if (!sc.hasNextInt()){
                System.out.println(ANSI_RED + "\nInvalid input! Please enter a number.\n" + ANSI_RESET);
                sc.next();
                continue;
            }

            spotPerFloor = sc.nextInt();
            if (spotPerFloor < 0) {
                System.out.println(ANSI_RED + "\nPlease enter a positive integer\n" + ANSI_RESET);
            } else if (spotPerFloor < 10){
                System.out.println(ANSI_RED + "\nThe Number of floor must be greater than or equal to 10\n" + ANSI_RESET);
            }  else if (spotPerFloor > 100) {
                System.out.println(ANSI_RED + "\nYou Enter the wrong number Floor number is max 100\n" + ANSI_RESET);
            }
        }  while (spotPerFloor < 10 || spotPerFloor > 100);

        parkingSpot = new String[floor][spotPerFloor];
        System.out.println("Parking Lot System has been started\n");
        System.out.println("\t--->Enter the number of floors(max 50): " + floor);
        System.out.println("\t--->Enter the number of spot per floor:number of spot per floor: " + spotPerFloor);
        System.out.println("\t--->The Total number of spots per floor: " + floor * spotPerFloor);
        System.out.println("\n\n");

        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println(ANSI_YELLOW + "\n---------------- Parking Management System ---------------\n" + ANSI_RESET);
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. Parking Operation ");
            System.out.println("2. View Parking Information");
            System.out.println("3. System Setting");
            System.out.println("4. Update Car by Name");
            System.out.println("5. Exit");

            System.out.print("\n\nchose Your Option (1 - 4) : ");

            if (!sc.hasNextInt()) {
                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                sc.next();
                continue;
            }

            choose = sc.nextInt();

            if (choose < 1 || choose > 5) {
                System.out.println(ANSI_RED + "You can input only 1 - 5." + ANSI_RESET);
                continue;
            }

            System.out.println("----------------------------------------------------------------");
            System.out.println(ANSI_YELLOW + "\n--------------  Parking Operation --------------\n" + ANSI_RESET);
            System.out.println("----------------------------------------------------------------");

            switch (choose) {
                case 1:
                    int chooseFloor, chooseSpot;

                    /*inputCarNumber = sc.next();*/
                    int checkOperation = 0;

                    System.out.println("1. Check In ");
                    System.out.println("2. Check Out");
                    System.out.println("3. Exit\n");
                    System.out.print("\n\nchose Your Option (1 - 3) : ");
                    checkOperation = sc.nextInt();
                    switch (checkOperation){
                        case 1:
                            addCarMore:
                            while (true) {
                                System.out.println("----------------------------------------------------------------");
                                System.out.println(ANSI_YELLOW + "\n--------------------- Check In ---------------------\n " + ANSI_RESET);
                                System.out.println("----------------------------------------------------------------");
                                System.out.print("Enter floor number: ");
                                if (!sc.hasNextInt()) {
                                    System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                    sc.next();
                                    continue;
                                }
                                chooseFloor = sc.nextInt();

                                if (chooseFloor <= 0 || chooseFloor > floor) {
                                    System.out.println(ANSI_RED + "Invalid floor number." + ANSI_RESET);
                                    continue;
                                }

                                System.out.print("Enter spot number: ");
                                if (!sc.hasNextInt()) {
                                    System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                    sc.next();
                                    continue;
                                }
                                chooseSpot = sc.nextInt();

                                if (chooseSpot <= 0 || chooseSpot > spotPerFloor) {
                                    System.out.println(ANSI_RED + "Invalid spot number." + ANSI_RESET);
                                    continue;
                                }

                                if (parkingSpot[chooseFloor - 1][chooseSpot - 1] != null) {
                                    System.out.println(ANSI_RED + "This spot is already occupied." + ANSI_RESET);
                                    continue;
                                }

                                sc.nextLine();

                                String regex = "^[0-9A-Za-z]{3}-[0-9]{3,4}$";
                                Pattern pattern = Pattern.compile(regex);

                                do {
                                    System.out.print("Enter car number (ex: 2As-ASSk): ");
                                    inputCarNumber = sc.nextLine();

                                    if (!pattern.matcher(inputCarNumber).matches()) {
                                        System.out.println(ANSI_RED + "Invalid format! Try again." + ANSI_RESET);
                                    }
                                } while (!pattern.matcher(inputCarNumber).matches());

                                parkingSpot[chooseFloor - 1][chooseSpot - 1] = inputCarNumber;
                                System.out.println(ANSI_GREEN + "Car added successfully!\n" + ANSI_RESET);

                                System.out.print("Do you want to add more cars? (Yes/No): ");
                                String answer = sc.nextLine().trim().toLowerCase();

                                if (answer.equals("yes") || answer.equals("y")) {
                                    continue addCarMore;
                                } else {
                                    break;
                                }
                            }

                            break;

                        case 2:
                            System.out.println("----------------------------------------------------------------");
                            System.out.println(ANSI_YELLOW + "\n---------------------------- Check Out ----------------------------\n" + ANSI_RESET);
                            System.out.println("----------------------------------------------------------------");
                            String searchCheckOut;
                            String regexCheckNoCar = "^[0-9A-Za-z]{3}-[0-9]{3,4}$";
                            Pattern patternId = Pattern.compile(regexCheckNoCar);
                            /*searchCheckOut = sc.nextLine();*/
                            sc.nextLine();
                            do {
                                System.out.print("Enter car number (ex: 2As-ASSk): ");
//                                sc.nextLine();
                                searchCheckOut = sc.nextLine();

                                if (!patternId.matcher(searchCheckOut).matches()) {
                                    System.out.println(ANSI_RED + "The Car Number is Not Fount : " + ANSI_RESET);
                                }

                            } while (!patternId.matcher(searchCheckOut).matches());

                            boolean isFound = false;

                            for (int i = parkingSpot.length - 1; i >= 0; i--) {
                                for (int j = 0; j < parkingSpot[i].length; j++) {
                                    if (parkingSpot[i][j] != null &&
                                            parkingSpot[i][j].equalsIgnoreCase(searchCheckOut)) {
                                            isFound = true;
                                            System.out.println(ANSI_GREEN + "Car was Found in System" + ANSI_RESET);
                                            System.out.println("\t--->Car Owner Number : " + searchCheckOut);
                                            System.out.println("\t--->The Car on Floor :" + (i + 1));
                                            System.out.println("\t--->The Spot Number : " + (j + 1));
                                            System.out.println("\t--->Entry Time : " + localDate);
                                            System.out.println("\t--->Exit Time");

                                            System.out.println("\t--->Parking Duration : \t"+ "Hour\t"+ "Minute");
                                            System.out.println("\t--->Parking Price : $");
                                        /*else {
                                            parkingSpot[i][j]=null;
                                            System.out.println("\nCar Owner Number : [ "+ ANSI_RED + searchCheckOut+ ANSI_RESET +" ] does not exist in the system \n");
                                        }*/
                                    }
                                    if (isFound) break;
                                }
                                /*System.out.println();
                                if (isFound) break;*/
                            }
                            if (!isFound) {
                                System.out.println(ANSI_RED + "Car number [ " + searchCheckOut + " ] does not exist in the system."
                                        + ANSI_RESET);
                            }

                            break;

                        case 3:
                            break;
                    }
                    break;

                case 2:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(ANSI_YELLOW + "\n------------------------ View Parking Information ------------------------\n" + ANSI_RESET);
                    System.out.println("----------------------------------------------------------------");

                    Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);

                    table.addCell("Floor ID");
                    table.addCell("Total Spots");
                    table.addCell("Occupied Spots");
                    table.addCell("Available Spots");
                    table.addCell("Rate");

                    int showPage = 2;
                    int startPage = 0;

                    int endPage = Math.min(startPage + showPage, parkingSpot.length);

                    for (int i = 0; i < endPage; i++) {

                        int totalSpots = parkingSpot[i].length;
                        int occupSpots = 0;

                        for (int j = 0; j < parkingSpot[i].length; j++) {
                            if (parkingSpot[i][j] != null) {
                                occupSpots++;
                            }
                        }

                        int availableSpots = totalSpots - occupSpots;
                        double rate = (occupSpots * 100.0) / totalSpots;

                        table.addCell(String.valueOf(i + 1));
                        table.addCell(String.valueOf(totalSpots));
                        table.addCell(String.valueOf(occupSpots));
                        table.addCell(String.valueOf(availableSpots));
                        table.addCell(String.format("%.2f%%", rate));
                    }
                    System.out.println(table.render());

                    System.out.println("\n");
                    System.out.print("1. Display By Floor\t\t");
                    System.out.print("2. Search for car number: \t\t");
                    System.out.print("3. First Page\t\t");
                    System.out.println("\n");
                   /* System.out.print("4. Next Page\t\t");
                    System.out.print("5. Previous Page\t\t");*/
                    System.out.print("6. Last Page\t\t");
                    System.out.print("7. Exit\t\t\n\n");

                    System.out.print("Chosee Your Option [1-7] : ");
                    int displayOption = sc.nextInt();

                    switch (displayOption) {
                        case 1:
                            System.out.print("\nEnter floor number that you want to display: ");

                            if (!sc.hasNextInt()) {
                                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                sc.next();
                                break;
                            }
                            int displayFloor = sc.nextInt();
                            if (displayFloor <= 0 || displayFloor > floor) {
                                System.out.println(ANSI_RED + "Invalid floor number." + ANSI_RESET);
                                break;
                            }
                            System.out.println("\n----------------------------- \t1. Display By Floor\t -----------------------------\n\n");
                            System.out.println("\n-----------------------------\t Floor " + displayFloor + " \t-----------------------------\n");

                            int show10Row = 10;
                            int totalSpots = parkingSpot[displayFloor - 1].length;

                            for (int i = 0; i < totalSpots; i += show10Row) {

                                int cols = Math.min(show10Row, totalSpots - i);
                                Table tableCase1 = new Table(cols);

                                for (int j = i; j < i + cols; j++) {
                                    if (parkingSpot[displayFloor - 1][j] == null) {
                                        tableCase1.addCell(ANSI_BLUE+"Floor"+displayFloor +"-"+(j+1)+ANSI_RESET+"[ EMPTY ]");
                                    } else {
                                        tableCase1.addCell(ANSI_BLUE+"Floor"+displayFloor +"-"+(j+1)+ANSI_RESET+ "[ "+parkingSpot[displayFloor - 1][j]  + " ]");
                                    }
                                }

                                System.out.println(tableCase1.render());
                            }
                            break;
                        case 2:
                            System.out.println("----------------------------------------------------------------");
                            System.out.println(ANSI_YELLOW + "\n----------------------------- 2. Search for car number -----------------------------: " + ANSI_RESET);
                            System.out.println("\n----------------------------------------------------------------");

                            String searchCarNumber;
                            String regexCheckNoCar = "^[0-9A-Za-z]{3}-[0-9]{3,4}$";
                            Pattern patternId = Pattern.compile(regexCheckNoCar);
                            /*searchCheckOut = sc.nextLine();*/
                            sc.nextLine();
                            do {
                                System.out.print("Enter car number (ex: 2As-ASSk): ");
//                                sc.nextLine();
                                searchCarNumber = sc.nextLine();

                                if (!patternId.matcher(searchCarNumber).matches()) {
                                    System.out.println(ANSI_RED + "The Car Number is Not Fount : " + ANSI_RESET);
                                }

                            } while (!patternId.matcher(searchCarNumber).matches());

                            boolean isFound = false;

                            for (int i = parkingSpot.length - 1; i >= 0; i--) {
                                for (int j = 0; j < parkingSpot[i].length; j++) {
                                    if (parkingSpot[i][j] != null &&
                                            parkingSpot[i][j].equalsIgnoreCase(searchCarNumber)) {
                                        isFound = true;
                                        System.out.println(ANSI_GREEN + "Car was Found in System" + ANSI_RESET + "\n");
                                        System.out.println("\t--->Car Owner Number : " + searchCarNumber);
                                        System.out.println("\t--->The Car on Floor :" + (i + 1));
                                        System.out.println("\t--->The Spot Number : " + (j + 1));
                                        System.out.println("Entry Time : ");
                                        System.out.println("Exit Time");

                                        System.out.println("Parking Duration : \t"+ "Hour\t"+ "Minute");
                                        System.out.println("Parking Price : $");

                                    }
                                    if (isFound) break;
                                }
                                /*System.out.println();
                                if (isFound) break;*/
                            }
                            if (!isFound) {
                                System.out.println(ANSI_RED + "Car number [ " + searchCarNumber + " ] does not exist in the system."
                                        + ANSI_RESET);
                            }
                            break;
                        case 3:
                            /*System.out.print("\nEnter floor number that you want to display: ");

                            if (!sc.hasNextInt()) {
                                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                sc.next();
                                break;
                            }
                            int displayFloor = sc.nextInt();
                            if (displayFloor <= 0 || displayFloor > floor) {
                                System.out.println(ANSI_RED + "Invalid floor number." + ANSI_RESET);
                                break;
                            }*/

                            System.out.println("\n----------------------------- 3. First Page -----------------------------\n");

                            int show10Rows = 10;
                            int totalSpot = parkingSpot[1 - 1].length;

                            for (int i = 0; i < totalSpot; i += show10Rows) {

                                int cols = Math.min(show10Rows, totalSpot - i);
                                Table tableCase1 = new Table(cols);

                                for (int j = i; j < i + cols; j++) {
                                    if (parkingSpot[1 - 1][j] == null) {
                                        tableCase1.addCell(ANSI_BLUE+"Floor"+1 +"-"+(j+1)+ANSI_RESET+"[ EMPTY ]");
                                    } else {
                                        tableCase1.addCell(ANSI_BLUE+"Floor"+1 +"-"+(j+1)+ANSI_RESET+ "[ "+parkingSpot[1 - 1][j]  + " ]");
                                    }
                                }

                                System.out.println(tableCase1.render());
                            }
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            System.out.println("\n----------------------------- 6. Last Page -----------------------------\n");

                            /*System.out.print("\nEnter floor number that you want to display: ");

                            if (!sc.hasNextInt()) {
                                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                sc.next();
                                break;
                            }
                            int displayFloor = sc.nextInt();
                            if (displayFloor <= 0 || displayFloor > floor) {
                                System.out.println(ANSI_RED + "Invalid floor number." + ANSI_RESET);
                                break;
                            }*/

                            int totalRows = 10;
                            int floorIndex = floor - 1;
                            int total = parkingSpot[floorIndex].length;

                            int colsPerRow = (int) Math.ceil((double) total / totalRows);
                            int spotIndex = 0;

                            for (int i = 0; i < totalRows; i++) {
                                int spots = total - spotIndex;
                                int colsInThisRow = Math.min(colsPerRow, spots);

                                Table tableRow = new Table(colsInThisRow);

                                for (int j = 0; j < colsInThisRow; j++) {
                                    if (parkingSpot[floorIndex][spotIndex] == null) {
                                        tableRow.addCell(ANSI_BLUE + "Floor" + (floor) + "-" + (spotIndex + 1) + ANSI_RESET + " [ EMPTY ]");
                                    } else {
                                        tableRow.addCell(ANSI_BLUE + "Floor" + (floor) +"-" + (spotIndex + 1) + ANSI_RESET + " [ " + parkingSpot[floorIndex][spotIndex] + " ]");
                                    }
                                    spotIndex++;
                                }

                                System.out.println(tableRow.render());

                                if (spotIndex >= total) break;
                            }
                            break;
                        case 7:
                            break;
                    }

                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(ANSI_YELLOW +"\n------------------------------------ 3. System Setting -------------------------------------\n"+ ANSI_RESET);
                    System.out.println("----------------------------------------------------------------");

                    System.out.println("1. Reset By Floor");
                    System.out.println("2. Reset All Floors");
                    System.out.println("3. Show many Page by user input  ");
                    System.out.println("4. Exit");
                    System.out.print("Choose option (1-4): ");

                    int chooseResetFloor = sc.nextInt();
                    sc.nextLine();
                    switch (chooseResetFloor) {
                        case 1:
                            System.out.print("Reset Floor (1 - " + floor + "): ");

                            if (!sc.hasNextInt()) {
                                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                                sc.next();
                                break;
                            }

                            int resetFloor = sc.nextInt();
                            sc.nextLine();

                            if (resetFloor > 0 && resetFloor <= floor) {

                                System.out.print("Do you want to reset Floor " + resetFloor + " (Yes/No)? : ");
                                String confirmReset = sc.nextLine().trim().toLowerCase();

                                if (confirmReset.equals("yes") || confirmReset.equals("y")) {

                                    for (int j = 0; j < parkingSpot[resetFloor - 1].length; j++) {
                                        parkingSpot[resetFloor - 1][j] = "Empty";
                                    }

                                    System.out.println(ANSI_RED_BACKGROUND + "Floor " + resetFloor + " has been reset." + ANSI_RESET);

                                } else {
                                    System.out.println("Reset cancelled.");
                                }

                            } else {
                                System.out.println("Invalid floor number!");
                            }
                            break;

                        case 2:
                            System.out.print("Do you want to reset ALL floors (Yes/No)? : ");
                            String confirmResetAll = sc.nextLine().trim().toLowerCase();
                            if (confirmResetAll.equals("yes") || confirmResetAll.equals("y")) {

                                for (int i = 0; i < parkingSpot.length; i++) {
                                    for (int j = 0; j < parkingSpot[i].length; j++) {
                                        parkingSpot[i][j] = "Empty";
                                    }
                                }
                                System.out.println(ANSI_RED_BACKGROUND + "All floors have been reset." +  ANSI_RESET);

                            } else {
                                System.out.println("Reset cancelled.");
                            }
                            break;

                        case 3:
                            System.out.println("----------------------------------------------------------------");
                            System.out.println(ANSI_YELLOW + "\n------------------------ Display Floor Report ------------------------\n" + ANSI_RESET);
                            System.out.println("----------------------------------------------------------------");

                            Table tableCase3 = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);

                            tableCase3.addCell("Floor ID");
                            tableCase3.addCell("Total Spots");
                            tableCase3.addCell("Occupied Spots");
                            tableCase3.addCell("Available Spots");
                            tableCase3.addCell("Rate");

                            int showPageUwant;
                            int pageStart = 0;

                            System.out.print("Input per floor that you want to show: ");
                            if (!sc.hasNextInt()){
                                System.out.println(ANSI_RED + "\nInvalid input! Please enter a number.\n" + ANSI_RESET);
                                sc.next();
                                continue;
                            }
                            showPageUwant = sc.nextInt();
                            if (showPageUwant < 0 && showPageUwant > floor) {
                                System.out.println(ANSI_RED + "\nYou can not Big then current page\n" + ANSI_RESET);
                                sc.next();
                                continue;
                            }

                            int pageEnd = Math.min(pageStart + showPageUwant, parkingSpot.length);

                            for (int i = 0; i < pageEnd; i++) {

                                int totalSpots = parkingSpot[i].length;
                                int occupSpots = 0;

                                for (int j = 0; j < parkingSpot[i].length; j++) {
                                    if (parkingSpot[i][j] != null) {
                                        occupSpots++;
                                    }
                                }

                                int availableSpots = totalSpots - occupSpots;
                                double rate = (occupSpots * 100.0) / totalSpots;

                                tableCase3.addCell(String.valueOf(i + 1));
                                tableCase3.addCell(String.valueOf(totalSpots));
                                tableCase3.addCell(String.valueOf(occupSpots));
                                tableCase3.addCell(String.valueOf(availableSpots));
                                tableCase3.addCell(String.format("%.2f%%", rate));
                            }
                            System.out.println(tableCase3.render());
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println(ANSI_RED + "Invalid option!" + ANSI_RESET);
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(ANSI_YELLOW + "\n----------------------------- 4. Update Car by Name -----------------------------: " + ANSI_RESET);
                    System.out.println("\n----------------------------------------------------------------");
                    String updateCarNumber;
                    String regex = "^[0-9A-Za-z]{3}-[0-9]{3,4}$";
                    Pattern pattern = Pattern.compile(regex);
                    System.out.println("1. Update Car by Name :");
                    System.out.println("2. Update Car by Status :");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: 1- 3 : ");
                    int chooseUpdate;
                    chooseUpdate = sc.nextInt();
                    switch (chooseUpdate){
                        case 1:
                            do {
                                System.out.print("Enter car number (ex: 2As-ASSk): ");
                                updateCarNumber = sc.nextLine();

                                if (!pattern.matcher(updateCarNumber).matches()) {
                                    System.out.println(ANSI_RED + "Invalid format! Try again." + ANSI_RESET);
                                }
                            } while (!pattern.matcher(updateCarNumber).matches());

                            boolean found = false;

                            for (int i = 0; i < parkingSpot.length; i++) {
                                for (int j = 0; j < parkingSpot[i].length; j++) {
                                    if (parkingSpot[i][j] != null &&
                                            parkingSpot[i][j].equalsIgnoreCase(updateCarNumber)) {

                                        found = true;
                                        int newFloor, newSpot;
                                        do {
                                            System.out.print("Enter new floor (1-" + parkingSpot.length + "): ");
                                            newFloor = sc.nextInt();
                                        } while (newFloor < 1 || newFloor > parkingSpot.length);

                                        do {
                                            System.out.print("Enter new spot (1-" + parkingSpot[newFloor-1].length + "): ");
                                            newSpot = sc.nextInt();
                                        } while (newSpot < 1 || newSpot > parkingSpot[newFloor-1].length);

                                        sc.nextLine();
                                        if (parkingSpot[newFloor-1][newSpot-1] == null) {
                                            parkingSpot[newFloor-1][newSpot-1] = parkingSpot[i][j];
                                            parkingSpot[i][j] = null;
                                            System.out.println(ANSI_GREEN + "Car " + updateCarNumber + " moved to Floor " +
                                                    newFloor + " Spot " + newSpot + ANSI_RESET);


                                        } else {
                                            System.out.println(ANSI_RED + "Target spot is not empty! Update failed." + ANSI_RESET);
                                        }
                                        break;
                                    }
                                }
                                if (found) break;
                            }

                            if (!found) {
                                System.out.println(ANSI_RED + "Car " + updateCarNumber + " not found in the parking lot." + ANSI_RESET);
                            }
                            break;
                            case 2:
                                int updateFloor, updateSpot;

                                do {
                                    System.out.print("Enter floor to clear (1-" + parkingSpot.length + "): ");
                                    updateFloor = sc.nextInt();
                                } while (updateFloor < 1 || updateFloor > parkingSpot.length);

                                do {
                                    System.out.print("Enter spot to clear (1-" + parkingSpot.length + "): ");
                                    updateSpot = sc.nextInt();
                                }while (updateSpot < 1 || updateSpot > parkingSpot.length);

                                if (parkingSpot[updateFloor-1][updateSpot-1] == null) {
                                    System.out.println(ANSI_YELLOW + "Spot Floor " + updateFloor + " - " + updateSpot + " is already EMPTY." + ANSI_RESET);
                                } else {

                                    parkingSpot[updateFloor-1][updateSpot-1] = null;
                                    System.out.println(ANSI_GREEN + "Floor: " + updateFloor + " \t Car Spot: " + updateSpot + "\t has been clear to Emity." + ANSI_RESET);
                                }
                                break;
                        default:
                            System.out.println(ANSI_RED + "Invalid option!" + ANSI_RESET);
                    }
                    break;

                case 5:
                    break;
            }
        } while (choose != 5);
    }
}