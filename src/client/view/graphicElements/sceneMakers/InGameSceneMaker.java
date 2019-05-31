package client.view.graphicElements.sceneMakers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class InGameSceneMaker extends SceneMaker {
    private static int baseNumber;
    private static Group group = new Group();
    private static Scene gameScene = new Scene(group, 1000, 600);
    private static Label gameOverLabel;
    private static Timeline gameOverTimeline;
    private static boolean timeLinePlaying = false;
    private final static int BOX_HEIGHT = 70;
    private final static int BOX_FIRST_DEPTH = 10;

    private final static Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    private final static Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    private final static Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

    static {
        rxBox.setAngle(-10);
        ryBox.setAngle(0);
        rzBox.setAngle(0);
    }

    @Override
    public Scene makeScene() {
        timeLinePlaying = false;
        gameOverLabel = initGameOverLabel();
        gameOverTimeline.stop();
//        new InGameController().loadGameTable();
        gameScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
//                    new InGameController().move(Directon.UP);
                    break;
                case RIGHT:
//                    new InGameController().move(Directon.RIGHT);
                    break;
                case LEFT:
//                    new InGameController().move(Directon.LEFT);
                    break;
                case DOWN:
//                    new InGameController().move(Directon.DOWN);
                    break;
            }
        });
        return gameScene;
    }

//    public static void updateScene(Table table) {
//        int numberOfRows = table.getNumberOfRows();
//        int numberOfColumns = table.getNumberOfColumns();
//        baseNumber = table.getBaseNumber();
//
//        Box groundBox = new Box(numberOfColumns * BOX_HEIGHT, numberOfRows * BOX_HEIGHT, BOX_FIRST_DEPTH);
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(Color.LIGHTBLUE);
//        groundBox.setMaterial(material);
//        groundBox.relocate(0, 0);
//        groundBox.getTransforms().addAll(new Translate(), rxBox, ryBox, rzBox);
//
//        Button exitButton = new ExitButton();
//        exitButton.relocate((numberOfColumns + 4) * BOX_HEIGHT, numberOfRows / 2 * BOX_HEIGHT);
//
//        Label scoreLabel = new Label("Score: " + table.getScore());
//        scoreLabel.relocate((numberOfColumns + 2) * BOX_HEIGHT, numberOfRows / 2 * BOX_HEIGHT - 40);
//        Label highScoreLabel = new Label("High score: " + GameContents.getCurrentProfile().getHighScore());
//        highScoreLabel.relocate((numberOfColumns + 2) * BOX_HEIGHT, numberOfRows / 2 * BOX_HEIGHT + 40);
//
//
//        group.getChildren().clear();
//        group.getChildren().addAll(groundBox, exitButton, scoreLabel, highScoreLabel);
//
//        if (table.isGameOver()) {
//            group.getChildren().add(gameOverLabel);
//            if (!timeLinePlaying) {
//                gameOverTimeline.play();
//                timeLinePlaying = true;
//            }
//        }
//
//        Cell[][] cells = table.getCells();
//        for (int i = 0; i < numberOfRows; i++) {
//            for (int j = 0; j < numberOfColumns; j++) {
//                Cell cell = cells[i][j];
//                if (cell.getValue() != 0) {
//                    Box box = makeBox(i, j, cell);
//                    Label label = makeLabel(i, j, cell);
//                    group.getChildren().add(box);
//                    group.getChildren().add(label);
//                }
//            }
//        }
//
//        group.relocate(BOX_HEIGHT, BOX_HEIGHT);
//    }

//    private static Box makeBox(int i, int j, Cell cell) {
//        Box box = new Box(BOX_HEIGHT, BOX_HEIGHT, getDepth(cell.getValue()));
//        box.relocate(j * BOX_HEIGHT, i * BOX_HEIGHT);
//        PhongMaterial material = new PhongMaterial();
//        material.setDiffuseColor(getBackgroundColor(cell.getValue()));
//        box.setMaterial(material);
//
//        box.getTransforms().addAll(new Translate(), rxBox, ryBox, rzBox);
//        return box;
//    }

//    private static Label makeLabel(int i, int j, Cell cell) {
//        Translate translate = new Translate(0, 0, 0);
//        Label label = new Label(cell.getValue() + "");
//        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
//        label.relocate(j * BOX_HEIGHT + BOX_HEIGHT / 4, i * BOX_HEIGHT + BOX_HEIGHT / 4);
//        label.setTextFill(getForegroundColor(cell.getValue()));
//        label.getTransforms().addAll(translate, rxBox, ryBox, rzBox);
//        return label;
//    }

    private static Label initGameOverLabel() {
        Label label = new Label("GAME OVER!!");
        label.setStyle("-fx-text-fill: #990900; -fx-font-size: 70px; -fx-font-weight: bolder;");

        Rotate rotate = new Rotate();
        rotate.setAngle(-20);

        Scale scale = new Scale();
        scale.setX(1);
        scale.setY(1);

        Translate translate = new Translate();
        translate.setX(300);
        translate.setY(300);
        translate.setZ(0);

        label.getTransforms().addAll(rotate, scale, translate);


        KeyValue keyValue = new KeyValue(scale.xProperty(), 0.25);
        KeyValue keyValue1 = new KeyValue(scale.yProperty(), 0.25);
        KeyValue keyValue2 = new KeyValue(translate.xProperty(), 600);
        KeyValue keyValue3 = new KeyValue(translate.yProperty(), 900);
        KeyValue keyValue4 = new KeyValue(translate.zProperty(), 300);
        KeyValue keyValue5 = new KeyValue(rotate.angleProperty(), 20);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1500)
                , keyValue, keyValue1, keyValue2
                , keyValue3, keyValue4, keyValue5);
        gameOverTimeline = new Timeline(keyFrame);
        gameOverTimeline.setAutoReverse(true);
        gameOverTimeline.setCycleCount(Timeline.INDEFINITE);

        return label;
    }
}
