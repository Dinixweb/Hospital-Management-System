package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

public class sqlqueries {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public sqlqueries() {
		conn = dbconnection.getConnection();
	}

	public String Login(String StaffID, String Password) {
		String status = "invalid";
		String sql = "Select * from Users where StaffID =? and Password = ? ";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, StaffID);
			pst.setString(2, Password);
			//pst.setString(3, dept);
			rs = pst.executeQuery();

			if (rs.next()) {
				status = "valid";
			}

			//pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	
		return status;

	}
	
	public ResultSet checkDept() {
		String sql = "Select * from Users";
		try {
		pst= conn.prepareStatement(sql);
		rs = pst.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
		if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
	}
		return rs;
	}

	public void addDoctor(String[] doctor) {

		String sql = "INSERT INTO Doctors(StaffID, firstName, lastName, d_department, w_ward, s_session)VALUES(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, doctor[0]);
			pst.setString(2, doctor[1]);
			pst.setString(3, doctor[2]);
			pst.setString(4, doctor[3]);
			pst.setString(5, doctor[4]);
			pst.setString(6, doctor[5]);

			int x = pst.executeUpdate();
			if (x == 0) {

			} else {
				JOptionPane.showInternalMessageDialog(null, "Registration Successful");

			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			if (e.toString().contains("StaffID")) {
				JOptionPane.showInternalMessageDialog(null, "Doctor with staffID: " + doctor[1] + " already exist");
			}

			else {
				JOptionPane.showInternalMessageDialog(null, "An error ocurred why trying to add employe");
			}

		}

	}

	public ResultSet displayDoctor() {
		String sql = "Select * from Doctors";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;

	}
	
	public ResultSet displayPatient() {
		String sql = "Select * from Patient";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;

	}
	

	public ResultSet refreshSelect() {
		String sql = "Select DISTINCT StaffID, firstName, lastName, d_department, w_ward, s_session from Doctors";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;

	}

	public String myUser(String staffID) {
		String sql = "Select firsName from Users where StaffID= ?";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			pst.setString(1, staffID);
			
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return staffID;
		

	}
	
	
	public ResultSet dipslayPatients() {
		
		String sql = "Select * from Patient";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	
		return rs;
		
	}
	
	
	public ResultSet displayNewPayment() {
		
		String sql = "Select PatientID, paymentCode from Payment";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
		
	}
	public void addPatient(String[] patient) {

		String sql = "INSERT INTO Patient (patientID, firstName, lastName, dateOfBirth, maritalStatus, NumOfChildren, phoneNumber, email, nextOfKinName, nextOfKinPhone, nextOfKinEmail, date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, patient[0]);
			pst.setString(2, patient[1]);
			pst.setString(3, patient[2]);
			pst.setString(4, patient[3]);
			pst.setString(5, patient[4]);
			pst.setString(6, patient[5]);
			pst.setString(7, patient[6]);
			pst.setString(8, patient[7]);
			pst.setString(9, patient[8]);
			pst.setString(10, patient[9]);
			pst.setString(11, patient[10]);
			pst.setString(12, patient[11]);
			
			int x = pst.executeUpdate();
			if (x == 0) {
				JOptionPane.showInternalMessageDialog(null, "An error ocurred why trying to add a Patient");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Patient Successfully Added");

			}
			
		} catch (SQLException e) {
		}
		finally {
			//if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}

	}
	public void bookPatient(String[] bookPatient) {

		String sql = "INSERT INTO BookedData (patientID, firstName, lastName, dateOfBirth, maritalStatus, numOfChildren, paymentCode, lastDateVisit) VALUES(?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, bookPatient[0]);
			pst.setString(2, bookPatient[1]);
			pst.setString(3, bookPatient[2]);
			pst.setString(4, bookPatient[3]);
			pst.setString(5, bookPatient[4]);
			pst.setString(6, bookPatient[5]);
			pst.setString(7, bookPatient[6]);
			pst.setString(8, bookPatient[7]);

			pst.executeUpdate();
			//pst.close();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		finally {
			//if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	}
	public ResultSet displayBookedData() {
		
		String sql = "Select * from BookedData";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;
		
	}

	public ResultSet checkPayment() {
		
		String sql = "Select PatientID, paymentStatus from Payment_Status";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;
		
	}
	public ResultSet allPayments() {
		
		String sql = "Select * from Payment";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	
		return rs;
		
	}
	
	public void dumpPayment(String[] payment) {
	String sql = "Insert into Payment (paymentCode, patientID, lastName, status,billingTitle, billingAmount) Values(?,?,?,?,?,?)";
	
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, payment[0]);
			pst.setString(2, payment[1]);
			pst.setString(3, payment[2]);
			pst.setString(4, payment[3]);
			pst.setString(5, payment[4]);
			pst.setString(6, payment[5]);
						
			int x = pst.executeUpdate();
			if (x == 0) {
			
			} else {
				JOptionPane.showInternalMessageDialog(null, "Payment Successful");
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
			if (e.toString().contains("paymentCode")) {
				//JOptionPane.showInternalMessageDialog(null, "Payment Code already exist"+ payment[0] );
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "An error ocurred why trying to book a Patient");
				e.printStackTrace();
			}
		}
		finally {
			if(rs==null) {try {rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}	
	}
	
	public ResultSet doctorBookedData() {
		
		String sql = "Select patientID, firstName, lastName, maritalStatus,  "
				+ "strftime('%Y', date('now'))-strftime('%Y', date(dateOfBirth)) AS dateOfBirth,  "
				+ " NumOfChildren, lastDateVisit from BookedData";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
		
	}
	
	public void addDoctorComment(String[] comment) {
	
		String sql = "Insert into doctorComment (patientID, healthStatus, recommendedDrug, doctorComment, date)values(?,?,?,?,?) ";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, comment[0]);
			pst.setString(2, comment[1]);
			pst.setString(3, comment[2]);
			pst.setString(4, comment[3]);
			pst.setString(5, comment[4]);
			
			int x = pst.executeUpdate();
			if (x == 0) {

			} else {
				JOptionPane.showInternalMessageDialog(null, "Details Added");
				

			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		
	}
	public ResultSet displayDoctorComment() {
		String sql = "Select * from doctorComment";
		
		try {
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
	}
	
	public ResultSet salesTable() {
		String sql = "Select * from Sales";
		
		try {
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
	}
	public ResultSet revenueValue() {
		String sql = "Select SUM(Total) Total from Sales";
		
		try {
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
	}
	
	public ResultSet stockVal() {
		String sql = "Select SUM(UnitPrice * QtySold) as StockValue from DrugInventory";
		
		try {
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		return rs;
	}
	
	public ResultSet stockRemain() {
		String sql = "Select SUM(UnitPrice * QtyRemaining) as StockValue from DrugInventory";
		
		try {
		pst = conn.prepareStatement(sql);
		
		rs = pst.executeQuery();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
	}
	
	public void updateSales(String drugID) {

		String sql = "UPDATE DrugInventory "
				+ "SET QtySold = QtyRemaining - (Select sum(SA.Quantity) from Sales SA "
				+ "left Join DrugInventory DI ON DI.DrugID = SA.DrugID)"
				+ "WHERE DrugID IN (Select DrugID from Sales where DrugID = ?)";
		
		
		/*
		 * String sql = "Update DrugInventory SET QtySold = (Select SA.Quantity - DI.QtyRemaining * -1 From Sales SA "
				+ "Inner Join DrugInventory DI ON DI.DrugID = SA.DrugID)"
				+ "WHERE DrugID IN (Select DrugID from Sales where DrugID)";
		 * 		 * 
		 */
			//
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, drugID);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	}
		
		public void addSales(String[] addSale) {
			
		String sql = "INSERT INTO Sales(DrugID, patientID, drugName, pharmacist, unitPrice, Total, date, Quantity) VALUES (?,?,?,?,?,?,?,?)";	
		
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1, addSale[0]);
			pst.setString(2, addSale[1]);
			pst.setString(3, addSale[2]);
			pst.setString(4, addSale[3]);
			pst.setString(5, addSale[4]);
			pst.setString(6, addSale[5]);
			pst.setString(7, addSale[6]);
			pst.setString(8, addSale[7]);
			
			int x = pst.executeUpdate();
			if(x>=0) {
				JOptionPane.showMessageDialog(null, "Added successful");
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}

	}
	public ResultSet generateData() {
		
		String sql = "Select DrugID, DrugName, unitPrice from DrugInventory";
		
		try {
			pst = conn.prepareStatement(sql);
			rs= pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
	}
	
	public ResultSet displayInvent() {
		String sql = "Select * from DrugInventory";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		return rs;
		
	}
	
	public void addingInventory(String[] inventory) {
		String sql ="INSERT INTO DrugInventory(DrugID, DrugName, DrugGrammage, ExpiryDate, UnitPrice, QtySold, QtyRemaining, date) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, inventory[0]);
			pst.setString(2, inventory[1]);
			pst.setString(3, inventory[2]);
			pst.setString(4, inventory[3]);
			pst.setString(5, inventory[4]);
			pst.setString(6, inventory[5]);
			pst.setString(7, inventory[6]);
			pst.setString(8, inventory[7]);
			
			
			int x = pst.executeUpdate();
			if(x>=0) {
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Drug successfully Added");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
	}
	public ResultSet displayUsers() {
		String sql = "Select * from Users";
		
		try {
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs==null) {try {	rs.close();}catch(SQLException ex) {}}
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
	
		return rs;
	}
	
	public void AddUser(String[]users) {
		
		String sql = "INSERT INTO Users (StaffID, firstName, lastName, Password, dept) VALUES(?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, users[0]);
			pst.setString(2, users[1]);
			pst.setString(3, users[2]);
			pst.setString(4, users[3]);
			pst.setString(5, users[4]);
			
			
			int x = pst.executeUpdate();
			
			if(x==0) {
				
			}
			else {
				JOptionPane.showMessageDialog(null, "User Added Successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pst==null) {try {pst.close();}catch(SQLException ex) {}}
		}
		
		
	}
}
