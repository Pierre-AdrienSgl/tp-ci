# tp-ci

Ceci est le résultat du TP de CI/CD.


Description du projet:

Le projet choisi est un projet qui nous a été donnée en cours de JavaEE.

Il s'agit d'un projet qui a pour but de mettre en pratique des pattern de programmation orienté objet sur des objets géométrique.
Ce projet est donc codé en Java.

Le TP est disponible avec la correction sur ce lien :
https://mborne.github.io/cours-patron-conception/annexe/tp-geometry/index.html
(à savoir que le TP à été codé sans la correction au départ).


Mise en oeuvre de l'intégration continue:

L'outil d'intégration continue différent de Jenkins, et hébergé dans une plateforme publique de type "cloud” est travis-ci.

Description du pipeline:

La première ligne dans le fichier .travis.yml est :

> language: java

Cette ligne de code permet de préciser l'environement de programation utilisé et build automatiquement le projet.

Ce projet utilise maven, et de ce fait, avant de build, travis installe automatiquement les dépendance à l'aide de cette commande : > mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

En revanche, il n'y a pas besoin de la préciser dans le fichier, c'est une commande par défaut.

Dans la même idée, comme le projet contient un fichier pom.xml, il lance aussi automatiquement la commande suivante : > mvn test -B

C'est la commande de build du projet.

Les lignes suivantes sont :

> jdk:
>   - openjdk8
>   - openjdk14

Ces lignes permettent de préciser les environement de test dans lesquels ils doivent se déroulés. Il y en a deux, conformément aux attentes sur ce projet.

Les dernières lignes sont :

> deploy:
>   provider: releases
>   api_key: $GITHUB_API_KEY
>   skip_cleanup: true
>   on:
>     tags: true
>     all_branches: true

Ces lignes servent au déploiement de l'application.

Le provider est le service sur lequel on déploit l'application, ici il s'agit de GitHub Releases. On précise donc une clé d'API de GitHub enregistré dans Travis.

skip_cleanup permet de passer l'étape de nettoyage avant déploiement.

on: tags permet de ne déployer l'application seulement si on tag un push sur une branche. Il n'y aura pas de déploiement sinon.
