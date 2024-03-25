class Garis {
    private int length;
    private boolean horizontal;

    public Garis(int length, boolean horizontal) {
        this.length = length;
        this.horizontal = horizontal;
    }

    public void draw() {
        if (horizontal == true) {
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
}