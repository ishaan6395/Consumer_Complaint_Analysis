
alter table subproduct
add constraint fk 
foreign key(product_ID) references product(product_ID);

alter table subissue
add constraint fk1
    foreign key(issue_ID) references issue(issue_ID);
    
alter table customer
add constraint customerfk
foreign key(zip) references location(zip)    ;


alter table cfpb_complaint
add constraint cfpb_complaint_FK
foreign key(product_id) references product(product_id);

alter table cfpb_complaint
add constraint cfpb_complaint_FK1
foreign key(subproduct_ID) references subproduct(subproduct_id);

alter table cfpb_complaint
add constraint cfpb_complaint_FK2
foreign key(issue_ID) references issue(issue_id);

alter table cfpb_complaint
add constraint cfpb_complaint_FK3
foreign key(subissue_ID) references subissue(subissue_id);

alter table cfpb_complaint
add constraint cfpb_complaint_FK4
foreign key(company_ID) references company(company_id);

alter table company_response
add constraint cr1
foreign key(complaint_ID) references cfpb_complaint(complaint_ID);

alter table company_response
add constraint cr2
foreign key(company_ID) references company(company_ID);

alter table company_location
add constraint cl1
foreign key(company_ID) references company(company_ID);

alter table company_location
add constraint cl2
foreign key(zip) references location(zip);