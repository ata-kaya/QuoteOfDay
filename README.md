
# Quote of the Day App

The Quote of the Day app is an Android application that displays a motivational or insightful quote each day. The app is designed with a focus on modern Android development practices, utilizing MVVM architecture, Jetpack Compose, and various powerful libraries for a clean and maintainable codebase.



## Features

- **Daily Quotes**: Fetches a new quote each day from a remote API.
- **Favorites**: Save your favorite quotes for easy access.
- **Modern UI**: Built with Jetpack Compose for a smooth and dynamic user interface.
- **Clean Architecture**: Separation of concerns with MVVM and Clean Architecture patterns.
- **Offline Support**: Quotes are stored locally using Room, allowing access even when offline.

## Architecture

This project follows the MVVM (Model-View-ViewModel) architecture pattern combined with Clean Architecture principles. It is divided into three layers:

- **Presentation Layer**: Contains UI code written in Jetpack Compose and ViewModels for handling UI-related data.
- **Domain Layer**: Contains business logic, including use cases that coordinate interactions between the Presentation and Data layers.
- **Data Layer**: Manages data sources, including Room database and remote API calls through Retrofit and OkHttp.

## Libraries and Tools

- **Kotlin**: The programming language used for the app.
- **Jetpack Compose**: Modern toolkit for building native Android UIs.
- **Navigation Component**: Manages navigation between different screens in the app.
- **Room**: Local database for storing favorite quotes.
- **Koin**: Dependency injection library used to manage dependencies.
- **Retrofit**: HTTP client for making API requests.
- **OkHttp**: Networking library used as an HTTP client for Retrofit.
- **RapidAPI**: Provides the API from which quotes are fetched.

## API

The quotes are fetched from the [RapidAPI.com](https://rapidapi.com) API. Ensure you have your API key configured before running the app.

## Getting Started

### Prerequisites

- Android Studio Flamingo or later
- Kotlin 1.9.x or later
- API key from [RapidAPI.com](https://rapidapi.com)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ata-kaya/QuoteOfDay.git
   ```

2. Open the project in Android Studio.

3. Add your RapidAPI key to the `local.properties` file:

   ```properties
   RAPID_API_KEY=your_api_key_here
   ```

4. Build and run the app on your device or emulator.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
