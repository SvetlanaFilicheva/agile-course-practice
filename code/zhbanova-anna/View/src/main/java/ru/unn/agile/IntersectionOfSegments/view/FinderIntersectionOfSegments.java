package ru.unn.agile.IntersectionOfSegments.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.agile.IntersectionOfSegments.viewmodel.ViewModel;

public class FinderIntersectionOfSegments {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtSeg1Point1X;
    @FXML
    private TextField txtSeg1Point1Y;
    @FXML
    private TextField txtSeg1Point2X;
    @FXML
    private TextField txtSeg1Point2Y;
    @FXML
    private TextField txtSeg2Point1X;
    @FXML
    private TextField txtSeg2Point1Y;
    @FXML
    private TextField txtSeg2Point2X;
    @FXML
    private TextField txtSeg2Point2Y;
    @FXML
    private Button btnFind;

    @FXML
    void initialize() {
        txtSeg1Point1X.textProperty().bindBidirectional(viewModel.seg1Point1XProperty());
        txtSeg1Point1Y.textProperty().bindBidirectional(viewModel.seg1Point1YProperty());
        txtSeg1Point2X.textProperty().bindBidirectional(viewModel.seg1Point2XProperty());
        txtSeg1Point2Y.textProperty().bindBidirectional(viewModel.seg1Point2YProperty());
        txtSeg2Point1X.textProperty().bindBidirectional(viewModel.seg2Point1XProperty());
        txtSeg2Point1Y.textProperty().bindBidirectional(viewModel.seg2Point1YProperty());
        txtSeg2Point2X.textProperty().bindBidirectional(viewModel.seg2Point2XProperty());
        txtSeg2Point2Y.textProperty().bindBidirectional(viewModel.seg2Point2YProperty());

        btnFind.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.calculate();
            }
        });
    }
}
