package datasensorfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDateTime;

public class MainViewController {

    @FXML
    private TextField suhuField;

    @FXML
    private TextField kelembapanField;

    @FXML
    private TextField gasField;

    @FXML
    private TableView<SensorData> tableView;

    @FXML
    private TableColumn<SensorData, LocalDateTime> waktuCol;

    @FXML
    private TableColumn<SensorData, Double> suhuCol;

    @FXML
    private TableColumn<SensorData, Double> kelembapanCol;

    @FXML
    private TableColumn<SensorData, Double> gasCol;

    private ObservableList<SensorData> dataList;

    @FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();

        waktuCol.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        suhuCol.setCellValueFactory(new PropertyValueFactory<>("suhu"));
        kelembapanCol.setCellValueFactory(new PropertyValueFactory<>("kelembapan"));
        gasCol.setCellValueFactory(new PropertyValueFactory<>("gas"));

        tableView.setItems(dataList);
    }

    @FXML
    private void handleAdd() {
        try {
            double suhu = Double.parseDouble(suhuField.getText());
            double kelembapan = Double.parseDouble(kelembapanField.getText());
            double gas = Double.parseDouble(gasField.getText());

            dataList.add(new SensorData(LocalDateTime.now(), suhu, kelembapan, gas));
            clearForm();
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Pastikan semua nilai angka diisi dengan benar!");
        }
    }

    @FXML
    private void handleDelete() {
        SensorData selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            dataList.remove(selected);
        } else {
            showAlert("Pilih Data", "Pilih data yang ingin dihapus dari tabel.");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    private void clearForm() {
        suhuField.clear();
        kelembapanField.clear();
        gasField.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
