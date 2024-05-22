To design a Grocery Booking API with responsibilities, i have followed a structured approach using Java, Spring Boot, and a relational database.
 Below are the API endpoints and their implementation outline.

Project Structure
grocery-booking-api/
|-- src
|--main/

 java/com/example/grocerybookingapi/
|-- controller
| -- model
|-- repository/
|-- service/
|-- resources/
|-- application.properties

|-- pom.xml


Added necessary dependencies in pom.xml


 Configuration
In --:: application.properties`:
 Can add database properties like url driver password details

Models and tables
Created the `GroceryItem` and `Order` entity class that persist data 

Controller service classes for calling the respective service to get and place order for user and admin roles

Also handled exception if any updation or deletion is happening without I'd param

Transaction annotations used for managing data in both table grocery as well as order if item is present 
Else rollback 

Repository mapping class for saving and getting details from database directly 
