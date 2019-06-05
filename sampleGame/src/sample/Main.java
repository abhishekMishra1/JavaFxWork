package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene;
    final float WIDTH = 800;
    final float HEIGHT = 600;

    TextField tfSpeed;
    Label lSpeed;
    Button sumbit;
    CollisionOfBall cb;
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Collision");
        Group root = new Group();
        scene = new Scene(root, WIDTH, HEIGHT);

        //Set Controlling Menu
        sumbit = new Button("Submit");
        lSpeed = new Label("Set Ball Speed");
        tfSpeed = new TextField("1");

       // sumbit.setOnAction();
        cb = new CollisionOfBall(WIDTH, HEIGHT);

        root.getChildren().addAll(cb.GetBall(), sumbit, lSpeed, tfSpeed);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long elapsedTime)
            {
                cb.update(elapsedTime);
            }
        };

        animator.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

//    private void SetValues()
}
