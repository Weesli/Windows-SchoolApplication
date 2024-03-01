module net.weesli.windowsschoolapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens net.weesli.windowsschoolapplication to javafx.fxml;
    exports net.weesli.windowsschoolapplication;
}