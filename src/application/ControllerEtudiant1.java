package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.RootPaneContainer;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ControllerEtudiant1 implements Initializable {
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
	private Button bouttonquitter;
	@FXML
	private ScrollPane scrollTable;
	@FXML
	private TreeTableView<Etudiant> tableEtudiant;
	@FXML
	private TreeTableColumn<Etudiant, Integer> colonneid;
	@FXML
	private TreeTableColumn<Etudiant, String> colonneNom;
	@FXML
	private TreeTableColumn<Etudiant, String> colonneprenom;
	@FXML
	private TreeTableColumn<Etudiant, String> colonnedate;
	@FXML
	private TreeTableColumn<Etudiant, String> colonnenote;

	public void initialize(URL location, ResourceBundle resources) {

	}

	public void itemclose(ActionEvent e) {
		System.exit(0);
	}

	public void itemajouteretudiant(ActionEvent e) {
		scrollTable.setVisible(true);
	}

	public void itemlisteetudiant(ActionEvent e) {
		scrollTable.setVisible(true);
		Etudiant etudiant = new Etudiant(1, "Adrien", "Morel", "05/05/1992");
		Etudiant etudiant2 = new Etudiant(2, "Pikachu", "Pokemon", "01/01/1997");
		Etudiant etudiant3 = new Etudiant(3, "Batman", "Best SuperHero", "I am Batman");
		TreeItem<Etudiant> itemroot = new TreeItem<Etudiant>(etudiant);
		TreeItem<Etudiant> item1 = new TreeItem<Etudiant>(etudiant2);
		TreeItem<Etudiant> item2 = new TreeItem<Etudiant>(etudiant3);
		itemroot.getChildren().add(item1);
		itemroot.getChildren().add(item2);
		tableEtudiant.setRoot(itemroot);
		colonneid.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, Integer>("id"));
		colonneNom.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("nom"));
		colonneprenom.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("prenom"));
		colonnedate.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("naissance"));

	}

	public void itemmodedemploi(ActionEvent e) {
		System.out.println("Voici comment fonctionne le logiciel");
	}

}