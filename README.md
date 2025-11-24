🏗️**Architecture Microservices – Projet To-Do**

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

Ce Projet ne se limite pas à un simple CRUD, je suis en train de construire une architecture distribuée composé d'un service d'authentification, un service de gestion des tâches et d'un service de notifications, chaqun est indépendant avec sa propre base de données et exposé via un API Gateway et Eureka pour la découverte des services.

<img width="527" height="561" alt="Diagramme sans nom drawio" src="https://github.com/user-attachments/assets/ddd30d37-5e2a-46f6-b98a-80a79e8f6623" />

📅 <span style="color:orange">***Roadmap des Sprints – Projet Microservices To-Do***</span>

## 🏁 Sprint 0 – Initialisation du projet

### 🎯 Objectifs
- Mise en place le dépôt GitHub (`todo-microservice`)
- Création de la structure du microservice `task-service`
- Configuration des branches principales (`main`, `develop`)
- Création de la base de données `taskdb`
- Développement des couches principales :
  - **Entity** : `Task` (modèle de données)
  - **Repository** : `TaskRepository` (interface JPA)
  - **Service** : `TaskService` (logique métier CRUD)
  - **Controller** : `TaskController` (endpoints REST)
- Test des méthodes CRUD avec **Postman**

### ✅ Réalisations
- [x] Initial commit : `Projet task-service CRUD`
- [x] Création des branches `main` et `develop`
- [x] Base de données `taskdb` opérationnelle
- [x] Endpoints CRUD testés avec Postman :
  - **Create** → `POST /tasks`
  - **Read** → `GET /tasks/{id}`
  - **Update** → `PUT /tasks/{id}`
  - **Delete** → `DELETE /tasks/{id}`

---

## 🔹 Sprint 1 – Service Tâches : Documentation & Tests

### 🎯 Objectif
Finalisation du Service Tâches avec une documentation claire et des tests unitaires.

### 📌 Issues
- [x] [#1] `feature/doc` → Rédaction du README  
- [x] [#2] `feature/swagger` → Ajout Swagger/OpenAPI pour documenter l'API  -> La documentation interactive est disponible sur [Swagger UI](http://localhost:8082/swagger-ui.html) grâce à Springdoc OpenAPI.
- [x] [#3] `feature/tests` → Écriture des tests unitaires pour TaskService  
- [x] [#4] `feature/validation` → Ajout validation des données (`@NotBlank`, `@Size`)

 


    

### 📦 Livrables
- README
- Swagger
- Tests unitaires
- Validation des données

---

## 🔹 Sprint 2 – Industrialisation

### 🎯 Objectif
Préparer le projet pour le déploiement et l’intégration continue.

### 📦 Livrables
- Dockerfile  
- docker-compose  
- GitHub Actions (CI/CD)

---

## 🔹 Sprint 3 – Architecture Microservices

### 🎯 Objectif
Étendre le projet vers une architecture distribuée.

### 📦 Livrables
- Service Auth  
- Service Notifications  
- Eureka Server  
- API Gateway  

---

## 🔹 Sprint 4 – Déploiement Cloud

### 🎯 Objectif
Déployer et finaliser la présentation du projet.

### 📦 Livrables
- Déploiement Oracle/AWS  
- Diagramme d’architecture  
- README bilingue final
