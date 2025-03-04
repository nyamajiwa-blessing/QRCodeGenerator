# Step-by-Step Explanation
1. *Generate QR Code:*
   - The QRCodeWriter encodes the input text into a BitMatrix.
2. *Convert BitMatrix to BufferedImage:*
   - The MatrixToImageWriter.toBufferedImage() method converts the BitMatrix to a BufferedImage.
3. *Convert Buffered Image to JavaFX Image:*
   - The BufferedImage is written to a ByteArrayOutputStream as a PNG.
   - The ByteArrayOutputStream is then converted to a ByteArrayInputStream.
   - A JavaFX Image is created from the ByteArrayInputStream.
4. *Display the Image:*
   - The JavaFX Image is set as the source for the ImageView.
5. *Save the QR Code - (to be implemented):*
   - The BufferedImage is saved as a PNG file using ImageIO.write().

# Running the Application
1. Install the ZXing library via Maven, Gradle or JAR files.
2. Run the QRCodeGeneratorApp class.
3. Enter text in the text field and click the "Generate QR Code" button.
4. The QR code will be displayed in the ImageView and saved as qrcode.png in the project directory.
