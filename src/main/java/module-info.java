module ar.edu.unlu.scrabble {
    requires javafx.controls;
    requires javafx.fxml;


    opens ar.edu.unlu.scrabble to javafx.fxml;
    exports ar.edu.unlu.scrabble;
}