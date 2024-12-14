public class NestedForLoop3 {
    public static void main(String[] args) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 1; j <= 4; j = j++) {
                System.out.print((i*4)+j + " ");
            }
            System.out.println();
        }
    }
}