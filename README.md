# Enhetsregisteret
Eksempel på enkel Java-app som henter bedrifter fra APIet til Enhetsregisteret og Lagrer lokalt som XML eller JSON 

Her er en jpackage-kommando for å lage en installasjons-veileder for Windows:

jpackage -i out/artifacts/ -d .. --main-jar enhetsregisteret.jar --name Enhetsregisteret --type exe  --vendor "ITFakultetet AS"  --win-console --win-shortcut --win-menu  --app-version 0.1.0 --win-per-user-install --win-dir-chooser --description "Program for å hente ut firmaer fra Enhetsregisteret"
