# Getting Started

## Build & Test Project

### 1. Build Project

from the root folder

    gradlew build

### 2. Run Project

    gradlew bootRun

    Launch the swagger URL
    
    http://localhost:9000/swagger

####  2.1 Endpoints
    
    Get Summary or Aggragate of Payments
    http://localhost:9000/api/v1/payment?page=1&limit=2
    
    Get Detailed Payment Summray of Parent PaymeentId
    http://localhost:9000/api/v1/payment/1/detail


### 3. Test Project
    Added integrarion Tests for the code

### 4. Code Coverage
    93%. will try to run this through Github Action
    
### 5. Deployment : Github Actions
    Will deploy the SpringBoot into Heroku suing Github Actions along with Code Coverage
    
    Local deployed through Heroku CLI 
    https://polar-reef-19446.herokuapp.com/swagger

    Will try the Github Actions also for CI/CD
