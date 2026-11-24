1. Pourquoi /api/admin/** doit-il être déclaré avant /api/** ?
   Parce que Spring Security applique la première règle correspondante, donc la règle ADMIN doit être prioritaire pour protéger les accès administrateur.


2. Quelle est la différence entre 401 Unauthorized et 403 Forbidden ?
   401 signifie que l'utilisateur n'est pas authentifié, tandis que 403 signifie qu'il est authentifié mais n'a pas les autorisations nécessaires.


3. Pourquoi utiliser BCrypt au lieu de stocker les mots de passe en texte clair ?
   BCrypt permet de hacher les mots de passe pour protéger les données des utilisateurs en cas de fuite de la base de données.


4. Pourquoi les utilisateurs en mémoire conviennent-ils à cet exercice mais pas en production ?
   Parce qu'ils sont simples à configurer pour les tests, mais qu'ils ne sont pas conservés dans une base de données et ne sont pas adaptés à une application réelle.


5. Que faut-il pour charger les utilisateurs et les rôles depuis MySQL ?
   Il faut créer des tables pour les utilisateurs et les rôles, configurer la connexion MySQL et utiliser un repository avec Spring Data JPA pour récupérer les informations.