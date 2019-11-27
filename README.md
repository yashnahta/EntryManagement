# Entry Management

Entry Mnagement Software for Innovaccer SDE Assignment

## Support Version

Min Sdk version supported is 16. The app has been tested on Android Phone running Android Pie.

## Setup

To install the app either open source code in **Android Studio** and build to run the app or install it directly with the **[Apk File](https://drive.google.com/open?id=1PUNinAsr_B9krhzVt66ubLZn8Uf_tHN1)**

Firebase Login credentials-

Email-firebase2911@gmail.com

Password-yashnahta291

## How It Works


The workflow is divided in 3 parts -


### 1.Check In-



When the user enters his details and checks in,the details are saved in **Firebase Database-**

<img src="Images/firebase1.png" width="400" >

Also **message** is sent to the **host** using the phones Messaging app Carrier Network-


<img src="Images/sms1.png" width="164" >


**E-Mail** is sent using JavaMail API in Android -[Port of JavaMail API](https://code.google.com/archive/p/javamail-android/)
We also need to Define a **JSSE**(Java Security Socket Extension) Provider.
Since our email sender is specialized for GMail, mailhost is hard coded. So, constructor takes only username and password to authenticate to SMTP server. In constructor, we define all the Properties used during the Session for which we get a default instance.
**E-mail** is sent to the **Host-**

<img src="Images/f2.png" width="350" >



### 2.Check Out-

When the user enters his details and checks out,the details are saved in **Firebase Database-**

<img src="Images/f4.png" width="400" >

Also an **E-mail** is sent to Visitor after user Checks out of the meeting-

<img src="Images/f3.png" height="400" >



### 3.Host-

**Host** Details can be changed in 2 ways-

1.Directly without any Validation.

2.Check for the password of the previous Host.

Depending on the requirements we can use any of the above.

## Tech Stack-
**Android Studio**
- **Java**
- **Xml**
- **Firebase**

## App ScreenShots-

**HomeScreen**

<img src="Images/s1.png" width="164" >


**Check In**

<img src="Images/s2.png" width="164" >


**Check Out**

<img src="Images/s3.png" width="164" >


**Current Host**

<img src="Images/s4.png" width="164" >


**Change Host**

<img src="Images/s5.png" width="164" >


**Validate Host**

<img src="Images/s6.png" width="164" >
