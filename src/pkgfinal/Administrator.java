package pkgfinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Administrator {
    private static Connection connection;
    
    public Administrator() {
        String url = "mssqlserverurl";
        String username = "MSSqlserverusername";
        String password = "MSSqlserverpassword";
        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert_into_pilot(String NAME,int ID,String SEX){
        String sql = "INSERT INTO Pilot(Name, ID, Sex) VALUES (?, ?, ?); ";
        try{
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, NAME);
        statement.setInt(2, ID);
        statement.setString(3, SEX);
        statement.executeUpdate();

        statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String getName_from_pilot(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Pilot where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Name") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int max_flightID(){
        String sql = "SELECT max(ID) as \'max\' FROM flight" ;
        int re = 0;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return re =  resultSet.getInt("max") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int max_planeID(){
        String sql = "SELECT max(ID) as \'max\' FROM plane" ;
        int re = 0 ;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return re =  resultSet.getInt("max") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int max_customerID(){
        String sql = "SELECT max(ID) as \'max\' FROM Customer" ;
        int re = 0 ;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return re =  resultSet.getInt("max") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int max_AdminID(){
        String sql = "SELECT max(ID) as \'max\' FROM admin" ;
        int re = 0 ;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return re =  resultSet.getInt("max") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public void add_flight(int ID,String plane_id,String pilot_id,String date,String source ,String destination, String available_seats,String time){
        Scanner input = new Scanner(System.in);
        String sql = "INSERT INTO Flight(ID, Plane_id , Pilot_id , Date , Source , Destination , Available_seats, Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";
        try{
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ID);
        statement.setInt(2, Integer.parseInt(plane_id));
        statement.setInt(3, Integer.parseInt(pilot_id));
        statement.setString(4,date);
        statement.setString(5, source);
        statement.setString(6, destination);
        statement.setInt(7, Integer.parseInt(available_seats));
        statement.setString(8,time);

        statement.executeUpdate();
        statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getPlaneID_from_flight(String ID){
        int re = 0 ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getInt("Plane_id") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int getPilotID_from_flight(String ID){
        int re = 0 ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getInt("Pilot_id") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getDate_from_flight(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Date") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getSource_from_flight(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Source") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getDestination_from_flight(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Destination") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public int getAvailableSeats_from_flight(String ID){
        int re = 0 ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getInt("Available_seats") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getTime_from_flight(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Time") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public void editPlaneID_in_flight(String ID , int plane_id){
        String sql = "UPDATE Flight SET Plane_id = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setInt(1,plane_id);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editPilotID_in_flight(String ID , int pilot_id){
        String sql = "UPDATE Flight SET Pilot_id = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setInt(1,pilot_id);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editDate_in_flight(String ID , String Date){
        String sql = "UPDATE Flight SET Date = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Date);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editSource_in_flight(String ID , String source){
        String sql = "UPDATE Flight SET Source = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,source);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

     public void editDestination_in_flight(String ID , String destination){
        String sql = "UPDATE Flight SET Destination = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,destination);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editAvailableSeats_in_flight(String ID , int Available_seats){
        String sql = "UPDATE Flight SET Available_seats = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setInt(1,Available_seats);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editTime_in_flight(String ID , String Time){
        String sql = "UPDATE Flight SET Time = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Time);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void edit_flight(){
        Scanner input = new Scanner(System.in);
        System.out.print("enter the id of flight that you want to edit: ");
        String ID = input.next();
        while(true){
            System.out.println("1.Edit Plane ID\n2.Edit Pilot ID\n3.Edit Date\n4.Edit source\n5.Edit destination\n6.Edit available seats\n7.Edit time\n8.Exit");
            System.out.print("enter your choice: ");
            String answer = input.next();
            switch(answer){
                case "1":
                    System.out.print("enter the new plane id of the flight: ");
                    this.editPlaneID_in_flight(ID,input.nextInt());
                    break ;
                case "2":
                    System.out.print("enter the new pilot id of the flight: ");
                    this.editPilotID_in_flight(ID,input.nextInt());
                    break ;
                case "3":
                    System.out.print("enter the new date of the flight: ");
                    this.editDate_in_flight(ID,input.next());
                    break ;
                case "4":
                    System.out.print("enter the new source of the flight: ");
                    input.nextLine();
                    this.editSource_in_flight(ID,input.nextLine());
                    break ;
                case "5":
                    System.out.print("enter the new destination of the flight: ");
                    input.nextLine();
                    this.editDestination_in_flight(ID,input.nextLine());
                    break ;
                case "6":
                    System.out.print("enter the available seats of the flight: ");
                    this.editAvailableSeats_in_flight(ID,input.nextInt());
                    break ;
                case "7":
                    System.out.print("enter the new time of the flight: ");
                    input.nextLine();
                    this.editTime_in_flight(ID,input.nextLine());
                    break ;
                case "8":
                    return ;
                default:
                    System.out.println("error input");
            }
        }
    }

    public void deleteFlight(String ID){
        
        String sql = "DELETE FROM FLIGHT WHERE ID = ? ;" ;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ID) ;
            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePlane(){
        Scanner input = new Scanner(System.in);
        String sql = "UPDATE FLIGHT SET Plane_id = NULL WHERE Plane_id = ? ;" ;
        String sql2 = "DELETE FROM plane WHERE ID = ? ;" ;

        try{
            System.out.print("enter id of plane that you want to delete");
            String ID = input.next();
//            input.close();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ID) ;
            statement.executeUpdate();
            statement.close();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,ID) ;
            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void showflights(){
        int seats ;
        String src ,des , date ;
        boolean counter = false ;
        Scanner input = new Scanner(System.in);
        String sql = "SELECT * FROM Flight ";
        System.out.println("We will need some information");
        System.out.print("Do you want to add date ? y/n : ");
        String choice = input.nextLine();
        if (choice.equals("y") || choice.equals("Y")){
            System.out.print("Enter the date : ");
            date = input.nextLine();
            sql = "SELECT * FROM Flight Where Date = '" + date + "'" ;
            counter = true ;
        }
        System.out.print("Do you want to add remaining seats ? y/n : ");
        choice = input.nextLine();
        if (choice.equals("y") || choice.equals("Y")){
            System.out.print("Enter the number of seats : ");
            seats = input.nextInt();
            input.nextLine();
            if (counter == false){
                sql = "SELECT * FROM Flight Where Available_seats >= " + seats  ;
                counter = true ;
            }else{
                sql = sql + " and Available_seats >= " + seats ;
            }
        }
        System.out.print("Do you want to add source ? y/n : ");
        choice = input.nextLine();
        if (choice.equals("y") || choice.equals("Y")){
            System.out.print("Enter the source : ");
            src = input.nextLine();
            if (counter == false){
                sql = "SELECT * FROM Flight Where Source = '" + src + "'" ;
                counter = true ;
            }
            else{
                    sql = sql + " and Source = '" + src + "'" ;
            }
        }
        System.out.print("Do you want to add Destination ? y/n : ");
        choice = input.nextLine();
        if (choice.equals("y") || choice.equals("Y")){
            System.out.print("Enter the destination : ");
            des = input.nextLine();
            if (counter == false){
                sql = "SELECT * FROM Flight Where Destination = '" + des + "'";
                counter = true  ;
            }else {
                sql = sql + " and Destination = '" + des + "'" ;
            }
        }
        sql = sql +" ;" ;

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("ID     Date     Source     Destination     available_seats");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("ID")+"    "+resultSet.getString("Date")+"    "+resultSet.getString("Source")+"    "+resultSet.getString("Destination")+"   "+resultSet.getInt("Available_seats"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public String geteMail_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
            try{
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                resultSet.next();
                return re =  resultSet.getString("Email") ;
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return re ;
    }

    public String getSsn_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("SSN") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
   }

    public String getName_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Name") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getPassword_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Password") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getPhone_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Phone") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public String getAddress_from_customer(String ID){
        String re = "" ;
        String sql = "SELECT * FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return re =  resultSet.getString("Address") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return re ;
    }

    public void edit_customer(){
        Scanner input = new Scanner(System.in);
        String sql = "UPDATE customer SET ID = ? , Email = ? , SSN = ? , Name = ? , Password = ? , Phone = ? , Address = ?  WHERE ID = ? ; ";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.print("enter the id of the customer that you want to edit: ");
            String ID = input.next();
            statement.setString(8,ID);

            System.out.print("do you want to change the customer id y/n: ");
            String answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new id of the customer: ");
                statement.setInt(1, input.nextInt());
            }
            else{
                statement.setString(1,ID );
            }

            System.out.print("do you want to change the customer e-mail y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new e-mail of the customer: ");
                input.nextLine();
                statement.setString(2, input.nextLine());
            }
            else{
                statement.setString(2,this.geteMail_from_customer(ID) );
            }

            System.out.print("do you want to change the ssn of the customer y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new ssn of the customer: ");
                statement.setString(3, input.next());
            }
            else{
                statement.setString(3,this.getSsn_from_customer(ID) );
            }

            System.out.print("do you want to change the name of the customer y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new name: ");
                input.nextLine();
                statement.setString(4, input.nextLine());
            }
            else{
                statement.setString(4,this.getName_from_customer(ID));
            }

            System.out.print("do you want to change the password of the customer ? y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new password : ");
                input.nextLine();
                statement.setString(5, input.nextLine());
            }
            else{
                statement.setString(5,this.getPassword_from_customer(ID));
            }

            System.out.print("do you want to change the phone of the customer ? y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new phone : ");
                input.nextLine();
                statement.setString(6, input.nextLine());
            }
            else{
                statement.setString(6,this.getPhone_from_customer(ID));
            }

            System.out.print("do you want to change the address of the customer y/n: ");
            answer = input.next();
            if(answer.equals("Y") || answer.equals("y")){
                System.out.print("enter the new address: ");
                input.nextLine();
                statement.setString(7, input.nextLine());
            }
            else{
                statement.setString(7,this.getAddress_from_customer(ID) );
            }

            statement.executeUpdate();
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void update_aircraft(){
        int id;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the plane you want to update: ");
        id = scanner.nextInt();

        try{
            String sql = "SELECT * FROM Plane WHERE ID = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            String name = null;
            String type = null;
            String model = "";
            int no_seats = 0;

            if (rs.next()) {
                name = rs.getString("Name");
                type = rs.getString("Type");
                model = rs.getString("Model");
                no_seats = rs.getInt("No_seats");
            }

//            statement.close();

            while (true) {
                int choice;
                System.out.println("What do you want to change? Enter the number:");
                System.out.println("1 - name");
                System.out.println("2 - id");
                System.out.println("3 - type");
                System.out.println("4 - model");
                System.out.println("5 - no_seats");
                System.out.println("6 - exit");
                choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Enter the new name of the plane: ");
                    name = scanner.next();
                } else if (choice == 2) {
                    System.out.println("Enter the new id of the plane: ");
                    id = scanner.nextInt();
                } else if (choice == 3) {
                    System.out.println("Enter the type of the plane: ");
                    type = sc.nextLine();
                } else if (choice == 4) {
                    System.out.println("Enter the new model name of the plane: ");
                    model = scanner.next();
                } else if (choice == 5) {
                    System.out.println("Enter the new number of seats of the plane: ");
                    no_seats = scanner.nextInt();
                } else if (choice == 6) {
                    break;
                }

                String sql2 = "UPDATE Plane SET Name=?, Type=?, Model=?, No_seats=? WHERE ID=?;";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setString(1, name);
                statement2.setString(2, type);
                statement2.setString(3, model);
                statement2.setInt(4, no_seats);
                statement2.setInt(5, id);
                statement2.executeUpdate();
//                statement2.close();
            }

            System.out.println("The data of the plane has been updated.");
//            scanner.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addingAircraft(int id , String model , int no_seats , String name , String type){
        
        String sql = "INSERT INTO Plane(Name, ID, Type ,Model , No_seats) VALUES (?, ?, ? , ? , ?); ";
        try{
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        statement.setString(3, type);
        statement.setString(4, model);
        statement.setInt(5, no_seats);
        statement.executeUpdate();

        statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // #####################################################
    public boolean flight_isExist(String ID){
        int re = 0 ;
        String sql = "SELECT count(*) as 'exist' FROM Flight where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            re =  resultSet.getInt("exist") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(re == 1){
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public boolean plane_isExist(String ID){
        int re = 0 ;
        String sql = "SELECT count(*) as 'exist' FROM Plane where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            re =  resultSet.getInt("exist") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(re == 1){
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public boolean pilot_isExist(String ID){
        int re = 0 ;
        String sql = "SELECT count(*) as 'exist' FROM Pilot where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            re =  resultSet.getInt("exist") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(re == 1){
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public ResultSet printAllFlights(){
        try{
            String sql = "SELECT * FROM Flight ;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet printAllCustomers(){
        try{
            String sql = "SELECT * FROM Customer ;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void editName_in_Customer(String ID , String Name){
        String sql = "UPDATE Customer SET Name = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Name);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editEmail_in_Customer(String ID , String Email){
        String sql = "UPDATE Customer SET Email = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Email);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editPassword_in_Customer(String ID , String Password){
        String sql = "UPDATE Customer SET Password = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Password);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editAddress_in_Customer(String ID , String Address){
        String sql = "UPDATE Customer SET Address = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Address);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editSSN_in_Customer(String ID , String SSN){
        String sql = "UPDATE Customer SET SSN = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,SSN);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void editPhone_in_Customer(String ID , String Phone){
        String sql = "UPDATE Customer SET Phone = ? WHERE ID = ? ;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2,ID);
            statement.setString(1,Phone);

            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean Customer_isExist(String ID){
        int re = 0 ;
        String sql = "SELECT count(*) as 'exist' FROM Customer where ID = " + ID + " ;";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            re =  resultSet.getInt("exist") ;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        if(re == 1){
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public void deletecustmer(String ID){
        Scanner input = new Scanner(System.in);
        String sql = "DELETE CustomerFlights WHERE Customer_id = ? ;" ;
        String sql2 = "DELETE FROM Customer WHERE ID = ? ;" ;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ID) ;
            statement.executeUpdate();
            statement.close();
            statement = connection.prepareStatement(sql2);
            statement.setString(1,ID) ;
            statement.executeUpdate();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean validPassword(String password){
        String passPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        Pattern ptrn = Pattern.compile(passPattern);

        if (ptrn.matcher(password).matches())
            return true;
        else
            return false;
    }

    public boolean validateEmail(String e_mail){
        String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@"+
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern ptrn = Pattern.compile(emailFormat);

        if (ptrn.matcher(e_mail).matches())
            return true;
        else
            return false;
    }

    public boolean validPhone(String phoneNumber){
        String regex = "^(011|012|010|015)\\d{8}$";
        return phoneNumber.matches(regex);
    }
    
    public ResultSet showflights(String d , String sts , String src , String des ){
       String date ;
       String Source ;
       String Destination ;
       int seats ;
       
        
        boolean counter = false ;
        String sql = "SELECT * FROM Flight ";
       
        
        if (!d.isEmpty()){
            date = d;
            sql = "SELECT * FROM Flight Where Date = \'" + date + "\'" ;
            counter = true ;
        }
        
        
        if (!sts.isEmpty()){
            
            seats = Integer.parseInt(sts);
            
            if (counter == false){
                sql = "SELECT * FROM Flight Where Available_seats >= " + seats  ;
                counter = true ;
            }else{
                sql = sql + " and Available_seats >= " + seats ;
            }
        }
        
        
        if (!src.isEmpty()){
           
            Source = src;
            if (counter == false){
                sql = "SELECT * FROM Flight Where Source = \'" + src + "\'" ;
                counter = true ;
            }
            else{
                    sql = sql + " and Source = \'" + src + "\'" ;
            }
        }
       
        
        if (!des.isEmpty()){
            
            Destination = des;
            if (counter == false){
                sql = "SELECT * FROM Flight Where Destination = \'" + des + "\'";
                counter = true  ;
            }else {
                sql = sql + " and Destination = \'" + des + "\'" ;
            }
        }
        sql = sql +" ;" ;

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            
            return resultSet;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
