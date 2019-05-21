package arraysortfx;

import java.util.Arrays;      // для использования встроенной сортировки
import java.util.Collections; // для обратной сортировки reverseOrder()
import java.util.Random;      // для генерации случайных чисел
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;      // радиокнопки
import javafx.scene.control.ToggleGroup; // группа радиокнопок
import javafx.scene.control.Label;       // текстовое поле (метка)
import javafx.scene.control.TextField;   // поле ввода 
import javafx.scene.control.RadioButton; // радио-кнопки 

public class FXMLDocumentController implements Initializable {
    
    @FXML                 
    private Label label1; // добавлял руками, как и методы, поскольку не знал, что  
/* На самом деле объявления всех элементов, операторов import для них и методов обработчиков из Scene Builder 
   можно добавить в одно действие: на файле FXML в NetBeans нажать правую кнопку мыши,
   затем выбираем "Установить контроллер" 
   (почему не делается автоматически после сохранения в Scene Builder - пока не знаю)
   (будет ли работать обратное, если создать все элементы руками в контроллере -
    и они появятся в Scene Builder - тоже вопрос)
    Хотя можно конечно вообще все писать руками ;-), как в книге Машнина Т.
*/
    @FXML                 // одной директивы недостаточно - перед каждым элементом из FXML файла такая директива
    private Label label2; 
    @FXML
    private TextField edit1; // размер под двузначное число, больше - не уместитьтся вывод на экране
    @FXML
    private RadioButton RadioButton1;
    @FXML
    private RadioButton RadioButton2;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private ToggleGroup SortOrder;
    
    Integer m[]; // объявляем пустой массив
    Random r=new Random(); // создаем класс для генерации случайных чисел
    
    @FXML
    private void handleButton1Action(ActionEvent event) { 
        String s=edit1.getText(); // введенный размер (текст)
        if (s.isEmpty()) return;  // если строка пуста - выход
        int n=Integer.parseInt(s); // размерность массива, введенная в поле edit1
        m=new Integer[n]; // создаем массив размерности n
        for (int i=0; i<n; i++)  // заполняем массив случайными числами
            m[i]=r.nextInt(100); // случайное целое от 0 до 100
        label1.setText(Arrays.toString(m)); // вывод исходного массива в тестовую метку label1
        button2.setDisable(false); // активизируем кнопку сортировки - массив есть !!!
    }
    
    @FXML
    private void handleButton2Action(ActionEvent event) { 
        if (RadioButton1.isSelected()) // кнопка RadioButton1 выбрана (отмечена)
            Arrays.sort(m); // сортируем массив m по возрастанию
        else // состояние кнопки RadioButton2 не проверяем, т.к. они противоположны по значению (объединены в ToggleGroup)
            Arrays.sort(m, Collections.reverseOrder()); // по убыванию
        label2.setText(Arrays.toString(m)); // вывод результируещего массива в тестовую метку label2
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
