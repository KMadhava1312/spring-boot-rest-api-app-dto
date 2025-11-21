This Spring Boot project demonstrates a complete end-to-end implementation of CRUD (Create, Read, Update, Delete) operations using MySQL as the database. It follows a clean, layered architectural pattern and includes DTO (Data Transfer Object) pattern to separate internal entity models from external API contracts.

The application uses the following flow:

Postman Request → Controller → Service → DTO Mapper → Repository → Database


Sample Json requests :
post : http://localhost:8080/api/account/create
          {
            "accType": "Savings",
            "openingDt": "2025-11-20",
            "openingBal": "50000.50",
            "ifscCode": "SBIoo0001234",
            "accStatus": "Active"
          }
          


Summary : 

🎯 Why DTO Pattern Is Added
          Prevents exposing sensitive data 
          Allows partial fields in request/response
          Improves security , performance of api
          Makes APIs stable even if entity changes
