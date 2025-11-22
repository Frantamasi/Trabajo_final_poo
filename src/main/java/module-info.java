module ar.edu.unlu.scrabble {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ar.edu.unlu.scrabble to javafx.fxml;
    exports ar.edu.unlu.scrabble;
}