package application;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private AnchorPane pane;
	private TextField text;
	private PasswordField senha;
	private Button entrar;
	private Button sair;
	private static Stage stage;

	private void inicializaComponentes() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		text = new TextField();
		text.setPromptText("Digite aqui seu login");
		senha = new PasswordField();
		senha.setPromptText("Digite aqui sua senha");
		entrar = new Button("Entrar");
		entrar.setOnAction(e -> logar());
		sair = new Button("Sair");
		sair.setOnAction(e -> sair());
		pane.getChildren().addAll(text, senha, entrar, sair);

	}

	private void posicionaElementos() {
		text.setLayoutX((pane.getWidth() - text.getWidth()) / 2);
		text.setLayoutY(50);
		senha.setLayoutX((pane.getWidth() - senha.getWidth()) / 2);
		senha.setLayoutY(100);
		entrar.setLayoutX((pane.getWidth() - entrar.getWidth()) / 2);
		entrar.setLayoutY(150);
		sair.setLayoutX((pane.getWidth() - sair.getWidth()) / 2);
		sair.setLayoutY(200);

	}

	private void sair() {
		System.exit(0);
	}

	private void logar() {
		if ("123456".equals(senha.getText()) && "alunos".equals(text.getText())) {
			JOptionPane.showMessageDialog(null, "usuario valido", "login", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "Usuario invalido", "Login", JOptionPane.ERROR_MESSAGE);

		}
	}

	@Override

	// iniica a construção de tela
	public void start(Stage stage) throws Exception {

		LoginApp.stage = stage;

		inicializaComponentes();

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		posicionaElementos();

		// faz com a janela feche no java 8
		sair.setOnAction(e -> System.exit(0));

		// faz com q o botão sair feche a janela no java 7
		// sair.setOnAction(new EventHandler<ActionEvent>() {

		// @Override
		// public void handle(ActionEvent event) {
		// System.exit(0);

		// }
		// });

	}

	public static void main(String[] args) {
		launch(args);
	}

}
