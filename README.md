# SerialisationDemo
![Build-Status](https://github.com/mflingelli/SerialisationDemo/actions/workflows/maven.yml/badge.svg)

In diesem Projekt wird gezeigt, wie Java-Objekte serialisiert werden können.

Folgende Formate werden derzeit gezeigt:
* JSON (mit der Bibliothek [Gson](https://github.com/google/gson))
  * Collection ```List<>``` im Package ```de.flingelli.training.json.list```.
  * Collection ```Map<>``` im Package ```de.flingelli.training.json.map```.
* XML (mit JAXB)
  * Collection ```List<>``` im Package ```de.flingelli.training.jaxb.list```.
  * Collection ```Map<>``` im Package ```de.flingelli.training.jaxb.map```.

## Dokumentation

* [Jaxb](doc/Jaxb.md)
* [Gson](doc/Gson.md)