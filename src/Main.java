public class Main {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();

        console.afficherMenuPricipale();
        console.readNextInt("\nAction à réaliser : ", 0, 5);
    }
}
