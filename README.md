# GUINDO BADARA ALIOU MSDIA FSM
### MASSAR 2100000017

# TP 5
# Application Web JEE avec Spring Boot

## Objectif
Créer une application Web JEE basée sur **Spring**, **Spring Data JPA**, **Hibernate**, **Thymeleaf** et **Spring Security** permettant de gérer des produits.


## 1. Création du projet avec les dépendances utiles

![](images/media/image1.png)
![](images/media/image2.png)

---

## 2. Création de l'entité `Product` avec les annotations Lombok

![](images/media/image3.png)
![](images/media/image4.png)

---

## 3. Test de la couche DAO

![](images/media/image5.png)
![](images/media/image6.png)

---

## 4. Configuration de `application.properties`

![](images/media/image7.png)

---

## 5. Résultat

![](images/media/image8.png)
![](images/media/image9.png)
![](images/media/image10.png)
![](images/media/image11.png)

---

## 6. Création d'une méthode dans le contrôleur Spring MVC

La méthode permet d'afficher la page `products` avec le mapping `/index` et d'envoyer la liste des produits à la page HTML via le modèle.

![](images/media/image12.png)

---

## 7. Ajout d’un bouton **Delete**

![](images/media/image13.png)
![](images/media/image14.png)
![](images/media/image15.png)

---

## 8. Ajout de la page `newproduct.html`

![](images/media/image16.png)

---

## 9. Ajout de la méthode `saveProduct` dans le contrôleur

![](images/media/image17.png)

---

## 10. Sécurisation de l'application avec Spring Security

On configure la sécurité de l’application Spring Boot à l’aide de Spring Security.  
La classe `SecurityConfig` définit :
- des utilisateurs en mémoire avec rôles (`USER`, `ADMIN`) pour simplifier les tests sans base de données,
- une méthode `securityFilterChain` pour restreindre l’accès :
    - `/index/**` autorisé aux utilisateurs avec rôle `USER`,
    - `/save/**`, `/delete/**` autorisés uniquement aux `ADMIN`,
    - toutes les autres requêtes nécessitent une authentification.

![](images/media/image18.png)

---

## 11. Création d’un formulaire de login personnalisé

![](images/media/image19.png)

---

## 12. Reconfiguration du logout

![](images/media/image20.png)

---


