# structure & architecture
##    auth-service:
 
    Spring Boot-based authentication service that provides token-based authentication for the RESTful API.
    It uses Spring Security and JWT tokens for authentication and authorization. The authentication service provides 
    endpoints for user registration, login, and token generation.(SpringBoot-Security-JWT)

##    rest-service:
    Spring Boot-based RESTful API that provides endpoints for accessing and manipulating data.
    It's secured with authentication provided by the auth-service. The RESTful API provides endpoints for 
    getting and modifying data.(FinalProject) 

##   client:
    React-based front-end application that interacts with the RESTful API to display and modify data. 
    It uses JWT tokens to authenticate with the RESTful API. The client provides a user interface for accessing 
    and modifying data.(finalprojeclient)
    
## endpoints:
### auth
***(POST) /api/auth/signup:*** This endpoint is used to register a new user by submitting their details such as name, email, and password.
***(POST) /api/auth/signin:*** This endpoint is used to authenticate a user and obtain a JWT token for subsequent requests.

### categories
***(GET) /categories:*** this endpoint is retrieving a list of categories. 

### product
***(GET) /product/{productId}:*** This endpoint is used to retrieve information about a specific product by its ID.
***(GET) /products/{categoryId}:*** This endpoint is used to retrieve a list of products in a specific category by its ID.

### Cart
***(GET) /cart/get/{userId}:*** Retrieves the contents of a user's shopping cart.

***(POST) /cart/add/{userId}/{productId}:*** Adds a product to a user's shopping cart.

***(POST) /cart/remove/{userId}/{productId}:*** Removes a product from a user's shopping cart.

***(POST) /cart/checkout/{userId}:*** Completes the purchase of the items in a user's shopping cart.

***(GET) /cart/purchased/{userId}:*** Retrieves a list of previously completed purchases for a user.

## database
![image](https://user-images.githubusercontent.com/49680162/233190932-6abe3bcb-6904-40a8-bacb-d2836202dc10.png)
 
postgresql has used in this project and this figure is diagram of tables.

# images from ui

![image](https://user-images.githubusercontent.com/49680162/233192129-9c0a7e7e-b058-47a9-89b4-08c28cd35c5f.png)


![image](https://user-images.githubusercontent.com/49680162/233192279-8ccb66ae-4762-469a-b22e-aaba4134782a.png)

![image](https://user-images.githubusercontent.com/49680162/233192626-8d57dac9-b0a7-4fc6-8c33-9acee195d170.png)

![image](https://user-images.githubusercontent.com/49680162/233192443-40077dcb-ac46-4992-83e2-c6454a82022e.png)

![image](https://user-images.githubusercontent.com/49680162/233192778-52035fe0-f94d-4a82-b137-1499cd32a31b.png)

![image](https://user-images.githubusercontent.com/49680162/233192844-2fbbae92-48a5-473d-8419-75418c1902d0.png)




    
