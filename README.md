Server e Client java
Questi file realizzano client e server in Java



-----------la classe ServerStr trasforma il messaggio del client in maiuscole e glielo reinvia

-----------La classe Server0
//Questo server si mette in ascolto sul ServerSocket 11111
//Quando arriva la conenssione su questa porta poi crea un Socket solo per quel client
//Il server invia un numero al client e si chiude

-----------La classe Server1
//Questo server si mette in ascolto sul ServerSocket 11111
//Quando arriva la connessione su questa porta poi crea un Socket solo per quel client
//Il server invia un numero sempre crescente per poi chiduersi quando questo numero arriva a cinque
//Attenzione NON E' multicast e  accontenta solo un client alla volta fino a un massimo di cinque

----------La classe Server2
//Il Server 2 invia la parola STOP al client e poi si chiude


----------La classe Server
//Il Server prende una stringa dal Client 
//e gliela reinvia in una sorta di eco.
//Il server é Multithreading ed é in grado di
//rispondere a piu` client contemporaneamente

