# Table of contents
1. [Title](#assignment)
2. [Feature](#features)
3. [Tech](#tech)
4. [Usage](#Usage)
5. [References](#references)
6. [Development](#development)

# Assignment (Andorid App)

This repository contains a sample app that fetches pictures from the [Shutterstock API](http://api.shutterstock.com/) and displays them in an infinite scrollable view.

## Features

- Fetche pictures from the [Shutterstock API] and displays them in an infinite scrollable view.
- The search endpoint of Shutterstock is used for fetching images.
- The new pictures will be fetched and shown when the user scrolls to the end of the list.

The main focus is on a highly performant app (smooth scrolling & lag-free UI)

## Tech

App is implemented by using following:

- [Kotlin language] - used because it is the modern and concise programming language for Android app development.
- [MVVM Architecture Pattern] - used because it is recommended pattern for app development and assures good quality testing and maintenance of code.
- [Paging library] - used for smooth scrolling and lag-free UI. It loads partial data on demand, reduces usage of network bandwidth and system resources.
- [Hilt Dagger (Dependency Injection)] - used because it provides a standard way to incorporate Dagger dependency injection into an Android application and also recommended by Google.
- [RX Java] - It provides a standard workflow that is used to manage all data and events across the application.
- [Espresso] - It is a testing framework for Android to make it easy to write reliable user interface tests.

## Usage

If you want to run this application, do the following steps.
- Create an account and sign in here [Shutterstock].
- Go to [developers page] and create an app.
- Generate Token and copy the token.
- place your own *TOKEN* in **local.properties** file as below.
  > `apiKey=YOUR_TOKEN`



## References

Shutterstock API documentation is here: https://www.shutterstock.com/developers/documentation.

## Development

Want to contribute? Great!


[//]: # (These are reference links used in the body of this note.)

[Shutterstock]: <https://accounts.shutterstock.com/>
[developers page]: <https://www.shutterstock.com/account/developers/apps>
[Kotlin language]: <https://developer.android.com/kotlin>
[Shutterstock API]: <http://api.shutterstock.com/>
[MVVM Architecture Pattern]: <https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide>
[Paging library]: <https://developer.android.com/topic/libraries/architecture/paging/v3-overview>
[Hilt Dagger (Dependency Injection)]: <https://developer.android.com/training/dependency-injection/hilt-android>
[RX Java]: <https://github.com/ReactiveX/RxJava>
[Espresso]: <https://developer.android.com/training/testing/espresso>