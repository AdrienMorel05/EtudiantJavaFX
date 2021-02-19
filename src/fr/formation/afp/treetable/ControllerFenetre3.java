package fr.formation.afp.treetable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.formation.afp.EtudiantService.EtudiantService;
import fr.formation.afp.EtudiantService.IEtudiantService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class ControllerFenetre3 implements Initializable {
	@FXML
	private Button enregistrer;
	@FXML
	private Button annuler2;
	@FXML
	private Button browser;
	@FXML
	private AnchorPane fenetre3;
	@FXML
	private TextField InfoNom;
	@FXML
	private TextField InfoPrenom;
	@FXML
	private TextField InfoDate;
	@FXML
	private Label dateManquante;
	@FXML
	private Label pr�nomManquant;
	@FXML
	private Label nomManquant;
	@FXML
	private Label labelPhoto ;
	Etudiant etudiant;

	IEtudiantService ies = new EtudiantService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
ControllerTableView.getMyVariable().getid();
InfoNom.setText(ControllerTableView.getMyVariable().getNom());
InfoPrenom.setText(ControllerTableView.getMyVariable().getPrenom());
InfoDate.setText(ControllerTableView.getMyVariable().getNaissance());

	}

	public void annuler2(ActionEvent e) {
		AnchorPane fxmlLoader = null;
		try {
			fxmlLoader = FXMLLoader.load(getClass().getResource("SceneTableView.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		fenetre3.getChildren().setAll(fxmlLoader);
	}

	public void modifierEtudiant(ActionEvent e) {
		
	
		
		
		String nomRec = InfoNom.getText();
		String pr�nomRec = InfoPrenom.getText();
		String dateRec = InfoPrenom.getText();


		if (nomRec.isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Probl�me d'ajout ");
			alert.setHeaderText("Probl�me");
			alert.setContentText("Merci de rentrer un nom");
			alert.show();
			nomManquant.setVisible(true);
			return;
		} else if (pr�nomRec.isEmpty()) {
			Alert alert0 = new Alert(AlertType.INFORMATION);
			alert0.setTitle("Probl�me d'ajout ");
			alert0.setHeaderText("Probl�me");
			alert0.setContentText("Merci de rentrer un pr�nom");
			alert0.show();
			pr�nomManquant.setVisible(true);
			return;
		} else if (dateRec.isEmpty()) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Probl�me d'ajout ");
			alert1.setHeaderText("Probl�me");
			alert1.setContentText("Merci de rentrer une date de naissance");
			alert1.show();
			dateManquante.setVisible(true);
			return;
		} else {
			etudiant = new Etudiant(InfoNom.getText(), InfoPrenom.getText(), InfoDate.getText());
			ies.modifierEtudiant(etudiant);
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Succ�s de la modification ! ");
			alert2.setHeaderText("");
			alert2.setContentText("Etudiant Modifier avec Succ�s !");
			alert2.show();
			AnchorPane fxmlLoader = null;
			try {
				fxmlLoader = FXMLLoader.load(getClass().getResource("SceneTableView.fxml"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			fenetre3.getChildren().setAll(fxmlLoader);
		}
	}
}
