import controller.GameController;
import service.GameService;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
