# Create Users management software
User class: ID , name , username , password, email ,role, age

## Validation :

###  ID :

Cannot be null

###  name :

Cannot be null

Length more than 4

###  username : 

Cannot be null

Length more than 4

must be unique


###  password :

Cannot be null


###  email : 

Cannot be null

must be valid email 

must be unique


###  role :

Cannot be null

must be user or admin only


###  age

Cannot be null 

must be integer



Use project lombok - Validation - Service layer - Repository layer - Advise layer

### Endpoints : 
- Get all the Users 
- Add new User 
- Update User 
- Delete User
- Check if username and password are correct
- Get user by email
- Get All users with specific role
- Get All users with specific age or above
