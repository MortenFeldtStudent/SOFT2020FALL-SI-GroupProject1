### SOFT2020FALL-SI-GroupProject1
**[Assignment Link](https://datsoftlyngby.github.io/soft2020fall/resources/473f0f56-MP1-WS.pdf)**  
***
#### Author's details
**Team 8**  
Jörg Oertel & Morten Feldt
***
#### Brief Summary
This project system regards a person service, which have basic person information stored in DB like **full name**, **year of birth** and **zip code**.
These person information is getting by a **RESTful service**.   
When make a GET request for details, this service will call an **RMI Registry** to calculate age of person based on year of birth and a **SOAP web service** to get the town and country for the giving person zip code.
***
#### Installation instructions
1. Clone GitHub project
2. Run **Groupproject1Application** in package **dk.si.groupproject1**
2. Run **Registry** in package **dk.si.groupproject1**
***
#### User instructions
***We recommend to use PostMan for instructions below***
1. GET http://localhost:8080/persons/2/summary
2. GET http://localhost:8080/persons/2/details (NOTICE, that details give you **age**, **town** and **country** for the person with the given id)
3. POST http://localhost:8080/persons/  
**Header**  
Content-Type | application/json  
**Body**  
{  
    "fullName": "Morten FeldtTEST-3",  
    "yearOfBirth": 1984,  
    "zipCode": 2500  
}  
4. PUT http://localhost:8080/persons/2  
**Header**  
Content-Type | application/json  
**Body**  
{  
    "fullName": "Morten FeldtTEST",  
    "yearOfBirth": 1984,  
    "zipCode": 2500  
}
5. DELETE http://localhost:8080/persons/2
***
