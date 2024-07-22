module org.fierydragon.fierydragon {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens org.fierydragon.fierydragon to javafx.fxml;
    exports org.fierydragon.fierydragon;
    exports org.fierydragon.fierydragon.animal;
    opens org.fierydragon.fierydragon.animal to javafx.fxml;
    exports org.fierydragon.fierydragon.action;
    opens org.fierydragon.fierydragon.action to javafx.fxml;
    exports org.fierydragon.fierydragon.chitcard;
    opens org.fierydragon.fierydragon.chitcard to javafx.fxml;
    exports org.fierydragon.fierydragon.subscriber;
    opens org.fierydragon.fierydragon.subscriber to javafx.fxml;
    exports org.fierydragon.fierydragon.controller;
    opens org.fierydragon.fierydragon.controller to javafx.fxml;
    exports org.fierydragon.fierydragon.volcano;
    opens org.fierydragon.fierydragon.volcano to javafx.fxml;
    exports org.fierydragon.fierydragon.tile;
    opens org.fierydragon.fierydragon.tile to javafx.fxml;
}