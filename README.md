# Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application

# Projet 2 – Débuggez une application Java

## 📌 Contexte
Ce projet s’inscrit dans le parcours [Développeur d’application Java – OpenClassrooms](https://openclassrooms.com/fr/paths/883-developpeur-dapplication-java).  
L’objectif est de reprendre le travail entamé par un autre développeur et de corriger les bugs d’une application Java existante.

L’application doit :
- Lire une liste de symptômes depuis un fichier texte (`symptoms.txt`).
- Compter le nombre d’occurrences de chaque symptôme.
- Trier les résultats par ordre alphabétique.
- Générer un fichier de sortie (`result.out`) listant chaque symptôme et son nombre d’occurrences.

---

## 🗂️ Structure du projet
Project02Eclipse/
│ README.md
│ symptoms.txt # Fichier d'entrée : liste brute des symptômes
│ result.out # Fichier généré : sortie du programme
│
└───src/com/hemebiotech/analytics/
AnalyticsCounter.java
ISymptomReader.java
ISymptomWriter.java
Main.java
ReadSymptomDataFromFile.java
WriteSymptomDataToFile.java


- **`Main.java`** : point d’entrée de l’application.  
- **`AnalyticsCounter.java`** : orchestre les étapes (lecture → comptage → tri → écriture).  
- **`ISymptomReader` / `ISymptomWriter`** : interfaces définissant les contrats pour la lecture et l’écriture.  
- **`ReadSymptomDataFromFile.java`** : implémentation de lecture depuis un fichier texte.  
- **`WriteSymptomDataToFile.java`** : implémentation d’écriture dans un fichier texte.  

---

## ⚙️ Prérequis
- **Java 8** ou version supérieure.  
- Un IDE comme Eclipse ou IntelliJ, ou un terminal avec `javac` et `java`.  

---

## ▶️ Compilation et exécution

### Depuis un IDE (Eclipse, IntelliJ)
1. Importer le projet `Project02Eclipse` comme projet Java.  
2. Vérifier que `symptoms.txt` est bien présent à la racine du projet.  
3. Lancer la classe `Main`.  
