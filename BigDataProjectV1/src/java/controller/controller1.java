package controller;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import Model.*;
@Controller
public class controller1 {
    
    @RequestMapping(value = "index.htm",method = RequestMethod.GET)
    public ModelAndView redirect(){
        
        ModelAndView mv = new ModelAndView("index");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("show tables");
            List<String> tables = new ArrayList<String>();
            mv.addObject("tables", tables);
            
            while(rs.next()){
                tables.add(rs.getString(1));
            }
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mv;
    }
    
    
    
    @RequestMapping(value="insert.htm", method = RequestMethod.GET)
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView("Insert");
        String getproduct_name = "select distinct product_name from product";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
            Statement st = con.createStatement();
            
            List<String> product_name = new ArrayList<String>();
            ResultSet rs = st.executeQuery("select distinct product_name from product");
            while(rs.next()){
                product_name.add(rs.getString("product_name"));
            }
            mv.addObject("product_name", product_name);
            
            List<String> subproduct_name = new ArrayList<String>();
            rs = st.executeQuery("select distinct subproduct_name from subproduct");
            while(rs.next()){
                subproduct_name.add(rs.getString("subproduct_name"));
            }
            mv.addObject("subproduct_name", subproduct_name);
            
            List<String> issue_name = new ArrayList<String>();
            rs = st.executeQuery("select distinct issue_name from issue");
            while(rs.next()){
                issue_name.add(rs.getString("issue_name"));
            }
            mv.addObject("issue_name", issue_name);
            
            List<String> subissue_name = new ArrayList<String>();
            rs = st.executeQuery("select distinct subissue_name from subissue");
            while(rs.next()){
                subissue_name.add(rs.getString("subissue_name"));
            }
            mv.addObject("subissue_name", subissue_name);
            
            List<String> submitted_via = new ArrayList<String>();
            rs = st.executeQuery("select distinct submitted_via from cfpb_complaint");
            while(rs.next()){
                submitted_via.add(rs.getString("submitted_via"));
            }
            mv.addObject("submitted_via",submitted_via);
            
            List<String> tags = new ArrayList<String>();
            rs = st.executeQuery("select distinct tags from cfpb_complaint order by tags desc");
            while(rs.next()){
                tags.add(rs.getString("tags"));
            }
            mv.addObject("tags", tags);
            
            List<String> company_response = new ArrayList<String>();
            rs = st.executeQuery("select distinct company_response from company_response where company_response!='NULL'");
            while(rs.next()){
                company_response.add(rs.getString("company_response"));
            }
            mv.addObject("company_response",company_response);
            
            List<String> response_status = new ArrayList<String>();
            rs = st.executeQuery("select distinct response_status from company_response;");
            
