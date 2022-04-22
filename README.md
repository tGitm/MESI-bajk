# MESI-bajk

Podjetje MESI svojim zaposlenim omogoča uporabo koles z
namenom spodbujanja zdravega načina življenja, lažjega doseganje vsakodnevnih ciljev med uro malice
in drugih službenih ali osebnih razlogov. Zaradi velikega povpraševanja in uporabe koles se pogosto zgodi,
da nobeno kolo ni več na voljo za Markota, ki je zaposlen na oddelku za prodajo in bi rad čim hitreje prišel
do kristalne palače na nujen poslovni sestanek glede prodaje naprave mTABLET. Tvoja naloga je izdelati
mobilno aplikacijo, ki bo omogočala rezervacijo koles zaposlenim v podjetju MESI. Aplikacija naj omogoča
zaposlenim rezervacijo kolesa in vpogled v zgodovino rezervacij posameznih koles


### Specifikacije:

* delovanje na operacijskem sistemu Android Lollipop
* shranjevanje podatkov v SQLite podatkovni bazi
* shranjevanja podatkov izposojevalca (Ime in priimek), sektor podjetja (razvoj, prodaja,
proizvodnja), termin izposoje (čas in datum izposoje / vrnitve), približna prevožena razdalja v km,
namen izposoje (službeni, privatni)
* na prvem zaslonu aplikacije naj bo izpisan seznam vseh koles z šiframi in nazivom (npr. #1, Modro
kolo) in z jasno vidnim statusom izposoje (na voljo/izposojeno)
* ob prvem zagonu aplikacije naj se v podatkovno bazo avtomatsko zapiše vseh sedem koles, ki jih
ima podjetje MESI na razpolago (Šifre in imena koles so poljubne izbire)
* za vsako kolo naj bo omogočen pregled zadnje in prihodnje rezervacije, število vseh prevoženih
kilometrov in število rezervacij glede na namen izposoje in sektor podjetja
* vsa vnosna polja so obvezna in v primeru napake izpišeš “Error” polje z vsebino napake
* za celotno aplikacijo je potrebno napisati programske teste (unit in UI testi


### Wireframe aplikacije
![image](https://user-images.githubusercontent.com/47832737/164161115-96e683b7-f312-4c9b-ab66-5bc2a4f5bf34.png)

## Completed project

![image](https://user-images.githubusercontent.com/47832737/164716271-663e91b2-4e4b-4f81-b607-5fa0105222e2.png)
![image](https://user-images.githubusercontent.com/47832737/164716332-e7ef70e2-df92-4b71-a985-a3a1f4a99c21.png)
![image](https://user-images.githubusercontent.com/47832737/164716376-b896f278-3217-419d-94b6-7447108505f4.png)
![image](https://user-images.githubusercontent.com/47832737/164716480-cd393329-c0ec-4c31-9715-28adfa899c95.png)

Aplikacija nas ob uspešnem dodajanju rezervacije obvesti:

![image](https://user-images.githubusercontent.com/47832737/164716881-414181dd-9463-4ee4-a717-89bf70cf0880.png)


Prav tako nas obvesti v primeru, če ne izpolnemo vseh podatkov, pri vnosu rezervacije:

![image](https://user-images.githubusercontent.com/47832737/164716794-e500315a-d151-4a4d-a400-23ed2bbb1080.png)
