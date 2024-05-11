# Pwned Email
Definition : To be Pwned ("owned") is to have been the victim of a data breach
## Purpose of the app
This app allows it's users to check, wether or not there email has been in a data breach, check all the known data breach and learn how to protect yourself.

![Phone Screenshot 1](https://github.com/AlphaOmarDiallo/PwnedEmail/assets/73855044/ac391275-dd6c-48d0-b2fa-6b4d785479ce)
![Phone Screenshot 2](https://github.com/AlphaOmarDiallo/PwnedEmail/assets/73855044/f5f490d7-0a69-49ce-8e27-d59073d035db)
![Phone Screenshot 3](https://github.com/AlphaOmarDiallo/PwnedEmail/assets/73855044/0c6597db-7d98-4e13-90ec-c8c2a937b81c)
![Phone Screenshot 4](https://github.com/AlphaOmarDiallo/PwnedEmail/assets/73855044/ea7af68f-7caf-4ce2-9af4-8d3be71061f8)

## Data
The data comes from the [Have I been pwned](https://haveibeenpwned.com/API/v3) version 3. Here are the details of the subscription.
* Name : Pwned1
* RPM : 10
* Details : A rate limited key allowing 10 email address searches per minute, and searches of domains with up to 25 breached email addresses each.

## Getting Started
1. Clone the repository and open it in Android Studio.
2. Contact me to get the API key or subscribe to get an API key.
3. On the APP folder, create a file called secrets.properties and add PAWNED_EMAIL_API=THE_API_KEY.
4. Build the app.
5. Launch the app.

## Architecture
A attempt of clean architecture has been given for this app. The is a Data, DI, Domain and Presentation layer. 
The architecture type is [MVVM](https://developer.android.com/topic/architecture).

Folders inside the app package are organized like this: 
* Common : everything common to the App
  * Data
  * Di
  * Domain
  * Presentation
* Feature : every feature comes with it's own data, domain and presentation layer. Allows to just add it to a screen or remove it easily.
  * appintroduction
  * breachesregistered
  * breachlist
  * getallbreaches
  * secure
* Screens : screens are composed of features, they do hold a minimum or no logic.
  * breaches
  * home
  * secure

## GIT Structure
* Main : same level as the production app
* develop : where all the new feature are merged before publication
* Apart from Main and Develop, all other branch must be put in one of the following folder :
  * Feature : new features
  * Fix : all the fix
  * Version : an image of all the versions published

## Tech Stack
* Language : Kotlin
* UI : Compose
* Dependency Injection: Hilt Dagger
* Navigation : Jetpack Navigation
* Threading : Coroutines
* Http client : Retrofit
* Json : Moshi
* Database : Room
* Image loading : Coil
* Logs : Timber
* Monitoring : Firebase Analytics and Crashlytics

## Test
There are no test at the moment. Unit test will be done soon. 
The app UI is manually tested following a task list.

## Analysis and quality
Analysis and quality are monitored with Firebase. To get access, please contact me. 
The Pwned App project contains two app : 
* Pwned App : for the release app with the id com.alphaomardiallo.pawnedemail
* Pwned App debug : for the debug app with the id com.alphaomardiallo.pawnedemail.debug

### Analysis
Firebase analytics is used to get data about users interactions with the app.

#### Screen View

When accessed, all screens will send an even with a tag name.

#### Feature search breaches for an account

* When search is clicked
* If search is successful
* If search returns error

#### Feature get all breaches

* When loading starts
* If search is successful
* If search returns error

### Quality
All the crashes are monitored and treated in Firebase. Whenever a crash is fixed in release, ths issue is closed and the PR is added in comment.
For the debug app, there isn't really a strict policy. 
