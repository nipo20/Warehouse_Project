# warehouseapi_2025

A RESTful API is developed to manage the inventory of Articles, Products and Pricing.

**Installation**

Any IDE of your choice Intellij or VS . It is a maven based Project.JDK 17 used for developing the API.

Open project through IDE

**Commands to run**

_--mvn clean install_

**Configuration**

Application is self-contained. H2 database has been used for DB service.

**Run the application**
To start the server:

_--mvn spring-boot:run_

Database Connection
H2 DB has been used to generate tables and details.

url: https://localhost:8081/h2-console
username:sa
password:password

The API will be available at http://localhost:8081

API Endpoints

##GET method

http://localhost:8081/article

http://localhost:8081/product

http://localhost:8081/price

To get all items in the table

http://localhost:8081/articles

http://localhost:8081/products

http://localhost:8081/prices

##POST Method

http://localhost:8081/article

http://localhost:8081/product

http://localhost:8081/price

##PUT Method

http://localhost:8081/article/{article_Id}

http://localhost:8081/product/{product_Id}

http://localhost:8081/price/{product_Id}

##DELETE Method

http://localhost:8081/article/{article_Id}

http://localhost:8081/product/{product_Id}

http://localhost:8081/price/{product_Id}

NEXT STEPS

Unit testing framework to be developed.

Current testing has been done using postman to check the endpoints.

Sample Data:

Articles:

Post Method:

{

"article_Id": 110,

"article_Name": "Knife stand",

"stocks": 582,

"products": null
},

{

"article_Id": 111,

"article_Name": "Kitchen towel",

"stocks": 581,

"products": null

}

Products:

Post Method:

{

"product_Id":5,

"product_Name": "växjo",

"article": [{"article_Id":"110"}]

}

Technology Stack

Java
Spring boot
Maven
REST API 











