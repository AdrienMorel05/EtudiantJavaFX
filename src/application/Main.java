package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Scene.fxml"));
			primaryStage.setTitle("Etudiant");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
//	TreeTableView<Etudiant> ttv = new TreeTableView<Etudiant>();
//	TreeTableColumn<Etudiant,String> colonneId= new TreeTableColumn<Etudiant, String>("ID");
//	TreeTableColumn<Etudiant,String> colonneNom= new TreeTableColumn<Etudiant, String>("Nom");
//	TreeTableColumn<Etudiant,String> colonnePrenom= new TreeTableColumn<Etudiant, String>("Prénom");
//	TreeTableColumn<Etudiant,String> colonneDate= new TreeTableColumn<Etudiant, String>("Date de naissance");
//	TreeTableColumn<Etudiant,String> colonneNote= new TreeTableColumn<Etudiant, String>("Note");
//
//	colonneId.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("Id"));
//	colonneNom.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("Nom"));
//	colonnePrenom.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("Prénom"));
//	colonneDate.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("Date"));
//	colonneNote.setCellValueFactory(new TreeItemPropertyValueFactory<Etudiant, String>("Note"));
//
//	
//	ttv.getColumns().addAll(colonneId,colonneNom,colonnePrenom,colonneDate,colonneNote);
//
//	
//	
//	Etudiant etud1= new Etudiant("Adrien", "prénom", "naissance");
//	TreeItem<Etudiant> ligneetud1 = new TreeItem<Etudiant>(etud1);
//	//ttv.set(ligneetud1);
//	
//	
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
