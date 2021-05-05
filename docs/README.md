# Android Boilerplate

This is an android boilerplate project I will be using to test different libraries and architectures.
The purpose of this project is mainly to practice and try different ideas and approaches to various Android architectures, libraries for dependency injection, async data handling, among others.

## Current Features
- Fetches a list from an API
- Uses a simple loading animation
- Uses a custom chip filtering system (categories)
- ListAdapter (DiffUtil)
- Coroutines
- MVVM Architecture

## TODO List
- Add lottie animations for loading
- Cache and data persistence using room
- Add images using Glide/Picasso
- Add the new Android navigation component
- Implement and test coroutine flows
- Try MVI architecture in a different module

## Libraries Used
- [Dagger Hilt](https://dagger.dev/hilt/) - Simpler dependency injection built on top of Dagger
- [Coroutines](https://developer.android.com/kotlin/coroutines) - Concurrency design pattern for asynchronous code
- [Retrofit](https://square.github.io/retrofit/) - HTTP API client for Android
- [GSON](https://github.com/google/gson) - Convert Java objects into their JSON representation and vice-versa
- [ktlint](https://github.com/pinterest/ktlint) - Kotlin linter and built-in formatter

## License

    Copyright 2021 Jack Yang Huang

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.