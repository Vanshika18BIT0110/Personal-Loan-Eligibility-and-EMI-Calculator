package vans;
import javafx.collections.*;
import javafx.application.Application; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup;  
import javafx.scene.control.ToggleButton; 
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 




public class jk extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		VBox root=new VBox(5);
		root.setPadding(new Insets(5));
		MenuBar menubar=new MenuBar();
		Menu menu=new Menu("Help");
		MenuItem m1 = new MenuItem("Get Loan/Contact Us"); 
        MenuItem m2 = new MenuItem("About Us"); 
        
        
        menubar.getMenus().addAll(menu);
        menu.getItems().add(m1); 
        menu.getItems().add(m2); 
        
        Label label2 = new Label(""); 
     

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() 
        { 
        	public void handle(ActionEvent e) 
        	{ 
        		label2.setText("For a loan contact us on 9650335010 (Vanshika Singh)"
        				+ " or mail us on vanshikasingh2803@gmail.com");
        	} 
        }; 
        m1.setOnAction(event1);
        
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() 
        { 
        	public void handle(ActionEvent e) 
        	{ 
        		label2.setText("This is an application created by Vanshika Singh for Checking personal loan eligibility and calculating EMI"); 
        	} 
        }; 
        m2.setOnAction(event2);
        
		Text name=new Text("Name");
		TextField name_text = new TextField();
		
		//DatePicker for entering date of birth
		Text dob=new Text("Date of Birth");
		DatePicker dob_text= new DatePicker();
		
		//Radio Button for selecting gender
		Text gender= new Text("Gender");     
	    ToggleGroup group_Gender= new ToggleGroup(); 
	    RadioButton male= new RadioButton("Male"); 
	    male.setToggleGroup(group_Gender); 
	    RadioButton female = new RadioButton("Female"); 
	    female.setToggleGroup(group_Gender);
	    RadioButton others = new RadioButton("Others"); 
	    others.setToggleGroup(group_Gender);
	    
	  //Toggle Button
	    Text citizen = new Text("Are you a citizen of India?");
	    ToggleButton citizen_toggle = new ToggleButton(); 
	    ToggleButton yes = new ToggleButton("Yes"); 
	    ToggleButton no = new ToggleButton("No"); 
	    ToggleGroup citizenin = new ToggleGroup(); 
	    yes.setToggleGroup(citizenin);
	    no.setToggleGroup(citizenin);

	    
	    
	    
	    //Monthly Income
	    Text mi=new Text("Monthly Income");
		TextField mi_text= new TextField();
		//Work Experience
		Text we=new Text("Work Experience");
		TextField we_text = new TextField();
		
		Text type = new Text("Type of Employment"); 
	    ChoiceBox type_drop = new ChoiceBox(); 
	    type_drop.getItems().addAll("Service", "Business Owner", "Self-Employed", "Retired");

		
		Text la=new Text("Loan Amount");
		TextField la_text = new TextField();
		
		// Interest per month 
       
        Text interest=new Text("Interest per month");
		TextField interest_text = new TextField();
  	
		
		Text time=new Text("Total Number of Months");
		TextField time_text = new TextField();
	    
		Button btn= new Button("Check Eligibility");
		Button btn2=new Button("EMI Calculator");
		Button btn1= new Button("Reset");
		
		Label label = new Label("");
		Label label1=new Label("");
		
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(500, 500); 
		gridPane.setPadding(new Insets(10, 10, 10, 10));  
		gridPane.setVgap(5); 
		gridPane.setHgap(5);
		//gridPane.setAlignment(Pos.CENTER);
		
		gridPane.add(name, 0, 0);
		gridPane.add(name_text, 1, 0);
		
		gridPane.add(dob, 0, 1);
		gridPane.add(dob_text, 1, 1);
		
		gridPane.add(gender, 0, 2);
		gridPane.add(male, 1, 2);
		gridPane.add(female, 2, 2);
		gridPane.add(others,3,2);
		
		
		gridPane.add(citizen, 0, 3);
		gridPane.add(yes, 1, 3);
		gridPane.add(no, 2, 3);
		
		gridPane.add(type, 0, 4);
		gridPane.add(type_drop, 1, 4);

		
		gridPane.add(mi, 0, 5);
		gridPane.add(mi_text, 1, 5);
		
		gridPane.add(we, 0, 6);
		gridPane.add(we_text, 1, 6);
		
		gridPane.add(la, 0, 8);
		gridPane.add(la_text, 1, 8);
		
		gridPane.add(interest, 0, 9);
		gridPane.add(interest_text, 1, 9);
		
		gridPane.add(time, 0, 10);
		gridPane.add(time_text, 1, 10);
		
		gridPane.add(btn, 0, 11);
		gridPane.add(btn2, 1, 11);
		gridPane.add(btn1, 2, 11);
		gridPane.add(label, 0, 13);
		gridPane.add(label1, 0, 14);
		gridPane.add(label2, 0, 15);
		
		
		EventHandler<MouseEvent> handler=new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event) {
				if(event.getSource()==btn)
				{

				 
				    boolean a=no.isSelected();
				    
				    double income=Double.parseDouble(mi_text.getText());
				    int exp=Integer.parseInt(we_text.getText());
					if(a || income<25000 || exp<3)
					{
						label.setText("Not eligible for a Personal Loan.");
					}
					else 
					{
						
						label.setText("Eligible for Personal Loan.");
					}
				}
				
				if(event.getSource()==btn2)
				{
					
				    
				    boolean a=no.isSelected();
				    
				    double income=Double.parseDouble(mi_text.getText());
				    double exp=Double.parseDouble(we_text.getText());
				    
					if(a || income<25000 || exp<3)
					{
						label.setText("Not eligible for a Personal Loan.");
					}
					else 
					{
						label.setText("Eligible for Personal Loan and Monthly EMI is:");
						int loan=Integer.valueOf(la_text.getText());
						int rate=Integer.valueOf(interest_text.getText());
						int time=Integer.valueOf(time_text.getText());
						//emi calculation formula=EMI = P × r × (1 + r)n/((1 + r)n - 1) where P= Loan amount, r= interest rate, n=tenure in number of months.
						int p=loan*rate/100*(1+rate/100)*time/((1+rate/100)*(time-1));
						label1.setText(Integer.toString(p));
					}
				}
				if(event.getSource()==btn1)
				{
					label.setText("");
					label2.setText("");
					label1.setText("");
					name_text.clear();
					mi_text.clear();
					interest_text.clear();
					time_text.clear();
					we_text.clear();
					la_text.clear();
					dob_text.getEditor().clear();
					male.setSelected(false);
				    female.setSelected(false);
				    others.setSelected(false);
				    yes.setSelected(false);
				    no.setSelected(false);
				}
				
			}
			
		};
		
		btn.setOnMouseClicked(handler);
		btn2.setOnMouseClicked(handler);
	    btn1.setOnMouseClicked(handler); 
		
	    root.getChildren().addAll(menubar,gridPane);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Personal Loan Eligibility and EMI Calculator");
		
		
        primaryStage.setScene(scene);
		primaryStage.show();
	}

}
