# tp-ci

Ceci est le résultat du TP de CI/CD.


**Description du projet:**

Le projet choisi est un projet qui nous a été donnée en cours de JavaEE.

Il s'agit d'un projet qui a pour but de mettre en pratique des pattern de programmation orienté objet sur des objets géométrique.
Ce projet est donc codé en Java.

Le TP est disponible avec la correction sur ce lien :
https://mborne.github.io/cours-patron-conception/annexe/tp-geometry/index.html
(à savoir que le TP a été codé sans la correction au départ).

**Mise en oeuvre de l'intégration continue:**

L'outil d'intégration continue différent de Jenkins, et hébergé dans une plateforme publique de type "cloud” est travis-ci.

**Description du pipeline:**

La première ligne dans le fichier .travis.yml est :

    language: java

Cette ligne de code permet de préciser l'environement de programation utilisé et build automatiquement le projet.

Ce projet utilise maven, et de ce fait, avant de build, travis installe automatiquement les dépendance à l'aide de cette commande :

    mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

En revanche, il n'y a pas besoin de la préciser dans le fichier, c'est une commande par défaut.

Dans la même idée, comme le projet contient un fichier pom.xml, il lance aussi automatiquement la commande suivante :

    mvn test -B

C'est la commande de build du projet.

Les lignes suivantes sont :

    jdk:
      - openjdk8
      - openjdk14

Ces lignes permettent de préciser les environement de test dans lesquels ils doivent se déroulés. Il y en a deux, conformément aux attentes sur ce projet.

Les lignes suivantes sont :

    after_success:
    - mvn clean site -X -Dgithub.site.dryRun=true

Ces lignes permettent, après un succès du déploiement, de mettre en ligne la documentation du projet après un clean et en mode débug (-X).

De plus, la dernière option permet de passer la mise en ligne de la documentation sur GitHub pour éviter de trop long temps de build. Il suffit de l'enlever pour qu'elle fonctionne.

Les lignes suivantes sont :

    deploy:
        provider: releases
        api_key: $GITHUB_API_KEY
        skip_cleanup: true
        on:
            tags: true
            all_branches: true

Ces lignes servent au déploiement de l'application.

Le provider est le service sur lequel on déploit l'application, ici il s'agit de GitHub Releases. On précise donc une clé d'API de GitHub enregistré dans Travis.

skip_cleanup permet de passer l'étape de nettoyage avant déploiement.

on: tags permet de ne déployer l'application seulement si on tag un push sur une branche. Il n'y aura pas de déploiement sinon.

Les dernières lignes sont :

    env:
        global:
        - secure: un_string_très_long


Ces lignes permettent de setup une variable globale pour travis. Il s'agit de la clé d'API GitHub pour la documentation (mvn site). Elle est sécurisée car elle est crypté.
