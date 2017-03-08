# MapReduce avec JAVA

### Description

Vous trouez ci joint les solutions relatives aux différentes activités de la formation "Intro to Hadoop and Map Reduce" élaboré par Cloudera et publiée sur Udacity. 

### Installation

Pour bénéficier de cette solution, il faut d'abord télécharger la machine virtuelle Cloudera disponible sur https://www.cloudera.com/downloads/quickstart_vms/5-5.html

### Usage

#### Pour Executer le projet en local
1. Importez la solution dans Eclipse 
2. Supprimez le dossier output s'il est existant 
3. Executer le projet en spécifiant des variables de configuration d'execution path_to_purchases.txt output . 
  1. En effet, purchases.txt correspond à notre jeu de données et ouput correpond au dossier du résultat.

#### Pour Executer le projet avec HDFS
1. Exporter le jar du projet 
2. Creer un dossier destination hadoop fs -mkdir /input 
3. Importer purchases.txt sur HDFS avec la commande hadoop fs -put purchases.txt /input 
4. Lancer la commande hadoop jar chemin_au_jar_du_projet chemin_au_main_du_jar_qui_est_StubDriver chemin_hdfs_au_jeu_de_données output 
5. Pour voir le réultat, lancer la commande hadoop fs -cat output/part-r-00000

###  Remarque

1. Cloudera est déja doté d'Eclipse Luna. 
2. Il est toujours recommandé de tester le code en local avant de le tester sur HDFS.

###  Auteur

Chaima DERBALI

###  Licence

Aucune
