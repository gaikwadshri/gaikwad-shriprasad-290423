Screenshot of all Test Cases
1.1 Get Customer information over an REST API call with any parameters
![Screenshot (3)](https://user-images.githubusercontent.com/132081954/235354734-18e8416b-5bcc-476c-9e7f-7b1086a7cf1b.png)


1.2  For mobile number only exact match data provided
![Screenshot (4)](https://user-images.githubusercontent.com/132081954/235354739-f63dc883-27a6-45f8-bc71-a47d71bf5ee2.png)



2. Ability to create a new customer over REST API.
    * Third party application should be able to create a customer using REST API.
    * Customer should be only created if the mobile number is not already present in DB.
    * If there is any error while creating the Customer appropriate message should be returned in response.
    * For example lets say if we already have a mobile number in system and request is received for same mobile number then in response we should get 500 status with message "Unable to create Customer. Mobile number already present.".
3. Modify the application to support multiple mobile number for a single customer.
    * Currently application supports only one mobile number but client wants the ability to store multiple mobile number.
    * That means a customer can contain at least one or multiple mobile numbers.
    * Once a user fetches customer using REST API all the mobile numbers should be returned along with Customer details.
4. Modify the application to be able to save a customer with multiple mobile number over REST API
    * Ability so that a **new** customer having one or multiple mobile number can be saved. This is similar to requirement 2 but now that multiple mobile numbers are supported that will change.
5. Ability to delete over REST API
    * There should be a way to delete a customer by using mobile number.
6. Ability to update mobile number for an existing customer.
     * Ability so that for an **existing** customer a mobile number can be added.
     * There should be a way to delete a mobile number from an **existing** customer.
