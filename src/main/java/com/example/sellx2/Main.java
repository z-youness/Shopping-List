package com.example.sellx2;
	
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.TableView;



public class Main extends Application {
	int numOfItems;
    Item[] items;
    
	@SuppressWarnings("unused")
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
		        
		        
		        Text text = new Text("Name");
		        text.minWidth(220);

		        

			    
			   	TextField textField = new TextField("");
		        textField.setMinWidth(220);
		        
		        TextField textField1 = new TextField("");
		        textField1.setMinWidth(220);
		        
		        Text text1 = new Text("Priority");
		        text1.minWidth(220);
		        
		        TextField textField2 = new TextField("");
		        textField2.setMinWidth(220);
		        
		       
		        Text text2 = new Text("Qte");
		        text2.minWidth(220);
		        
		        TextField textField3 = new TextField("");
		        textField3.setMinWidth(220);
		        
		        Text text3 = new Text("Price");
		        text3.minWidth(220);
		        
		        FlowPane root = new FlowPane();
		        
		        

		        Button buttonSubmit = new Button("Submit");
		        Button buttonList = new Button("Shopping List");
		        

		        ArrayList<Items> items = new ArrayList<>();
		        
		       buttonList.setOnAction(e -> {
		    	   
			    //    root.getChildren().clear();
			        
			        
			        int lines = 0;
		            
		            BufferedReader reader;
					try {
						reader = new BufferedReader(new FileReader("myfile.txt"));
						
						  
				            while (reader.readLine() != null) lines++;
				            reader.close();
				            
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          
		            
		            String[][] data = new String[lines][4];
		            
		            
		             int i = 0;
		            try {

		            File Obj = new File("myfile.txt");
		            Scanner Reader;
									Reader = new Scanner(Obj);
					
		            while (Reader.hasNextLine()) {
		                String d = Reader.nextLine();
		                
		                
		                
		                String[] arrOfStr = d.split(" ");
		                
		                Items it = 
		                		new Items(arrOfStr[0],arrOfStr[1],arrOfStr[2],arrOfStr[3]);
		                
		                
		                items.add(it);
		                
		                data[i] = arrOfStr;
		                
		                i++;
		                
		                
		                
		                
		                
		                
		            }
		            Reader.close();
		            
		            } 
		            
		            
		            catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            



		    	   
		    	 
		    	      TableView<Items> table =  new TableView<>();
		    	      
		    	      TableColumn Name
		    	      = new TableColumn("Name");
		    	      Name.setMinWidth(100);
		    	      Name.setCellValueFactory(
		    	                new PropertyValueFactory<>("Name"));

		    	      TableColumn Priority
		    	      = new TableColumn("Priority");
		    	      
		    	      Priority.setMinWidth(100);
		    	      Priority.setCellValueFactory(
		    	                new PropertyValueFactory<>("Priority"));

		    	      
		    	      TableColumn Qte
		    	      = new TableColumn("Qte");
		    	      
		    	      Qte.setMinWidth(100);
		    	      Qte.setCellValueFactory(
		    	                new PropertyValueFactory<>("Qte"));
		    	      
		    	      TableColumn Price 
		    	      = new TableColumn("Price");
		    	      
		    	      Price.setMinWidth(100);
		    	      Price.setCellValueFactory(
		    	                new PropertyValueFactory<>("Price"));

		    	      ObservableList<Items>  dataList;

			            dataList = FXCollections.observableList(items);

		    	      
		    	      table.setItems(dataList);
		    	      
		    	      table.getColumns().addAll(Name,Priority,Qte,Price);
		    	      
				      
		    	      
		    	      //root.getChildren().add(table);
		    	      
		    	      TextField budget = new TextField("");
		    	      budget.setMinWidth(220);
				        
				        Text budgetText = new Text("budget");
				        budgetText.minWidth(220);
				        				        
				       
				        Button buttonBudget = new Button("Submit");
				        
				        
			    	      FlowPane root2 = new FlowPane();

			    	      root2.getChildren().add(budgetText);
			    	      root2.getChildren().add(budget);
			    	      root2.getChildren().add(buttonBudget);
			    	      

			    	      
			    	      root2.getChildren().add(table);
			    	      
			    	   

				    	      
				    	      
						        
				    	        Scene scene2 = new Scene(root2, 600, 400);
				    	        Stage stage2 = new Stage();
				    	        stage2.setTitle("Shopping List");
				    	        stage2.setScene(scene2);
				    	        stage2.show();
				    	      

			    	      
			    	      buttonBudget.setOnAction(e1 -> {
			    	    	  
			    	        	int B = Integer.parseInt(budget.getText().toString());

			    	        	
			    	        	ArrayList<Item> itemsBuy = new ArrayList<>();
			    	        	
			    	        	ArrayList<Item> restItems = new ArrayList<>();

			    	        	
			    	        	try {

			    	        		
			    	        		ArrayList<Item> list = new ArrayList<>();
			    	        		
			    	        		
			    	                File Obj = new File("myfile.txt");
			    	                Scanner Reader;
			    	    							Reader = new Scanner(Obj);
			    	    			
			    	                while (Reader.hasNextLine()) {
			    	                    String d = Reader.nextLine();
			    	                    
			    	                    
			    	                    
			    	                    String[] arrOfStr = d.split(" ");
			    	                    
			    	                    Item ite = new Item(arrOfStr[0],
			    	                    		Integer.parseInt(arrOfStr[1]),
			    	                    		Integer.parseInt(arrOfStr[2]),
			    	                    		Integer.parseInt(arrOfStr[3]));
			    	                    
			    	                    list.add(ite);
			    	                    
			    	                    
			    	                    
			    	                    
			    	                    
			    	                }
			    	                Collections.sort(list);
			    	                
			    	            	itemsBuy = new ArrayList<>();

			    	                
			    	                for (Item it : list) {
			    	                	
			    	                	
			    	                	System.out.println(it.Price);
			    	                	
			    	                	System.out.println(B);

			    	                	
			    	                	if(B >= (it.Price*it.Qte)) {
			    	                		
			    	                		B -= (it.Price*it.Qte);
			    	                		
			    	                		itemsBuy.add(it);
			    	                		
			    	                        System.out.println("Size"+itemsBuy.size());

			    	                		
			    	                		
			    	                	}
			    	                	else {
			    	                		
			    	                		restItems.add(it);
			    	                	}
			    	                	
			    	              
			    	                	
			    	                }
			    	                
			    	                
			    	                try {
			    	                    FileWriter myWriter = new FileWriter("myfile.txt");
			    	                    
			    	                    
			    	                    for (Item it : restItems) {
			    	                    	
			    	                    	
			    	                    	myWriter.write(it.Name + " " +
			    	                                String.valueOf(it.Priority) + " " + 
			    	                                String.valueOf(it.Qte) +" " + 
			    	                                String.valueOf(it.Price)+ "\n");
			    	                    	

			    	                    	
			    	                    	
			    	                    }
			    	                    myWriter.close();

			    	                  } catch (IOException e3) {
			    	                    System.out.println("An error occurred.");
			    	                    e3.printStackTrace();
			    	                  }
			    	                
			    			   ArrayList<Items> itemsBuys = new ArrayList<>();

			    	                
			    			   for (Item it : itemsBuy) {
			                   	
			                   	Items itemss =  new Items(it.Name,
			                   			String.valueOf(it.Priority),
			                   			String.valueOf(it.Qte),
			                   			String.valueOf(it.Price));
			                   	
			                   	itemsBuys.add(itemss);
			                  
			                   	
			                   	
			                   }
			    	        	
			    			   
			    			   
			    			   //root.getChildren().clear();
			    			   
					    	      ObservableList<Items>  dataaList;

						            dataaList = FXCollections.observableList(itemsBuys);

					    	      
						            
					    	      table.setItems(dataaList);
					    	      
					    	      //table.getColumns().addAll(Name,Priority,Qte,Price);
					    	      
							        FlowPane root1 = new FlowPane();

					    	      
					    	      root1.getChildren().add(table);
					    	      
					    	   

						    	      
						    	      
								        
						    	        Scene scene = new Scene(root1, 600, 400);
						    	        Stage stage = new Stage();
						    	        stage.setTitle("Buying List");
						    	        stage.setScene(scene);
						    	        stage.show();
						    	      
						    	      
						    	     
			    			   
			    	                
			    	                
			    	                Reader.close();
			    	                
			    	                } 
			    	                
			    	                
			    	                catch (FileNotFoundException e2) {
			    	    				// TODO Auto-generated catch block
			    	    				e2.printStackTrace();
			    	    			}
			    	        	
			    	    	  
			    	    	  
			    	    	  
			    	      });


		    	      

		       });
		        
		        buttonSubmit.setOnAction(e -> {
		        	
		        	
		        	
		        	boolean Existe = false;
	            	
	            	
		           	 try {
		                    File Obj = new File("myfile.txt");
		                    Scanner Reader = new Scanner(Obj);
		                    while (Reader.hasNextLine()) {
		                        String data = Reader.nextLine();
		                        
		                        String[] arrOfStr = data.split(" ");
		                        
		                        if(textField.getText().toString().equals(arrOfStr[0])) {
		                       	 
		                       	 Existe = true;
		                        }
		                        
		                        
		                        
		                    }
		                    Reader.close();
		                    
		                    if(!Existe) {
		                    
		                   	 try {
		                   		 
		                            // Open given file in append mode by creating an
		                            // object of BufferedWriter class
		                            BufferedWriter out = new BufferedWriter(
		                                new FileWriter("myfile.txt", true));
		                 
		                            out.write(textField.getText().toString() + " " +
		                            		textField1.getText().toString() + " " + 
		                            		textField2.getText().toString()+" " + 
		                            		textField3.getText().toString()+ "\n");

		                            out.close();
		                            
		                            Dialog<String> dialog = new Dialog<String>();
		                            //Setting the title
		                            dialog.setTitle("Dialog");
		                            ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		                            //Setting the content of the dialog
		                            dialog.setContentText("Your item is added");
		                            //Adding buttons to the dialog pane
		                            dialog.getDialogPane().getButtonTypes().add(type);
		        		            dialog.showAndWait();


		                        }
		                 
		                        // Catch block to handle the exceptions
		                        catch (IOException e2) {
		                 
		                            // Display message when exception occurs
		                            System.out.println("exception occurred" + e2);
		                        }
		                    }
		                    else {
		                    	
		                    	Dialog<String> dialog = new Dialog<String>();
	                            //Setting the title
	                            dialog.setTitle("Dialog");
	                            ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
	                            //Setting the content of the dialog
	                            dialog.setContentText("Item already existe");
	                            //Adding buttons to the dialog pane
	                            dialog.getDialogPane().getButtonTypes().add(type);
	        		            dialog.showAndWait();
		                   	 

		                   	 
		                    }
		                }
		           	 
		                catch (FileNotFoundException e1) {
		                    System.out.println("An error has occurred.");
		                    e1.printStackTrace();
		                } 
		         });

		      
		        
		        
		        root.setPadding(new Insets(10));
		        root.getChildren().add(text);
		        root.getChildren().add(textField);
		        root.getChildren().add(text1);
		        root.getChildren().add(textField1);
		        root.getChildren().add(text2);
		        root.getChildren().add(textField2);
		        root.getChildren().add(text3);
		        root.getChildren().add(textField3);
		        root.getChildren().add(buttonSubmit);
		        root.getChildren().add(buttonList);

		        Scene scene = new Scene(root, 250, 400);

		        primaryStage.setTitle("Shopping");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public class Items {
		
		StringProperty Name,Priority,Qte,Price;
		
		
		public Items (String n , String p , String q , String pr){
			
			Name =  new SimpleStringProperty(n);
			Priority =  new SimpleStringProperty(p);
			Qte =  new SimpleStringProperty(q);
			Price =  new SimpleStringProperty(pr);
			
			
		}
		
		public String getName() {
			return Name.get();
		}
		
		public String getPriority() {
			return Priority.get();
		}
		
		public String getQte() {
			return Qte.get();
		}
		
		public String getPrice() {
			return Price.get();
		}
		
		
		public void setName(String n) {
			
			
            Name.set(n);

			
		}

	}

}



