module com.grey.converter.qrcodegenerator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.zxing;
    // requires javafx.embed.swing;
    requires com.google.zxing.javase;
    requires java.desktop;

    opens com.grey.converter.qrcodegenerator to javafx.fxml;
    exports com.grey.converter.qrcodegenerator;
}