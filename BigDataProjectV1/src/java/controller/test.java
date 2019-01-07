package controller;

import java.sql.*;
import java.sql.*;
import java.util.*;

public class test {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject4","root","");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select customer_ID from customer");
            List<Integer> customer_ID = new ArrayList<Integer>();
            List<Integer> customer_ID1 = new ArrayList<Integer>();
            customer_ID1 = customer_ID;
            while(rs.next()){
                customer_ID.add(rs.getInt("customer_ID"));
            }
            List<Integer> complaint_ID = new ArrayList<Integer>();
            int size = customer_ID.size();
            rs = st.executeQuery("select complaint_ID from cfpb_complaint order by complaint_ID");
            while(rs.next()){
                complaint_ID.add(rs.getInt("complaint_ID"));
            }
            
            System.out.println(size);
            System.out.println("complaint size "+complaint_ID.size());
            int j = 95000;
             for(int i=1;i<=950000;i++){
                int x = customer_ID.get(j);
                j--;
                if(j==1)
                    j=95000;
                System.out.println(i);
                
                 try{
                st.executeUpdate("update cfpb_complaint set customer_ID = '"+x+ "'"
                        + "where complaint_ID = '"+complaint_ID.get(i)+"'");
                System.out.println("added "+x);
                }catch(Exception e){
                    System.out.println("Problem in "+x);
                }   
            }
            
           /* 
            String product = "Balaji waffers";
            String subproduct = "Masala waffers";
            
            String issue = "Quantity";
            String subissue = "Hawa bau che bc";
            
            String company = "Balaji";
            String company_response = "Lol";
            String response_status = "Uncleared";
            String consumer_disputed = "No";
            String timely_response = "Nope";
            
            String date_received = "10/20/2018";
            String submitted_via = "fone";
            String complaint_narratives = "hawa bau che biju su";
            String tags = "ama su tag";
            String date_sent_to_company = "11/20/2018";
            String consent_provided = "na bhai na";
            
            String customer = "Ishaan :*";
            String customer_ZIP = "14623";
            String age_range = "23";
            String income_range = "1000000";
            
            Statement st = con.createStatement();
            
            //PRODUCT
            String product_Sql = "insert into product(product_Name) Values(?)";
            PreparedStatement ps = con.prepareCall(product_Sql);
            ps.setString(1, product);
            System.out.println("Product insert: "+ps.executeUpdate());
            
            int product_id=-999;
            
            String getProduct = "Select * from product where product_Name = '"+product+"'";
            ResultSet rs = st.executeQuery(getProduct);
            int count = 0;
            while(rs.next()){
                product_id = rs.getInt("product_ID");
            }
            System.out.println("product_ID is " +product_id+"\n");
            //SUBPRODUCT
            String subproduct_SQL = "insert into subproduct(product_id,subproduct_Name) Values(?,?)";
            ps = con.prepareStatement(subproduct_SQL);
            ps.setInt(1, product_id);
            ps.setString(2, subproduct);
            System.out.println("Subproduct insert: "+ps.executeUpdate());
            int subproduct_id = -999;
            String getSubproduct = "Select * from subproduct where subproduct_Name = '"+subproduct+"'";
            rs = st.executeQuery(getSubproduct);
            
            while(rs.next()){
                subproduct_id = rs.getInt("subproduct_ID");
            }
            System.out.println("Subproduct_id: "+subproduct_id+"\n");
            
            //ISSUE
            String issue_sql = "insert into issue(issue_Name) Values(?)";
            ps = con.prepareStatement(issue_sql);
            ps.setString(1, issue);
            System.out.println("Issue insert: "+ps.executeUpdate());
            int issue_id=-999;
            String getissue = "select * from issue where issue_Name ='"+issue+"'";
            rs = st.executeQuery(getissue);
            while(rs.next()){
                issue_id = rs.getInt("issue_ID");
            }
            System.out.println("issue_ID: "+issue_id+"\n");
            
            String subissue_sql = "insert into subissue(issue_ID,subissue_Name) Values(?,?)";
            ps = con.prepareStatement(subissue_sql);
            ps.setInt(1, issue_id);
            ps.setString(2, subissue);
            System.out.println("Subissue Insert: "+ps.executeUpdate());
            int subissue_id = -999;
            String getsubissue = "select * from subissue where subissue_Name = '"+subissue+"' "
                    + "and issue_ID = '"+issue_id+"'";
            rs = st.executeQuery(getsubissue);
            while(rs.next()){
                subissue_id = rs.getInt("subissue_ID");
            }
            System.out.println("Subissue_ID: "+subissue_id+"\n");
            
            String customer_sql = "insert into customer(customer_Name,zip,age_range,income_range)"
                    + "Values(?,?,?,?)";
            ps = con.prepareStatement(customer_sql);
            ps.setString(1, customer);
            ps.setString(2,customer_ZIP);
            ps.setString(3,age_range);
            ps.setString(4,income_range);
            System.out.println("Customer insert: "+ps.executeUpdate());
            int customer_id=-999;
            String getcustomer = "select * from customer where customer_Name = '"+customer+"' "
                    + "and zip = '"+customer_ZIP+"' and age_range = '"+age_range+"'"
                    + "and income_range = '"+income_range+"'";
            rs = st.executeQuery(getcustomer);
            while(rs.next()){
                customer_id = rs.getInt("customer_ID");
            }
            System.out.println("Customer_ID: "+customer_id+"\n");
            
            //COMPANY
            String company_sql = "insert into company(company_name) values(?)";
            ps = con.prepareStatement(company_sql);
            ps.setString(1, company);
            System.out.println("Company Insert: "+ps.executeUpdate() );
            int company_id = -999;
            String getcompany = "Select * from company where company_name ='"+company+"' ";
            rs = st.executeQuery(getcompany);
            while(rs.next()){
                company_id = rs.getInt("company_ID");
            }
            System.out.println("Company_ID: "+company_id);
            
            //CFPB_complaint
            String cfpb = "insert into cfpb_complaint"
                    + "(date_received,product_id,subproduct_id,issue_id,subissue_id,company_ID,"
                    + "submitted_via,complaint_narratives,tags,date_sent_to_company,consent_provided"
                    + ",complaint_ID)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(cfpb);
            ps.setString(1, date_received);
            ps.setInt(2, product_id);
            ps.setInt(3, subproduct_id);
            ps.setInt(4,issue_id);
            ps.setInt(5,subissue_id);
            ps.setInt(6,company_id);
            ps.setString(7,submitted_via );
            ps.setString(8,complaint_narratives);
            ps.setString(9,tags);
            ps.setString(10,date_sent_to_company);
            ps.setString(11,consent_provided);
            ps.setInt(12, 666666);
            System.out.println("Cfpb insert: "+ps.executeUpdate());
            int cfpb_id = -999;
            String getcfpb = "select * from cfpb_complaint where date_received = '"+date_received+"' and " 
                    + "product_id = '"+product_id+"' and subproduct_id = '"+subproduct_id+"' and "
                    + "issue_id = '"+issue_id+"' and subissue_id='"+subissue_id+"' and "
                    + "company_ID = '"+company_id+"' and date_sent_to_company = '"+date_sent_to_company+"'";
            rs = st.executeQuery(getcfpb);
            List<Integer> cfpbs = new ArrayList<Integer>();
            while(rs.next()){
                cfpbs.add(rs.getInt("complaint_ID"));
            }
            System.out.println(cfpbs+"\n");
            
            //Company Response
            
            String company_response_sql = "insert into company_response(complaint_ID,company_ID,company_response,response_status,consumer_disputed,timely_response)"
                    + "Values(?,?,?,?,?,?)";
            ps = con.prepareStatement(company_response_sql);
            ps.setInt(1,cfpbs.get(0));
            ps.setInt(2, company_id);
            ps.setString(3,company_response);
            ps.setString(4, response_status);
            ps.setString(5, consumer_disputed);
            ps.setString(6,timely_response);
            System.out.println("Company Response Insert: "+ps.executeUpdate());
            int company_response_id = -999;
            String getcompanyresponse = "select * from company_response where complaint_id"
                    + " = '"+cfpbs.get(0)+"'";
            rs = st.executeQuery(getcompanyresponse);
            while(rs.next()){
                company_response_id = rs.getInt("response_ID");
            }
            System.out.println("company_response_id: "+company_response_id);*/
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        }
    }
}
