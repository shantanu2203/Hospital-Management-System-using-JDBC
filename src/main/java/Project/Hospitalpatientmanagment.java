package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Hospitalpatientmanagment {

	public static void create() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Aditya@5787");
			String sql = "create table if not exists project (id int, name varchar(100) , address varchar(100) , phone varchar(100), age int(2), bloodgroup varchar(100) )";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Aditya@5787");
			String sql = "insert into project(id, name, address, phone, age, bloodgroup) values (?, ?, ?, ?, ?, ?)";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter your name");
			String name1 = sc.nextLine();
			
			System.out.println("Enter your address");
			String address1 = sc.nextLine();
			
			System.out.println("Enter your Phone");
			String phoneno = sc.nextLine();
			
			
			System.out.println("Enter your age");
			int age1 = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter your bloodgroup");
			String bloodgroup1 = sc.nextLine();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name1);
			ps.setString(3, address1);
			ps.setString(4, phoneno);
			ps.setInt(5, age1);
			ps.setString(6, bloodgroup1);

			int status = ps.executeUpdate();
			if (status > 0) {
				System.out.println("your data has been insert  succesfully");
			} else {
				System.out.println("your data has not been insert  succesfully");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void fetch() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Aditya@5787");
			PreparedStatement pr = con.prepareStatement("select * from project");
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int age = rs.getInt("age");
				String bloodgroup = rs.getString("bloodgroup");

				System.out.println("ID is : " + id);
				System.out.println("NAME is : " + name);
				System.out.println("ADDRESS is : " + address);
				System.out.println("PHONE is : " + phone);
				System.out.println("AGE is : " + age);
				System.out.println("BLOOD GROUP is : " + bloodgroup);

				System.out.println();
				System.out.println("--------------------------------------------------------");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Aditya@5787");
			String sql = "update project SET name=?, address=?, phone=?, age=?, bloodgroup=?  WHERE id=?";
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter your name");
			String name1 = sc.next();
			sc.nextLine();
			System.out.println("Enter your address");
			String address1 = sc.nextLine();
			System.out.println("Enter your Phone");
			String phoneno = sc.nextLine();
			System.out.println("Enter your age");
			int age1 = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your bloodgroup");
			String bloodgroup1 = sc.nextLine();
			System.out.println("Enter your id");
			int id = sc.nextInt();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name1);
			ps.setString(2, address1);
			ps.setString(3, phoneno);
			ps.setInt(4, age1);
			ps.setString(5, bloodgroup1);
			ps.setInt(6, id);
			int st = ps.executeUpdate();
			if (st > 0) {
				System.out.println("your data has been updated");
			} else {
				System.out.println("your data has not updated");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Aditya@5787");
			String sql = "Delete from project where id=?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id");
			int id = sc.nextInt();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int status1 = ps.executeUpdate();
			if (status1 > 0) {
				System.out.println("data has been deleted");
			} else {
				System.out.println("data has not been deleted");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		System.out.println("     Welcome To Hospital    ");
		System.out.println("1.Create Table");
		System.out.println("2.Add Patient Details");
		System.out.println("3.See Patient Details");
		System.out.println("4.Update Patient Data");
		System.out.println("5.Delete Patient Detail");

		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Select a appropriate option Do You Want");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				create();
				break;
			}
			case 2: {
				insert();
				break;
			}
			case 3: {
				fetch();
				break;
			}
			case 4: {
				update();
				break;
			}
			case 5: {
				delete();
				break;
			}

			default:
			}

		} while (choice != 6);

	}

}