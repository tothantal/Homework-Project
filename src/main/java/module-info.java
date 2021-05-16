module hw.hw {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.tinylog.api;
	
	requires java.xml.bind;
	requires javafx.graphics;

    opens hw.hw to javafx.fxml, junit;
    opens boardgame.model to java.xml.bind, junit;
    
    exports hw.hw;
    exports boardgame.model;
}
