import java.util.Scanner;

public class BankAccount {
     int bankBalance;

    //vorheriger abgebuchter/eingezahlter Betrag
    private int previousTransaction;
    private String customerName;
    private String customerID;

    //Konstruktor um den Namen und die ID zu bekommen
    BankAccount(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;

    }


    //Einzahlung auf das Konto
    void deposit(int amount){
        if(amount != 0){
            bankBalance = bankBalance + amount;
            previousTransaction = amount;
        }
    }

    //Auszahlung vom Konto
    void withdraw(int amount){
        if(amount != 0){
            bankBalance = bankBalance - amount;
            previousTransaction = -amount;
        }
    }

    //MEthode zeigt an was vorher eingezahlt bzw. ausgezahlt wurde
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Eingezahlt: " + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.println("Ausgezahlt: " + previousTransaction);
        }
        else{
            System.out.println("Keine Transaktionen");
        }
    }

    //Menü mit den einzelnen möglichen Optionen
    void showMenu(){

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wilkommen " + customerName);
        System.out.println("Ihre ID lautet " + customerID + "\n");
        System.out.println("A. Kontostand");
        System.out.println("B. Einzahlen");
        System.out.println("C. Auszahlen");
        System.out.println("D. Vorherige Transaktion");
        System.out.println("E. Schließen");

        while(option != 'E'){
            System.out.println("###############################");
            System.out.println("Bitte Option Wählen");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("-----------------------------");
                    System.out.println("Kontostand: " + bankBalance);
                    System.out.println("-----------------------------");
                    break;

                case 'B':
                    System.out.println("-----------------------------");
                    System.out.println("Bitte den einzuzahlenden Betrag eingeben: ");
                    int amountDeposit = scanner.nextInt();
                    deposit(amountDeposit);
                    System.out.println("-----------------------------");
                    System.out.println("Betrag wurde eingezahlt");
                    System.out.println("-----------------------------");
                    break;

                case 'C':
                    System.out.println("-----------------------------");
                    System.out.println("Bitte den auszuzahlenden Betrag eingeben: ");
                    System.out.println("-----------------------------");
                    int amountWithdraw = scanner.nextInt();
                    withdraw(amountWithdraw);
                    System.out.println("-----------------------------");
                    System.out.println("Betrag wurde ausgezahlt");
                    System.out.println("-----------------------------");
                    break;

                case 'D':
                    System.out.println("-----------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------");
                    break;

                case 'E':
                    System.out.println("----//Exit//----");

                default:
                    System.out.println("Die Eingabe ist inkorrekt!. Bitte geben Sie einer der oben stehenden Optionen ein.");

            }

            System.out.println("Service wurde beendet");

        }

    }
}
