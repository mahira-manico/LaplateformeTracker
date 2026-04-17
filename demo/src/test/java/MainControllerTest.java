import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Student;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;

public class MainControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
            stage.toFront();
        } catch (Exception e) {
            System.out.println("FXML WON'T CHARGE" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testAlive() {
        System.out.println("Test is working");
    }

    @Test
    public void testClickOnAddButton() {

        clickOn("#addBtn");
        System.out.println("Test worked!");
    }

    @Test
    public void testClickOnModifyButton(){
        clickOn("#searchBtn");
        clickOn("#searchField").write("Albert");
    }

    @Test
    public void testStudentsNumber() {

        TableView<Student> table = lookup("#studentTable").query();
        int nombre = table.getItems().size();
        System.out.println("Total students" + nombre);
        assert(nombre == 3);
    }
}