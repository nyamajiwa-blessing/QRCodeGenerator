package com.grey.converter.qrcodegenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.application.Application;
//import javafx.embed.swing.SwingFXUtils;
// import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class QRCodeGeneratorApp extends Application{
    @Override
    public void start(Stage primaryStage){
        // Create UI components
        Label label = new Label("Enter text to generate QR Code: ");
        TextField textField = new TextField();
        Button generateButton = new Button("Generate QR Code");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        // Set up the layout
        VBox vbox = new VBox(10, label, textField, generateButton, imageView);
        vbox.setPadding(new Insets(30));
        Scene scene = new Scene(vbox, 300, 300);

        // Set up the stage
        primaryStage.setTitle("QR Code Generator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Handle button click event
        generateButton.setOnAction(event -> {
            String text = textField.getText();
            if(!text.isEmpty()){
                try{
                    // Generate QR Code
                    QRCodeWriter qrCodeWriter = new QRCodeWriter();
                    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

                    // Convert BitMatrix to BufferedImage
                    BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

                    // Convert BufferedImage to JavaFX Image
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "png", outputStream);
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                    Image qrImage = new Image(inputStream);
                    imageView.setImage(qrImage);

                    // Save the QR Code as an image file (optional)
                     File outputFile = new File("qrcode.png");
                     ImageIO.write(bufferedImage, "png", outputFile);

                    // Display the QQR code in the ImageView
                    // Image qrImage = SwingFXUtils.toFXImage(bufferedImage, null);
                    // imageView.setImage(qrImage);
                }catch(WriterException | IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
