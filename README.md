# Entry Management
Entry Mnagement Software for Innovacer SDE Assignment

# Prerequisites
Min Sdk version supported is 16. The app has been tested on Android Phone running Android Pie.

# How It Works
# Check In-
When the user enters his details and checks in,the details are saved in Firebase Database-
![Database](firebase1.png)

Also message is sent to the host using the phones Messaging app Carrier Network-

![Database](sms1.png)

E-Mail is sent using JavaMail API in Android -[Port of JavaMail API](https://code.google.com/archive/p/javamail-android/)
We also need to Define a JSSE(Java Security Socket Extension) Provider.
Since our email sender is specialized for GMail, mailhost is hard coded. So, constructor takes only username and password to authenticate to SMTP server. In constructor, we define all the Properties used during the Session for which we get a default instance.

![Database](f2.png)

# Check Out-
When the user enters his details and checks out,the details are saved in Firebase Database-

![Database](f4.png)

Also an E-mail is sent to Host post the meeting-

![Database](f3.png)
