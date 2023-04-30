
### Requirements
1. Get Customer information over an REST API call
    * Any third-party application should be able to get Customer related information in JSON format.
    * The third-party should be able to request either all customer or filter information using any or all of the parameters like first name, last name and mobile number.
    * First name and Last name should be able to return result which partially match. Example if we have a user with first name Kathy then if we get request using first name filter criteria as "Kat", "aTHY" or "Ath" then Kathy should be returned.
    * For mobile number only exact match should be returned.
    * Do not use native SQL only use JPQL or HQL.

![Screenshot (3)](https://user-images.githubusercontent.com/132081954/235352577-765ba2dc-6dd1-40d1-a8c2-c3339749831c.png)



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
