package com.assignment.cryptocurrency.UIController;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
//import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import javafx.fxml.*;

public class RegisterController implements Initializable
{
	//-----------------------------------------------------------------------------------------
	@FXML private Button registerNewUserAction;
	@FXML private Button loginAction;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField passwordConfirm;
	@FXML private Text registerNoticeText;
	@FXML private TextField email;
	@FXML private TextField tel;
	//@FXML private TextField username;
	//@FXML private TextField username;
	
	@FXML private TextField tfInviterCode;
	
	//-----------------------------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		registerNewUserAction.setOnAction(e ->
		{
			if (!password.getText().equals(passwordConfirm.getText())) {
				registerNoticeText.setText("Please confirm your password");
			} else {
				sendRegisterFormDataToServer(e);
//				hideCurrentWindow();
				//showLoginWindow();
			}
		});
		
		loginAction.setOnAction(e ->
		{
			//sendRegisterFormDataToServer(e);
		    //hideCurrentWindow();
		    showLoginWindow();
		});
	}
	//-----------------------------------------------------------------------------------------
	void sendRegisterFormDataToServer(ActionEvent e)
	{
		CloseableHttpClient httpClient=null;
		try 
		{
			String randString=String.valueOf(new Random().nextInt(8000));
//			username.setText("username"+randString);
//			password.setText("password"+randString);
//			email.setText("a"+randString+"@b"+randString+".com");
//			tel.setText("555-"+randString);
			JSONObject json = new JSONObject();
			json.put("username", username.getText());
			json.put("password", password.getText());
			json.put("last_name", username.getText());
			json.put("first_name", username.getText());
			json.put("email", email.getText());
			json.put("mobile", tel.getText());
			String inviteCode=tfInviterCode.getText();
			/*if (inviteCode!=null)
				json.put("inviteCode", inviteCode);
			*/
			httpClient = HttpClientBuilder.create().build();
		    HttpPost request = new HttpPost("http://localhost:8080/api/Users?inviteCode="+inviteCode);
		    StringEntity params = new StringEntity(json.toString());
		    
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse  response = httpClient.execute(request);
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	hideCurrentWindow();
			    showLoginWindow();
		    }
		    else
		    {
					registerNoticeText.setText("Something went wrong");
		    }
		} 
		catch (Exception ex) 
		{
			registerNoticeText.setText(ex.getMessage());
		} 
		finally 
		{
			try 
			{
				if (httpClient!=null)
					httpClient.close();
			} 
			catch (IOException e1) 
			{
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------
	void showLoginWindow()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("../UIView/login.fxml"));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		 Stage stage = (Stage) registerNewUserAction.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
	};
	//-----------------------------------------------------------------------------------------
	void hideCurrentWindow()
	{
		Stage stage= (Stage) registerNewUserAction.getScene().getWindow();
		if (stage!=null)
			stage.hide();
	}
	//-----------------------------------------------------------------------------------------
}




