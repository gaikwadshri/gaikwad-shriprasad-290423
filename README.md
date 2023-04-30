Screenshot of all Test Cases

1.1 Get Customer information over an REST API call with any parameters
![Screenshot (3)](https://user-images.githubusercontent.com/132081954/235354734-18e8416b-5bcc-476c-9e7f-7b1086a7cf1b.png)


1.2  For mobile number only exact match data provided
![Screenshot (4)](https://user-images.githubusercontent.com/132081954/235354739-f63dc883-27a6-45f8-bc71-a47d71bf5ee2.png)

2 Ability to create a new customer over REST API.
    2.1 . Feature provided that third party application able to create a customer using REST API.
![Screenshot (17)](https://user-images.githubusercontent.com/132081954/235355832-9f9299ff-c742-4ece-9631-18539f7f9dc9.png)


2.2 Exception provided with response 500 status that the Customer should be only created if the mobile number is not already present in DB 
![Screenshot (5)](https://user-images.githubusercontent.com/132081954/235355798-c8f0625e-89dd-4e1a-9fdc-9d088bfd13e7.png)  
 2.3 If the mobile number is larger than 10 then also excpetion provided 
  ![Screenshot (6)](https://user-images.githubusercontent.com/132081954/235355811-0cbfa541-b6d0-4104-addf-45f1ed25e23a.png)
   
3. Application modifed to support multiple mobile number for a single customer.
   ![Screenshot (7)](https://user-images.githubusercontent.com/132081954/235355280-76ffad02-41af-444f-955c-326aaa90339e.png)
   
   

   4.1 Application modifed to be able to save a customer with multiple mobile number over REST API

   ![Screenshot (8)](https://user-images.githubusercontent.com/132081954/235355349-35262a2f-6131-4eff-9b66-03a7f651f87d.png)
   
   4.2 Check provided to all the mobile number present in the New Customer 
   ![Screenshot (9)](https://user-images.githubusercontent.com/132081954/235355362-0e97e9ae-c02d-4ebc-8837-6bf0963d8e8f.png)
      
      
      5 Provided ability to delete over REST API
        ![Screenshot (10)](https://user-images.githubusercontent.com/132081954/235356171-fd5657dc-c0f8-45ba-9e56-3a71d3628209.png)
6 Ability to update mobile number for an existing customer.
     * 6.1  Ability so that for an **existing** customer a mobile number can be added.
     ![Screenshot (11)](https://user-images.githubusercontent.com/132081954/235355534-7ea43b3f-a2ce-46d2-ab7e-2e009f3ca7f5.png)

     ![Screenshot (12)](https://user-images.githubusercontent.com/132081954/235355520-9772088c-be40-4324-899e-59d2adedff20.png)

     
     6.2 Provision give to delete the mobile number from existing customer
     
      ![Screenshot (13)](https://user-images.githubusercontent.com/132081954/235355540-e876dc8e-9671-475a-9b9e-ed6be93f334e.png)
      
      ![Screenshot (14)](https://user-images.githubusercontent.com/132081954/235355598-f3069a04-ef22-4051-bb31-ee700733a6e3.png)
     6.3 Exception Provided if some one try to delete mobile number which is not present in the database
      ![Screenshot (15)](https://user-images.githubusercontent.com/132081954/235355612-6d262115-d333-4127-a935-9be7a2b0e03a.png)    
     6.4 Exception provided if the customer have only one mobile number and customer try to delete this mobile number 
    ![Screenshot (16)](https://user-images.githubusercontent.com/132081954/235356221-2d84084b-3a21-467b-a9b0-b3d85156b657.png)

