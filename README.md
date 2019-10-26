
# USYD Message Board (ELEC5619)
## Users
### Login
The username and password must be correct, otherwise there will show “User does not exist!”.

### Registration
Username must be unique, it will be used once user need to login the website that will not show on the website. Password must be 8 digit which can be edited in Account Setting, once the user needs to change the password, he will need to double confirm it.The Email address must be Usyd Email address (@uni.sydney.edu.au).The system will not display the gender by default, the user can change gender option or just leave it.

### User profile
Users can edit the account password, change the profile photo (the system will automatically create a profile photo for users or they can DIY the photo by purchasing Redemption Code). Users also can edit the nickname and motto (If users do not do any change in motto, then the system will automatically show “I am an empty person.”)

### Search Bar 
For users searching topic (Unit code), if it does not in the system, the website will show “Topic doesn’t Exist.” Discussion board Search Bar is for users searching comments. It will show “No Such Thread!” if the comment doesn’t exist.

### Topic List 
Users can see all topics (Unit code) on the main page. The web staff can use the staff page to add or delete the topic and the main page will search the database and show all valid topics. It uses the iframe to make the page looks unified.

### Thread List
When users click into a certain topic they can see comments of other users about this topic. They can choose to comment on certain threads or create a new thread themselves. It uses the iframe to make the page looks unified.
### User Authentication
When the page loading, it will check the users’ cookies if the cookie doesn’t exist it will pop up an alert box to ask users to log in first which means users cannot use the URL to go to a certain page directly.
## Administrant
### Add topic
Admin can use add topic function to add topics in the system database. The topic name and description must be detailed, otherwise, there will have a notification. If the topic that wants to be added has already existed in the system, the system will notify about the repeat.
 
### Check
Admin can check all the topics and replies on the check page, they do not need to shift to general user web page.
 
### Delete 
On the delete page, all the topics and users will be shown on it. Admin can use the selection box to choose one or more topics or users to delete, once the topic or user has been deleted all the relevant comments will be automatically deleted as well. Once the admin takes the action of delete, there will show the confirm notification to avoid deleting incorrectly.


## Configuration

### Tomcat
This project uses html as its front end display language instead of using jsp. Hence we need you use the specific Tomcat server we provide to run this project. 
The Tomcat server files are contained in the project folder:

Path: {local path}/webproject/apache-tomcat-9.0.27 

The deployment configuration should be as the following image shows:



### SQL connection

Our project use Google Cloud SQL Database, hence we provide a test account for new user to visit the database with local IP.

Step 1: Login with the test Google account
Account: testcomp5619@gmail.com 
Password: Tester1234
Step 2: Visit http://ip4.me to get the local IP4 address

Step 3:  Visit Google Cloud Platform
https://console.cloud.google.com/sql/instances/webproject/overview?project=webproject-9f90f&authuser=1&duration=PT1H

Step 4: Choose CONNECTIONS tab


Step 5: Add your IP4 here and save


Then you can start to run the website in localhost, enjoy.


