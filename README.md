# Manuel d’utilisation
 
## Les prérequis:

```
●JRE version 11, ou plus
●Un IDE compatible avec les projets Spring Boot
◦IntelliJ
◦Spring Tool Suite
◦Visual Studio Code
◦Eclipse
◦...
●Connexion internet, pour télécharger les
dépandances.
●Base de donnée : MySQL
◦Vous pouvez utiliser un autre, mais il faut spécifier
çà dans application.properties
```

## Préparation:

```
●Créez une nouvelle base de donnée qui s’appelle
tpterroir (ou n’importe quel nom, l’important est que
la base donnée est vide, pour que Spring Boot crée
les tables nécessaires)
●Accédez au fichier application.properties, puis
spécifiez les infos liés à votre base de donnée.
```
## Lancement de l’application:

Lancement de l’application dépend principalement de
l’outil de l’environnement.
Pour VS Code : <br/> 
●Installez l’extension Java by RedHat <br/> 
●Installez l’extension Maven <br/> 
●Installez l’extension Spring Boot Dashboard v
●Redémmarer VS Code <br/> 
●Lancer le projet en utilisant Spring Boot Dashboard
Pour les autres IDEs, vous trouverez comment dans
l’internet. <br/> 

Après le lancement, ouvrir le fichier DB.sql, puis
exécutez-le dans votre base de donnée pour créer un
compte administrateur : <br/> 
 Username : Admin <br/> 
 Password : Admin


## Comment utiliser l’application:

Ouvrez un navigateur, puis accéder à localhost:

### En tant qu’Admin:

Connectez à votre compte.

![1](https://user-images.githubusercontent.com/75063008/197336335-aa163fcf-c55c-43bb-ba09-c9ba3987f142.jpg)

![2](https://user-images.githubusercontent.com/75063008/197336302-64403c21-3c63-481b-914d-61da333ee1ae.jpg)

Après, accéder à votre espace pour créer des matières premières et origines, afin de remplir votre base de donnée.
![3](https://user-images.githubusercontent.com/75063008/197336395-4597a3f3-1b13-4ac8-813f-2f96405cf741.jpg)

Remarque : Cet espace est accessible uniquement aux admins, les autres ne sont pas autorisé.

Cliquez sur le bouton pour créer un nouveau matière première

![4](https://user-images.githubusercontent.com/75063008/197336412-f7484228-6e9b-4fa0-abba-521fac927779.jpg)

Puis spécifier un nom de votre choix
![image](https://user-images.githubusercontent.com/75063008/197337270-0e5e08fc-d79c-4eb5-80ef-a23c989120d3.png)

 


Répétez ce procédure jusqu’à vous aurez beaucoup des matières premières.
Appliquez la même procédure avec les origines.

À la fin : nous avons des matières premières & origines.

Laissez le navigateur ouvert, on va l’appeler le navigateur admin.
Ouvrez un autre navigateur qu’il va être considéré navigateur client.

### En tant que coopérative:

Créer un compte.
![5](https://user-images.githubusercontent.com/75063008/197336418-a9718c7f-480c-41d5-8d74-285d8068750c.jpg)
 


Après la création, connectez au compte créé. Puis cliquez sur devenir un coopérative pour demander être coopérative.

![6](https://user-images.githubusercontent.com/75063008/197336439-53f1e2cf-3bde-442e-ba23-070ef9766154.jpg)
 

Remplissez les infos de votre coopérative.

![7](https://user-images.githubusercontent.com/75063008/197336450-98addfd1-0d42-4914-8064-4eb7376c383c.jpg)
 

Remarque : Les secteurs d’activités sont décrit dans le fichier entities.enumerations.secteurActivite


Revenez au navigateur Admin, puis allez à l’espace Gérer les coopératives.

![8](https://user-images.githubusercontent.com/75063008/197336479-684bf873-24e5-4600-bc2f-26d8294221ec.jpg)

Dans cet espace, vous trouverez tous les demandes d’être coopérative, en tant qu’Admin, accepter la demande.

![9](https://user-images.githubusercontent.com/75063008/197336493-4e8cb243-850c-4831-ba10-9750ec04c20f.jpg)

Maintenant, le client a le rôle coopérative. Il peut gérer ses propres produits. Actualisez la page, puis accédez au l’espace Gestion du produit.

![10](https://user-images.githubusercontent.com/75063008/197336504-7aef4a7a-70f1-494d-99f3-031e718c75f5.jpg)


Dans la page, ajouter quelque produits à votre choix, n’oubliez pas de donner une image pour chaque produit.

Après la création, vous remarquez l’apparition de 3 boutons :

![11](https://user-images.githubusercontent.com/75063008/197336533-0cd2ddfa-8505-4119-af4d-2de439a5a4ed.jpg)


Le bouton :
 Associer : Permet d’affecter au produit, une matière
première avec nombre d’unités et l’origine. <br/> 
 Modifier : Permet de modifier les infos du produit,
par exemple, le nom, le prix... <br/> 
 Supprimer : C’est évident
Après la gestion, vous pouvez vérifier dans le magasin si
vos produits apparaissent ou non.


### En tant que client:

Accéder au magasin.

![12](https://user-images.githubusercontent.com/75063008/197336805-29d4bff7-130b-4542-afea-f3923747db6a.jpg)

Dans la page, vous trouvez tous les produits, en outre, il y
a la possibilité de filtrer selon un de ces 3 critères : <br/> 
 Catégorie <br/> 
 Matière première <br/> 
 Origine <br/> 

![13](https://user-images.githubusercontent.com/75063008/197336566-25bc0cad-d26e-4574-b5b5-962c96744746.jpg)


En tant que client, filtrez ce que vous voulez, à la fin, sélectionner un produit pour la voir.

![14](https://user-images.githubusercontent.com/75063008/197336555-a4a286f2-fac1-4acb-91a5-7f7a68183261.jpg)

Remarque 1 : L’application journalise chaque filtrage vous avez fait, vous la trouverez dans /logs/sortedProduit.log <br/> 
Remarque 2 : L’application journalise chaque produit
vous consulter, vous la trouverez dans /logs/popularProduit.log


Après, vous spécifiez le nombre à acheter.
 

Remarque : Le panier est basé sur les cookies, donc le client peut utiliser le panier même s’il n’est pas connecté.

À la fin, accédez au panier pour valider votre achat.


Pour acheter, le client doit impérativement se connecter.
Donc, créez un autre compte pour le client, ne vous en faites pas, votre panier ne va pas être écrasé.
Revenez au panier, puis achetez.

Après le clic, l’application vous rediriger vers la page d’accueil, donc la commande a été passé au coopérative.
Revenez au navigateur du coopérative, puis accédez à l’espace Suivre commandes clients.

Dans cet espace, en tant que coopérative, vous êtes le responsable à délivrer les achats aux clients.

Vous trouverez toutes les infos de l’achat.

![15](https://user-images.githubusercontent.com/75063008/197336577-391e96ba-b244-4d92-a938-442b2565c65f.jpg)

Si vous avez bien délivré la commande, cliquez sur le checkbox.

![16](https://user-images.githubusercontent.com/75063008/197336600-25cb81e0-f5dc-48db-a87f-b11b36b0ab7c.jpg)

# Diagramme de classe
![alt text](https://github.com/Bsoulmindy/mini-projet/blob/master/classDiagram.jpg?raw=true)
