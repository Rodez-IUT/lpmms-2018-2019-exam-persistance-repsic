#### NOM : AMEN   Prénom : Raphaël 


## LP MMS / 2018-2019 /Examen pratique / Persistance des données

Vous disposez de 2h00 pour réaliser le TP. 

- L'usage des téléphones mobiles est interdit.
- Les documents papiers sont interdits.
- Il est strictement interdit de communiquer de manière directe ou indirecte, de quelque manière que ce soit
(messagerie instantanée, SMS, forum, réseaux sociaux, communication orale, etc.) avec une personne autre
que les enseignants en charge de la surveillance.
Toute violation de cet interdit entraînera **une sanction lourde immédiate et est susceptible de poursuite
pour fraude à examen**.

### Préliminaire

Inscrivez votre nom et votre prénom en tête de ce fichier et effectuez **un push contenant cette unique modification** sur votre projet Github.

Pour cette épreuve, vous allez travailler à partir d'un repository Github contenant un projet très fortement inspiré du projet OurbusinessProject.
Pour créer et accéder à votre repository Github, vous devez vous connecter à l'adresse communiquée par votre surveillant et suivre les instructions affichées.
Votre travail s'effectuera sur votre machine local après avoir cloné le repository Github qui a été créé pour vous.
Le rendu de votre travail s'effectura via  un **_push_ unique**  de vos modifications sur votre repository Github **en fin de séance** :
- une pénalité de 5 points sera appliquée à toute personne effectuant un *push* de son projet avant la fin de la séance ;
- toute personne ayant terminé son projet avant les 2 heures allouées devra tout de même attendre la fin de l'épreuve pour effectuer son *push*.

Vous devez répondre aux questions ouvertes directement dans ce fichier là où apparaissent les commentaires **"// A COMPLETER"**.

Il est strictement interdit de modifier le code contenu dans les classes _Bootstrap_, _InitializationService_ et _OurBusinessprojectApplication_.

Il est strictement interdit de modifier le code contenu dans les classes de test.  

### Prise en main du projet

1. Naviguez dans le projet, vérifiez qu'il a bien été reconnu votre IDE comme un projet Maven. Étudiez les classes du projet.
2. Lancez l'ensemble des tests est vérifiez que tous les tests passent exceptés ceux de la classe _"ZEvaluationM2DLTest"_.

Récupérez le contenu du fichier ENONCE.md disponible à l'URL fourni par votre enseignant et insérez le à la suite de ce fichier

### Enoncé

Introduction
Récupérez le contenu du fichier "ZEvaluationLPMMSTest.java" disponible à l'adresse suivante et insérez le dans votre fichier "ZEvaluationLPMMSTest.java". Étudiez le code de la classe "ZEvaluationLPMMSTest". Votre travail consistera à faire en sorte que tous les tests commentés de cette classe passent en plus de tous les autres.

Partie 1 - Gestion améliorée de la sauvegarde des objets métiers (7 points)
Cette partie vise à évaluer votre capacité à faire un bon usage de la méthode "EntityManager.merge(...)".

Décommentez le test "testSaveDetachedEnterprise" et modifiez le code principal de votre application pour faire en sorte que le test "testSaveDetachedEnterprise" passe. Vérifiez que l'ensemble des tests passent toujours. Si ce n'est pas le cas, modifiez votre code jusqu'à obtenir l'ensemble des tests au vert.

La méthode "EnterpriseProjectService.save(Project project)" contient l'instruction "entityManager.flush()". En étudiant la documentation de l'API JPA, décrivez quelle garantie apporte cette instruction pour le bon fonctionnement de la méthode.

// A COMPLETER :
La méthode flush permet de synchroniser le contexte de persistance avec la base de données. Cela permet de mettre à jour la base sans que cela ne soit commité tant que la transaction n'est pas terminée.

Décommentez le test "testSaveDetachedProject" et modifiez le code principal de votre application pour faire en sorte que le test "testSaveDetachedProject" passe. Vérifiez que l'ensemble des tests passent toujours. Si ce n'est pas le cas, modifiez votre code jusqu'à obtenir l'ensemble des tests au vert.

Partie 2. Gestion du changement d'entreprise d'un projet (6 points)
Décommentez le test "testSaveOfProjectAfterEnterpriseSwitch" et modifiez le code principal de votre application pour faire en sorte que le test "testSaveOfProjectAfterEnterpriseSwitch" passe. Vérifiez que l'ensemble des tests passent toujours. Si ce n'est pas le cas, modifiez votre code jusqu'à obtenir l'ensemble des tests au vert.

Le test "testSaveOfProjectAfterEnterpriseSwitch" contient l'assertion suivante : "assertThat(savedProject, is(project))". Que pouvez vous en déduire sur le comportement de la méthode "merge" ?

// A COMPLETER :
La méthode merge permet de racorder un projet détaché "project" au contexte de persistance, pour que le projet qui est sauvegardé soit "project", et non pas une autre instance d'un projet identique.

Partie 3. Optimistic locking (7 points)
Étudiez la documentation de l'annotation "jaxa.persistence.Version" de l'API JPA.

Décommentez le test "testProjectsAreVersionned" et modifiez le code principal de votre application pour faire en sorte que le test "testProjectsAreVersionned" passe. Vérifiez que l'ensemble des tests passent toujours. Si ce n'est pas le cas, modifiez votre code jusqu'à obtenir l'ensemble des tests au vert.

Décommentez le test "testOptimisticLockingOnConcurrentProjectModification" et modifiez, si nécessaire, le code principal de votre application pour faire en sorte que le test "testOptimisticLockingOnConcurrentProjectModification" passe. Vérifiez que l'ensemble des tests passent toujours. Si ce n'est pas le cas, modifiez votre code jusqu'à obtenir l'ensemble des tests au vert.

Expliquez clairement, en français, ce qui se passe dans le test "testOptimisticLockingOnConcurrentProjectModification".

// A COMPLETER :
Ce test simule un accès concurrentiel sur un projet. Et lorsque l'on modifie ce projet pendant qu'il est utilisé, on s'attend à ce que l'exception "OptimisticLockException" soit levée pour qu'un rollback soit demandé.




