package net.weesli.windowsschoolapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

public class Controller {

    public TextField textbox;
    public Label title;
    public VBox background;
    public Button one, two, three, four, five, six, seven, eight, nine, zero;
    public Button open;


    @FXML
    private void initialize(){
        StringBuilder builder = new StringBuilder(new String());
        String[] number = {"0",
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9"};

        Random random = new Random();
        for(int x = 0; x < 5; x++){
            String ramdomNumber = number[random.nextInt(9)];
            builder.append(ramdomNumber);
        }
        title.setText(title.getText().replaceAll("<code>" , builder.toString()));
    }

    // TODO: WAIT THIS STEP

    @FXML
    public void CheckCode(MouseEvent e){
        try {
            URL obj = new URL("localhost?=" + title.getText());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String[] statusList = response.toString().split(":");
                String status = statusList[1].replaceAll("}", "");
                System.out.println(status);
            } else {
                throw new IOException("Response code: " + responseCode);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    private void addNumberToLabel(Integer number){
        textbox.setText(textbox.getText() + number);
    }
    @FXML
    private void removeCharacter(MouseEvent e){
        if(textbox.getText().length() != 0){
            StringBuilder string = new StringBuilder(new String());
            for(int a = 0; a != (textbox.getText().length() - 1);a++){
                string.append(textbox.getText().charAt(a));
            }
            textbox.setText(string.toString());
        }
    }

    @FXML
    private void one(MouseEvent event) {
        event.consume();
        addNumberToLabel(1);
    }

    @FXML
    private void two(MouseEvent event) {
        event.consume();
        addNumberToLabel(2);
    }

    @FXML
    private void three(MouseEvent event) {
        event.consume();
        addNumberToLabel(3);
    }

    @FXML
    private void four(MouseEvent event) {
        event.consume();
        addNumberToLabel(4);
    }

    @FXML
    private void five(MouseEvent event) {
        event.consume();
        addNumberToLabel(5);
    }

    @FXML
    private void six(MouseEvent event) {
        event.consume();
        addNumberToLabel(6);
    }

    @FXML
    private void seven(MouseEvent event) {
        event.consume();
        addNumberToLabel(7);
    }

    @FXML
    private void eight(MouseEvent event) {
        event.consume();
        addNumberToLabel(8);
    }

    @FXML
    private void nine(MouseEvent event) {
        event.consume();
        addNumberToLabel(9);
    }

    @FXML
    private void zero(MouseEvent event) {
        event.consume();
        addNumberToLabel(10);
    }

}