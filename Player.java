public class Player {
    private int live = 3;

    public void loseLive() {
        live--;
        if (live <= 0) {
            // Handle player loss
        }
    }

    public void resetLive() {
        live = 3;
    }
}
