package fr.formation.afp.treetable;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.formation.afp.EtudiantService.EtudiantService;
import fr.formation.afp.EtudiantService.IEtudiantService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class ControllerTableView implements Initializable {
	@FXML
	private AnchorPane mainPane;
	@FXML
	private Menu menuFichier;
	@FXML
	private MenuItem menuClose;
	@FXML
	private MenuItem menuAjout;
	@FXML
	private MenuItem itemajouteretudiant;
	@FXML
	private MenuItem itemlisteetudiant;
	@FXML
	private MenuItem itemmodedempoi;
	@FXML
	private Button boutonajout;
	@FXML
	private Button boutonsuppEtudiant;
	@FXML
	private Button boutonafficheEtudiant;
	@FXML
	private Button boutonModEtudiant;
	@FXML
	private Button bouttonquitter;
	@FXML
	private ScrollPane scrollTable;
	@FXML
	private TableView<Etudiant> tableEtudiant;
	@FXML
	private TableColumn<Etudiant, Integer> colonneid;
	@FXML
	private TableColumn<Etudiant, String> colonnenom;
	@FXML
	private TableColumn<Etudiant, String> colonneprenom;
	@FXML
	private TableColumn<Etudiant, String> colonnedate;
	@FXML
	private TableColumn<Etudiant, String> colonnenote;
	@FXML
	private TextField textfieldrecherche;

	IEtudiantService ies = new EtudiantService();

	Etudiant etudiantselection;

	static Etudiant myVariable;

	public void initialize(URL location, ResourceBundle resources) {

	}

	public void itemclose(ActionEvent e) {
		Alert alertsupp = new Alert(AlertType.CONFIRMATION);
		alertsupp.setTitle("Nous quitter?");
		alertsupp.setHeaderText("Souhaitez-vous quitter logiEtudiant?");
		alertsupp.setContentText("");
		Optional<ButtonType> option = alertsupp.showAndWait();
		if (option.get() == ButtonType.OK) {
			System.exit(0);
		} else if (option.get() == ButtonType.CANCEL) {
			return;
		}
		
	}

	public void itemajouteretudiant(ActionEvent e) {
		AnchorPane fxmlLoader = null;
		try {
			fxmlLoader = FXMLLoader.load(getClass().getResource("Fenetre2.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		mainPane.getChildren().setAll(fxmlLoader);

	}

	public void afficheEtudiant(ActionEvent e) {
		List<Etudiant> etudiants = ies.listEtudiant();

		ObservableList<Etudiant> list = FXCollections.observableArrayList(etudiants);

		FilteredList<Etudiant> rechercheFiltre = new FilteredList<>(list, p -> true);

		textfieldrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			rechercheFiltre.setPredicate(etudiant -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if (etudiant.getNom().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (etudiant.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (etudiant.getNaissance().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Etudiant> sortedlist = new SortedList<>(rechercheFiltre);
		sortedlist.comparatorProperty().bind(tableEtudiant.comparatorProperty());
		tableEtudiant.setItems(sortedlist);

		colonneid.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
		colonnenom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colonneprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		colonnedate.setCellValueFactory(new PropertyValueFactory<>("naissance"));
		colonnenote.setCellValueFactory(new PropertyValueFactory<>("note"));
		// List<Etudiant> etudiants = ies.listEtudiant();
		// ObservableList<Etudiant> list = FXCollections.observableArrayList(etudiants);
		tableEtudiant.setItems(sortedlist);

	}

	public void addButtonToTable() {
		TableColumn<Etudiant, Void> colBtn = new TableColumn("Supprimer");

		Callback<TableColumn<Etudiant, Void>, TableCell<Etudiant, Void>> cellFactory = new Callback<TableColumn<Etudiant, Void>, TableCell<Etudiant, Void>>() {
			@Override
			public TableCell<Etudiant, Void> call(final TableColumn<Etudiant, Void> param) {
				final TableCell<Etudiant, Void> cell = new TableCell<Etudiant, Void>() {

					private final Button btn = new Button("Supprimer");

					{
						btn.setOnAction((ActionEvent event) -> {
							Etudiant data = getTableView().getItems().get(getIndex());
							long idsupp = data.getIdEtudiant();
							ies.supprimeUnEtudiant(idsupp);
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

		tableEtudiant.getColumns().add(colBtn);

	}

	public void modifierEtudiant(ActionEvent e) {

		Etudiant etudiantselection = (Etudiant) tableEtudiant.getSelectionModel().getSelectedItem();
		System.out.println(etudiantselection);
		setMyVariable(etudiantselection);
		AnchorPane fxmlLoader = null;
		try {
			fxmlLoader = FXMLLoader.load(getClass().getResource("Fenetre3.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		mainPane.getChildren().setAll(fxmlLoader);

	}

	public void supprimerEtudiant(ActionEvent e) {
		Etudiant etudiantselection = (Etudiant) tableEtudiant.getSelectionModel().getSelectedItem();
		long idsupp = etudiantselection.getIdEtudiant();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Suppression");
		alert.setHeaderText("Souhaitez-vous vraiment supprimer cet étudiant?");
		alert.setContentText("");
		Optional<ButtonType> option = alert.showAndWait();
		if (option.get() == ButtonType.OK) {
			ies.supprimeUnEtudiant(idsupp);
		} else if (option.get() == ButtonType.CANCEL) {
			return;
		}

	}

	public void itemmodedemploi(ActionEvent e) {
		System.out.println("Voici comment fonctionne le logiciel");
	}

	public void rechercheDynamique() {

	}

	public static void setMyVariable(Etudiant myVariable) {
		ControllerTableView.myVariable = myVariable;
	}

	public static Etudiant getMyVariable() {
		return myVariable;
	}

}
//	public void itemlisteetudiant(ActionEvent e) {
//		Etudiant etudiant = new Etudiant(1, "Adrien", "Morel", "05/05/1992");
//		Etudiant etudiant2 = new Etudiant(2, "Pikachu", "Pokemon", "01/01/1997");
//		Etudiant etudiant3 = new Etudiant(3, "Batman", "Best SuperHero", "I am Batman");
//
//		colonneid.setCellValueFactory(new PropertyValueFactory<>("id"));
//		colonnenom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//		colonneprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//		colonnedate.setCellValueFactory(new PropertyValueFactory<>("naissance"));
//		colonnenote.setCellValueFactory(new PropertyValueFactory<>("note"));
//
//		tableEtudiant.getItems().add(etudiant);
//		tableEtudiant.getItems().add(etudiant2);
//		tableEtudiant.getItems().add(etudiant3);

//}