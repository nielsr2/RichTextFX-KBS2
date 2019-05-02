package org.fxmisc.richtext.demo.richtext;


import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class KBS extends HBox {
    private String oprSystem;
    private boolean visible = false;
    protected int kbsTimesUsed = 0;
    String functionality;
    protected int tbTimesClicked = 0;
    private int nrOnList;
    private boolean pinned;
    public int KBStype[] = new int[5];

    private double opacity = 1;
    Rectangle backgroundRect;
    ImageView icon;
    Text shortcut;

    /**
     * colors for the gradient
     */
    // http://www.java2s.com/Tutorials/Java/JavaFX/0110__JavaFX_Gradient_Color.htm

    Color grColorGrey1 = new Color(0.5, 0.5, 0.5, 0.30);
    Color grColorGrey2 = new Color(0.7, 0.7, 0.7, 0.15);

    Color grColorRed1 = new Color(0.5, 0, 0, 0.70);
    Color grColorRed2 = new Color(0.5, 0, 0, 0.30);

    Color grColorYellow1 = new Color(0.9, 0.7, 0, 0.70);
    Color grColorYellow2 = new Color(0.9, 0.7, 0, 0.30);

    Color grColorGreen1 = new Color(0.2, 0.6, 0, 0.70);
    Color grColorGreen2 = new Color(0.2, 0.6, 0, 0.30);

//    TODO 1 ARE ALL THESE COLORS AND FUNCTIONS NECESSARY? WHAT ABOUT ONE FUNCTION WITH PARAMS FOR COLOR AND OPACITY?

    KBS(String shortcut, String iconPath) {

        // initial rectangle
        backgroundRect = new Rectangle(170, 50, Color.LIGHTGREY);

        HBox content = new HBox(5);
        content.setPadding(new Insets(5, 5, 5, 5));

        icon = new ImageView(new Image(iconPath));
        icon.setFitWidth(40);
        icon.setPreserveRatio(true);
        icon.setSmooth(true);
        icon.setCache(true);

        this.shortcut = new Text(shortcut);
        this.shortcut.setFont(new Font(30));

        content.getChildren().addAll(icon, this.shortcut);


        this.getChildren().addAll(backgroundRect, content);
        //.fade(0.1,2).play();
        this.setOnMouseMoved(event -> {
            System.out.println("test");
        });
    }
    HBox content;
    KBS(String shortcut) {
        // initial rectangle
        backgroundRect = new Rectangle(170, 50, Color.LIGHTGREY);

        content = new HBox(5);
        content.setPadding(new Insets(5, 5, 5, 5));

        this.shortcut = new Text(shortcut);
        this.shortcut.setFont(new Font(30));

        content.getChildren().addAll( this.shortcut);


        this.getChildren().addAll(backgroundRect, content);
        //.fade(0.1,2).play();
        this.setOnMouseMoved(event -> {
            System.out.println("test");
        });
    }
    KBS(){}
// TODO CAN WE MAYBE JUST CALL THE FUNCTION USE FOR THIS PARAM, INSIDE KBSMANAGER
//    KBS(String oprSystem) {
//        this.oprSystem = oprSystem;
//    }

    public void KBSused() {
        this.kbsTimesUsed++;
        this.tbTimesClicked++;
        System.out.println(this.kbsTimesUsed + " " + this.tbTimesClicked);
    }

    /**
     * methods for each gradient color gradient
     */
    //    TODO 1

    public void setColor(Color color1, Color color2) {
        Stop[] stopsColor = new Stop[]{new Stop(0, color1), new Stop(1, color2)};
        LinearGradient lgColor = new LinearGradient(1, 0, 0, 0, true, CycleMethod.NO_CYCLE, stopsColor);

        this.backgroundRect.setFill(lgColor);
    }



    public FadeTransition fade(double opacityEnd, double time) {

        double opacityStart = this.opacity;


        FadeTransition fade = new FadeTransition(Duration.seconds(time), this);
        fade.setFromValue(opacityStart);
        fade.setToValue(opacityEnd);
        //fade.setCycleCount(Timeline.INDEFINITE);
        //fade.setAutoReverse(true);
        fade.play(); //start animation

        return fade;

        //this.setOnMousePressed(e -> System.out.println("adasfdf"));


    }


}