            while(rs.next()){
                response_status.add(rs.getString("response_status"));
            }
            mv.addObject("response_status",response_status);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mv;
    }
    
    @RequestMapping(value = "gettest.htm " ,method = RequestMethod.GET)
    public ModelAndView gettest(@RequestParam("product")String product, @RequestParam("subproduct")
            String subproduct,@RequestParam("issue")String issue,@RequestParam("subissue")String subissue,
            @RequestParam("customer")String customer,@RequestParam("cname")String company,
            @RequestParam("company_response")String company_response,@RequestParam("response_status")String response_status
            ,@RequestParam("consumer_disputed")String consumer_disputed, @RequestParam("timely_response")String timely_response
            ,@RequestParam("date_received") String date_received,@RequestParam("date_sent_to_company")String date_sent_to_company
            ,@RequestParam("complaint_narratives")String complaint_narratives,@RequestParam("tags")String tags
            ,@RequestParam("consent_provided")String consent_provided,@RequestParam("submitted_via")String submitted_via
            ,@RequestParam("age")String age_range,@RequestParam("income")String income_range
            ,@RequestParam("zip")String customer_ZIP){
            ModelAndView mv = new ModelAndView("gettest");
            String status = "Failed to add";
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
            Statement st = con.createStatement();
            
            
        
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
            System.out.println("company_response_id: "+company_response_id);
            status = "Successsfully added the complaint";
            
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            mv.addObject("status",status);
            
            
        return mv;
    }
    @RequestMapping(value = "preview.htm " ,method = RequestMethod.GET)
    public ModelAndView preview(){
        ModelAndView mv = new ModelAndView("preview");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("show tables");
            List<String> tables = new ArrayList<String>();
            
            
            while(rs.next()){
                if(!(rs.getString(1).equals("location"))){
                tables.add(rs.getString(1));
                 }
            }
            mv.addObject("tables", tables);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mv;
    }
    
    @RequestMapping(value = "tableload.htm",method = RequestMethod.GET)
    public ModelAndView tableload(@RequestParam("name")String name){
        ModelAndView mv = new ModelAndView("tableload");
        System.out.println(name);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
            Statement st =  con.createStatement();
            if(name.equals("cfpb_complaint")){
                String sql = "";
                List<cfpb_complaint> cfpb = new ArrayList<cfpb_complaint>();
                ResultSet rs = st.executeQuery("select * from cfpb_complaint limit 0,5");
                while(rs.next()){
                    cfpb.add(new cfpb_complaint(rs.getString("complaint_ID"),rs.getInt("product_ID")
                            , rs.getInt("subproduct_ID"), rs.getInt("issue_ID"),
                            rs.getInt("subissue_ID"), rs.getInt("company_ID"), rs.getString("submitted_via"),
                            rs.getString("complaint_narratives"), rs.getString("tags"), 
                            rs.getString("date_sent_to_company"), rs.getString("consent_provided"), rs.getString("date_received")));
                }
                mv.addObject("name",cfpb);
                mv.addObject("tableName",name);
                
                System.out.println("here hahahahha");
                mv.addObject("table_contents",cfpb);
            }
            
            //PRODUCT
            else if(name.equals("product")){
                
                List<product> p = new ArrayList<product>();
                String sql = "select * from product limit 0,5";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    p.add(new product(rs.getInt("product_ID"), rs.getString("product_Name")));
                }
                mv.addObject("name",p);
                mv.addObject("tableName","product");
            }
            
            else if(name.equals("subproduct")){
                String sql = "select * from subproduct limit 0,5";
                
                ResultSet rs = st.executeQuery(sql);
                List<subproduct> s = new ArrayList<subproduct>();
                while(rs.next()){
                    s.add(new subproduct(rs.getInt("subproduct_ID"),rs.getInt("product_ID"),
                            rs.getString("subproduct_Name")));
                }
                
                mv.addObject("name",s);
                mv.addObject("tableName",name);
            }
            else if(name.equals("issue")){
                List<issue> i = new ArrayList<issue>();
                String sql = "select * from issue limit 0,5";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    i.add(new issue(rs.getInt("issue_ID"),rs.getString("issue_Name")));
                }
                mv.addObject("name",i);
                mv.addObject("tableName",name);
            }
            
            else if(name.equals("subissue")){
                List<subissue> s = new ArrayList<subissue>();
                ResultSet rs = st.executeQuery("select * from subissue limit  0,5");
                while(rs.next()){
                    s.add(new subissue(rs.getInt("subissue_ID"),rs.getInt("issue_ID") ,rs.getString("subissue_name")));
                }
                mv.addObject("name",s);
                mv.addObject("tableName",name);
            }
            
            else if(name.equals("company")){
                List<company> c = new ArrayList<company>();
                ResultSet rs = st.executeQuery("select * from company limit 0,5");
                while(rs.next()){
                    c.add(new company(rs.getInt("company_ID"),rs.getString("company_name")));
                }
                mv.addObject("name",c);
                mv.addObject("tableName",name);
            }
            else if(name.equals("customer")){
                List<customer> c = new ArrayList<customer>();
                ResultSet rs = st.executeQuery("select * from customer limit 0,5");
                while(rs.next()){
                    c.add(new customer(rs.getInt("customer_ID"),
                            rs.getString("customer_Name"), rs.getString("zip"),
                            rs.getString("age_range"),rs.getString("income_range")));
                }
                
                mv.addObject("name",c);
                mv.addObject("tableName",name);
                
            }
            else if(name.equals("company_response")){
                List<company_response> cr = new ArrayList<company_response>();
                ResultSet rs = st.executeQuery("select * from company_response limit 0,5");
                while(rs.next()){
                    cr.add(new company_response(rs.getInt("response_ID"), rs.getInt("complaint_id")
                        , rs.getInt("company_ID"), rs.getString("company_response"),
                        rs.getString("response_status"), rs.getString("consumer_disputed"),
                        rs.getString("timely_response")));
                }
                mv.addObject("name",cr);
                mv.addObject("tableName",name);
                
            }
            else if(name.equals("prod_subprod")){
                List<prod_subprod> p = new ArrayList<prod_subprod>();
                ResultSet rs = st.executeQuery("select * from subproduct join product"
                        + " on product.product_ID = subproduct.product_ID limit 0,5");
                while(rs.next()){
                    p.add(new prod_subprod(rs.getInt("product_id"), rs.getInt("subproduct_ID"),
                            rs.getString("product_Name"), rs.getString("subproduct_Name")));
                }
                mv.addObject("name",p);
                mv.addObject("tableName","prod_subprod");
            }
            else if(name.equals("issue_subissue")){
                List<issue_subissue> i = new ArrayList<issue_subissue>();
                ResultSet rs = st.executeQuery("select * from subissue join issue on "
                        + "issue.issue_id = subissue.issue_ID limit 0,5");
                while(rs.next()){
                    i.add(new issue_subissue(rs.getInt("subissue_ID"), rs.getInt("issue_ID"),
                            rs.getString("subissue_Name"), rs.getString("issue_Name")));
                }
                mv.addObject("name",i);
                mv.addObject("tableName",name);
            }
            else if(name.equals("cfpb_merge")){
                List<cfpb_merged> c = new ArrayList<cfpb_merged>();
                ResultSet rs = st.executeQuery("select cfpb_complaint.date_received, product.product_name,subproduct.subproduct_name,issue.issue_name,subissue.subissue_name, company.company_name,cfpb_complaint.submitted_via,complaint_narratives,cfpb_complaint.tags,cfpb_complaint.date_sent_to_company,cfpb_complaint.consent_provided from cfpb_complaint join product on cfpb_complaint.product_id = product.product_id join subproduct on cfpb_complaint.subproduct_id = subproduct.subproduct_id join issue on cfpb_complaint.issue_id = issue.issue_id join subissue on cfpb_complaint.subissue_id = subissue.subissue_id join company on cfpb_complaint.company_ID= company.company_ID");
                while(rs.next()){
                    c.add(new cfpb_merged(rs.getString("complaint_ID"), rs.getString("date_received"),
                            rs.getString("date_sent_to_company"),rs.getString("product_name"),
                            rs.getString("subproduct_name"), rs.getString("issue_name"),
                            rs.getString("subissue_name"),rs.getString("company_name"),
                            rs.getString("submitted_via"),rs.getString("complaint_narratives"),
                            rs.getString("tags"), rs.getString("consent_provided")));
                }
                 mv.addObject("name",c);
                mv.addObject("tableName",name);
                System.out.println("this executed");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mv;
    }
    
    @RequestMapping(value = "queries.htm",method = RequestMethod.GET)
    public ModelAndView queries(){
        ModelAndView mv = new ModelAndView("queries");
        ArrayList<String> issue = new ArrayList<String>();
        ArrayList<String> product = new ArrayList<String>();
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select distinct issue_name from issue join subissue on issue.issue_id = subissue.issue_ID where subissue.subissue_name!=NULL or subissue.subissue_name!='NULL' order by issue.issue_name");
                while(rs.next()){
                    issue.add(rs.getString("issue_name"));
                }
                mv.addObject("issue", issue);
                
                rs = st.executeQuery("select distinct product_name from product");
                while(rs.next()){
                    product.add(rs.getString("product_name"));
                }
                mv.addObject("product",product);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mv;
    }
    
    @RequestMapping(value = "queryoutput.htm",method = RequestMethod.GET)
    public ModelAndView queriesoutput(@RequestParam("name")String name){
        ModelAndView mv = new ModelAndView("queryoutput");
            String n[] = name.split(",");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bigdataproject","root","");
                Statement st = con.createStatement();
                ResultSet rs ;
                if(n[0].equals("query1")){
                    List<company_complaints> c = new ArrayList<company_complaints>();
                rs = st.executeQuery("select  count(complaint_ID) as Total_Complaints,company.company_name from cfpb_complaint join company on company.company_id = cfpb_complaint.company_ID group by company.company_name order by Total_Complaints desc ");
                
                while(rs.next()){
                    c.add(new company_complaints(rs.getInt("Total_Complaints"),rs.getString("company_name")));
                }
                mv.addObject("name",c);
                mv.addObject("tableName", name);
                
            }
                else if(n[0].equals("query2")){
                    List<company_complaints> c = new ArrayList<company_complaints>();
                rs = st.executeQuery("select  count(complaint_ID) as Total_Complaints,company.company_name from cfpb_complaint join company on company.company_id = cfpb_complaint.company_ID group by company.company_name order by Total_Complaints desc limit 0,"+Integer.parseInt(n[1]));
                
                while(rs.next()){
                    c.add(new company_complaints(rs.getInt("Total_Complaints"),rs.getString("company_name")));
                }
                mv.addObject("name",c);
                mv.addObject("tableName", n[0]);
                }
                
                else if(n[0].equals("query3")){
                    rs = st.executeQuery("select * from subissue join issue on issue.issue_ID = subissue.issue_ID where issue_Name='"+n[1]+"' ");
                    List<issue_subissue> s = new ArrayList<issue_subissue>();
                    while(rs.next()){
                    s.add(new issue_subissue(rs.getInt("subissue_ID"), rs.getInt("issue_ID"), 
                            rs.getString("subissue_name"), rs.getString("issue_name")));
                    }
                    mv.addObject("name",s);
                    mv.addObject("tableName", n[0]);
                    System.out.println("executed");
                }
                
                else if(n[0].equals("query5")){
                    
                    rs = st.executeQuery("select count(company_response.response_ID) as Total_Responses,company.company_name from company_response join company on company.company_ID = company_response.company_ID group by company.company_name order by Total_responses desc limit 0,"+Integer.parseInt(n[1]));
                    ArrayList<company_complaints> c = new ArrayList<company_complaints>();
                    while(rs.next()){
                    c.add(new company_complaints(rs.getInt("Total_Responses"), rs.getString("company.company_name")));
                        
                    }
                    mv.addObject("name",c);
                    mv.addObject("tableName", n[0]);
                    System.out.println("executed");
                }
                
                else if(n[0].equals("query6")){
                    ArrayList<company_complaints> c = new ArrayList<company_complaints>();
                    rs = st.executeQuery("select count(complaint_ID) as Total_Complaints,product.product_name from cfpb_complaint join product on product.product_ID = cfpb_complaint.product_ID group by product.product_name order by Total_complaints desc;");
                    while(rs.next()){
                        c.add(new company_complaints(rs.getInt("Total_Complaints"),
                                rs.getString("product.product_name")));
                    
                    }
                    mv.addObject("name",c);
                    mv.addObject("tableName", n[0]);
                    System.out.println("executed");
                }
                
                else if(n[0].equals("query7")){
                    ArrayList<company_complaints> c = new ArrayList<company_complaints>();
                    rs = st.executeQuery("select count(complaint_ID) as Total_Complaints,issue.issue_name from cfpb_complaint join issue on issue.issue_ID = cfpb_complaint.issue_ID group by issue.issue_name order by Total_complaints desc;");
                    while(rs.next()){
                        c.add(new company_complaints(rs.getInt("Total_Complaints"),
                                rs.getString("issue.issue_name")));
                    
                    }
                    mv.addObject("name",c);
                    mv.addObject("tableName", n[0]);
                    System.out.println("executed");
                }
                
                else if(n[0].equals("query8")){
                    ArrayList<company_complaints> c = new ArrayList<company_complaints>();
                    rs = st.executeQuery("select count(complaint_ID) as Total_Complaints,submitted_via from cfpb_complaint group by submitted_via order by Total_complaints desc;");
                    while(rs.next()){
                        c.add(new company_complaints(rs.getInt("Total_Complaints"),
                                rs.getString("submitted_via")));
                    
                    }
                    mv.addObject("name",c);
                    mv.addObject("tableName", n[0]);
                    System.out.println("executed");
                }
                
                
            }catch(Exception e){
                System.out.println(e.getMessage());
        }
        return mv;
    }
}

    