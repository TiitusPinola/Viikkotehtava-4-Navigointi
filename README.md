# Viikkotehtava-4-Navigation

## Kuvaus

Yksinkertainen Android-sovellus, jossa voit:
- Lisätä, poistaa ja merkitä tehtäviä tehdyksi/tekemättömäksi
- Muokata tehtäviä modal-ikkunan (AlertDialog) avulla
- Siirtyä kotiscreenin ja kalenterinäkymän 
- Vaihtaa teemaa

## Navigointi

- Navigointi tarkoittaa ruutujen vaihtamista sovelluksessa
- NavHost näyttää ruudut
- NavController ohjaa, mikä ruutu näkyy
- Sovelluksessa voi liikkua Home ↔ Calendar ruutujen välillä

## MVVM ja tila

- Model: tehtävät ja niiden tiedot
- View: HomeScreen, CalendarScreen ja SettingsScreen
- ViewModel: yhdistää Modelin ja View’n, sisältää sovelluksen tilan
- Sama ViewModel toimii molemmilla ruuduilla, joten tehtävät näkyvät kummassakin ja päivittyvät automaattisesti

## CalendarScreen

- Näyttää tehtävät päivämäärien mukaan kalenterissa
- Päivän tehtävät ryhmitellään näkyviin

## AlertDialog

- addTask: lisää uusi tehtävä
- editTask: muokkaa olemassa olevaa tehtävää
- Muutokset tallennetaan ViewModeliin, jolloin UI päivittyy heti

## Teknologiat

- Kotlin
- Android Studio
- Jetpack Compose
- StateFlow

## Asennus ja ajaminen

1. Kloonaa projekti

2. Avaa Android Studiossa

3. Rakenna ja aja sovellus emulaattorissa tai laitteessa
