# MobileChallenge
![Alt text](https://cdn-bkbcj.nitrocdn.com/xXGyDftZNTJakTYAyusNDmbcdztlQjmL/assets/images/optimized/rev-749eaa2/wp-content/uploads/2017/06/Mobile-App-developers.jpg "Mobile Challange")

Besides providing exceptional transportation services, Also runs a physical store which sells Products.
Api Reference: https://gist.githubusercontent.com/palcalde/6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/Products.json

# Third-party libraries used

**DI:**
* Dagger Hilt

**Testing:**
* Junit
* Espresso
* Robolectric
* Hamcrest

**Ui:**
* Jetpack Compose

**Comunication:**
* UI State
* Coroutines
* Flow

**Rest connection(Remote):**
* Okhttp 3
* Retrofit 2
* Chucker

**DB(Local)**
* Room
* SQL Lite

**Other:**
* Google Splash Screen
* Google
* Timber
* Test
* Constraint Layout
* Lazy Column
* Materials
* SwipeRefreshLayout


# Project structure

This app has been developed in Kotlin language.

It uses MVVM pattern and has been designed to be modular and scalable, being able to add new features or remove existing without need to change code or break any dependency created. Also implements adaptive icons.

App layers are:

* **App** Launcher
* **Presentation layer:**  UI, ViewModel
* **Domain layer:** Use Case & Business model
* **Data layer:** Local, Remote, models(local - DB, remote - API) & repository
* **Core:** Framework, Utils, Constants, Component, Theme, Test Utils, Providers

# Description

This app has been designed to show a list of random users fetched from https://randomuser.me and allow the user to add them to favorites, saving them in local storage using Room DB. It also has dark and light mode and language selection