# Document-Oriented-Middleware-usingMongoDB
@author: Sebastian Sailer
@version: 14.05.2024

## Datenbankerstellung

```bash
docker pull mongo

docker docker run -d -p 27017:27017 --name mongo mongo

docker exec -it mongo bash
```


## Navigation in der Datenbank
```bash
mongosh #starten der mongo bash

show dbs #Datenbanken anzeigen

show collections #zeigt Tabellen

db.productData.find() #Zeigt Daten der productData an


```



## Fragestellungen

**NoSQL vs. relationale Datenbanken:**

**Vorteile NoSQL:**

* Skalierbar
* Flexibel
* Leistungsstark
* Günstig

**Nachteile NoSQL:**

* Inkonsistente Daten
* Spezifische Abfragesprachen
* Weniger ausgereift
* Fehlende Standards

**Arten von NoSQL-Datenbanken:**

* Key-Value-Speicher (z.B. Redis)
* Dokumenten-Datenbanken (z.B. MongoDB)
* Graphdatenbanken (z.B. Neo4j)
* Weitverteilte Hash-Tabellen (z.B. Cassandra)

**CAP-Theorem:**

* C (Konsistenz): Alle Daten sind immer gleich
* A (Verfügbarkeit): Alle Lese- und Schreibvorgänge sind immer möglich
* P (Partitionstoleranz): Das System funktioniert auch bei Ausfall von Knoten

 > NoSQL kann nur zwei der drei garantieren


