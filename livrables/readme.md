#Installation de l'application

Pour installer l'application, il suffit de déployer le fichier war sur le serveur.
Pour cela, vous avez juste à déposer le fichier war dans le dossier "webapps" de votre serveur. Il sera déployé
automatiquement par Tomcat.

#Personalisation de la connection à la base de données
Par défaut, l'application utilise la base de données attribuée à notre groue (team5).
Si vous voulez en utiliser une autre, il suffit de déclarer cette conenction sous forme de resource sur le serveur
et de lui conner comme nom : "mainApp" avec comme ContextPath : "/". Ainsi, la resource déclarée dans le war sera
écrasée par celle de votre serveur.

#Comptes utilisateurs
Une fois l'application lancée une première fois, Hibernate aura généré les tables. Pour ajouter des utilisateurs,
vous pouvez utiliser le fichier SQL "team5_schema_Employee.sql".
Voici les accès :  
username    / password  
general     / admin  
commercial  / azerty  
technical   / azerty  
customer    / azerty  

#Compilation à partir des sources
Si vous voulez recompiler le projet à partir du code source, il faudra copier le fichier 
WebContent/META-INF/context.xml.dist dans le même dossier et le renommer "context.xml".
Enfin, vous devrez remplir les informations de connexion à la base de donnée.

C'est le fichier qui défini la ressource de connexion à la base de données par défaut (si pas écrasé par d'autre
comme dans le point précédent).
