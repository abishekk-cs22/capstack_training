package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataManipulation {

	public DataManipulation() {
		
	}

	String hostname = "localhost";
	int port = 3306;
	String databaseName = "bank_management";
	String dbUsername = "root";
	String dbPassword = "mysql";
	
	public void readDataFromDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);

			//String query = "SELECT * FROM transaction";
			String query = "SELECT transaction.id, transaction.description, transaction.amount, transaction_modes.name as 'transaction_mode' FROM bank_management.transaction, bank_management.transaction_modes WHERE transaction.transaction_mode_id = transaction_modes.id";			
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			int totalRecords = 0;
			while(resultSet.next()) {
				System.out.println("Id: " + resultSet.getInt("id"));
				System.out.println("Description:" + resultSet.getString("description"));
				System.out.println("Amount: " + resultSet.getString("amount"));
				System.out.println("Transaction mode: " + resultSet.getString("transaction_mode"));
				totalRecords++;
			}
			
			if(totalRecords>0) {
				System.out.println("Total Records: "+ totalRecords);
			} else {
				System.out.println("No Records found");
			}
			
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
				}
			}
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
					resultSet = null;
				}
			}			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
					resultSet = null;
				}
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}

	public void insertDataIntoDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			//String query = "SELECT * FROM students";
			String query = "INSERT INTO `transaction`(`id`,`description`,`amount`,`transaction_mode_id`) VALUES ( 104007, 'na', '1500', 3)";			
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}	

	public void updateDataToDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			String query = "UPDATE `transaction` SET `transaction_mode_id` = 2 WHERE id = 104004";
			/* String query = "UPDATE `students` SET `gender_id` = 2"; */
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}	

	public void deleteDataFromDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			//String query = "SELECT * FROM students";
			String query = "DELETE FROM transaction";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}
	
}
