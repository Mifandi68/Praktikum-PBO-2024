class Garis implements Clearable {
    public int length;
    public boolean horizontal;

    public Garis(int length, boolean horizontal) {
        this.length = length;
        this.horizontal = horizontal;
    }

    @Override
    public void draw() {
        if (horizontal) {
            for (int i = 0; i < length; i++) {
                System.out.print("=");
            }
            System.out.println();
        } else {
            for (int i = 0; i < length; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while clearing the screen: " + e.getMessage());
        }
    }
}
