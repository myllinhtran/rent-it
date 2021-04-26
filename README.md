# Rentit

### Application
Rentit is a simple web application for renting vehicles.
* Can show all products ready for rent.
* Can create new products, update and delete them.
* Create add new users, edit and remove them.


### Prerequisites
The setups steps expect following tools installed on the system.
+ PostgreSQL 13.1
+ Github
+ Heroku

#### 1. Clone the repository

#### 2. Run the application locally

Visit the site at the URL: http://localhost:3000


#### 3. Deploy to Heroku

[Create a Heroku user account](https://signup.heroku.com/devcenter)
[Install the Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)
Login into your Heroku account:
```
$ heroku login
 ```

Initialize and commit your code to git
```
$ git init
$ git add .
$ git commit -m "Initial commit"
```

Deploy the app to Heroku
```
$ heroku create
$ git push heroku master
```

Visit the app in browser
```
$ heroku open
```



