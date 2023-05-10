# Labo Todolist basique
 
## Conditions préalables

- POO avec Kotlin
  -Architecture 3 niveaux
- Repository Design Pattern
  - The idea with this pattern is to have a generic abstract way for the app to work with the data layer without being bother with if the implementation is towards a local database or towards an online API.
    - [Repository Design Pattern](https://medium.com/@pererikbergman/repository-design-pattern-e28c0f3e4a30)
    - [Repository Design Pattern for Data Access in Software Development](https://psid23.medium.com/repository-pattern-for-data-access-in-software-development-4c10aa9604da)
- ViewBinding
- UI
  - ToolBar
    - https://www.daniweb.com/programming/mobile-development/tutorials/537009/android-native-how-to-add-material-3-top-app-bar

- Navigation


## Travail à faire

- Création du projet à l'aide de deux activités
  - Sans utiliser 
    - ViewModel

## Travail à faire : version 2
- Possibilité de changer le LayoutManager de RecyclerView
- Utilisez DataBinding au lieu de ViewBinding
- add setTimestamp and setPriority to task_view

## Les étapes de réalisation.

- Création du projet vide
- Configuration du projet
- Création des classes
  - TaskDao
  - TaskEntry
  - TaskRepository

- Création de l'activité : MainActivity
- Création de l'activité : TaskFormActivity

## Configuration du projet



### Configuration de ViewBinding 

````conf
    buildFeatures {
        viewBinding = true
    }
````

## Création de classes d'entités

## Création de l'activité : MainActivity

## Création de l'activité : TaskFormActivity

## Prototype - simple
- ViewModel
- RecyclerView
- POO
- Repository Pattern
  
## Prototype - Basic
- Material Design
- ViewModel
- LiveData
- ROOM

## Prototype - Standard
- MVVM architecture
- Dependency Injection
- UnitTest


## Les références
- [Android Fundamentals in Kotlin Starter Apps](https://github.com/google-developer-training/android-kotlin-fundamentals-starter-apps)
- [Android Fundamentals in Kotlin Solution Apps](https://github.com/google-developer-training/android-kotlin-fundamentals-apps)
- [Repository Design Pattern](https://medium.com/@pererikbergman/repository-design-pattern-e28c0f3e4a30)
- [Google Developer Training](https://github.com/google-developer-training)
