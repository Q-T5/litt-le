# LITT-LE README
## ABOUT THE PROJECT
 - **Project Title**: Litt-le
 - **Project Developer**: Bikathi Martin
 - **Project License**: Apache2.0 License
 - **Languages**: Java, JavaScript, HTML5, CSS3
 ## PROJECT DEFINITION 
 ### PROJECT VISION
 The core vision of the project is to **develop a simple, self-hostable URL shortening application** in as few lines of code as possible(under 1000).  The service should function the same way as _Bit.ly_(S.P) but serve only one purpose:
 <u>to shorten and persist shortened URLs for the user hosting it.</u>
 ### PROJECT INSPIRATION
 The idea and inspiration to create this project comes from a long-time desire to become an independent internet user, and to develop software that, <u>Does One Thing And Does It Well</u>. In regards to the first mentioned goal, this project is one in a line of others code named <u>Project Mephitis</u>\*. This project aims to develop a suite of fully free, open source, self-hosted applications that reduce dependence on third-party services, tools and subscriptions, all while keeping your personal data all to yourself.
 > A <u>Mephitis</u> is the scientific name for a skunk(_Mephitis_ mephitis). Scientists believe skunks to be one of the most independent animals in the world, needing no packs or groups in order to ward of predators or survive.
 ### PROJECT SAMPLE USAGE
 This short video clip shows how the UI of the project works and how to use the app to shorten your own URLs and use them in real life in your browser(or any app that supports shortened URLs) 
 
 [Sample_Video](https://user-images.githubusercontent.com/98804363/210074874-2a40fdad-a70b-43b4-a574-93874d7491cc.webm)
 ### INSTALLATION GUIDE
 > This guide was written with VPS or self-hosting users mind, and also with a preferential bias towards the Linux space.  
 #### 1. Pre-Requisites
 Before proceeding, ensure you have each of the following installed(as all projects in the Mephitis code base will use these):
 - Java JVM/JDK- Version 17+
 - Apache Maven- Version 3.6+
 - MySQL Database- Version 8+
 #### 2. Procedure
 1. From the releases section of this repo download the latest version of the Litt-le project. It is downloaded as a jar file.
 2. **With all pre-requisites** installed, head over to whatever directory the project was installed on and run the command below to install dependencies and start up the application:
```
java -jar {project-name-version}.jar
```
The project should startup with a console prompts similar to these:
![Project-Startup](https://github.com/Q-T5/litt-le/blob/main/gallery/project-startup.png)
3. Open your browser and head over to **localhost:8080/** and you should see a page similar to the one shown in the sample video above. Now you can go ahead and test the app by shortening any link and using the shortened link to visit the page from another tab.
4. To kill the app simply press `ctrl+c` on your keyboard or close your termimal window.
5. Now that you have the project up and running, you can always have it run as a background service by running the following command on Linux:
```
nohup java -jar {project-name-version}.jar &
```
***
This way allows you to close the terminal and still have the app running as a background service with an output similar to this:
![Background-Service](https://github.com/Q-T5/litt-le/blob/main/gallery/background-service.png)
***
To kill the background service, simply run:
```
killall java
```
### Suggested Actions
- Consider setting up the app to start as a background service each time your computer starts.
- Check the MySQL database to see how the URLs are being persisted.
- Change the code to suit your own needs, its free and entirely open source.
## SUPPORT
To support this and other cool projects that I spend time working on, kindly consider donating via PayPal. Your kindness is appreciated.
[Donate To Bikathi Martin](https://www.paypal.com/donate/?hosted_button_id=X96ET3EGU2BNJ)(jCreator on PayPal)
